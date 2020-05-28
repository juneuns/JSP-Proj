package com.increpas.www.controller.board.tboard;


/**
 * 이 클래스는 사이드바 메뉴를 통해 트레이너 게시판 목차를 볼때의 요청을 처리할 클래스입니다.
 * @author	주재석
 * @since	2020.05.25
 */
import java.util.*;
import javax.servlet.http.*;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.*;
import com.increpas.www.util.*;

public class TboardList implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardList.jsp";
		
		int nowPage = 1;
		String sid = (String)req.getSession().getAttribute("SID");
		String type = (String)req.getSession().getAttribute("TYPE");
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		
		TboardDAO tdao = new TboardDAO();
		int totalCount = tdao.getCont();
		PageUtil page = new PageUtil(nowPage, totalCount, 5, 2);
		
		ArrayList list = tdao.getALL(page);
		
		// 아이디를 통해 , 그 사용자의 type을 조회하여 요청에 심는다.
		req.setAttribute("SID", sid);
		req.setAttribute("TYPE", type);
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		return view;
	}

}
