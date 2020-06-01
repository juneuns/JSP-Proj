package com.increpas.www.controller.member.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;
import com.increpas.www.vo.MembVO;

public class InfoHome implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/info/infoHome.jsp";
		// 회원 이미지 받아오기 
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		if("".equals(id) || id==null) {
			req.setAttribute("isRedirect", true);
			view = "/Alice/main/main.do";
			return view;
		}
		MemberDao mDao = new MemberDao();
		MembVO mVO = mDao.getProfile(id);
		req.setAttribute("DATA", mVO);
		return view;
	}

}
