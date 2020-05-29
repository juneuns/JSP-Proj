package com.increpas.www.sql;
/**
 * 이 클래스는 회원 정보 관리 패키지에 사용되는 질의명령을 만들어 반환하는 클래스이다.
 * 
 * @author	박광호
 * @since	2020.05.25 
 * @version	v 1.0.2
 * @see	
 * 			1. SEL_USERS_SIGNIN : 트레이너,일반회원 로그인 처리 질의명령
 * 			2. SEL_FIT_LOGIN : 시설 관리자 회원 로그인 처리 질의명령
 * 			3. SEL_USERS_VALID_INFO : 트레이너 일반회원 아이디 찾기 시 DB 체크 
 * 			4. SEL_FIT_VALID_INFO : 시설 관리자 아이디 찾기 시 DB 체크 
 * 			5. SEL_TYPE : 로그인 시 회원 종류
 * 			6. SEL_USERS_ID : 트레이너,일반회원 아이디 찾기 
 * 			7. SEL_FIT_ID : 시설 회원 아이디 찾기 
 * 			8. SEL_FIT_FNO : 시설 회원 PK 찾기 
 * 			9. SEL_USERS_PW_VALID : 비밀번호 찾기 트레이너,회원 DB 체크  
 * 			10. SEL_FIT_PW_VALID : 비밀번호 찾기 시설 회원 DB 체크  
 * 			11. SEL_CK_USERS_PW : 비밀번호 변경 트레이너,회원 DB체크 
 * 			12. SEL_CK_FIT_PW : 비밀번호 변경 시설 회원 DB체크 
 * 			13. SEL_CK_USERS_ID : 트레이너, 회원 회원가입 ID 중복확인  
 * 			14. SEL_CK_FIT_ID : 시설 회원 회원가입 ID 중복확인 
 * 			15. SEL_FIT_SMYINFO : 시설 검색 도전중 실패 
 * 			16. SEL_USERS_DETAIL 
 * 			16. SEL_FIT_DETAIL 
 */
public class MemberSQL {
	public final int SEL_USERS_SIGNIN = 1001;
	public final int SEL_FIT_SIGNIN = 1002;
	public final int SEL_USERS_VALID_INFO = 1003;
	public final int SEL_FIT_VALID_INFO = 1004;
	public final int SEL_TYPE = 1005;
	public final int SEL_USERS_ID = 1006;
	public final int SEL_FIT_ID = 1007;
	public final int SEL_FIT_FNO = 1008;
	public final int SEL_USERS_PW_VALID = 1009;
	public final int SEL_FIT_PW_VALID = 1010;
	public final int SEL_CK_USERS_PW = 1012;
	public final int SEL_CK_FIT_PW = 1013;
	public final int SEL_CK_USERS_ID = 1014;
	public final int SEL_CK_FIT_ID = 1015;
	public final int SEL_FIT_SMYINFO = 1016;
	public final int SEL_USERS_DETAIL = 1017;
	public final int SEL_TRAINER_DETAIL = 1018;
	
	public final int EDIT_USERS_PW = 2001;
	public final int EDIT_FIT_PW = 2002;
	public final int EDIT_SHOW_N = 2003;
	
