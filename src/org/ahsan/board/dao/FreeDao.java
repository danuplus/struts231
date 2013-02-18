package org.ahsan.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ahsan.board.domain.Free;
import org.ahsan.board.domain.Freply;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FreeDao {

	private static final int ARTICLE_PER_PAGE = 15;
	private static FreeDao fdao;
	private SqlSessionFactory ssf;
	
	public static FreeDao getInstance() throws IOException {
		if(fdao == null) {
			fdao = new FreeDao();
		}
		return fdao;
	}
	
	private FreeDao() throws IOException {
		String rs = "mybatis/mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(rs);
		ssf = new SqlSessionFactoryBuilder().build(is);
	}
	
	public int getTotalPage() {
		SqlSession session = ssf.openSession();
		
		int result = session.selectOne("mybatis.MapperFree.getTotalPage");
		int total = (int)Math.ceil(result/(double)ARTICLE_PER_PAGE);
		
		session.close();
		return total;
	}
	
	public List<Free> getArticlesByPage(int page) {
		SqlSession session = ssf.openSession();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (page-1)*ARTICLE_PER_PAGE);
		map.put("end", ARTICLE_PER_PAGE);
		
		List<Free> articles = session.selectList("mybatis.MapperFree.getArticlesByPage", map);
		
		session.close();
		return articles;
	}
	
	public Free getArticleByNo(int no) {
		SqlSession session = ssf.openSession();
		
		Free article = session.selectOne("mybatis.MapperFree.getArticleByNo", no);
		
		session.close();
		return article;
	}
	
	public boolean addArticle(Free article) {
		SqlSession session = ssf.openSession();
		
		// 원글
		article.setGroup_no(0);
		article.setSequence_in_group(0);
		article.setIndent_in_group(0);
		article.setRef_no(0);
		
		int result = session.insert("mybatis.MapperFree.addArticle", article);
		
		// 그룹 번호를 글 번호로 업데이트
		session.update("mybatis.MapperFree.updateGroupNo");
		
		session.close();
		return result > 0 ? true : false;
		
	}
	
	public boolean addChildArticle(int parent_no, Free article) {
		SqlSession session = ssf.openSession();
		
		Free p_article = getArticleByNo(parent_no);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		System.out.println(p_article.getGroup_no());
		map.put("parent_group_no", p_article.getGroup_no());
		map.put("parent_sequence_in_group", p_article.getSequence_in_group());
		session.update("mybatis.MapperFree.updateChildSequence", map);
		
		// 답글
		article.setGroup_no(p_article.getGroup_no());
		article.setSequence_in_group(p_article.getSequence_in_group() + 1);
		article.setIndent_in_group(p_article.getIndent_in_group() + 1);
		article.setRef_no(parent_no);
		
		int result = session.insert("mybatis.MapperFree.addArticle", article);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean updateReadCount(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperFree.updateReadCount", no);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean editArticle(Free article) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperFree.editArticle", article);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean removeArticle(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.delete("mybatis.MapperFree.removeArticle", no);
		
		// 자식 글들의 참조 번호를 -1로 업데이트 한다.
		session.update("mybatis.MapperFree.updateRefNo", no);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean checkArticlePassword(int no, String password) {
		SqlSession session = ssf.openSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		
		int result = session.selectOne("mybatis.MapperFree.checkArticlePassword", map);
		session.close();
		
		return result > 0 ? true : false;
	}
	
	public List<Freply> getRelatedRepliesByNo(int no) {
		SqlSession session = ssf.openSession();
		
		List<Freply> replies = session.selectList("mybatis.MapperFree.getRelatedRepliesByNo", no);
		session.close();
		
		return replies;
	}
	
	public boolean addReply(int parent_no, Freply reply) {
		SqlSession session = ssf.openSession();
		
		// 덧글의 참조 글 번호를 입력
		reply.setRef_no(parent_no);
		
		// 덧글 입력
		int result = session.insert("mybatis.MapperFree.addReply", reply);
		session.close();
		
		// 원글의 덧글 갯수 1 증가
		updateReplyCount(parent_no, 1);
		
		return result > 0 ? true : false;
	}
	
	public boolean removeReply(int parent_no, int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.delete("mybatis.MapperFree.removeReply", no);
		session.close();
		
		// 원글의 댓글 갯수 1 차감
		updateReplyCount(parent_no, -1);
		
		return result > 0 ? true : false;
	}
	
	public boolean updateReplyCount(int no, int inc) {
		SqlSession session = ssf.openSession();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("no", no);
		map.put("inc", inc);
		
		int result = session.update("mybatis.MapperFree.updateReplyCount", map);
		session.close();
		
		return result > 0 ? true : false;
	}
	
	public boolean checkReplyPassword(int no, String password) {
		SqlSession session = ssf.openSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		
		int result = session.selectOne("mybatis.MapperFree.checkReplyPassword", map);
		session.close();
		
		return result > 0 ? true : false;
	}
}
