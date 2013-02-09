package org.ahsan.board.web;

import java.util.Map;

import org.ahsan.board.dao.InquireDao;
import org.ahsan.board.domain.Inquire;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InquireEdit implements Action, ModelDriven<Inquire>, Preparable, SessionAware {
	private int no;
	private int page;
	private Inquire article;
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
	public Inquire getArticle() {
		return article;
	}
	public void setArticle(Inquire article) {
		this.article = article;
	}
	private Map<String, Object> session;
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		article = new Inquire();
	}
	@Override
	public Inquire getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(session.containsKey("no")) {
			no = ((Integer)session.get("no")).intValue();
			session.remove("no");
			article.setNo(no);
			
			InquireDao dao = InquireDao.getInstance();
			dao.editArticle(article);
			
			return "success";
		} else {
			return "fail";
		}
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	} 
	
}
