package com.increpas.www.controller.centerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;
import com.increpas.www.vo.CenterBoardVO;

public class CenterBoardMain implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/centerBoard/centerBoardMain.jsp";
		int fno = 1002;
		req.setAttribute("fno", fno);
		int divno = 1;
		CenterBoardDAO cdao1 = new CenterBoardDAO();
		CenterBoardVO cvo1 = new CenterBoardVO();
		cvo1 = cdao1.getMImg(fno, divno);
		req.setAttribute("ivo1", cvo1);
		CenterBoardDAO cdao2 = new CenterBoardDAO();
		CenterBoardVO cvo2 = new CenterBoardVO();
		divno++;
		cvo2 = cdao2.getMImg(fno, divno);
		req.setAttribute("ivo2", cvo2);
		CenterBoardDAO cdao3 = new CenterBoardDAO();
		CenterBoardVO cvo3 = new CenterBoardVO();
		divno++;
		cvo3 = cdao3.getMImg(fno, divno);
		req.setAttribute("ivo3", cvo3);
		return view;
	}

}
