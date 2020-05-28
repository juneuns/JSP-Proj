package com.increpas.www.controller.member.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;

public class SignUpResult implements DoController{
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/signUp/signUpResult.jsp";
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		if(sid!=null) {
			req.setAttribute("isRedirect", true);
			view="/Alice/main/main.do";
			return view;
		}
		return view;
	}
}
