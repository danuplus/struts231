package org.ahsan.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ahsan.board.domain.Blog;
import org.ahsan.board.domain.Breply;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BlogDao {

	private static final int ARTICLE_PER_PAGE = 15;
	private static BlogDao bdao;
	private SqlSessionFactory ssf;
	
	public static final BlogDao getInstance() throws IOException {
		if(bdao == null) {
			bdao = new BlogDao();
		}
		return bdao;
	}
	
	private BlogDao() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		ssf = new SqlSessionFactoryBuilder().build(is);
	}
	
	public int getTotalPage() {
		SqlSession session = ssf.openSession();
		int result = session.selectOne("mybatis.MapperBlog.getTotalPage");
		int page = (int)Math.ceil(result/(double)ARTICLE_PER_PAGE);
		session.close();
		return page;
	}
	
	public List<Blog> getArticlesByPage(int page) {
		SqlSession session = ssf.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (page-1)*ARTICLE_PER_PAGE);
		map.put("end", ARTICLE_PER_PAGE);
		
		List<Blog> articles = session.selectList("mybatis.MapperBlog.getArticlesByPage", map);
		
		session.close();
		return articles;
	}
	
	public Blog getArticleByNo(int no) {
		SqlSession session = ssf.openSession();
		
		Blog article = session.selectOne("mybatis.MapperBlog.getArticleByNo", no);
		
		session.close();
		return article;
	}
	
	public List<Breply> getAllReplyByNo(int no) {
		SqlSession session = ssf.openSession();
		
		List<Breply> replies = session.selectList("mybatis.MapperBlog.getAllReplyByNo", no);
		
		session.close();
		
		if(replies.size() > 0)
			return replies;
		else
			return null;
	}
	
	public boolean checkArticlePassword(int no, String password) {
		SqlSession session = ssf.openSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		int result = session.selectOne("mybatis.MapperBlog.checkArticlePassword", map);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean checkReplPassword(int no, String password) {
		SqlSession session = ssf.openSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		int result = session.selectOne("mybatis.MapperBlog.checkReplPassword", map);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean addArticle(Blog article) {
		SqlSession session = ssf.openSession();
		
		int result = session.insert("mybatis.MapperBlog.addArticle", article);
		session.close();
		
		return result > 0 ? true : false;
	}
	
	public boolean editArticle(Blog article) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperBlog.editArticle", article);
		session.close();
		
		return result > 0 ? true : false;
	}
	
	public boolean removeArticle(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.delete("mybatis.MapperBlog.remveArticle", no);
		
		// 관련 댓글 모두 삭제
		session.delete("mybatis.MapperBlog.removeAllReplyByNo", no);
		
		session.close();
		
		return result > 0 ? true : false;
	}
	
	public boolean addReply(int parent_no, Breply reply) {
		SqlSession session = ssf.openSession();
		
		reply.setRef_no(parent_no);
		int result = session.insert("mybatis.MapperBlog.addReply", reply);
		
		// 뎃글 갯수를 1 증가시킨다.
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("inc", 1);
		map.put("no", parent_no);
		session.update("mybatis.MapperBlog.updateReplyCount", map);
		
		session.close();
		
		return result > 0 ? true : false;
	}
	
	public boolean remveReply(int parent_no, int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.delete("mybatis.MapperBlog.removeReply", no);
		
		// 뎃글 갯수를 1 감소시킨다.
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("inc", -1);
		map.put("no", parent_no);
		session.update("mybatis.MapperBlog.updateReplyCount", map);
		
		session.close();
		
		return result > 0 ? true : false;
	}
	
	public boolean addReadCount(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperBlog.addReadCount", no);
		session.close();
		return result > 0 ? true : false;
	}
}
