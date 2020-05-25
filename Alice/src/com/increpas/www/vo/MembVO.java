package com.increpas.www.vo;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class MembVO {
	private int uno,mno,infouno;
	private String id,pw,mail,addr1,addr2,addr3,body,goal,ptime,ucode;
	private Time mtime;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getInfouno() {
		return infouno;
	}
	public void setInfouno(int infouno) {
		this.infouno = infouno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public void setPtime() {
		SimpleDateFormat form1  = new SimpleDateFormat("HH24:mm");
		String str = form1.format(mtime);
		this.ptime = str;
	}
	public Time getMtime() {
		return mtime;
	}
	public void setMtime(Time mtime) {
		this.mtime = mtime;
	}
	public String getUcode() {
		return ucode;
	}
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}
	
}
