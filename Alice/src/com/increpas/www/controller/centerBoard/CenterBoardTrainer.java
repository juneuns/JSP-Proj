package com.increpas.www.controller.centerBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;
import com.increpas.www.vo.CenterBoardVO;

public class CenterBoardTrainer implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/centerBoard/centerBoardTrainer.jsp";
		int fno = 1002;
		CenterBoardDAO cdao = new CenterBoardDAO();
		ArrayList<CenterBoardVO> list = new ArrayList<CenterBoardVO>();
		list = cdao.getTLIST(fno);
		req.setAttribute("LIST", list);
		return view;
	}
}
