package com.increpas.www.controller.member.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;

public class PwEditResult implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/info/pwEditResult.jsp";
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		if("".equals(id) || id==null) {
			req.setAttribute("isRedirect", true);
			view = "/Alice/main/main.do";
		}
		return view;
	}

}