	public final int ADD_MEM = 3001;
	public final int ADD_MEMINFO = 3002;
	public final int ADD_T = 3003;
	public final int ADD_TINFO = 3004;
	public final int ADD_USERS_IMG = 3005;
	public final int ADD_FIT = 3006;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_USERS_SIGNIN:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			buff.append("	AND pw = ? ");
			buff.append("	AND isshow = 'Y' ");
			break;
		case SEL_FIT_SIGNIN : 
			buff.append("SELECT ");
			buff.append("	count(*) AS cnt ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			buff.append("	AND pw = ? ");
			break;
		case SEL_TYPE : 
			buff.append("SELECT ");
			buff.append("	ucode ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	uno = ( ");
			buff.append("	SELECT uno FROM users WHERE id = ? ");
			buff.append("	) ");
			break;
		case SEL_USERS_VALID_INFO :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	name = ? ");
			buff.append("	AND mail = ? ");
			break;
		case SEL_FIT_VALID_INFO :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	foname = ? ");
			buff.append("	AND mail = ? ");
			break;
		case SEL_USERS_ID :
			buff.append("SELECT ");
			buff.append("	id ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	name = ? ");
			buff.append("	AND mail = ? ");
			buff.append("	AND isshow = 'Y' ");
			break;
		case SEL_FIT_ID :
			buff.append("SELECT ");
			buff.append("	id ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	foname = ? ");
			buff.append("	AND mail = ? ");
			break;
		case SEL_FIT_FNO :
			buff.append("SELECT ");
			buff.append("	fno ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case SEL_USERS_PW_VALID :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	name = ? ");
			buff.append("	AND id = ? ");
			buff.append("	AND mail = ? ");
			buff.append("	AND isshow = 'Y' ");
			break;
		case SEL_FIT_PW_VALID :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	foname = ? ");
			buff.append("	AND id = ? ");
			buff.append("	AND mail = ? ");
			break;
		case EDIT_USERS_PW :
			buff.append("UPDATE ");
			buff.append("	users ");
			buff.append("SET ");
			buff.append("	pw = ? ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			buff.append("	AND isshow = 'Y' ");
			break;
		case EDIT_FIT_PW :
			buff.append("UPDATE ");
			buff.append("	fit ");
			buff.append("SET ");
			buff.append("	pw = ? ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case EDIT_SHOW_N :
			buff.append("UPDATE ");
			buff.append("	users ");
			buff.append("SET ");
			buff.append("	isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("	uno = ( ");
			buff.append("		SELECT uno FROM users WHERE id = ?  ");
			buff.append("	)  ");
			break;
		case SEL_CK_USERS_PW :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE  ");
			buff.append("	id = ? ");
			buff.append("	AND pw = ? ");
			buff.append("	AND isshow = 'Y' ");
			break;
		case SEL_CK_FIT_PW :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE  ");
			buff.append("	id = ? ");
			buff.append("	AND pw = ? ");
			break;
		case SEL_CK_USERS_ID :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			buff.append("	AND isshow = 'Y' ");
			break;
		case SEL_CK_FIT_ID :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case SEL_FIT_SMYINFO :
			buff.append("SELECT ");
			buff.append("	fno, fname,addr2 ");
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	fname like ? ");
			break;
		case SEL_USERS_DETAIL :
			buff.append("SELECT "); 
			buff.append("    u.uno uno,name,id, savename,mail,body,goal,pagree,TO_CHAR(ptime,'HH24:MI') mtime "); 
			buff.append("FROM  "); 
			buff.append("    userimage ui,users u , meminfo m  "); 
			buff.append("WHERE  "); 
			buff.append("    u.uno= m.uno (+) "); 
			buff.append("    and u.isshow = 'Y' "); 
			buff.append("    and u.uno = im_uno (+) "); 
			buff.append("    AND id = ? "); 
			break;
		case SEL_TRAINER_DETAIL :
			buff.append("SELECT "); 
			buff.append("    u.uno uno,id,name, mail,career,info,savename,fit fno,(SELECT fname FROM fit,users u WHERE fno = u.fit AND u.uno = (SELECT uno FROM users WHERE id = '?') ) as fname "); 
			buff.append("FROM "); 
			buff.append("    users u, tinfo t,userImage ui "); 
			buff.append("WHERE  "); 
			buff.append("    u.uno = t.uno "); 
			buff.append("    AND u.uno = ui.im_uno "); 
			buff.append("    AND u.isshow = 'Y' ");
			buff.append("    AND id = ? ");
			break;
		case ADD_MEM :
			buff.append("INSERT INTO  "); 
			buff.append("    users(uno,id,pw,mail,name,tel,addr1,addr2,addr3) "); 
			buff.append("VALUES ( "); 
			buff.append("    (SELECT NVL(MAX(uno)+1,100) FROM users), "); 
			buff.append("    ?,?,?,?,?,?,?,? "); 
			buff.append(") ");
			break;
		case ADD_MEMINFO :
			buff.append("INSERT INTO  "); 
			buff.append("    meminfo(mno,body,goal,ptime,uno) "); 
			buff.append("VALUES ( "); 
			buff.append("    (SELECT NVL(MAX(mno)+1,100) FROM meminfo), "); 
			buff.append("    ?,?,TO_DATE(?,'HH24:MI') "); 
			buff.append("    ,(SELECT uno FROM users WHERE id = ?) "); 
			buff.append(") ");
			break;
		case ADD_T :
			buff.append("INSERT INTO "); 
			buff.append("    users(uno,id,pw,mail,name,tel,addr1,addr2,addr3,fit,ucode) "); 
			buff.append("VALUES ( "); 
			buff.append("    (SELECT NVL(MAX(uno)+1,100) FROM users), "); 
			buff.append("    ?,?,?,?,?,?,?,?,?,'T' "); 
			buff.append(") ");
			break;
		case ADD_TINFO :
			buff.append("INSERT INTO  "); 
			buff.append("    tinfo(tno,career,info,uno) "); 
			buff.append("VALUES( "); 
			buff.append("   (SELECT NVL(MAX(tno)+1,100)FROM tinfo), "); 
			buff.append("    ?,?,(SELECT uno FROM users WHERE id = ?)  "); 
			buff.append(") ");
			break;
		case ADD_USERS_IMG :
			buff.append("INSERT INTO  "); 
			buff.append("	userimage(ino,oriname,savename,len,im_uno) "); 
			buff.append("VALUES( "); 
			buff.append("	(SELECT NVL(MAX(ino)+1,1000)FROM userimage), "); 
			buff.append("	?,?,?, "); 
			buff.append("	(SELECT uno FROM users WHERE id = ?) "); 
			buff.append(") ");
			break;
		case ADD_FIT :
			buff.append("INSERT INTO "); 
			buff.append("    fit(fno,id,pw,mail,fname,foname,tel,addr1,addr2,addr3) "); 
			buff.append("VALUES( "); 
			buff.append("    (SELECT NVL(MAX(fno)+1,100) FROM fit), "); 
			buff.append("    ?,?,?,?,?,?,?,?,? "); 
			buff.append(") ");
			break;
		}
		
		
		return buff.toString();
	}
	
}
