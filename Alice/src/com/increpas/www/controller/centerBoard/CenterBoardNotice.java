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
		System.out.println("FNO"+session.getAttribute("FNO"));
		String ssfno = "" + session.getAttribute("FNO");
		String sssfno = "" + session.getAttribute("fno");
		try{
			sfno = Integer.parseInt(ssfno);
			fno = Integer.parseInt(req.getParameter("fno"));
			System.out.println("try"+sfno);
		}catch(Exception e){
			fno =Integer.parseInt(sssfno);
		}finally{
//			if(sfno==0) {
//				sfno=0;
//			}
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