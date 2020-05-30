package com.increpas.www.controller.member.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;

public class LogoutProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/main/main.do";
		HttpSession session = req.getSession();
		
		session.removeAttribute("SID");
		session.removeAttribute("FNO");
		session.removeAttribute("fno");
		session.removeAttribute("TYPE");
		req.setAttribute("isRedirect", true);
		return view;
	}
}
