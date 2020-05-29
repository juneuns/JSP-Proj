package com.increpas.www.controller.centerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;

public class CenterBoardNoticeDelete implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/centerBoardNotice.do";
		req.setAttribute("isRedirect",true);
		int fno = 1002;
		int bno = Integer.parseInt(req.getParameter("bno"));
		CenterBoardDAO cdao = new CenterBoardDAO();
		int cnt = cdao.delNotice(bno);
		return view;
	}

}
