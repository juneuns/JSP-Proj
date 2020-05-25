package com.proj.www.DB;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;
public class WebDBCP {
	public DataSource ds;
	
	public WebDBCP() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			System.out.println("*** 커넥션 풀 가져오기 실패 ***");
		}
	}
	
	public Connection getCon() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Statement getStmt(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getPstmt(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	public void close(Object o) {
		try {
			if(o instanceof Connection) {
					((Connection) o).close();
			} else if(o instanceof Statement) {
				((Statement) o).close();
			} else if(o instanceof PreparedStatement) {
				((PreparedStatement) o).close();
			} else if(o instanceof ResultSet) {
				((ResultSet) o).close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
