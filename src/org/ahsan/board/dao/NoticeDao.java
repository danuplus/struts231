package org.ahsan.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ahsan.board.domain.Notice;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NoticeDao {

	private static final int BOARD_PER_PAGE = 15;
	private static NoticeDao dao;
	private SqlSessionFactory ssf;
	
	public static NoticeDao getInstance() throws IOException {
		if(dao == null) {
			dao = new NoticeDao();
		}
		return dao;
	}
	
	private NoticeDao() throws IOException {
		String rs = "mybatis/mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(rs);
		ssf = new SqlSessionFactoryBuilder().build(is);
	}
	
	public int getTotalPage() {
		SqlSession session = ssf.openSession();
		
		int result = session.selectOne("mybatis.MapperNotice.getTotalPage");
		int total = (int)Math.ceil(result/(double)BOARD_PER_PAGE);
		
		session.close();
		return total;
	}
	
	public List<Notice> getArticlesByPage(int page) {
		SqlSession session = ssf.openSession();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (page-1)*BOARD_PER_PAGE);
		map.put("stop", BOARD_PER_PAGE);
		
		List<Notice> articles = session.selectList("mybatis.MapperNotice.getArticlesByPage", map);
		session.close();
		return articles;
	}
	
	public Notice getArticleByNo(int no) {
		SqlSession session = ssf.openSession();
		
		Notice article = session.selectOne("mybatis.MapperNotice.getArticleByNo", no);
		
		session.close();
		return article;
	}
	
	public boolean addArticle(Notice article) {
		SqlSession session = ssf.openSession();
		
		int result = session.insert("mybatis.MapperNotice.addArticle", article);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean editArticle(Notice article) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperNotice.editArticle", article);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean removeArticle(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.delete("mybatis.MapperNotice.removeArticle", no);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean addReadCount(int no) {
		SqlSession session = ssf.openSession();
		
		int result = session.update("mybatis.MapperNotice.addReadCount", no);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean checkPassword(int no, String password) {
		SqlSession session = ssf.openSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		
		int result = session.selectOne("mybatis.MapperNotice.checkPassword", map);
		
		session.close();
		return result > 0 ? true : false;
	}
}
