package com.increpas.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.MultipartRequest;

public class UImgFileVO {
	private int ino,uno,len;
	private String oriname,savename,iloc,id,sDate;
	private Date iDate;
	private Time iTime;
	private MultipartRequest multi;
	
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public void setsDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		
		String str = form1.format(iDate)+" "+form2.format(iTime);
		this.sDate = str;
	}
	public Date getiDate() {
		return iDate;
	}
	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}
	public Time getiTime() {
		return iTime;
	}
	public void setiTime(Time iTime) {
		this.iTime = iTime;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getIloc() {
		return iloc;
	}
	public void setIloc(String iloc) {
		this.iloc = iloc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MultipartRequest getMulti() {
		return multi;
	}
	public void setMulti(MultipartRequest multi) {
		this.multi = multi;
	}
	
}
