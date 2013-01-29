package org.ahsan.board.web;

import org.ahsan.board.dao.MemoDao;
import org.ahsan.board.domain.Memo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class MemoWrite implements Action, Preparable, ModelDriven<Memo> {

	private Memo memo;
	
	public Memo getMemo() {
		return memo;
	}
	
	public void setMemo(Memo memo) {
		this.memo = memo;
	}
	
	@Override
	public void prepare() throws Exception {
		memo = new Memo();
	}
	
	@Override
	public String execute() throws Exception {
		MemoDao dao = MemoDao.getInstance();
		dao.addMemo(memo);
		return "success";
	}
	
	@Override
	public Memo getModel() {
		return memo;
	}
}
