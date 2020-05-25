package com.increpas.www.controller.member.signIn;
/**
 * 이 클래스는 로그인 처리 요청이 들어오면 응답하는 클래스이다.
 * 
 * @author	박광호
 * @since	2020.05.25
 * @version	v 1.0.0
 * @see 	
 * 			
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class SignInFProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="/main/main.do";
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String f= req.getParameter("f");
		int cnt = 0; 
		int fno = 0;
		MemberDao mDao = new MemberDao();
		cnt = mDao.getSignIn(id, pw, f);
		
		if(cnt == 1 ) {
			fno=mDao.getFPK(id);
			HttpSession session = req.getSession();
			session.setAttribute("SID", id);
			session.setAttribute("FNO", fno);
		}else {
			String msg = "로그인 실패";
			req.setAttribute("MSG", msg);
		}
		
		req.setAttribute("isRedirect", true);
		return view;
	}

}
