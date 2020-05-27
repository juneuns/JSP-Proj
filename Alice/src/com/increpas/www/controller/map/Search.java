package com.increpas.www.controller.map;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MapDAO;
import com.increpas.www.vo.MsearchVO;

public class Search implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="/map/search.jsp";
		MapDAO aDAO = new MapDAO();
		String keyword = req.getParameter("keyword");
		HttpSession session = req.getSession();
		String type = (String)session.getAttribute("type");
		ArrayList<MsearchVO> slist = aDAO.getKeyword(type,keyword);
	    req.setAttribute("KEYWORD", keyword);
		req.setAttribute("SLIST", slist);
		return view;
	
	}

}
