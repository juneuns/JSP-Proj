package com.increpas.www.controller.centerBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;
import com.increpas.www.vo.CenterBoardVO;

public class CenterBoardNotice implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/centerBoard/centerBoardNotice.jsp";
//		int fno = Integer.parseInt(req.getParameter("fno"));
		int fno = 1002;
		CenterBoardDAO cDAO = new CenterBoardDAO();
		ArrayList<CenterBoardVO> nlist = cDAO.getNList(fno);
//		ArrayList<CenterBoardVO> rlist = cDAO.getRList(fno);
		CenterBoardVO cvo = cDAO.getFInfo(fno);		

		req.setAttribute("cvo",cvo);
		req.setAttribute("NLIST", nlist);
//		req.setAttribute("RLIST", rlist);
		
		return view;
	}
}