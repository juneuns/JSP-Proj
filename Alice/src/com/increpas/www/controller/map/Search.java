package com.increpas.www.controller.map;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MapDAO;
import com.increpas.www.vo.AddrVO;

public class Search implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="/map/search.jsp";
		MapDAO aDAO = new MapDAO();
		String keyword = req.getParameter("keyword");
		ArrayList<AddrVO> list = aDAO.getList();
		ArrayList<AddrVO> slist = aDAO.getKeyword(keyword);
	    req.setAttribute("KEYWORD", keyword);
		req.setAttribute("SLIST", slist);
		req.setAttribute("LIST", list);
		return view;
	
	}

}
