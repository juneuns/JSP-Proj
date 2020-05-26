package com.increpas.www.sql;
/**
 * 이 클래스는 회원 정보 관리 패키지에 사용되는 질의명령을 만들어 반환하는 클래스이다.
 * 
 * @author	박광호
 * @since	2020.05.25 
 * @version	v 1.0.0
 * @see	
 * 			1. SEL_USERS_SIGNIN : 트레이너,일반회원 로그인 처리 질의명령
 * 			2. SEL_FIT_LOGIN : 시설 관리자 회원 로그인 처리 질의명령
 * 			3. SEL_USERS_VALID_INFO : 트레이너 일반회원 아이디 찾기 시 DB 체크 
 * 			4. SEL_FIT_VALID_INFO : 시설 관리자 아이디 찾기 시 DB 체크 
 * 			5. SEL_TYPE : 로그인 시 회원 종류
 * 			6. SEL_USERS_ID : 트레이너,일반회원 아이디 찾기 
 * 			7. SEL_FIT_ID : 시설 회원 아이디 찾기 
 * 			8. SEL_FIT_FNO : 시설 회원 PK 찾기 
 * 			8. SEL_FIND_PW_PROC : 비밀번호 찾기 DB 체크  
 * 			8. SEL_FIT_FNO : 시설 회원 PK 찾기 
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
	
	public final int EDIT_USERS_PW = 2001;
	public final int EDIT_FIT_PW = 2002;
	
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
			break;
		case EDIT_FIT_PW :
			buff.append("UPDATE ");
			buff.append("	fit ");
			buff.append("SET ");
			buff.append("	pw = ? ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case SEL_CK_USERS_PW :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE  ");
			buff.append("	id = ? ");
			buff.append("	AND pw = ? ");
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
		}
		
		
		return buff.toString();
	}
	
}
