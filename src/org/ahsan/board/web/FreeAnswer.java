package org.ahsan.board.web;

import org.ahsan.board.dao.FreeDao;
import org.ahsan.board.domain.Free;

import com.opensymphony.xwork2.Action;

public class FreeAnswer implements Action {
	private int no;
	private int page;
	private Free article;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Free getArticle() {
		return article;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		FreeDao dao = FreeDao.getInstance();
		article = dao.getArticleByNo(no);
		
		return "success";
	}
	
}
