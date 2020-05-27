package com.increpas.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class MatchingVO {	
	private String name,addr,career,info ,agree,goal,body,stime;
	private Time ptime;
	
	public String getStime() {
		return stime;
	}

	public void setStime() {
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		
		String str = form2.format(ptime);
		
		this.stime = str;
	}
	public void setStime(String sdate) {
		this.stime = sdate;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public String getGoal() {
		return goal;
	}

	public Time getPtime() {
		return ptime;
	}

	public void setPtime(Time ptime) {
		this.ptime = ptime;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
