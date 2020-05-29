package com.increpas.www.dao;

/**
 * 이 클래스는 디비 작업을 통해 결과값을 반환해주는 클래스입니다.
 * @author	주재석
 * @since	2020.05.25
 */

import java.sql.*;
import java.util.*;
import java.io.*;

import com.increpas.www.DB.*;
import com.increpas.www.sql.*;
import com.increpas.www.util.*;
import com.increpas.www.vo.*;
import com.oreilly.servlet.*;

public class TboardDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	TboardSQL tSQL;
	
	public TboardDAO() {
		db = new WebDBCP();
		tSQL = new TboardSQL();
	}
	
	// 게시글 모두를 불러오는 함수
	public ArrayList getALL(PageUtil page) {
		ArrayList list = new ArrayList();
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_ALL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TboardVO tVO = new TboardVO();
				tVO.setBno(rs.getInt("bno"));
				tVO.setId(rs.getString("id"));
				tVO.setTitle(rs.getString("title"));
				tVO.setB_uno(rs.getInt("b_uno"));
				tVO.setHdate(rs.getDate("hiredate"));
				tVO.setHtime(rs.getTime("hiredate"));
				tVO.setSdate();
				String str = tVO.getSdate();
				str = str.substring(0, str.lastIndexOf("/"));
				tVO.setSdate(str);
				tVO.setBcontent(rs.getString("bcontent"));
				tVO.setClick(rs.getInt("click"));
				list.add(tVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	// 총 게시물 조회수 구해오는 함수
	public int getCont() {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_CONT);
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	
	// id로 유저번호 가져오는 함수
	public int getUno(String id) {
		int uno = 0;
		con =db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_UNO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			uno = rs.getInt("uno");
		} catch(Exception e) {}
		finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return uno;
	}
	// 게시글에 달린 댓글의 총 갯수를 가져오는 함수
	public int getRcon(int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_RCON);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 입력된 게시물의 마지막 bno를 가져오는 함수
	public int getBno() {
		int bno = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_BNO);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			bno = rs.getInt("bno");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return bno;
	}
	// 클릭된 게시물의 정보를 가져오는 함수
	public TboardVO getBoard(int bno) {
		TboardVO tvo = new TboardVO();
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_BRD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			rs.next();
			tvo.setBno(bno);
			tvo.setId(rs.getString("id"));
			tvo.setTitle(rs.getString("title"));
			tvo.setB_uno(rs.getInt("b_uno"));
			tvo.setBcontent(rs.getString("bcontent"));
			tvo.setHdate(rs.getDate("hiredate"));
			tvo.setHtime(rs.getTime("hiredate"));
			tvo.setSdate();
			String str = tvo.getSdate();
			str = str.substring(0, str.lastIndexOf("/"));
			tvo.setSdate(str);
			tvo.setClick(rs.getInt("click"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return tvo;
	}
	
	// 클릭된 게시물의 이미지 정보를 가져오는 함수
	public ArrayList<BoardImageVO> getImage(int bno) {
		ArrayList<BoardImageVO> list = new ArrayList<BoardImageVO>();
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_IMG);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardImageVO ivo = new BoardImageVO();
				ivo.setIno(rs.getInt("ino"));
				ivo.setBno(rs.getInt("i_bno"));
				ivo.setOriname(rs.getString("oriname"));
				ivo.setSavename(rs.getString("savename"));
//				System.out.println(ivo.getSavename());
				list.add(ivo);
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
	
	// 클릭된 게시물의 댓글정보를 가져오는 함수
	public ArrayList<BoardReplyVO> getReply(int bno, PageUtil page) {
		ArrayList<BoardReplyVO> list = new ArrayList<BoardReplyVO>();
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_RPL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			pstmt.setInt(2, page.getStartCont());
			pstmt.setInt(3, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardReplyVO rvo = new BoardReplyVO();
				rvo.setId(rs.getString("id"));
				rvo.setRno(rs.getInt("rno"));
				rvo.setR_uno(rs.getInt("r_uno"));
				rvo.setRcontent(rs.getString("rcontent"));
				rvo.setRuno(rs.getInt("runo"));
				rvo.setStep(rs.getInt("step"));
				list.add(rvo);
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
	// 게시글의 댓글 수정에 필요한 댓글정보 가져오는 함수
	public BoardReplyVO getReply(int rno) {
		BoardReplyVO rvo = new BoardReplyVO();
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.SEL_UPL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			rs.next();
			rvo.setRno(rs.getInt("rno"));
			rvo.setR_uno(rs.getInt("r_uno"));
			rvo.setRcontent(rs.getString("rcontent"));
			rvo.setRuno(rs.getInt("runo"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return rvo;
	}
	
	// 게시글 클릭을 수정하는 함수
	public int updClick(int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.UPD_CLK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

	// 게시글 내용 수정하는 함수
	public int updBrd(String title, String bcontent, int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.UPD_BRD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, title);
			pstmt.setString(2, bcontent);
			pstmt.setInt(3, bno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 댓글 내용 수정하는 함수
	public int updRpl(String rcontent, int rno) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.UPD_RPL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, rcontent);
			pstmt.setInt(2, rno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 게시글 디비에 추가하고 반환하는 함수
	public int insBrd(String title, int b_uno, String bcontent) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.ADD_BRD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, title);
			pstmt.setInt(2, b_uno);
			pstmt.setString(3, bcontent);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 추가된 게시글을 참조하여 이미지를 디비에 추가하고 반환하는 함수
	public boolean insImg(BoardImageVO ivo, String path) {
		boolean bool = false;
		// 가져온 이미지 갯수
		int result = 0;
		// 디비에 업로드된 이미지 갯수
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.ADD_IMG);
		
		MultipartRequest multi = ivo.getMulti();
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()) {
			pstmt = db.getPSTMT(con, sql);
			String key =(String)en.nextElement();
//			System.out.println("key : " + key);
			String oriname = multi.getOriginalFileName(key);
//			System.out.println("oriname : " + oriname);
			if(oriname == null || oriname.length() == 0) {
				continue;
			}
			++result;
//			System.out.println("result : " + result);
			String savename = multi.getFilesystemName(key);
//			System.out.println("savename : " + savename);
			File file = multi.getFile(key);
			long len = file.length();
//			System.out.println("len : " + len);
			
			try {
				pstmt.setInt(1, ivo.getBno());
				pstmt.setString(2, oriname);
				pstmt.setString(3, savename);
				pstmt.setLong(4, len);
				cnt += pstmt.executeUpdate();
//				System.out.println("cnt : " + cnt);

			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(pstmt);
			}
		}
		db.close(con);

		if(cnt == result) {
			bool = true;
		}
		return bool;
	}
	
	// 클릭된 게시글에 댓글을 추가하는 함수
	public int insRly(int uno, String rcontent, int bno, int runo) {
		int cnt = 0;
		con = db.getCon();
		String sql;
//		String sql = tSQL.getSQL(tSQL.ADD_RPL);
//		pstmt = db.getPSTMT(con, sql);
		try {
			if(runo == -1) {
				sql = tSQL.getSQL(tSQL.ADD_RPL);
				sql = sql.replaceAll("@", " ");
				sql = sql.replaceAll("#", " ");			
				pstmt = db.getPSTMT(con, sql);
				pstmt.setInt(1, uno);
				pstmt.setString(2, rcontent);
				pstmt.setInt(3, bno);
			} else {
				sql = tSQL.getSQL(tSQL.ADD_RPL);
				sql = sql.replaceAll("@", ", runo");
				sql = sql.replaceAll("#", ", ?");
				pstmt = db.getPSTMT(con, sql);
				pstmt.setInt(1, uno);
				pstmt.setString(2, rcontent);
				pstmt.setInt(3, bno);
				pstmt.setInt(4, runo);
			}
//			if(runo == -1) {
//				pstmt.setInt(1, uno);
//				pstmt.setString(2, rcontent);
//				pstmt.setInt(3, bno);
//			} else {
//				pstmt.setInt(1, uno);
//				pstmt.setString(2, rcontent);
//				pstmt.setInt(3, bno);
//				pstmt.setInt(4, runo);				
//			}
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 게시물이 안보이게 하는 함수
	public int DelBrd(int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.DEL_BRD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 댓글이 안보이게 하는 함수
	public int DelRpl(int rno) {
		int cnt = 0;
		con = db.getCon();
		String sql = tSQL.getSQL(tSQL.DEL_RPL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, rno);
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
