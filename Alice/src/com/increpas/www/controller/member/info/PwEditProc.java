package com.increpas.www.controller.member.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class PwEditProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";
		req.setAttribute("isRedirect", true);
		String pw = req.getParameter("pw");
		String f = req.getParameter("f");
		if("".equals(f) || f ==null) {
			f = null;
		}
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		int cnt = 0 ; 
		
		MemberDao mDao = new MemberDao();
		cnt = mDao.editPW(id, pw, f);
		if(cnt != 1) {
			view = "/Alice/member/info/pwEdit.do";
			req.setAttribute("FAILEDMSG", "비밀번호 변경에 실패했습니다.");
		} else {
			view = "/Alice/member/info/pwEditResult.do";
		}
		
		return view;
	}

}
