package com.proj.www.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.www.controller.ComController;
import com.proj.www.util.CalendarUtil;

public class BoardTdetail implements ComController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/boardDetailT.jsp";
		// 이 페이지가 보여질 때 해당 게시글에 캘린더를 사용하는지 물어본다.
		// 그 후 등록일자를 매개변수로 캘린더를 생성하고, 캘린더 안에 게시글정보를 넣는다.
		// 우선 캘린더를 만든다.
		CalendarUtil cal = new CalendarUtil("2020년05월23일");
		// 이달의 시작날짜의 요일 구하고
		int sdate = cal.getSdate(cal);
		// 시작날짜까지의 공백 연출하고
		String[] sblock = cal.getSblock(sdate);
		// 이달의 끝날짜를 구하고
		int eday = cal.getToday();
		// 끝나는 날부터의 공백 구해주고
		int edate = cal.getEdate(cal);
		// 끝나는 날에서부터 공백 가져오고
		String[] eblock = cal.getEblock(edate);
		// 시작일 부터 그달의 마지막 날까지 를 가져오는 함수
		int[] date = cal.getDate(eday);
		// 뷰가 볼수있게 심어준다.
		req.setAttribute("SBLOCK", sblock);
		req.setAttribute("EBLOCK", eblock);
		req.setAttribute("DATE", date);
		req.setAttribute("EDAY", eday);
		return view;
	}

}
