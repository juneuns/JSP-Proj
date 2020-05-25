package com.proj.www.controller.board;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.proj.www.controller.ComController;
import com.proj.www.util.BoardCalendar;

public class BoardForm implements ComController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/boardForm.jsp";
		// 오늘날짜로 셋팅된 캘린더를 가져온다.
		BoardCalendar cal = new BoardCalendar();
		// 일요일에서부터 오늘요일까지의 공백을 표현해준다.
		// 1. 오늘날짜 가져오고
		int start = cal.getStart();
		// 2. 횟수를 구한다.
		ArrayList block = new ArrayList();
		for(int i = 1; i < start; i++) {
			block.add("&nbsp;");
		}
		// 3. 횟수를 담은 리스트를 반환한다.
		req.setAttribute("LIST", block);
		
		// 이제 해당월의 날짜를 리스트로 보여준다.
		// 이때 일요일은 빨간색 토요일은 파란색으로 표현해야하므로, 횟수에 맞게 색을 바꿔준다.
		// 1. 횟수체크 변수선언
		int yoil = 0;
		// 2. 날짜를 담을 리스트 만들고
		ArrayList day = new ArrayList();
		// 3. 횟수를 구한다. 달의 끝날까지
		int eday = cal.geteDay();
		for(int i = 1; i <= eday; i++ ) {
			// 요일에 맞게 바꿔줄 컬러
			String color = "";
			if(yoil == 0) { // 이경우 일요일
				color = "RED";
			} else if (yoil == 6) {
				color = "light-blue";
			} else {
				color = "BLACK";
			}
			
		}
		
		return view;
	}

}