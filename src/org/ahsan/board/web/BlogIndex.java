package org.ahsan.board.web;

import java.util.List;

import org.ahsan.board.dao.BlogDao;
import org.ahsan.board.domain.Blog;

import com.opensymphony.xwork2.Action;

public class BlogIndex implements Action {
	private int page = 1;
	private int total;
	private List<Blog> articles;
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
	public List<Blog> getArticles() {
		return articles;
	}
	public void setArticles(List<Blog> articles) {
		this.articles = articles;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BlogDao dao = BlogDao.getInstance();
		total = dao.getTotalPage();
		articles = dao.getArticlesByPage(page);
		return "success";
	}
	
}
