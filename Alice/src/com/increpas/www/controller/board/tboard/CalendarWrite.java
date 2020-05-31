package com.increpas.www.controller.board.tboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.TboardDAO;

public class CalendarWrite implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";
		TboardDAO tdao = new TboardDAO();
		String htn = req.getParameter("htn");
		String htb = req.getParameter("htb");
		String eat = req.getParameter("eat");
		String strbno = req.getParameter("bno");
		int bno = 0;
		try {
			bno = Integer.parseInt(strbno);
		} catch(Exception e){}
		
		tdao.insCbo(htn, htb, eat, bno);
		
		return null;
	}

}
