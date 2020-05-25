package com.increpas.www.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 이 클래스는 메일을 보내기 위한 코어 함수를 가지고 있는 클래스이다.
 * @author	박광호
 * @since	2020.05.16
 */
public class Mailing {
	private String fromA ="khpark0227@gmail.com";
	public void sendMail(String to,String name) throws Exception{
		// properties 설정
		Properties props = new Properties();
		// 프로퍼티스 값에 SMTP 서버 호스트 지정
		props.put("mail.smtp.host","smtp.gmail.com"); // gmail SMTP 서비스 주소(호스트)
		props.put("mail.smtp.port","465"); // gmail 서비스 포트 설정
		props.put("mail.smtp.auth","true"); 
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.smtp.ssl.trust","smtp.gmail.com");
		try {
			
			// 보내는 사람의 정보를 가져올수 잇게 클래스를 선언한다.
			Authenticator auth =new Gmail();
			// 세션에 프로퍼티스 인스턴스를 생성한다 .
			Session session = Session.getDefaultInstance(props, auth);
			
			Message mimeMessage = new MimeMessage(session);
			MailContent mailCnt = new MailContent(name); 
			InternetAddress from = new InternetAddress(fromA);
			mimeMessage.setFrom(from);
			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			mimeMessage.setSubject(mailCnt.getSubject());
			mimeMessage.setText(mailCnt.getContent());
			Transport.send(mimeMessage);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//
		
	}
}