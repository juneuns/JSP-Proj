package com.increpas.www.controller.centerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;
import com.increpas.www.vo.CenterBoardVO;

public class CenterBoardReplyWrite implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Alice/centerBoardNotice.do";
		req.setAttribute("isRedirect",true);
		
		CenterBoardVO cvo = new CenterBoardVO();
		CenterBoardDAO cdao = new CenterBoardDAO();
		
		String rebody = req.getParameter("rebody");
		System.out.println(rebody);
		int fno = Integer.parseInt(req.getParameter("fno"));
		System.out.println(fno);
		int bno = Integer.parseInt(req.getParameter("bno"));
		System.out.println(bno);
		int prno = Integer.parseInt(req.getParameter("rno"));
		System.out.println(prno);
		
		cvo.setFno(fno);
		cvo.setBno(bno);
		cvo.setRebody(rebody);
		cvo.setPrno(prno);
		
		int cnt = cdao.addReply(cvo);
		return view;
	}
}

