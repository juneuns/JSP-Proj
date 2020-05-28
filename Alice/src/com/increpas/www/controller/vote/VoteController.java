package com.increpas.www.controller.vote;


import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.increpas.www.controller.DoController;
import com.increpas.www.dao.VoteDao;

public class VoteController implements DoController {
	
	@Override
	public String exec(HttpServletRequest req,HttpServletResponse resp) {
		String view = "";
		
		String strvno = req.getParameter("vno");
		String strPage = req.getParameter("nowPage");
		int vno = 0;
		int nowPage = 1;
		
		try {
			vno = Integer.parseInt(strvno);
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		
		VoteDao vdao = new VoteDao();
		int cnt = vdao.updClick(vno);
		
		if(cnt !=1) {
			view = "/Alice/vote/VoteCheck.do";
			req.setAttribute("isRedirect", true);
			return view;
		}
		return view;
	} 
}

