package com.increpas.www.dao;
import java.io.File;
/**
 * 이 클래스는 회원 정보 관리 패키지의 DB작업을 처리하는 클래스이다.
 * @author	박광호
 * @since	2020.05.25 
 * @version	v 1.0.1
 * @see 
 * 			
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.UUID;

import com.increpas.www.DB.WebDBCP;
import com.increpas.www.sql.MemberSQL;
import com.increpas.www.vo.FitVO;
import com.increpas.www.vo.MembVO;
import com.increpas.www.vo.UImgFileVO;
import com.oreilly.servlet.MultipartRequest;

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
		if(f == null) {
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
		String sql = mSQL.getSQL(mSQL.SEL_FIT_FNO);
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
	// 아이디 찾기 정보 유효성 검사 전담 함수 
	public int getValidInfo(String name, String mail,String f) {
		int cnt = 0;
		String sql = null;
		// 커넥션 얻기 
		con =db.getCon();
		// 질의명령 얻기 
		if("".equals(f) || f==null) {
			sql = mSQL.getSQL(mSQL.SEL_USERS_VALID_INFO);			
		} else {
			sql = mSQL.getSQL(mSQL.SEL_FIT_VALID_INFO);
		}
		// 필요한 스테이트먼트 얻기
		pstmt = db.getPSTMT(con, sql);
		// 질의명령 완성하기 
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			// 질의명령 보내고 결과 받기
			rs = pstmt.executeQuery();
			rs.next();
			// 결과에서 필요한 데이터 꺼내기
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
			
		}
		// 데이터 내보내기 
		return cnt ;
	}
	// 아이디 찾기 처리 전담 함수 
	public String getID(String name,String mail,String f) {
		String findId = "";
		String sql = null;
		// 커넥션 얻기 
		con = db.getCon();
		// 질의명령 얻기 
		if("".equals(f) || f==null) {
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
			rs.next();
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
		
		String sql = null;
		if("".equals(f) || f == null) {
			sql = mSQL.getSQL(mSQL.SEL_USERS_PW_VALID);
		} else {
			sql = mSQL.getSQL(mSQL.SEL_FIT_PW_VALID);
		}
		// 커넥션 얻어오기 
		con = db.getCon();
		// 질의명령 얻어오기
		// 필요한 스테이트먼트 얻기 
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하기 
			pstmt.setString(1,name);
			pstmt.setString(2,id);
			pstmt.setString(3,mail);
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
		String pass=passInit();
		// 회원 종류별로 
		if("".equals(f)||f==null) {
			sql = mSQL.getSQL(mSQL.EDIT_USERS_PW);
		} else {
			sql = mSQL.getSQL(mSQL.EDIT_FIT_PW);
		}
		con =db.getCon();
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
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
	// 비밀번호 재설정 중 기존 비밀번호 확인 전담 처리함수
	public int getPWCK(String id,String pw, String f) {
		int cnt = 0 ;
		String sql = null;
		// 커넥션 얻기
		con = db.getCon();
		// 질의 명령 얻기 
		if("".equals(f) || f == null){
			sql = mSQL.getSQL(mSQL.SEL_CK_USERS_PW);
			System.out.println(sql);
		} else {
			sql = mSQL.getSQL(mSQL.SEL_CK_FIT_PW);
			System.out.println(sql);
		}
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			System.out.println("cnt :"+cnt);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt ;
	}
	// 비밀번호 재설정 전담 처리함수 
	public int editPW(String id,String pw, String f) {
		int cnt = 0 ;
		// 커넥션 얻기 
		con = db.getCon();
		String sql = null;
		if("".equals(f) || f == null) {
			sql = mSQL.getSQL(mSQL.EDIT_USERS_PW);
		} else {
			sql = mSQL.getSQL(mSQL.EDIT_FIT_PW);
		}
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
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
	// 아이디 중복확인 전담 처리 함수 
	public int idDoubleCk(String id,String type) {
		int cnt = 0 ; 
		String sql = null;
		con = db.getCon();
		// 회원 종류별 질의 명령 얻기 
		if(type.equals("fit")) {
			sql = mSQL.getSQL(mSQL.SEL_CK_FIT_ID);
		} else {
			sql = mSQL.getSQL(mSQL.SEL_CK_USERS_ID);
		}
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의 명령 채우기
			pstmt.setString(1, id);
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
		return cnt ;
	}
	public ArrayList<FitVO> getFitSMYInfo(String fname){
		ArrayList<FitVO> list = new ArrayList<FitVO>();
		con = db.getCon();
		
		String sql = mSQL.getSQL(mSQL.SEL_FIT_SMYINFO);
		pstmt = db.getPSTMT(con, sql);
		System.out.println("fname : "+fname);
		try {
			pstmt.setString(1,'%'+fname+'%');
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FitVO fVO = new FitVO();
				fVO.setFno(rs.getInt("fno"));
				fVO.setFname(rs.getString("fname"));
				fVO.setAddr2(rs.getString("addr2"));
				list.add(fVO);
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
	// 멤버 회원가입 전담 처리함수 
	public int addMem(MembVO mVO) {
		int cnt =0;
		con = db.getCon();
		String sql = null;
		sql = mSQL.getSQL(mSQL.ADD_MEM);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mVO.getId());
			pstmt.setString(2, mVO.getPw());
			pstmt.setString(3, mVO.getMail());
			pstmt.setString(4, mVO.getName());
			pstmt.setString(5, mVO.getTel());
			pstmt.setString(6, mVO.getAddr1());
			pstmt.setString(7, mVO.getAddr2());
			pstmt.setString(8, mVO.getAddr3());
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 일반회원의 부가정보를 추가하는 전담 함수
	public int addMemInfo(MembVO mVO) {
		int cnt = 0;
		
		con =db.getCon();
		
		String sql = mSQL.getSQL(mSQL.ADD_MEMINFO);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, mVO.getBody());
			pstmt.setString(2, mVO.getGoal());
			pstmt.setString(3, mVO.getPtime());
			pstmt.setString(4, mVO.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt ;
	}
	// 트레이너의 회원가입을 전담하는 함수 
	public int addTrainer(MembVO mVO) {
		int cnt = 0 ;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.ADD_T);
		pstmt= db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, mVO.getId());
			pstmt.setString(2, mVO.getPw());
			pstmt.setString(3, mVO.getMail());
			pstmt.setString(4, mVO.getName());
			pstmt.setString(5, mVO.getTel());
			pstmt.setString(6, mVO.getAddr1());
			pstmt.setString(7, mVO.getAddr2());
			pstmt.setString(8, mVO.getAddr3());
			pstmt.setInt(9,mVO.getFno());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 트레이너의 부가정보 추가를 전담하는 함수 
	public int addTInfo(MembVO mVO) {
		int cnt = 0;
		
		con =db.getCon();
		
		String sql = mSQL.getSQL(mSQL.ADD_TINFO);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, mVO.getCareer());
			pstmt.setString(2, mVO.getInfo());
			pstmt.setString(3, mVO.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt ;
	}
	// 회원들의 파일 업로드를 전담하는 함수 
	public boolean addImgInfo(UImgFileVO fVO) {
		boolean bool = false;
		// 할일
		int cnt = 0 ; // 업로드된 파일의 갯수
		int result = 0 ; // DB에 추가된 행 갯수 
		// 1. 커넥션 얻어오고 
		con = db.getCon();
		// 2. 질의명령 가져오고 
		String sql = mSQL.getSQL(mSQL.ADD_USERS_IMG);
		// 3. pstmt 겨져오고 
		// 4. 데이터 만들고 
		MultipartRequest multi = fVO.getMulti();
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()) {
			pstmt = db.getPSTMT(con, sql);
			// 업로드된 파일의 키(name)값을 알아내고 
			String key = (String) en.nextElement();
			// 해당 키값을 가지고 있는 파일 이름을 알아낸다.
			String oriname = multi.getOriginalFileName(key);
			// 실제 저장된 이름을 알아낸다. 
			if(oriname == null|| oriname.equals("null") || oriname.length()==0) {
				// 이 경우는 파일을 선택하지 않은 경우이므로 다음 회차로 진행한다.
				continue;
			}
			cnt++;
			String savename = multi.getFilesystemName(key);
			File file = multi.getFile(key);
			long len = file.length();
			
			try {
				// 5. 질의 명령 완성
				pstmt.setString(1, oriname); 
				pstmt.setString(2, savename); 
				pstmt.setLong(3, len);
				pstmt.setString(4, fVO.getId());
				// 6. 보내고 결과 받고 
				result += pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
		db.close(pstmt);
		db.close(con);
		
		// 7. 결과 비교해서 반환하기 
		if(cnt == result) {
			bool = true;
		}
		return bool;
	}
	// 시설회원 회원가입 전담 처리함수
	public int addFit(FitVO fiVO) {
		int cnt = 0 ;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.ADD_FIT);
		
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, fiVO.getId());
			pstmt.setString(2, fiVO.getPw());
			pstmt.setString(3, fiVO.getMail());
			pstmt.setString(4, fiVO.getFname());
			pstmt.setString(5, fiVO.getFoname());
			pstmt.setString(6, fiVO.getTel());
			pstmt.setString(7, fiVO.getAddr1());
			pstmt.setString(8, fiVO.getAddr2());
			pstmt.setString(9, fiVO.getAddr3());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt ; 
	}
	// 회원의 정보를 제공을 담당하는 함수
	public MembVO getMemInfo(String id) {
		MembVO mVO = new MembVO();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_USERS_DETAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			mVO.setUno(rs.getInt("uno"));
			mVO.setName(rs.getString("name"));
			mVO.setSavename(rs.getString("savename"));
			mVO.setId(rs.getString("id"));
			mVO.setMail(rs.getString("mail"));
			mVO.setBody(rs.getString("body"));
			mVO.setPagree(rs.getString("pagree"));
			mVO.setGoal(rs.getString("goal"));
			mVO.setMtime(rs.getTime("mtime"));
			mVO.setPtime();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}
}
