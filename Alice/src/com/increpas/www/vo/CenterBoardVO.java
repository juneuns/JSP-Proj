package com.increpas.www.vo;

import java.sql.*;
import java.text.*;
import java.util.Date;

import com.oreilly.servlet.MultipartRequest;

public class CenterBoardVO {
	private int bno, fno, vno, uno, divno,rno,prno;
	private String rebody,body,isshow,sDate,fname,foname,
				tel,mail,name,career,info,bcode,edit,
				oriname, savename, id, dir;
	private long len;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPrno() {
		return prno;
	}
	public void setPrno(int prno) {
		this.prno = prno;
	}
	public String getRebody() {
		return rebody;
	}
	public void setRebody(String rebody) {
		this.rebody = rebody;
	}
	private MultipartRequest multi;
	
	public int getDivno() {
		return divno;
	}
	public void setDivno(int divno) {
		this.divno = divno;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public MultipartRequest getMulti() {
		return multi;
	}
	public void setMulti(MultipartRequest multi) {
		this.multi = multi;
	}
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		if(edit.equals("Y")){
			edit = "(수정됨)";
		}else{
			edit = "";
		}
		this.edit = edit;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFoname() {
		return foname;
	}
	public void setFoname(String foname) {
		this.foname = foname;
	}
	private Date gDate;
	private Time gTime;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		String str = form1.format(gDate) + " " + form2.format(gTime);
		this.sDate = str;
	}
	public Date getgDate() {
		return gDate;
	}
	public void setgDate(Date gDate) {
		this.gDate = gDate;
	}
	public Time getgTime() {
		return gTime;
	}
	public void setgTime(Time gTime) {
		this.gTime = gTime;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
}
