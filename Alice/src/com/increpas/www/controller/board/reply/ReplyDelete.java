package com.increpas.www.controller.board.reply;

/**
 * 	이 클래스는 게시글에 달린 댓글을 안보이게 해주는 클래스입니다.
 * @author	주재석
 * @since	2020.05.26
 */

import javax.servlet.http.*;
import javax.servlet.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.increpas.www.controller.DoController;
import com.increpas.www.dao.*;
import com.increpas.www.vo.BoardReplyVO;

public class ReplyDelete implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
//		req.setAttribute("isRedirect", null);
		String strbno = req.getParameter("bno");
		String strno = req.getParameter("rno");
		int rno = 0;
		int bno = 0;
		try {			
			bno = Integer.parseInt(strbno);	
			rno = Integer.parseInt(strno);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("rno : " + rno + "bno : " + bno);
		
		TboardDAO tdao = new TboardDAO();
		int cnt = tdao.DelRpl(rno);
		
		
		// 응답문서 인코딩(한글처리
//		resp.setCharacterEncoding("UTF-8");
//		JSONObject json = new JSONObject();
//		
//		json.put("rno", rvo.getRno());
//		json.put("rcontent", rvo.getRcontent());
//		
//		return json.toString();
//		String view = "/Alice/tboard/tboardDetail.do";
//		StringBuffer buff = new StringBuffer();
//		buff.append("{\"view\":[");
//		buff.append("\"");
//		buff.append(view);
//		buff.append("\",");
//		buff.append("\"bno\":[");
//		buff.append("\"");
//		buff.append(bno);
//		buff.append("\"");
//		buff.append("]}");
//		return buff.toString();
		String view = "/board/tboard/tboardRedirect.jsp";
		
		req.setAttribute("BNO", bno);
		return view;
	}

}
