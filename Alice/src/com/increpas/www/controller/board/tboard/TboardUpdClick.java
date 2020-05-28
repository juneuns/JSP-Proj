package com.increpas.www.controller.board.tboard;

/**
 * 이 클래스는 게시글 상세보기로 클릭되어 뷰를 보여주기전 클릭수 업데이트를 위한 클래스입니다.
 * @author	주재석
 * @since	2020.05.27
 */
import javax.servlet.http.*;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.TboardDAO;

public class TboardUpdClick implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardRedirect.jsp";
		String strbno = req.getParameter("bno");
		String strPage = req.getParameter("nowPage");
		int bno = 0;
		int nowPage = 0;

		try {
			bno = Integer.parseInt(strbno);
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		
		TboardDAO tdao = new TboardDAO();
		int cnt = tdao.updClick(bno);
		
		if(cnt != 1) {
			view = "/Alice/tboard/tboardList.do";
			req.setAttribute("isRedirect", true);
			return view;
		}
		
		req.setAttribute("BNO", bno);
		req.setAttribute("nowPage", nowPage);
		return view;
	}

}
