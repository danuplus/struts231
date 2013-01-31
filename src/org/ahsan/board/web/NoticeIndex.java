package org.ahsan.board.web;

import java.util.List;

import org.ahsan.board.domain.Notice;
import org.ahsan.board.dao.NoticeDao;

import com.opensymphony.xwork2.Action;

public class NoticeIndex implements Action {

	private int page = 1;
	private int total;
	private List<Notice> articles;
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
	public List<Notice> getArticles() {
		return articles;
	}
	public void setArticles(List<Notice> articles) {
		this.articles = articles;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		NoticeDao dao = NoticeDao.getInstance();
		total = dao.getTotalPage();
		articles = dao.getArticlesByPage(page);
		return "success";
	}
	
}
