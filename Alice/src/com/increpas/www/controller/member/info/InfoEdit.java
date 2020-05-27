package com.increpas.www.controller.member.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class InfoEdit implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/info/infoEdit.jsp";
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		int cnt = -1; 
		MemberDao mDao = new MemberDao();
		
		
		return view;
	}

}
