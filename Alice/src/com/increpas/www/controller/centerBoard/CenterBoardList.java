package com.increpas.www.controller.centerBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;
import com.increpas.www.vo.CenterBoardVO;

public class CenterBoardList implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/centerBoard/centerBoardList.jsp";
		ArrayList<CenterBoardVO> list = new ArrayList<CenterBoardVO>();
		CenterBoardDAO cdao = new CenterBoardDAO();
		list = cdao.getBList();
		req.setAttribute("LIST", list);
		return view;
	}
}
