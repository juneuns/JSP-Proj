package com.increpas.www.controller.board.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.TboardDAO;

public class ReplyEditProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardRedirect.jsp";
		
		String strbno = req.getParameter("bno");
		String strno = req.getParameter("rno");
		String rupdate = req.getParameter("rupdate");
		String id = (String)req.getSession().getAttribute("SID");
		int bno = 0;
		int rno = -1;
		int empno = 7369;
		System.out.println("strbno : " + strbno);
		System.out.println("strno : " + strno);
		try {
			bno = Integer.parseInt(strbno);
			rno = Integer.parseInt(strno);
//			System.out.println("*****************************");
		} catch(Exception e) {}
		System.out.println("bno : " + bno + "runo : " + rno);
		
		TboardDAO tdao = new TboardDAO();
		int cnt = tdao.updRpl(rupdate, rno);
		System.out.println("cnt : " + cnt);
		if(cnt != 1) {
			view = "/tboard/tboardList.do";
			req.setAttribute("isRedirect", true);
		}
		req.setAttribute("BNO", bno);

		return view;
	}

}
