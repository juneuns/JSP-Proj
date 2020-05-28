package com.increpas.www.vo;

/**
 * 이 클래스는 이미지 파일에 대한 정보를 저장할 클래스입니다.
 * @author	주재석
 * @since	2020.05.26
 */

import java.sql.*;
import java.text.*;

import com.oreilly.servlet.*;

public class BoardImageVO {
	private int ino, bno;
	private long len;
	private String oriname, savename, id, dir, sdate, path;
	private Date idate;
	private Time itime;
	private MultipartRequest multi;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public MultipartRequest getMulti() {
		return multi;
	}
	public void setMulti(MultipartRequest multi) {
		this.multi = multi;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
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
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat frm1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat frm2 = new SimpleDateFormat("HH:ss");
		this.sdate = frm1.format(idate) + " " + frm2.format(itime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public Time getItime() {
		return itime;
	}
	public void setItime(Time itime) {
		this.itime = itime;
	}
}