package com.increpas.www.controller.centerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;

public class CenterBoardNoticeEdit implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/centerBoardNotice.do";
		req.setAttribute("isRedirect",true);
		CenterBoardDAO cDAO = new CenterBoardDAO();
		String ebody = req.getParameter("ebody");
		int bno = Integer.parseInt(req.getParameter("bno"));
		int cnt = cDAO.editNotice(bno, ebody);
		int fno = Integer.parseInt(req.getParameter("fno"));
		HttpSession session = req.getSession();
		session.setAttribute("fno", fno);
		return view;
	}
}
