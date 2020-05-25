package com.increpas.www.controller.member.findId;
/**
 * 이 클래스는 시설회원이 아이디 찾기 처리 요청을 하면 응답하는 클래스이다.
 * @author	박광호
 * @since	2020.05.24
 * @version	v 1.0.3
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class FindIdFProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String f = req.getParameter("f");
		req.setAttribute("isRedirect",true);
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getValidInfo(name, mail, f);
		if(cnt != 1 ) {
			req.setAttribute("FAILEDMSG", "아이디를 찾을 수 없습니다.");
			view ="/Alice/member/findId/findId.do";
			return view;
		}
		String id = mDao.getID(name, mail, f);
		HttpSession session = req.getSession();
		session.setAttribute("FINDID", id);
		
		view = "/Alice/member/findId/findIdResult.do";
		return view;
	}

}
