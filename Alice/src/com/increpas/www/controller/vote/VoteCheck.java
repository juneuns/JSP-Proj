package com.increpas.www.controller.vote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.VoteDao;

public class VoteCheck implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="/vote/vote.do";
		String id = "zhsekfkawnl";
		
		VoteDao vdao = new VoteDao();
		int cnt = vdao.getVote(id);
		
		return view;
	}

}

