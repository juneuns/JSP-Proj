package com.increpas.www.controller.map;
/**
 * 이 클래스는 
 * @author 정우승
 * 
 */
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MapDAO;
import com.increpas.www.vo.AddrVO;

public class Profile implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/map/profile.jsp";
		MapDAO tdao = new MapDAO();
		/* ArrayList<AddrVO> tlist = tdao.getTinfo(id); */
		/* req.setAttribute("TLIST", tlist); */
		return view;
	}

}
