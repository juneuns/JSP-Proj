package com.increpas.www.controller.member.info;
/**
 * 이 클래스는 마이페이지의 메뉴중 컨택 리스트에 대한 뷰를 요청하면 응답하는 클래스이다. \
 * 
 * @author	박광호
 * @since	2020.05.26
 * @version	v 1.0.0
 * @see		
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;

public class ContactList implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/info/contactList.jsp";
		// 세션의 아이디, 회원 분류 꺼내는 작업
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("SID");
		String type = (String)session.getAttribute("TYPE");
		// 디비 작업 해서 리스트 업 주기 
		
		if(type.equals("T")) {
			// 일반회원의 정보를 리스트<vo> 반환 
		}else {
			
			// 트레이너의 정보를 리스트<vo> 반환 
			
		}
		return view;
	}

}
