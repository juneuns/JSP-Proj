package com.increpas.www.controller.board.reply;

/**
 * 이 클래스는 게시글에 달린 댓글의 내용을 수정할 내용을 ajax으로 불러오는 클래스입니다.
 * @author	주재석
 * @since	2020.05.26
 * 
 */
import javax.servlet.http.*;

import org.json.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.increpas.www.controller.DoController;
import com.increpas.www.dao.*;
import com.increpas.www.vo.*;

public class ReplyEdit implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", null);

		String struno = req.getParameter("runo");
		int rno = 0;
		try {
			rno = Integer.parseInt(struno);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("rno : " + rno);
		
		TboardDAO tdao = new TboardDAO();
		BoardReplyVO rvo = tdao.getReply(rno);
		
		
		// 응답문서 인코딩(한글처리
		resp.setCharacterEncoding("UTF-8");
//		JSONObject json = new JSONObject();
//		
//		json.put("rno", rvo.getRno());
//		json.put("rcontent", rvo.getRcontent());
//		
//		return json.toString();
		Gson gson = new GsonBuilder().create();
		String gstr = gson.toJson(rvo);
		return gstr;
	}

}
