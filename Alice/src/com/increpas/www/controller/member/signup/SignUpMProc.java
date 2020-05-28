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
import com.increpas.www.vo.MembVO;

public class SignUpMProc implements DoController{
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view =null;
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
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String addr3 = req.getParameter("addr3");
		if("".equals(addr3)) {
			addr3=null;
		}
		// 체형 따로 받은 것 합치기 
		// 여기서부터는 부가정보 
		String height = req.getParameter("height");
		if("".equals(height)) {
			height=null;
		}
		String weight = req.getParameter("weight");
		if("".equals(weight)) {
			weight=null;
		}
		String body = height+" "+weight;
		if("".equals(body)) {
			body=null;
		}
		String goal = req.getParameter("goal");
		if("".equals(goal)) {
			goal=null;
		}
		String pagree = req.getParameter("pagree");
		if("".equals(pagree)) {
			pagree="N";
		}
		String ptime =req.getParameter("ptime");
		if("".equals(ptime)) {
			ptime=null;
		}
		MembVO mVO = new MembVO();
		mVO.setId(id);
		mVO.setPw(pw);
		mVO.setName(name);
		mVO.setTel(tel);
		mVO.setMail(mail);
		mVO.setAddr1(addr1);
		mVO.setAddr2(addr2);
		mVO.setAddr3(addr3);
		
		mVO.setBody(body);
		mVO.setGoal(goal);
		mVO.setPtime(ptime);
		mVO.setPagree(pagree);
		MemberDao mDao = new MemberDao();
		cnt = mDao.addMem(mVO);
		if(cnt != 1 ) {
			view ="/Alice/member/signUp/signUpAgree.do";
		}else {
			cnt = mDao.addMemInfo(mVO);
			if(cnt==1) {
				view="/Alice/member/signUp/signUpResult.do";
			} else {
				view="/Alice/member/signUp/signUpAgree.do";
			}
		}
		req.setAttribute("isRedirect", true);
		return view;
	}
}
