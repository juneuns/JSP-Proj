package com.increpas.www.controller.member.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;

public class FitPop implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/signUp/fitPop.jsp";
		
		return view;
	}

}
