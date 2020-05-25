package com.increpas.www.util;
/**
 * 이 클래스는 메일을 보내는 관리자의 정보를 담고있다.
 * @author	박광호
 * @since	2020.05.16
 * @version	v.1.0.0
 * 
 */
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		String adminGmailID = "khpark0227";
		String adminGmailPW = "qkrrhkdgh1@";
		return new PasswordAuthentication(adminGmailID,adminGmailPW);
	}
}
