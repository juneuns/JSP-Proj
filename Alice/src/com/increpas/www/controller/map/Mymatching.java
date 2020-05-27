package com.increpas.www.controller.map;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MapDAO;
import com.increpas.www.vo.MatchingVO;

public class Mymatching implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";
		MapDAO mdao = new MapDAO();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		ArrayList<MatchingVO> mlist = mdao.getMYPT(id);
		req.setAttribute("MLIST", mlist);
		return view;
	}

}
