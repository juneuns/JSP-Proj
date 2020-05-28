package com.increpas.www.controller.board.reply;

/**
 * 이 클래스는 게시글의 댓글과 대댓글을 작성하기 위한 클래스입니다.
 * @author	주재석
 * @since	2020.05.28
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.*;

public class ReplyWrite implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String strbno = req.getParameter("bno");
		String struno = req.getParameter("runo");
		String rcontent = req.getParameter("rcontent");
		String rupdate = req.getParameter("rupdate");
		String id = (String)req.getSession().getAttribute("SID");
		int bno = 0;
		int runo = -1;
		int empno = 7369;
//		System.out.println("strbno : " + strbno);
//		System.out.println("struno : " + struno);
		try {
			bno = Integer.parseInt(strbno);
			runo = Integer.parseInt(struno);
//			System.out.println("*****************************");
		} catch(Exception e) {}
		System.out.println("bno : " + bno + "runo : " + runo);
		if(runo != -1) {
			TboardDAO tdao = new TboardDAO();
			tdao.insRly(empno, rupdate, bno, runo);
		} else {
			TboardDAO tdao = new TboardDAO();
			tdao.insRly(empno, rcontent, bno, runo);			
		}
		
		String view = "/board/tboard/tboardRedirect.jsp";
		req.setAttribute("BNO", bno);

		return view;
	}

}
