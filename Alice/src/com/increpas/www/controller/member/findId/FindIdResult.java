package com.increpas.www.controller.member.findId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;

public class FindIdResult implements DoController{
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/findId/findIdResult.jsp";
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("FINDID");
		
		session.removeAttribute("FINDID");
		
		req.setAttribute("FINDID", id);
		return view;
	}
}
