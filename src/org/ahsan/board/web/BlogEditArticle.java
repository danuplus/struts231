package org.ahsan.board.web;

import java.util.Map;

import org.ahsan.board.dao.BlogDao;
import org.ahsan.board.domain.Blog;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BlogEditArticle implements Action, Preparable, ModelDriven<Blog>, SessionAware {
	private int no;
	private int page;
	private Blog article;
	private Map<String, Object> session;
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
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	@Override
	public Blog getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		article = new Blog();
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(session.containsKey("no")) {
			no = ((Integer)session.get("no")).intValue();
			session.remove("no");
			article.setNo(no);
			BlogDao dao = BlogDao.getInstance();
			dao.editArticle(article);
			return "success";
		} else {
			return "fail";
		}
	}
	
}
