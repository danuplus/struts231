package org.ahsan.board.web;

import org.ahsan.board.dao.BlogDao;
import org.ahsan.board.domain.Blog;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BlogWriteArticle implements Action, Preparable, ModelDriven<Blog> {

	private Blog article;

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
		BlogDao dao = BlogDao.getInstance();
		dao.addArticle(article);
		
		return "success";
	}
	
}
