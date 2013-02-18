package org.ahsan.board.web;

import com.opensymphony.xwork2.Action;

public class FreeWrite implements Action {
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
}
