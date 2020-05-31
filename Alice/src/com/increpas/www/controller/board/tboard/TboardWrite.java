package com.increpas.www.controller.board.tboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.util.CalendarUtil;

public class TboardWrite implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardWrite.jsp";
		
		String sid = (String) req.getSession().getAttribute("SID");
		req.setAttribute("SID", sid);
		// String sid = (String)req.getSession().getAttribute("SID");
		// req.setAttribute("SID", sid);
		
		CalendarUtil cal = new CalendarUtil();
		
		// 달 시작일의 요일 가져오고
		int sdate = cal.getSdate(cal);
		// 시작일로부터 생기는 블럭생성하고
		String[] sblock = cal.getSblock(sdate);
		// 월의 마지막일 가져오고
		int eday = cal.getEday(cal);
		// 날짜의 내용을 채워줄 데이터 가져오고
		int[] edate = cal.getDate(eday);
		
		// 캘린더 정의에 필요한 내용
		req.setAttribute("SBLOCK", sblock);
		// 캘린더 날짜
		req.setAttribute("DATE", edate);
		
		return view;
	}

}
