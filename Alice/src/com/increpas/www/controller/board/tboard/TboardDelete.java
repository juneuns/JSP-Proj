package com.increpas.www.controller.board.tboard;

/**
 * 이 클래스는 게시글이 더이상 보이지 않게 하는 클래스입니다.
 * @author	주재석
 * @since	2020.05.26
 */

import javax.servlet.*;
import javax.servlet.http.*;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.*;

public class TboardDelete implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/tboard/tboardList.do";
		req.setAttribute("isRedirect", true);
		String strbno = req.getParameter("bno");
		String strPage = req.getParameter("nowPage");
		int bno = 0;
		int nowPage = 1;
		try {
			bno = Integer.parseInt(strbno);
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		
//		System.out.println("bno : " + bno);
//		System.out.println("nowPage : " + nowPage);
		TboardDAO tdao = new TboardDAO();
		int cnt = tdao.DelBrd(bno);
//		System.out.println("cnt : " + cnt);
		if(cnt != 1) {
			view = "/Alice/tboard/tboardDetail.do";
		}
		
		return view;
	}

}
