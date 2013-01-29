package org.ahsan.board.web;

import org.ahsan.board.dao.MemoDao;

public class MemoCheckPassword {
	private int no;
	private int page;
	private String password;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception {
		MemoDao dao = MemoDao.getInstance();
		if(dao.checkPassword(no, password)) {
			dao.removeMemo(no);
			return "success";
		} else {
			return "fail";
		}
	}
}
