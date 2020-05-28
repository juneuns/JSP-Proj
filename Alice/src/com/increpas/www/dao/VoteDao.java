package com.increpas.www.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

import com.increpas.www.DB.WebDBCP;
import com.increpas.www.sql.VoteSQL;

public class VoteDao {
	WebDBCP db = null;
	VoteSQL vSQL = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public VoteDao() {
		db= new WebDBCP();
		vSQL= new VoteSQL();
	}
    //  처리 전담 함수 
	public int getVote(String id) {
		int cnt = 0;
		String sql = vSQL.getSQL(vSQL.SEL_USERS_VOTE);
		con = db.getCon();
		pstmt = db.getPSTMT(con, sql); 
		try {
			//질의 명령 완성하기 
			pstmt.setString(1,id);
			//질의명령 보내기
			pstmt.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}	
	// 클릭 함수
	public int updClick(int vno) {
		int cnt = 0;
		con = db.getCon();
		String sql = vSQL.getSQL(vSQL.SEL_UPD_CLK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, vno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;	    
   }
	// 중복 투표 방지
	public boolean isUsing (int vno) {
		int cnt = 0;
		boolean isUsing = false;
		String key ="";
	
	return isUsing;
 }
    
	// 득표수 처리함수
	public int getcVote(int count) {
		int cnt = 0;
		String sql = vSQL.getSQL(vSQL.SEL_USERS_cVOTE);
		con = db.getCon();
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, count);
			rs = pstmt.executeQuery(sql);
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		db.close(pstmt);
		db.close(con);
	}   
		return cnt;
  }
} 