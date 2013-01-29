package org.ahsan.board.web;

import java.util.List;

import org.ahsan.board.dao.MemoDao;
import org.ahsan.board.domain.Memo;

public class MemoIndex {
	private int page = 1;
	private int total;
	private List<Memo> memos;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Memo> getMemos() {
		return memos;
	}
	public void setMemos(List<Memo> memos) {
		this.memos = memos;
	}
	
	public String execute() throws Exception {
		MemoDao dao = MemoDao.getInstance();
		total = dao.getTotalMemo();
		memos = dao.getMemosByPage(page);
		
		return "success";
	}
}
