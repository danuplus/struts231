package org.ahsan.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ahsan.board.domain.Memo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemoDao {

	private static MemoDao dao;
	private static final int MEMO_PER_PAGE = 15;
	private SqlSessionFactory ssf;
	
	public static MemoDao getInstance() throws IOException {
		if(dao == null) {
			dao = new MemoDao();
		}
		return dao;
	}
	
	private MemoDao() throws IOException {
		String rs = "mybatis/mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(rs);
		ssf = new SqlSessionFactoryBuilder().build(is);
	}
	
	public List<Memo> getMemosByPage(int page) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (page-1)*MEMO_PER_PAGE);
		map.put("stop", MEMO_PER_PAGE);
		
		SqlSession session = ssf.openSession();
		List<Memo> memos = session.selectList("mybatis.MapperMemo.getMemosByPage", map);
		
		session.close();
		return memos;
	}
	
	public int getTotalMemo() {
		SqlSession session = ssf.openSession();
		
		int result = session.selectOne("mybatis.MapperMemo.getTotalMemo");
		int total = (int)Math.ceil(result/(double)MEMO_PER_PAGE);
		
		session.close();
		return total;
	}
	
	public boolean addMemo(Memo memo) {
		SqlSession session = ssf.openSession();
		
		int result = session.insert("mybatis.MapperMemo.addMemo", memo);
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean checkPassword(int no, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		
		SqlSession session = ssf.openSession();
		int result = session.selectOne("mybatis.MapperMemo.checkPassword", map);
		
		session.close();
		return result > 0 ? true : false;
	}
	
	public boolean removeMemo(int no) {
		SqlSession session = ssf.openSession();
		int result = session.delete("mybatis.MapperMemo.removeMemo", no);
		session.close();
		
		return result > 0 ? true : false;
	}
}
