package org.ahsan.board.web;

import java.util.List;

import org.ahsan.board.dao.BlogDao;
import org.ahsan.board.domain.Blog;
import org.ahsan.board.domain.Breply;

import com.opensymphony.xwork2.Action;

public class BlogView implements Action {
	private int no;
	private int page;
	private String r;
	private Blog article;
	private List<Breply> replies;
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
	public Blog getArticle() {
		return article;
	}
	public void setArticle(Blog article) {
		this.article = article;
	}
	public List<Breply> getReplies() {
		return replies;
	}
	public void setReplies(List<Breply> replies) {
		this.replies = replies;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BlogDao dao = BlogDao.getInstance();
		article = dao.getArticleByNo(no);
		if(article.getContent()!=null) {
			article.setContent(article.getContent().replace("\r\n", "<br />"));
		}
		replies = dao.getAllReplyByNo(no);
		
		if(r==null) dao.addReadCount(no);
		
		return "success";
	}
	
}
