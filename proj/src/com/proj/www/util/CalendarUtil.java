package com.proj.www.util;

/**
 * 이 클래스는 게시글 등록일자를 토대로 화면에 보여질 캘린더의 날짜를 계산하기 위해서
 * 만들어진 유틸리티적인 클래스
 * @author	주재석
 *
 */
import java.util.*;

public class CalendarUtil {
	private int year; // 년도를 담을 변수.
	private int month; // 월을 담을 변수.
	private int date; // 날짜를 담을 변수.
	
	private int start; // 오늘을 기준으로 요일을 담을 변수.(일요일: 1, 토요일: 7)
	
	Calendar cal; // 캘린더의 변수를 쓰기위해 미리 초기화한다.
	
	public CalendarUtil() {
		// 이 클래스가 불려질 때, 매개변수에 데이터가 없다면 오늘을 기준으로 날짜가 셋팅된다.
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		date = cal.get(Calendar.DATE);
//		// 생성자가 오버라이딩 되어 있으므로 중복하여 사용하지 않기위해 String 타입으로 변환하여 오버로딩한다.
//		String syear = Integer.toString(year);
//		String smonth = Integer.toString(month);
//		String sdate = Integer.toString(date);
//		
//		String tdate = syear + "년" + smonth + "월" + sdate + "일";
//		this(tdate);
		cal.set(year, month, date);
	}
	
	public CalendarUtil(int year, int month, int date) {
		// 이 클래스가 불려질 때, 매개변수에 년 월 일로 변수가 들어온다면
		this.year = year;
		this.month = month;
		this.date = date;
		
		cal.set(year, month, date);
	}
	
	public CalendarUtil(String date) {
		/*
		 	넘어오는 매개변수는 데이터베이스에서 넘어올 때 년도와 일시를 합쳤을 것이므로,
		 	년도까지만 끊어준다. 형식이 yyyy년mm월dd일 일것이므로 문자열 일을 기준으로 짜른다.
		 */
		// 이 클래스가 불러질 때 인스턴스를 생성한다.
		String str = date.substring(0, date.indexOf("일"));
		// 가져온 데이터를 다시 년월일 기준으로 분리하여 캘린더에 셋팅한다.
		String syear = str.substring(0, str.indexOf("년"));
		// 다시 문자열을 정렬하고
		str = str.substring(str.indexOf("년") + 1);
		// 월을 잘라온다.
		String smonth = str.substring(0, str.indexOf("월"));
		// 일을 잘라온다.
		String sdate = str.substring(str.indexOf("월") + 1, str.lastIndexOf("일") - 1);
		// 가져온 String 타입 데이터를 int 타입으로 변환한다.
		int year = Integer.parseInt(syear);
		int month = Integer.parseInt(smonth);
		int day = Integer.parseInt(sdate);
		// 캘린더 인스턴스에 셋팅한다.
		cal.set(year, month, day);
	}
	
	// 오늘을 기준으로 공백을 나타낼 함수
	public int getSblock(int start) {
		int block = 0;
		// 반복문을 진행하여 start의 값까지 회차를 누적시킨다.
		for(int i = 0; i < start; i++) {
			block++;
		}
		return block;
	}
	
	// 
	public int getSday() {
		int sday = cal.getMinimum(Calendar.DATE);
		return sday;
	}
}
