package com.proj.www.dao;

import com.proj.www.sql.*;
import com.proj.www.DB.*;

import java.sql.*;

public class TboardDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	TboardSQL tSQL;
	
	public int addTbo(String title, String bcontent, String ename) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.ADD_ONE);
		pstmt = db.getPstmt(con, sql);
		try {
			pstmt.setString(1, title);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, ename);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
