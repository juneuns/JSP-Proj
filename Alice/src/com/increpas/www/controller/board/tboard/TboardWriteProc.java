package com.increpas.www.controller.board.tboard;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 이 클래스는 게시글 작성페이지에서 서브밋 버튼이 눌렸을때 디비에 저장을 도와주는 클래스 입니다.
 * 
 */

import javax.servlet.http.*;

import com.increpas.www.controller.DoController;
import com.increpas.www.vo.*;
import com.increpas.www.dao.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
/**
 * 이 클래스는 작성 요청 처리를 하는 클래스입니다.
 * @author	주재석
 * @since	2020.05.27
 *
 */
public class TboardWriteProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/tboard/tboardRedirect.jsp";
//		req.setAttribute("isRedirect", true);
		
		String sid = (String)req.getSession().getAttribute("SID");
		String path = req.getSession().getServletContext().getRealPath("img");
//		System.out.println("path : " + path);
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(req, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String title = multi.getParameter("title");
		String tcont = multi.getParameter("tcont");
		// 게시글 추가
		TboardDAO tdao = new TboardDAO();
		int uno = tdao.getUno(sid);
		int inb = tdao.insBrd(title, uno, tcont);
//		System.out.println("inb : " + inb);
		if(inb != 1) {
			view = "/Alice/tboard/tboardList.do";
			req.setAttribute("isRedirect", true);
			return view;
		}
		// 게시글이 추가되고 난뒤 가장 큰 값을 구해오면 작성된 게시글이 선택될 것이다.
		int bno = tdao.getBno();
		
		// 이미지 추가
		BoardImageVO ivo = new BoardImageVO();
		ivo.setBno(bno);
		ivo.setMulti(multi);
		boolean bool = tdao.insImg(ivo, path);
		System.out.println(bool);
		if(!bool) {
			 view = "/Alice/board/errorMsg.jsp";
			 req.setAttribute("isRedirect", true);
		}
		
		// 모두 동일
		req.setAttribute("SID", sid);
		req.setAttribute("BNO", bno);
		req.setAttribute("PATH", path);
		return view;
	}

}
