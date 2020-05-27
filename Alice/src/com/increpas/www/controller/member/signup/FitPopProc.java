package com.increpas.www.controller.member.signup;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
import com.increpas.www.dao.MemberDao;
import com.increpas.www.vo.FitVO;

public class FitPopProc implements DoController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="/member/signUp/fitPop.jsp";
		String fname = req.getParameter("keyword");
		
		MemberDao mDao = new MemberDao();
		ArrayList<FitVO> list = mDao.getFitSMYInfo(fname);
		System.out.println("리스트의 사이즈는 : "+list.size());
		req.setAttribute("LIST", list);
		return view;
	}

}
