package com.increpas.www.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.increpas.www.DB.WebDBCP;
import com.increpas.www.sql.MapSQL;
import com.increpas.www.vo.AddrVO;
import com.increpas.www.vo.MeminfoVO;
import com.increpas.www.vo.TinfoVO;

public class MapDAO {
	WebDBCP tdb;
	MapSQL asql;
	Statement stmt;
	PreparedStatement pstmt;
	Connection con;	
	ResultSet rs;
	String name;
	public MapDAO() {
		tdb =new WebDBCP();
		asql = new MapSQL();
	}
	//회원 정보 조회 처리함수
    public ArrayList<AddrVO> getList() {
    	ArrayList<AddrVO> list = new ArrayList<AddrVO>();
    	
    	con = tdb.getCon();
    	
    	String sql =asql.getSQL(asql.SEL_ADDR);
    	stmt = tdb.getSTMT(con);
    	try {
    		rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			AddrVO vo = new AddrVO();
    			
    			vo.setUno(rs.getInt("uno"));
    			vo.setId(rs.getString("id"));
    			vo.setPw(rs.getString("pw"));
    			vo.setMail(rs.getString("mail"));
    			vo.setName(rs.getString("name"));
    			vo.setAddr1(rs.getString("addr1"));
    			vo.setAddr2(rs.getString("addr2"));    			
    			list.add(vo);    			
    			
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		tdb.close(rs);
			tdb.close(stmt);
			tdb.close(con);
    	}

    	
    	return list;
    }
    // 키워드 검색시 리스트 나오는 함수 
    public ArrayList<AddrVO> getKeyword(String keyword){
    	ArrayList<AddrVO> slist = new ArrayList<AddrVO>();
    	con = tdb.getCon();
    	String ssql = asql.getSQL(asql.SEL_SEARCH);
    	keyword  =   "%"+ keyword +"";
    	try {
    		pstmt = tdb.getPSTMT(con, ssql);
    		pstmt.setString(1,keyword);
    		pstmt.setString(2,keyword);
    		rs= pstmt.executeQuery();
    		while(rs.next()) {
    			AddrVO kvo = new AddrVO();
    			kvo.setName(rs.getString("name"));
    			kvo.setMail(rs.getString("mail"));
    			kvo.setAddr2(rs.getString("addr2"));
    			slist.add(kvo);

    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	} finally {
    		tdb.close(rs);
    		tdb.close(pstmt);
    		tdb.close(con);
    	}
    	return slist;
    }
    // 트레이너가 매칭 함수
    public ArrayList<TinfoVO> getTinfo(String id){
    	ArrayList<TinfoVO> tlist = new ArrayList<TinfoVO>();
    	
    	con = tdb.getCon();
    	String tsql = asql.getSQL(asql.SEL_TMATCHING);
    	
    	try {
    		pstmt = tdb.getPSTMT(con, tsql);
    		pstmt.setString(1, id);
    		rs = pstmt.executeQuery();
    		while(rs.next()) {
    			TinfoVO tvo = new TinfoVO();
    			tvo.setName(rs.getString("name"));
    			tvo.setCareer(rs.getString("career"));
    			tvo.setAdd2(rs.getString("addr2"));
    			tvo.setInfo(rs.getString("info"));
    			tlist.add(tvo);
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		tdb.close(rs);
    		tdb.close(pstmt);
    		tdb.close(con);
    	}
    	return tlist;
    }
    // 일반 유저가 매칭 하는 함수 
    public ArrayList<MeminfoVO> getMeminfo(String id){
    	ArrayList<MeminfoVO> mlist = new ArrayList<MeminfoVO>();
    	con = tdb.getCon();
    	String msql = asql.getSQL(asql.SEL_MMATCHING);
    	
    	try {
    		pstmt = tdb.getPSTMT(con, msql);
    		pstmt.setString(1, id);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			MeminfoVO mvo= new MeminfoVO();
    			mvo.setName(rs.getString("name"));
    			mvo.setAddr2(rs.getString("addr2"));
    			mvo.setPtime(rs.getString("ptime"));
    			mvo.setBody(rs.getString("body"));
    			mvo.setGoal(rs.getString("goal"));
    			mlist.add(mvo);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		tdb.close(rs);
    		tdb.close(pstmt);
    		tdb.close(con);
    	}
    	return mlist;
    }

}
