package com.proj.www.controller.board;

import javax.servlet.http.*;

import com.proj.www.controller.ComController;
import com.proj.www.dao.*;

public class BoardTwriteProc implements ComController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";
		String title = req.getParameter("title");
		String bcontent = req.getParameter("bcontent");
		String ename = (String) req.getSession().getAttribute("ename");
		
		TboardDAO tdao = new TboardDAO();
		int cnt = tdao.addTbo(title, bcontent, ename);
		if(cnt == 1) {
			req.setAttribute("isRedirect", true);
			view = "/proj/board/boardTlist.do";
		} else {
			
		}
		
		return view;
	}

}
