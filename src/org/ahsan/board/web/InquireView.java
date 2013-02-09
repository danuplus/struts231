package org.ahsan.board.web;

import org.ahsan.board.dao.InquireDao;
import org.ahsan.board.domain.Inquire;

import com.opensymphony.xwork2.Action;

public class InquireView implements Action {
	private int no;
	private int page;
	private String r;
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
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public Inquire getArticle() {
		return article;
	}
	public void setArticle(Inquire article) {
		this.article = article;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		InquireDao dao = InquireDao.getInstance();
		article = dao.getArticleByNo(no);
		
		if(article.getContent()!=null) {
			article.setContent(article.getContent().replace("\r\n", "<br />"));
		}
		
		if(r==null) {
			dao.addReadCount(no);
		}
		return "success";
	}
}
