package com.increpas.www.controller.ajax;
/**
 *  이 클래스는 회원 가입 입력폼 작성중 아이디 중복 확인 요청이 오면 응답하고 json문서를 내보는 클래스이다.
 *  
 *  @author	박광호
 *  @since	2020.05.26
 *  @version	v 1.0.0
 *  
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;

public class IdDoubleCk implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		StringBuffer buff = new StringBuffer();
		int cnt = -1;
		String id = req.getParameter("id");
		String type = req.getParameter("type");
		MemberDao mDao = new MemberDao();
		cnt = mDao.idDoubleCk(id, type);
		
		if(cnt == 0) {
			buff.append("{");
			buff.append("	\"result\":\"ok\"");
			buff.append("}");
		} else {
			buff.append("{");
			buff.append("	\"result\":\"no\"");
			buff.append("}");
		}
		req.setAttribute("isRedirect", null);
		// 문서 내보내기 
		return buff.toString();
	}

}
