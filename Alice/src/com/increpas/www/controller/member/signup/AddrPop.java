package com.increpas.www.controller.member.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;

public class AddrPop implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/signUp/addrPop.jsp";
		String inputYn = req.getParameter("inputYn");
		String roadFullAddr = req.getParameter("roadFullAddr");
		String roadAddrPart1 = req.getParameter("roadAddrPart1");
		String confmKey = "devU01TX0FVVEgyMDIwMDUxNzIyMzI0MjEwOTc2NTM=";
		String zipNo = req.getParameter("zipNo");
		System.out.println("#### inputYn : " + inputYn);
		req.setAttribute("INPUTYN", inputYn);
		req.setAttribute("CONFMKEY", confmKey);
		
		req.setAttribute("ROADFULLADDR", roadFullAddr);
		req.setAttribute("ROADADDRPART1", roadAddrPart1);
		req.setAttribute("ZIPNO", zipNo);
		return view;
	}

}
