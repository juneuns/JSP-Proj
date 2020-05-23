package com.proj.www.controller.board;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.www.controller.ComController;
import com.proj.www.util.CalendarUtil;

public class BoardTlist implements ComController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/boardListT.jsp";
		
		return view;
	}

}
