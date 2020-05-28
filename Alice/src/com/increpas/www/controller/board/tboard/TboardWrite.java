package com.increpas.www.controller.board.tboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;

public class TboardWrite implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardWrite.jsp";
		
		int empno = 7369;
		req.setAttribute("SID", empno);
		// String sid = (String)req.getSession().getAttribute("SID");
		// req.setAttribute("SID", sid);
		
		return view;
	}

}
