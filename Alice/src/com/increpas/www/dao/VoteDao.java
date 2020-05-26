package com.increpas.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
}

