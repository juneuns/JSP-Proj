package com.increpas.www.controller.centerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;

public class CenterBoardSongEdit implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/gogym/centerBoardSong.do";
		req.setAttribute("isRedirect",true);
		CenterBoardDAO cDAO = new CenterBoardDAO();
		String ebody = req.getParameter("ebody");
		int bno = Integer.parseInt(req.getParameter("bno"));
		int cnt = cDAO.editSong(bno, ebody);
		return view;
	}
}
