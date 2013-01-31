package org.ahsan.board.web;

import org.ahsan.board.dao.NoticeDao;
import org.ahsan.board.domain.Notice;

import com.opensymphony.xwork2.Action;

public class NoticeView implements Action {

	private int no;
	private int page;
	private Notice article;
	private String r = "y";
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
	public Notice getArticle() {
		return article;
	}
	public void setArticle(Notice article) {
		this.article = article;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		NoticeDao dao = NoticeDao.getInstance();
		article = dao.getArticleByNo(no);
		if(article.getNotice()!=null) {
			article.setNotice(article.getNotice().replace("\r\n", "<br />"));
		}
		if(r.equals("y")) {
			dao.addReadCount(no);
		}
		return "success";
	}
		
}
