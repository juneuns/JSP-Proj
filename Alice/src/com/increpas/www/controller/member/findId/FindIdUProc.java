package com.increpas.www.controller.member.findId;
/**
 * 이 클래스는 아이디 찾기 처리 요청이 오면 응답하는 클래스이다.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class FindIdUProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/member/findId/findIdResult.do";
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String f = null;
		MemberDao mDao = new MemberDao();
		String id = mDao.getID(name, mail, f);
		
		 view = "/Alice/member/findId/findIdResult.do?id="+id;
		req.setAttribute("isRedirect",true);
		return view;
	}

}
