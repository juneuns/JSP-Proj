package com.increpas.www.controller.member.findId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;

public class FindIdResult implements DoController{
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/findId/findIdResult.jsp";
		String id = req.getParameter("id");
		
		req.setAttribute("FINDID", id);
		req.setAttribute("isRedirect", true);
		return view;
	}
}
