package com.increpas.www.controller.board.tboard;

/**
 * 이 클래스는 게시글목차를 클릭하여 게시글 상세보기에 들어왔을 시 뷰를 보여주는 클래스입니다.
 * @author	주재석
 * @since	2020.05.26
 * 
 */

import javax.servlet.http.*;
import java.util.*;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.*;
import com.increpas.www.util.*;
import com.increpas.www.vo.*;

public class TboardDetail implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardDetail.jsp";
		
		String strbno = req.getParameter("bno");
		String strPage = req.getParameter("nowPage");
		String strePage = req.getParameter("rePage");
		
		int bno = 0;
		int nowPage = 1;
		int rePage = 1;
		try {
			bno = Integer.parseInt(strbno);
			nowPage = Integer.parseInt(strPage);
			rePage = Integer.parseInt(strePage);
		} catch(Exception e) {}
		TboardDAO tdao = new TboardDAO();
		// 게시글 가져오기
		TboardVO tvo = tdao.getBoard(bno);
		// 게시글 이미지가져오기
		ArrayList<BoardImageVO> list = tdao.getImage(bno);
		// 게시글의 댓글 가져오기
		int reTotalPage = tdao.getRcon(bno);
		// 게시글의 페이지 유틸 적용하기.
		PageUtil page = new PageUtil(rePage, reTotalPage, 5, 3);
		ArrayList<BoardReplyVO> reply = tdao.getReply(bno, page);
		// id를 통해 진입한 사람이 작성자와 동일한지 확인한다.
		// id로 사용자번호를 조회해서 넣어준다.
		String sid = (String)req.getSession().getAttribute("SID");
		int uno = tdao.getBno();
		
		req.setAttribute("UNO", uno);
		req.setAttribute("DATA", tvo);
		req.setAttribute("LIST", list);
		req.setAttribute("REPLY", reply);
		req.setAttribute("PAGE", page);
		req.setAttribute("SID", sid);
		
		return view;
	}

}
