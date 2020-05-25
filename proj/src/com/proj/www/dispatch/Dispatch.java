package com.proj.www.dispatch;


/**
 * 이 클래스는 확장자가 cls로 요청되는 경우 Dispatch시킬 서블릿 클래스이다.
 */
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.proj.www.controller.*;

import java.util.*;
import java.io.*;

@WebServlet("*.do")// URL 패턴지정
public class Dispatch extends HttpServlet {
	public HashMap<String, ComController> map;
	
	public void init(ServletConfig config) throws ServletException {
		Properties prop = new Properties();
		FileInputStream fin = null;
		try {
			String path = this.getClass().getResource("").getPath();
//			System.out.println(path);
			fin = new FileInputStream(path + "../resource/do.properties");
			prop.load(fin);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch(Exception e) {}
		}
		
		map = new HashMap<String, ComController>();
		
		Set keys = prop.keySet();
		
		ArrayList<String> list = new ArrayList<String>(keys);
		for(int i = 0 ; i < list.size(); i++) {
			String key = list.get(i);
			String sclass = (String)prop.get(key);
			try {
				Class tmp = Class.forName(sclass);
				ComController com = (ComController) tmp.newInstance();
				
				map.put(key, com);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String full = req.getRequestURI();
		String domain = req.getContextPath();
		String realPath = full.substring(domain.length());
		System.out.println("* realPath : " + realPath);
		
		ComController com = map.get(realPath);
		req.setAttribute("isRedirect", false);
		String view = com.exec(req, resp);
		Boolean bool;
		try {
			bool = (boolean) req.getAttribute("isRedirect");
		} catch(Exception e) {
			bool = null;
		}
		if(bool == null) {
			PrintWriter pw = resp.getWriter();
			try {
				pw.println(view);
			} catch(Exception e) {}
		} else if(bool == true) {
			resp.sendRedirect(view);
		} else {
			try {
				RequestDispatcher rd = req.getRequestDispatcher(view);
				rd.forward(req, resp);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
/*		boolean bool = false;
		bool = (boolean) req.getAttribute("isRedirect");
		if(bool) {
			resp.sendRedirect(view);
		} else {
			try {
				RequestDispatcher rd = req.getRequestDispatcher(view);
				rd.forward(req, resp);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		*/
	}
}
