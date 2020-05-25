package com.proj.www.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.www.controller.ComController;

public class BoardTwrite implements ComController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/boardWriteT.jsp";
		return view;
	}

}
