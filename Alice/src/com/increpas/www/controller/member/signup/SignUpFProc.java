package com.increpas.www.controller.member.signup;
/**
 *  이 클래스는 일반회원이 회원가입시 응답하는 클래스이다.
 *  @author	박광호
 *  @since	2020.05.27
 *  @version	v 1.0.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;
import com.increpas.www.vo.FitVO;

public class SignUpFProc implements DoController{
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="/Alice/member/signUp/signUpResult.do";
		int cnt = 0;
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		if(sid!=null) {
			req.setAttribute("isRedirect", true);
			view="/Alice/main/main.do";
			return view;
		}
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String foname = req.getParameter("name");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String addr3 = req.getParameter("addr3");
		String fname = req.getParameter("fname");
		if("".equals(addr3)) {
			addr3=null;
		}
		FitVO fiVO = new FitVO();
		fiVO.setId(id);
		fiVO.setPw(pw);
		fiVO.setFname(fname);
		fiVO.setFoname(foname);
		fiVO.setTel(tel);
		fiVO.setMail(mail);
		fiVO.setAddr1(addr1);
		fiVO.setAddr2(addr2);
		fiVO.setAddr3(addr3);
		MemberDao mDao = new MemberDao();
		cnt = mDao.addFit(fiVO);
		
		if(cnt !=1 ) {
			view = "/Alice/main/main.do";
			req.setAttribute("isRedirect", true);
			return view;
		}
		
		req.setAttribute("isRedirect", true);
		return view;
	}
}
