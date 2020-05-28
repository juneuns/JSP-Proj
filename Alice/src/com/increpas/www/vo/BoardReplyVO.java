package com.increpas.www.vo;

/**
 * 이 클래스는 댓글의 정보를 저장하는 클래스입니다.
 * @author	주재석
 * @since	2020.05.26
 */

import java.sql.*;
import java.text.*;

public class BoardReplyVO {
	private int rno, r_bno, r_uno, runo, step;
	private String rcontent, sdate;
	private Date rdate;
	private Time rtime;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getR_bno() {
		return r_bno;
	}
	public void setR_bno(int r_bno) {
		this.r_bno = r_bno;
	}
	public int getR_uno() {
		return r_uno;
	}
	public void setR_uno(int r_uno) {
		this.r_uno = r_uno;
	}
	public int getRuno() {
		return runo;
	}
	public void setRuno(int runo) {
		this.runo = runo;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat frm1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat frm2 = new SimpleDateFormat("HH:ss");
		this.sdate = frm1.format(rdate) + " " +frm2.format(rtime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public Time getRtime() {
		return rtime;
	}
	public void setRtime(Time rtime) {
		this.rtime = rtime;
	}
}
