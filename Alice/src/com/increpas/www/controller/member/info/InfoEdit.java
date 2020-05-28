package com.increpas.www.controller.member.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;
import com.increpas.www.vo.MembVO;

public class InfoEdit implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/info/infoEdit.jsp";
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		String type = (String)session.getAttribute("TYPE");
		MembVO mVO = null;
		if("".equals(id) || id==null) {
			req.setAttribute("isRedirect", true);
			view = "/Alice/main/main.do";
			return view;
		}
		MemberDao mDao = new MemberDao();
		if(type.equals("T")) {
			mVO = mDao.getTrainerInfo(id);
		}else {
			mVO = mDao.getMemInfo(id); 			
		}
		
		req.setAttribute("DATA", mVO); 
		return view;
	}

}
