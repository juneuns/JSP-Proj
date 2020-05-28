package com.increpas.www.controller.board.tboard;

/**
 * 이 클래스는 게시글을 수정할 때 사용될 클래스입니다.
 * @author	주재석
 * @since	2020.05.28
 */
import javax.servlet.http.*;
import javax.servlet.*;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.TboardDAO;
import com.increpas.www.vo.*;

public class TboardEdit implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardWrite.jsp";
		
		String strbno = req.getParameter("bno");
		String sid = (String) req.getSession().getAttribute("SID");
		
		int bno = 0;
		try {
			bno = Integer.parseInt(strbno);
		} catch(Exception e) {}
//		System.out.println("Edit bno : " + bno);
		TboardDAO tdao = new TboardDAO();
		TboardVO tvo = tdao.getBoard(bno);
		
		req.setAttribute("DATA", tvo);
		req.setAttribute("BNO", bno);
		req.setAttribute("SID", sid);

		return view;
	}

}
