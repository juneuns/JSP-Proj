package com.increpas.www.controller.centerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;

public class CenterBoardNoticeWrite implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/gogym/centerBoardNotice.do";
		req.setAttribute("isRedirect",true);
		String body = req.getParameter("body");
		System.out.println(body);
		int fno = Integer.parseInt(req.getParameter("fno"));
		CenterBoardDAO cDAO = new CenterBoardDAO();
		int cnt = cDAO.addNotice(fno,body);
		return view;
	}
}

