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
    //  ó�� ���� �Լ� 
	public int getVote(String id) {
		int cnt = 0;
		String sql = vSQL.getSQL(vSQL.SEL_USERS_VOTE);
		con = db.getCon();
		pstmt = db.getPSTMT(con, sql); 
		try {
			//���� ��� �ϼ��ϱ� 
			pstmt.setString(1,id);
			//���Ǹ�� ������
			pstmt.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}	
	// Ŭ�� �Լ�
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
	// �ߺ� ��ǥ ����
	public boolean isUsing (int vno) {
		int cnt = 0;
		boolean isUsing = false;
		String key ="";
	
	return isUsing;
 }
    
	// ��ǥ�� ó���Լ�
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