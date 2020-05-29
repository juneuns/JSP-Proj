package com.increpas.www.controller.centerBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;
import com.increpas.www.vo.CenterBoardVO;

public class CenterBoardNotice implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/centerBoard/centerBoardNotice.jsp";
		CenterBoardDAO cDAO = new CenterBoardDAO();
		int fno = 0;
		int sfno = 0;
		HttpSession session = req.getSession();
		
		try {
			String ssfno = "" + session.getAttribute("FNO");
			sfno = Integer.parseInt(ssfno);
		}catch(Exception e) {
			sfno = 0;
		}
		
		try{
			String sssfno = "" + session.getAttribute("fno");
			fno =Integer.parseInt(sssfno);
		}catch(Exception e){
			fno = Integer.parseInt(req.getParameter("fno"));
		}
		req.setAttribute("fno", fno);
		req.setAttribute("sfno", sfno);

		ArrayList<CenterBoardVO> nlist = cDAO.getNList(fno);
//		ArrayList<CenterBoardVO> rlist = cDAO.getRList(fno);
		CenterBoardVO cvo = cDAO.getFInfo(fno);		

		System.out.println(sfno);
		req.setAttribute("cvo",cvo);
		req.setAttribute("NLIST", nlist);
//		req.setAttribute("RLIST", rlist);
		
		return view;
	}
}