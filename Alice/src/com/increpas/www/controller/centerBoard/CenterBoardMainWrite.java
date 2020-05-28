package com.increpas.www.controller.centerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.CenterBoardDAO;
import com.increpas.www.vo.CenterBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CenterBoardMainWrite implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/gogym/centerBoardMain.do";
		req.setAttribute("isRedirect", true);
		int fno = 1002;
		String path = req.getSession().getServletContext().getRealPath("img");
		MultipartRequest multi = null;		
		try {
			multi = new MultipartRequest(req, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		} catch(Exception e) {
			e.printStackTrace();
		}
		CenterBoardVO ivo = new CenterBoardVO();
		CenterBoardDAO cdao = new CenterBoardDAO();
		int divno = Integer.parseInt(multi.getParameter("divno"));
		System.out.println(divno);
		ivo.setFno(fno);
		ivo.setDivno(divno);
		ivo.setMulti(multi);
		int cnt = cdao.addMainImg(ivo);
		if(cnt!=1) {
			 view = "/Alice/board/errorMsg.jsp";
			 req.setAttribute("isRedirect", true);
		}
		return view;
	}
}
