package com.increpas.www.vo;

/**
 * 이 클래스는 게시물의 데이터를 담는 vo 입니다.
 * @author	주재석
 * @since	2020.05.25
 * @version v.1.0
 */
import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

public class TboardVO {
	private int bno, b_empno, click;
	private String title, sdate, bcontent, ename;
	private Date hdate;
	private Time htime;
	private ArrayList<BoardImageVO> ivo;
	
	public ArrayList<BoardImageVO> getIvo() {
		return ivo;
	}
	public void setIvo(ArrayList<BoardImageVO> ivo) {
		this.ivo = ivo;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getB_empno() {
		return b_empno;
	}
	public void setB_empno(int b_empno) {
		this.b_empno = b_empno;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat frm1 = new SimpleDateFormat("yyyy/MM/dd/");
		SimpleDateFormat frm2 = new SimpleDateFormat("HH:ss");
		this.sdate = frm1.format(hdate) + " " + frm2.format(htime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHdate() {
		return hdate;
	}
	public void setHdate(Date hdate) {
		this.hdate = hdate;
	}
	public Time getHtime() {
		return htime;
	}
	public void setHtime(Time htime) {
		this.htime = htime;
	}
}
