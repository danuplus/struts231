package org.ahsan.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ahsan.board.domain.Inquire;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InquireDao {
	private static final int ARTICLE_PER_PAGE = 15;
	private static InquireDao idao;
	private static SqlSessionFactory ssf;
	
	public static InquireDao getInstance() throws IOException {
		if(idao == null) {
			idao = new InquireDao();
		}
		return idao;
	}
	
	public InquireDao() throws IOException {
		String rs = "mybatis/mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(rs);
		ssf = new SqlSessionFactoryBuilder().build(is);
	}
	
	public int getTotalCount() {
		SqlSession session = ssf.openSession();
		int result = session.selectOne("mybatis.MapperInquire.getTotalCount");
		int total = (int)Math.ceil(result/(double)ARTICLE_PER_PAGE);
		
		session.close();
		return total;
	}
	
	public List<Inquire> getArticlesByPage(int page) {
		SqlSession session = ssf.openSession();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (page-1)*ARTICLE_PER_PAGE);
		map.put("end", ARTICLE_PER_PAGE);
		
		List<Inquire> articles = session.selectList("mybatis.MapperInquire.getArticlesByPage", map);
		
		session.close();
		return articles;
	}
	
	public Inquire getArticleByNo(int no) {
		SqlSession session = ssf.openSession();
		
		Inquire article = session.selectOne("mybatis.MapperInquire.getArticleByNo", no);
		
		session.close();
		return article;
	}
	
	public boolean addReadCount(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperInquire.addReadCount", no);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean addArticle(Inquire article) {
		SqlSession session = ssf.openSession();
		
		int result = session.insert("mybatis.MapperInquire.addArticle", article);
		
		if(article.getGroup_no()==0) {
			session.update("mybatis.MapperInquire.updateGroupNo");
		}
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean addChildArticle(int parent_no, Inquire article) {
		SqlSession session = ssf.openSession();
		
		Inquire p_article = getArticleByNo(parent_no);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("parent_group_no", p_article.getGroup_no());
		map.put("parent_sequence_in_group", p_article.getSequence_in_group());
		
		session.update("mybatis.MapperInquire.updateSequenceInGroup", map);
		
		session.close();
		
		article.setGroup_no(p_article.getGroup_no());
		article.setSequence_in_group(p_article.getSequence_in_group() + 1);
		article.setIndent_in_group(p_article.getIndent_in_group() + 1);
		article.setRef_no(parent_no);
		
		return addArticle(article);
	}
	
	public boolean editArticle(Inquire article) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperInquire.editArticle", article);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean removeArticle(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.delete("mybatis.MapperInquire.removeArticle", no);
		
		// 원글이 삭제되면 답글의 원글 참조는 -1로 업데이트된다.
		session.update("mybatis.MapperInquire.updateRefNo", no);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean checkPassword(int no, String password) {
		SqlSession session = ssf.openSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		int result = session.selectOne("mybatis.MapperInquire.checkPassword", map);
		
		session.close();
		return result > 0 ? true : false;
	}
}
