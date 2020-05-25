package com.increpas.www.dao;
/**
 * 이 클래스는 회원 정보 관리 패키지의 DB작업을 처리하는 클래스이다.
 * @author	박광호
 * @since	2020.05.25
 * @version	v 1.0.0
 * @see 
 * 			
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.UUID;

import com.increpas.www.DB.WebDBCP;
import com.increpas.www.sql.MemberSQL;

public class MemberDao {
	WebDBCP db = null;
	MemberSQL mSQL = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public MemberDao() {
		db= new WebDBCP();
		mSQL= new MemberSQL();
	}

	//  로그인 처리 전담 함수 
	public int getSignIn(String id, String pw,String f) {
		int cnt=0;
		String sql =null;
		// 커넥션 얻기
		con = db.getCon();
		// 질의명령 얻기
		if(f.equals(null)) {
			sql = mSQL.getSQL(mSQL.SEL_USERS_SIGNIN);			
		} else {
			sql = mSQL.getSQL(mSQL.SEL_FIT_SIGNIN);
		}
		// 필요한 스테이트먼트 얻기
		pstmt = db.getPSTMT(con, sql);
		try {
			//질의 명령 완성하기 
			pstmt.setString(1,id);
			pstmt.setString(2, pw);
			//질의명령 보내기
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 회원 종류 처리 전담함수 
	public String getType(String id) {
		String type = null;
		// 커넥션 얻기
		con = db.getCon();
		// 질의명령 얻기
		String sql = mSQL.getSQL(mSQL.SEL_TYPE);
		// 필요한 스테이트먼트 얻기
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			// 질의명령 보내기 
			rs = pstmt.executeQuery();
			rs.next();
			type = rs.getString("ucode");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return type;
	}
	// 시설 회원 번호 얻어오는 함수 
	public int getFPK(String id) {
		int fno = 0;
		// 커넥션 얻기
		con = db.getCon();
		// 질의명령 얻기
		String sql = mSQL.getSQL(mSQL.SEL_TYPE);
		// 필요한 스테이트먼트 얻기
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			// 질의명령 보내기 
			rs = pstmt.executeQuery();
			rs.next();
			fno = rs.getInt("fno");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return fno;
	}
	// 아이디 찾기 처리 전담 함수 
	public String getID(String name,String mail,String f) {
		String findId = "";
		String sql = null;
		// 커넥션 얻기 
		con = db.getCon();
		// 질의명령 얻기 
		if(f.equals(null)) {
			sql = mSQL.getSQL(mSQL.SEL_USERS_ID);			
		} else {
			sql = mSQL.getSQL(mSQL.SEL_FIT_ID);
		}
		// 필요한 스테이트먼트 얻기 
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하기 
			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			// 질의명령 보내고 결과 받기 
			rs = pstmt.executeQuery();
			findId = rs.getString("id");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 결과 내보내기 
		return findId;
	}
	// 비밀번호 찾기 결과 내보내는 처리 함수
	public int passFindProc(String name ,String id ,String mail,String f) {
		int cnt = 0 ;
		String table = null;
		if(f.equals(null)) {
			table = "users";
		} else {
			table = "fit";
		}
		// 커넥션 얻어오기 
		con = db.getCon();
		// 질의명령 얻어오기
		String sql = mSQL.getSQL(mSQL.SEL_FIND_PW_PROC);
		// 필요한 스테이트먼트 얻기 
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하기 
			pstmt.setString(1,table);
			pstmt.setString(2,name);
			pstmt.setString(3,id);
			pstmt.setString(4,mail);
			// 질의명령 보내고 결과 받기
			rs = pstmt.executeQuery();
			rs.next();
			// 질의 명령 결과에서 필요한 데이터 꺼내기 
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 결과 내보내기
		return cnt ; 
	}
	// 임시 비밀번호 생성
	public String passInit() {
		String pass = "";
		
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0,9);
		uuid = uuid.replaceAll("-", "");
		pass= uuid+"A@";
		
		return pass;			
	}
	// 만들어진 임시비밀번호 DB 처리하는 함수 
	public int editPW(String name, String id, String mail,String f) {
		int cnt = 0 ; 
		String sql = null;
		String table = null;
		String pass=passInit();
		// 회원 종류별로 
		if(f.equals(null)) {
			table = "users";
		} else {
			table = "fit";
		}
		con =db.getCon();
		sql = mSQL.getSQL(mSQL.EDIT_PW);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, table);
			pstmt.setString(2, pass);
			pstmt.setString(3, id);
			//만들어진 PASS DB에 넣기 작업 
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt ;
	}
	
}
