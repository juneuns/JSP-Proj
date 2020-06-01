package com.increpas.www.vo;
/**
 * 일반회원과 트레이너의 정보를 가지는 VO 클래스 
 * @author	박광호
 * @since	2020.05.24
 * @version	v 1.0.2
 * 
 */
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MembVO {
	private int uno,mno,infouno,fno,tno,ino;
	private String id,pw,mail,name,addr1,addr2,addr3,body,goal,ptime,ucode,tel,pagree,career,info,savename,fname;
	private Time mtime;
	private ArrayList<UImgFileVO> file ;
	
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
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
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getPagree() {
		return pagree;
	}
	public void setPagree(String pagree) {
		this.pagree = pagree;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public void setPtime() {
		SimpleDateFormat form1  = new SimpleDateFormat("HH:mm");
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
	public ArrayList<UImgFileVO> getFile() {
		return file;
	}
	public void setFile(ArrayList<UImgFileVO> file) {
		this.file = file;
	}
}
