package com.increpas.www.controller.member.findPW;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;
import com.increpas.www.util.Mailing;

public class FindPassUProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/member/findPW/findPassResult.do";
		req.setAttribute("isRedirect", true);
		int cnt = 0 ;
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String f= null;
		// DB에 일치하는 id가 없다면 req.setAttribute에 플래그를 만들어 view 반환  
		MemberDao mDao = new MemberDao();
		cnt = mDao.passFindProc(name, id, mail, f);
		if(cnt != 1 ) {
			req.setAttribute("FAILDMSG", "입력하신 정보를 다시 확인해주세요.");
			view = "/Alice/member/findPW/findPass.do";
			return view; 
		} else if(cnt == 1) {
			cnt = mDao.editPW(name, id, mail, f);
			if(cnt == 1 ) {
				Mailing mailSend = new Mailing();
				try {
					mailSend.sendMail(mail, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		return view;
	}

}
