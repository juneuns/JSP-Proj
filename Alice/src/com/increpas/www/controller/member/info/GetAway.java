package com.increpas.www.controller.member.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class GetAway implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/main/main.do";
		req.setAttribute("isRedirect", true);
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		
		if("".equals(id)||id==null) {
			view = "/Alice/main/main.do";
			return view;
		}
		MemberDao mDao = new MemberDao();
		int cnt = 0 ; 
		cnt = mDao.getAwayUser(id); 
		if (cnt != 1) {
			view = "/Alice/main/main.do";
			return view;
		}
		session.removeAttribute("SID");
		session.removeAttribute("TYPE");
		return view;
	}

}
