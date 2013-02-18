package org.ahsan.board.web;

import java.util.List;

import org.ahsan.board.dao.FreeDao;
import org.ahsan.board.domain.Free;

import com.opensymphony.xwork2.Action;

public class FreeIndex implements Action {
	private int page = 1;
	private int total;
	private List<Free> articles;
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
	public List<Free> getArticles() {
		return articles;
	}
	public void setArticles(List<Free> articles) {
		this.articles = articles;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		FreeDao dao = FreeDao.getInstance();
		total = dao.getTotalPage();
		articles = dao.getArticlesByPage(page);
		
		// 들여쓰기 조정
		for(Free article : articles) {
			if(article.getIndent_in_group() > 0) {
				StringBuilder builder = new StringBuilder();
				for(int i=0; i<article.getIndent_in_group(); i++) {
					builder.append("&nbsp;&nbsp;");
				}
				builder.append("<img src='images/reply_icon.gif' />");
				if(article.getRef_no() == -1) {
					builder.append("<span class='error-text'>[원글이 삭제된 답글]</span>");
				}
				article.setTitle(builder.toString() + article.getTitle());
			}
		}
		return "success";
	}
	
}
