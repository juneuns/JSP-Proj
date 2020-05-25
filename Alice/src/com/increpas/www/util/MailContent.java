package com.increpas.www.util;
import com.increpas.www.dao.MemberDao;

public class MailContent {
	private String subject ; 
	private String content ;
	public MailContent() {
		this("name");
	}
	public MailContent(String name) {
		createContent(name);
		setSubject();
		setContent(name, "null");
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setSubject() {
		this.subject = "[joGym] 비밀번호 변경이 완료되었습니다.";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
	public void setContent(String name,String nullable) {
		this.content = createContent(name);
	}
	
	public String createContent(String name) {
		MemberDao mDao = new MemberDao();
		// 비밀번호 임시 생성과 DB 처리를 하는 함수 호출 
		String pass = mDao.passInit();
		StringBuffer buff = new StringBuffer();
		buff.append(" 안녕하세요 "+name+" 님, ");
		buff.append(" 회원님의 JoGym 계정의 비밀번호가 변경되었습니다. ");
		buff.append(" 변경된 비밀번호는 "+pass+" 입니다. ");
		return buff.toString();
	}
}
