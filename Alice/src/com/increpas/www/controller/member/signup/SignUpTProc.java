package com.increpas.www.controller.member.signup;
/**
 *  이 클래스는 트레이너 회원이 회원가입시 응답하는 클래스이다.
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
import com.increpas.www.vo.UImgFileVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class SignUpTProc implements DoController{
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
		String path = req.getSession().getServletContext().getRealPath("userimg");
		
		MultipartRequest multi = null;
		try { 
			multi = new MultipartRequest(req, path,1024 * 1024 * 6 , "UTF-8",new DefaultFileRenamePolicy());
		} catch(Exception e){
			e.printStackTrace();
		}
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String name = multi.getParameter("name");
		String tel = multi.getParameter("tel");
		String mail = multi.getParameter("mail");
		String addr1 = multi.getParameter("addr1");
		String addr2 = multi.getParameter("addr2");
		String addr3 = multi.getParameter("addr3");
		if("".equals(addr3)) {
			addr3=null;
		}
		String career = multi.getParameter("career");
		String info = multi.getParameter("info");
		String sfno = multi.getParameter("fno");
		int fno = 0;
		try {
			fno = Integer.parseInt(sfno);
		} catch(Exception e) {}
		MembVO mVO = new MembVO();
		mVO.setId(id);
		mVO.setPw(pw);
		mVO.setName(name);
		mVO.setTel(tel);
		mVO.setMail(mail);
		mVO.setAddr1(addr1);
		mVO.setAddr2(addr2);
		mVO.setAddr3(addr3);
		mVO.setCareer(career);
		mVO.setInfo(info);
		mVO.setFno(fno);
		MemberDao mDao = new MemberDao();
		
		cnt = mDao.addTrainer(mVO);
		
		if(cnt != 1 ) {
			view = "/Alice/member/signUp/signUpAgree.do";
			return view;
		}
		cnt = mDao.addTInfo(mVO);
		UImgFileVO fVO = new UImgFileVO();
		fVO.setId(id);
		fVO.setMulti(multi);
		boolean bool = mDao.addImgInfo(fVO);
		if(!bool) {
			view = "/Alice/main/main.do";
		}
		req.setAttribute("isRedirect", true);
		return view;
	}
}
