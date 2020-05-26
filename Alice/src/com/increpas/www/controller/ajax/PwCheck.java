package com.increpas.www.controller.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class PwCheck implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		StringBuffer buff = new StringBuffer();
		String pw = req.getParameter("pw");
		String f = req.getParameter("type");
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		int cnt = 0 ; 
		MemberDao mDao = new MemberDao();
		System.out.println("id , type , pw " + id + "|" + f + "|" +pw+"|");
		cnt = mDao.getPWCK(id, pw, f);
		if(cnt == 1 ) {
			buff.append("{");
			buff.append("	\"result\":\"ok\"");
			buff.append("}");
		}else {
			buff.append("{");
			buff.append("	\"result\":\"no\"");
			buff.append("}");
		}
		req.setAttribute("isRedirect", null);
		
		return buff.toString();
	}

}
