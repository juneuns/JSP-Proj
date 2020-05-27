package com.increpas.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.increpas.www.DB.WebDBCP;
import com.increpas.www.sql.MapSQL;
import com.increpas.www.vo.MatchingVO;
import com.increpas.www.vo.MsearchVO;
import com.increpas.www.vo.PtnoVO;

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
    // 키워드 검색시 리스트 나오는 함수 
    public ArrayList<MsearchVO> getKeyword(String type,String keyword){
    	ArrayList<MsearchVO> slist = new ArrayList<MsearchVO>();
    	con = tdb.getCon();
    	String sql = null;
    	if(type.equals('T')) {
    		sql = asql.getSQL(asql.SEL_TSEARCH);
    	}else {
    		sql = asql.getSQL(asql.SEL_MSEARCH);
    	}
    	keyword  =   "%"+ keyword +"";
    	
    	try {
    		if(type.equals('T')) {
    			pstmt = tdb.getPSTMT(con, sql);
    			pstmt.setString(1,keyword);
    			pstmt.setString(2,keyword); 
    			rs=pstmt.executeQuery();
    		}else {
    			pstmt = tdb.getPSTMT(con, sql);
    			pstmt.setString(1,keyword);
    			pstmt.setString(2,keyword);    			
    			pstmt.setString(3,keyword);
    			rs= pstmt.executeQuery();    		
    		}
    		while(rs.next()) {
    			MsearchVO mvo= new MsearchVO();
    			if(type.equals('T')) {
    				mvo.setName(rs.getString("name"));
    				mvo.setAddr2(rs.getString("addr2"));
    				mvo.setBody(rs.getString("body"));
    				mvo.setGoal(rs.getString("goal"));   
    				slist.add(mvo);
    			}else {
    				mvo.setFname(rs.getString("fname"));
    				mvo.setTel(rs.getString("tel"));
    				mvo.setAddr2(rs.getString("addr2"));
    				mvo.setName("name");   
    				slist.add(mvo);
    			}
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
    public ArrayList<MatchingVO> getTinfo(String id){
    	ArrayList<MatchingVO> mlist = new ArrayList<MatchingVO>();
    	con = tdb.getCon();
    	String msql = null;
    	if(id.equals('T')) {
    		msql = asql.getSQL(asql.SEL_TMATCHING);
    	}else if(id.equals('M')){
    		msql = asql.getSQL(asql.SEL_MMATCHING);
    	}    	
    	try {
    		if(id.equals('T')) {
    			pstmt = tdb.getPSTMT(con, msql);
    			pstmt.setString(1,id);
    			rs=pstmt.executeQuery();
    		}else if(id.equals('M')){
    			pstmt = tdb.getPSTMT(con, msql);
    			pstmt.setString(1,id);
    			rs= pstmt.executeQuery();    		
    		}
    		while(rs.next()) {
    			MatchingVO mavo= new MatchingVO();
    			if(id.equals('T')) {
    				mavo.setBody(rs.getString("body"));
    				mavo.setGoal(rs.getString("goal"));
    				mavo.setName(rs.getString("name"));
    				mavo.setAddr(rs.getString("addr2"));    				
    				mlist.add(mavo);
    			}else if(id.equals('M')){
    				mavo.setCareer(rs.getString("career"));
    				mavo.setInfo(rs.getString("info"));
    				mavo.setName(rs.getString("name"));
    				mavo.setAddr(rs.getString("addr2"));    				
    				mlist.add(mavo);
    			}
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	} finally {
    		tdb.close(rs);
    		tdb.close(pstmt);
    		tdb.close(con);
    	}
    	return mlist;
    }  
    	//PT 요청 DB에 담는 함수
    	public ArrayList<PtnoVO> getPtno(int ptno, int mno, String id){
    		ArrayList<PtnoVO> plist = new ArrayList<PtnoVO>();
    		int pno = 0;
    		con = tdb.getCon();
    		String psql = asql.getSQL(asql.SEL_PTNO);
    		try {
    			pstmt = tdb.getPSTMT(con, psql);
    			pstmt.setInt(1,ptno);
    			pstmt.setInt(2,mno);
    			pstmt.setString(3,id);
    			pno = pstmt.executeUpdate();
    		}catch (Exception e){
    			e.printStackTrace();
    		}finally {
    			tdb.close(rs);
    			tdb.close(pstmt);
    			tdb.close(con);
    		}
    		
    		return plist;
    	}
    	// PT 요청 수락 거절 함수 
    	public ArrayList<PtnoVO> getPtny(String id){
    		ArrayList<PtnoVO> alist= new ArrayList<PtnoVO>(); 	
    		int pno = 0; 
    		con = tdb.getCon();
    	    String sql = null;
   
    			 sql = asql.getSQL(asql.SEL_MYPTNO);
    			 try {
    				 pstmt = tdb.getPSTMT(con, sql);
    				 pstmt.setString(1, id);
    				 pno = pstmt.executeUpdate();
    			 }catch(Exception e) {
    				 e.printStackTrace();
    			 } finally {
    				 tdb.close(rs);
    				 tdb.close(pstmt);
    				 tdb.close(con);
    			 }   		
    		
    		return alist;
    	}
    	// 본인 PT요청 보기
    	public ArrayList<MatchingVO> getName(String id){
    		ArrayList<MatchingVO> nlist = new ArrayList<MatchingVO>();
    		con = tdb.getCon();
    		
    		String nsql = asql.getSQL(asql.SEL_MYPT);
    		try {
    			pstmt = tdb.getPSTMT(con, nsql);
    			pstmt.setString(1, id);
    			rs = pstmt.executeQuery();
    		}catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			tdb.close(rs);
    			tdb.close(pstmt);
    			tdb.close(con);
    		}
    		return nlist;
    	}
    	// PT요청 상세보기 함수
    	public ArrayList<MatchingVO> getMYPT(String id){
    		ArrayList<MatchingVO> mylist = new ArrayList<MatchingVO>();
    		
    		con = tdb.getCon();
    		String sql = null;
    		
    		if(id.equals('T')) {
    			sql = asql.getSQL(asql.SEL_TMYPT);
    		}else if(id.equals('M')) {
    			sql = asql.getSQL(asql.SEL_MMYPT);
    		}
    		try {
    			if(id.equals('T')) {
    				pstmt = tdb.getPSTMT(con, sql);
    				pstmt.setString(1, id);
    				rs = pstmt.executeQuery();
    			} else if(id.equals('M')) {
    				pstmt = tdb.getPSTMT(con, sql);
    				pstmt.setString(1, id);
    				rs = pstmt.executeQuery();
    			}
    			while(rs.next()) {
    				MatchingVO mvo = new MatchingVO();
    				if(id.equals('T')) {
    					mvo.setBody(rs.getString("a.body"));
    					mvo.setGoal(rs.getString("a.goal"));
    					mvo.setStime(rs.getString("a.ptime"));
    					mylist.add(mvo);
    				}else if(id.equals('M')) {
    					mvo.setCareer(rs.getString("t.career"));
    					mvo.setInfo(rs.getString("t.info"));
    					mylist.add(mvo);
    				}
    					
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			tdb.close(rs);
    			tdb.close(pstmt);
    			tdb.close(con);
    		}
    		return mylist;
    	}
    	
}
