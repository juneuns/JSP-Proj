package com.proj.www.util;

/**
 * 이 클래스는 리스트에서 보여질 한 페이지 내의 게시물 갯수와 페이지 수를 처리하는
 * 유틸리티 적인 클래스 입니다.
 * @author jueunhae
 *
 */
public class PageUtil {
	private int startPage;	// 시작페이지
	private int endPage;	// 끝페이지
	
	private int rowPage;	// 한 화면에 보여질 페이지 수
	private int totalPage;	// 보여질 총 페이지 수
	
	private int rowCont;	// 한 화면에 보여질 게시글 수
	private int totalCont;	// 보여질 총 게시글 수
	
	public PageUtil() {}
	
	public PageUtil(int rowCont, int totalCont) {
		this(3, 3, rowCont, totalCont);
	}
	
	public PageUtil(int rowPage, int totalPage, int rowCont, int totalCont) {
		this.rowPage = rowPage;
		this.totalPage = totalPage;
		this.rowCont = rowCont;
		this.totalCont = totalCont;
	}
	
	public int getTotalPage(int totalCont, int rowCont) {
		totalPage = totalCont / rowCont + 1;
		
		if(totalPage < endPage) {
			totalPage = endPage;
		}
		return totalPage;
	}
	

}
