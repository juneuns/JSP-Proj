package com.increpas.www.vo;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class PtnoVO {
	private int ptno,mno,tno,career,info,body,goal;
	private String act,stime;
	private Time ptime;

	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public int getBody() {
		return body;
	}
	public void setBody(int body) {
		this.body = body;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public String getStime() {
		return stime;
	}
	public void setStime() {
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		
		String str = form2.format(ptime);
		
		this.stime = str;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public Time getPtime() {
		return ptime;
	}
	public void setPtime(Time ptime) {
		this.ptime = ptime;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public int getPtno() {
		return ptno;
	}
	public void setPtno(int ptno) {
		this.ptno = ptno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}

}
