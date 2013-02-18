package org.ahsan.board.web;

import java.util.List;

import org.ahsan.board.dao.FreeDao;
import org.ahsan.board.domain.Free;
import org.ahsan.board.domain.Freply;

import com.opensymphony.xwork2.Action;

public class FreeView implements Action {
	private int no;
	private int page;
	private String r;
	private Free article;
	private List<Freply> replies;
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
	public Free getArticle() {
		return article;
	}
	public void setArticle(Free article) {
		this.article = article;
	}
	public List<Freply> getReplies() {
		return replies;
	}
	public void setReplies(List<Freply> replies) {
		this.replies = replies;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		FreeDao dao = FreeDao.getInstance();
		
		// 글 내용 가져오기
		article = dao.getArticleByNo(no);
		
		// 글 내용의 줄 바꿈 처리
		if(article.getContent() != null) {
			article.setContent(article.getContent().replace("\r\n", "<br />"));
		}
		
		// &r=n이 아니면 조회수 증가
		if(r==null || !r.equals("n")) {
			dao.updateReadCount(no);
		}
		
		// 덧글 가져오기
		replies = dao.getRelatedRepliesByNo(no);
		if(replies.size() == 0) replies = null;
		
		return "success";
	}
	
}
