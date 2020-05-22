package com.proj.www.util;

import java.text.*;
import java.util.*;

public class BoardCalendar {
	int year, month, date;
	Calendar cal;
	
	public BoardCalendar() {
		// 인스턴스 가져오고
		cal = Calendar.getInstance();
		// 변수선언
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		date = cal.get(Calendar.DATE);
		// 인스턴스에 셋팅한다.
		cal.set(year, month, date);
	}

	public BoardCalendar(int year, int month, int date) {
		
	}

	// 시작 날짜 받아오는 함수
	public int getsDay() {
		int sDay = cal.getMinimum(Calendar.DATE);
		return sDay;
	}
	
	// 끝나는 날짜 받아오는 함수
	public int geteDay() {
		int eDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return eDay;
	}
	
	// 요일 받아오는 함수
	public int getStart() {
		int start = cal.get(Calendar.DAY_OF_WEEK);
		return start;
	}
	
	// 오늘 날짜 받아오는 함수
	public int getToday() {
		Calendar todayCal = Calendar.getInstance();
		SimpleDateFormat frm = new SimpleDateFormat("yyyyMMdd");
		int today = Integer.parseInt(frm.format(todayCal.getTime()));
		return today;
	}
}
