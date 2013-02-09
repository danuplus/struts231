package org.ahsan.board.web;

import org.ahsan.board.dao.InquireDao;
import org.ahsan.board.domain.Inquire;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InquireAnswerArticle implements Action, Preparable, ModelDriven<Inquire> {
	private int parent_no;
	private int page;
	private Inquire article;
	public int getParent_no() {
		return parent_no;
	}
	public void setParent_no(int parent_no) {
		this.parent_no = parent_no;
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
	@Override
	public Inquire getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		article = new Inquire();
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		InquireDao dao = InquireDao.getInstance();
		dao.addChildArticle(parent_no, article);
		
		return "success";
	}
	
}
