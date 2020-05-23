package com.proj.www.util;

import java.text.*;
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
		cal = Calendar.getInstance();
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
		System.out.println("생성자 호출 : " + year + month + date);
	}
	
	public CalendarUtil(int year, int month, int date) {
		cal = Calendar.getInstance();
		// 이 클래스가 불려질 때, 매개변수에 년 월 일로 변수가 들어온다면
		this.year = year;
		this.month = month;
		this.date = date;
		
		cal.set(year, month, date);
		System.out.println("생성자 인트변수 호출 : " + year + month + date);
	}
	
	public CalendarUtil(String date) {
		/*
		 	넘어오는 매개변수는 데이터베이스에서 넘어올 때 년도와 일시를 합쳤을 것이므로,
		 	년도까지만 끊어준다. 형식이 yyyy년mm월dd일 일것이므로 문자열 일을 기준으로 짜른다.
		 */
		// 이 클래스가 불러질 때 인스턴스를 생성한다.
		cal = Calendar.getInstance();
		String str = date;
		// 가져온 데이터를 다시 년월일 기준으로 분리하여 캘린더에 셋팅한다.
		String syear = str.substring(0, str.indexOf("년"));
		// 다시 문자열을 정렬하고
		str = str.substring(str.indexOf("년") + 1);
		// 월을 잘라온다.
		String smonth = str.substring(0, str.indexOf("월"));
		// 일을 잘라온다.
		String sdate = str.substring(str.indexOf("월") + 1, str.lastIndexOf("일"));
		// 가져온 String 타입 데이터를 int 타입으로 변환한다.
		int year = Integer.parseInt(syear);
		int month = Integer.parseInt(smonth);
		int day = Integer.parseInt(sdate);
		// 캘린더 인스턴스에 셋팅한다.
		cal.set(year, month, day);
		System.out.println("생성자 스트링 호출 : " + syear + smonth + sdate);
	}
	
	public static void main(String[] args) {
		CalendarUtil cal = new CalendarUtil();
		CalendarUtil cal1 = new CalendarUtil(2020, 05, 20);
		String strr = "2020년5월23일";
		CalendarUtil cal2 = new CalendarUtil(strr);
		
		int start = cal2.getStart();
		System.out.println("오늘 요일 가져오는 변수 : " + start);
		int today = cal2.getToday();
		System.out.println("오늘날짜를 가져오는 함수 : " + today);
		int eday = cal2.getEday();
		System.out.println("해당월 끝나는날 가져오는 함수 : " + eday);
		int sdate = cal2.getSdate(cal2);
		System.out.println("해당월 시작날 요일 가져오는 함수 : " + sdate);
		String[] i = cal2.getSblock(sdate);
		System.out.println("요일이 매개변수로 들어가면 빈칸을 반환해주는 함수" + Arrays.toString(i));
		int edate = cal2.getEdate(cal2);
		System.out.println("해당월 끝나는 날의 요일 가져오는 함수 : " + edate);
		String[] eblock = cal2.getEblock(edate);
		System.out.println("끝나는 날 이후의 블럭처리 : " + Arrays.toString(eblock));
		int[] date = cal2.getDate(eday);
		System.out.println("마지막날까지 반복하는 함수 : " + Arrays.toString(date));
		
	}
	
	// 오늘 요일 받아오는 함수
	public int getStart() {
		int start = cal.get(Calendar.DAY_OF_WEEK);
		return start;
	}
	
	// 오늘을 기준으로 공백을 나타낼 함수
	public String[] getSblock(int sdate) {
		// 끝나는날이 토요일인 경우는 블럭이 필요없다.
		// 따라서 edate = 7인 경우는 만들어 주지 않는다.
		String[] sblock = null;
		if(sdate != 7) {
			sblock = new String[7-sdate];
			// 배열길이까지 반복하는 것이 아닌, 일주일에서 
			// 배열길이만큼의 차를 반복해야 하는 것이다.
			for(int i = 0; i < sblock.length; i++ ) {
				sblock[i] = "&nbsp;";									
			}
		} else {
			return null;
		}
		return sblock;
	}
//	public String[] getSblock(int start) {
//		// 반복문을 진행하여 start의 값까지 회차를 누적시킨다.
//		// 공백만큼의 배열을 만들어서 배열의 길이만큼 빈 날짜를 표현해준다.
//		String[] sblock = new String[start-1];
//		if(sblock.length != 0)
//		for(int i = 0; i < sblock.length; i ++ ) {
//			sblock[i] = "&nbsp;";
//		} else {
//			return null;
//		}
//		return sblock;
//	}
	// 끝나는 날 이후의 블럭을 만들어줄 함수
	public String[] getEblock(int edate) {
		// 끝나는날이 토요일인 경우는 블럭이 필요없다.
		// 따라서 edate = 7인 경우는 만들어 주지 않는다.
		String[] eblock = null;
		if(edate != 7) {
			eblock = new String[7-edate];
			// 배열길이까지 반복하는 것이 아닌, 일주일에서 
			// 배열길이만큼의 차를 반복해야 하는 것이다.
			for(int i = 0; i < eblock.length; i++ ) {
				eblock[i] = "&nbsp;";									
			}
		} else {
			return null;
		}
		return eblock;
	}
	
	// 마지막 날짜까지 반복해서 배열로 반환해주는 함수
	public int[] getDate(int eday) {
		int[] Date = new int[eday];
		for(int i = 0; i < Date.length; i++ ) {
			Date[i] = i+1;
		}
		return Date;
	}

	// 마지막 날짜를 받아오는 함수
	public int getEday() {
		int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return eday;
	}
	
	// 오늘 날짜 받아오는 함수
	public int getToday() {
		Calendar todayCal = Calendar.getInstance();
		SimpleDateFormat frm = new SimpleDateFormat("yyyy년MM월dd일");
		String sday = frm.format(todayCal.getTime());
		String tday = sday.substring(sday.indexOf("월") + 1, sday.indexOf("일"));
		int today = Integer.parseInt(tday);
		return today;
	}
	
	// 시작일의 요일을 알아내는 함수
	public int getSdate(CalendarUtil cal) {
		int sdate = 0;
		// 오늘 요일 가져오고
		int start = cal.getStart();
		// 오늘 날짜 가져오고
		int today = cal.getToday();
		// 오늘 날짜부터 역순으로 계산
		for(int i = 1; i < today; i++) {
			if(sdate == 0) {
				sdate = (start - 1);
			} else {
				sdate -= 1;
			}			
		}
		// 반복 진행을 위해 토요일을 0으로 사용했으므로, 다시 7로 바꿔준다.
		if(sdate == 0) {
			sdate = 7;
		}
		return sdate;
	}
	
	// 해당월의 끝나는 날의 요일을 알아내는 함수
	public int getEdate(CalendarUtil cal) {
		// 시작날의 요일을 가져오고
		int sdate = cal.getSdate(cal);
		// 시작날부터 요일 계산할 변수 만들고;
		int edate = sdate;
		// 끝나는 날짜 가져오고
		int eday = cal.getEday();
		// 끝나는날의 요일까지 반복한다.
		for(int i = 1; i < eday; i++ ) {
			if(edate == 6) {
				edate = 0;
//				System.out.println(edate);
			} else {
				edate += 1;
//				System.out.println(edate);
			}
		}
		// 반복진행을 위해 토요일을 0으로 사용했으므로, 다시 7로 바꿔준다.
		if(edate == 0) {
			edate = 7;
		}
		return edate;
	}
}
