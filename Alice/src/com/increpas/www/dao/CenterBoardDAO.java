package com.increpas.www.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;

import com.increpas.www.DB.WebDBCP;
import com.increpas.www.sql.CenterBoardSQL;
import com.increpas.www.vo.CenterBoardVO;
import com.oreilly.servlet.MultipartRequest;

public class CenterBoardDAO {
	WebDBCP db;
	Connection con = null;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	CenterBoardSQL cSQL;
	CenterBoardVO cVO;
	public CenterBoardDAO(){
		db = new WebDBCP();
		cSQL =new CenterBoardSQL();
	}
	public ArrayList<CenterBoardVO> getNList(int fno){
		ArrayList<CenterBoardVO> list = new ArrayList<CenterBoardVO>();
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.SEL_NLIST);
		pstmt = db.getPSTMT(con,sql);
		try {
			pstmt.setInt(1, fno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CenterBoardVO vo = new CenterBoardVO();
				vo.setFno(rs.getInt("fno"));
				vo.setBno(rs.getInt("bno"));
				vo.setBody(rs.getString("body"));
				vo.setgDate(rs.getDate("gdate"));
				vo.setgTime(rs.getTime("gdate"));
				vo.setFname(rs.getString("fname"));
				vo.setFoname(rs.getString("foname"));
				vo.setsDate();
				vo.setEdit(rs.getString("edit"));
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	public ArrayList<CenterBoardVO> getSList(int fno){
		ArrayList<CenterBoardVO> list = new ArrayList<CenterBoardVO>();
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.SEL_SLIST);
		pstmt = db.getPSTMT(con,sql);
		try {
			pstmt.setInt(1, fno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CenterBoardVO vo = new CenterBoardVO();
				vo.setFno(rs.getInt("fno"));
				vo.setBno(rs.getInt("bno"));
				vo.setBody(rs.getString("body"));
				vo.setgDate(rs.getDate("gdate"));
				vo.setgTime(rs.getTime("gdate"));
				vo.setFname(rs.getString("fname"));
				vo.setFoname(rs.getString("foname"));
				vo.setsDate();
				vo.setEdit(rs.getString("edit"));
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	public ArrayList<CenterBoardVO> getTLIST(int fno){
		ArrayList<CenterBoardVO> list = new ArrayList<CenterBoardVO>();
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.SEL_TINFO);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setInt(1, fno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CenterBoardVO cvo = new CenterBoardVO();
				cvo.setName(rs.getString("name"));
				cvo.setMail(rs.getString("mail"));
				cvo.setTel(rs.getString("tel"));
				cvo.setCareer(rs.getString("career"));
				cvo.setInfo(rs.getString("info"));
				list.add(cvo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	public CenterBoardVO getFInfo(int fno){
		CenterBoardVO cvo = new CenterBoardVO();
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.SEL_FINFO);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setInt(1, fno);
			rs = pstmt.executeQuery();
			rs.next();
			cvo.setFno(rs.getInt("fno"));
			cvo.setFname(rs.getString("fname"));
			cvo.setFoname(rs.getString("foname"));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cvo;
	}
	public CenterBoardVO getMImg(int fno, int divno){
		CenterBoardVO cvo = new CenterBoardVO();
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.SEL_IMG);
		System.out.println(divno);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setInt(1, fno);
			pstmt.setInt(2, divno);
			rs = pstmt.executeQuery();
			rs.next();
			cvo.setFno(rs.getInt("fno"));
			cvo.setSavename(rs.getString("savename"));
			System.out.println(cvo.getFno());
			System.out.println(cvo.getSavename());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cvo;
	}
	public int getSFno(String sid){
		CenterBoardVO cvo = new CenterBoardVO();
		int fno = 0;
		Integer ifno = null;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.SEL_SUFNO);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			ifno = rs.getInt("ffno");
			if(ifno==null){
				ifno = rs.getInt("ufno");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		fno = ifno;
		return fno;
	}
	public ArrayList<CenterBoardVO> getBList(){
		ArrayList<CenterBoardVO> list = new ArrayList<CenterBoardVO>();
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.SEL_CBLIST);
		stmt = db.getSTMT(con);
		try{
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				CenterBoardVO cvo = new CenterBoardVO();
				cvo.setFno(rs.getInt("fno"));
				cvo.setFname(rs.getString("fname"));
				list.add(cvo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	public int addNotice(int fno, String body) {
		int cnt = 0 ;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.ADD_NOTICE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, fno);
			pstmt.setString(2, body);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int addReply(CenterBoardVO vo){
		int cnt = 0;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.ADD_REPLY);
		System.out.println(sql);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setInt(1, vo.getBno());
			pstmt.setInt(2, vo.getFno());
			pstmt.setString(3, vo.getRebody());
			pstmt.setInt(4, vo.getPrno());
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int addSong(int fno, String body) {
		int cnt = 0 ;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.ADD_SONG);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, fno);
			pstmt.setString(2, body);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int addMainImg(CenterBoardVO ivo){
		int cnt = 0;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.ADD_IMG);
		
		MultipartRequest multi = ivo.getMulti();
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()){
			pstmt = db.getPSTMT(con, sql);
			String key =(String)en.nextElement();
			System.out.println("key : " + key);
			String oriname = multi.getOriginalFileName(key);
			System.out.println("oriname : " + oriname);
			String savename = multi.getFilesystemName(key);
			System.out.println("savename : " + savename);
			File file = multi.getFile(key);
			long len = file.length();
			System.out.println("len : " + len);
			
			try {
				pstmt.setString(1, oriname);
				pstmt.setString(2, savename);
				pstmt.setLong(3, len);
				pstmt.setInt(4, ivo.getFno());
				pstmt.setInt(5, ivo.getDivno());
				cnt = pstmt.executeUpdate();
				System.out.println("cnt : " + cnt);
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
		db.close(pstmt);
		db.close(con);

		return cnt;
	}
	public int editNotice(int bno, String ebody){
		int cnt = 0;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.EDT_NOTICE);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setString(1, ebody);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int editSong(int bno, String ebody){
		int cnt = 0;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.EDT_SONG);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setString(1, ebody);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int delNotice(int bno){
		int cnt = 0;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.DEL_NOTICE);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setInt(1, bno);
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int delSong(int bno){
		int cnt = 0;
		con = db.getCon();
		String sql = cSQL.getSQL(cSQL.DEL_SONG);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setInt(1, bno);
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
