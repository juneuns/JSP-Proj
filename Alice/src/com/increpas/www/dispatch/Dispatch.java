package com.increpas.www.dispatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
/**
 * 이클래스는 확장자가 cls로 요청이 되는 경우 Dispatch시킬 서블릿 클래스이다.
 * @author 박광호
 * @since 2020.05.11
 * @see
 *          com.increpas.www.controller.clsController
 */
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;
@WebServlet("*.do") // URL 패턴 지정
public class Dispatch extends HttpServlet {
   /*
      할일
           1.요청 내용과 클래스의 인스턴스를 매핑할 맵이 필요하다.
             요청 내용과 요청내용에 맞는 클래스의 경로를 Properties 파일로 관리할 예정이다.
             Properties는 맵의 일종이므로 
             키갑으로 사용하는 요청 내용을 안다면 클래스의 경로도 알수 있게된다.
             
    */
   public HashMap <String, DoController>map;
   
   public void init(ServletConfig config) throws ServletException{
      //이 함수는 서버가 기동된 이후
      // 요청 내용이 .do로 끝나는 요청이 왔을경우 처음 딱 한번만 실행되는 함수이다.
      // 최초로 이서블릿이 시작되면 준비된 properties 파일을 읽어서
      // 이것을 이용해서 실제 실행 가능한 클래스로 요청내용과 클래스 객체를 맵핑을 해놓아야 한다.
      
      Properties prop = new Properties();
      FileInputStream fin =null;
      try {
         String path = this.getClass().getResource("").getPath();
         // 파일을 스트림으로 만들고
         fin = new FileInputStream(path + "../resource/do.properties");
         prop.load(fin);
      }catch(Exception e) {
         e.printStackTrace();
      }finally{
         try{ 
            fin.close();
         }catch(Exception e) {}
   }
      map = new HashMap<String, DoController>();
      
      //먼저 키값만 뽑아온다.
      Set keys = prop.keySet();
      
      //키값을 알아냈으니 이제 실제 실행할 클래스의 경로를 알아낼수있다.
      // 해당 클래스의 경로를 실제 실행가능한 클래스로 변경해준다.
      
      ArrayList<String> list = new ArrayList<String>(keys);
      
      for(int i=0; i< list.size(); i++) {
         String key = list.get(i);
         String sclass =(String) prop.get(key);
         // 이제 실행 가능한 클래스로 변환한다.
         try {
            Class tmp = Class.forName(sclass);
            DoController doCon= (DoController) tmp.newInstance();
            
            map.put(key,doCon);
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
   // 실제 요청 내용에 맞는 처리를 담당하는 함수
   public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
      //할일
      //1. 요청내용을 알아낸다.
      String full = req.getRequestURI();
      String domain =req.getContextPath();
      // 3. 실제 요청내용을 알아낸다.
      String realPath = full.substring(domain.length());
      
      //4. 요청내용을 알아냈으니 실제 실행할 클래스를 가져온다.
      DoController doCon = map.get(realPath);
   //   System.out.println("############ realPath :" + realPath + "#########");
      
      req.setAttribute("isRedirect", false);
      String view = doCon.exec(req, resp);
      
	  Boolean bool ;
	  try {
		   bool = (boolean)req.getAttribute("isRedirect");
	  } catch(Exception e) {
		   bool = null;
	  }
	  if(bool == null) {
		  PrintWriter pw = resp.getWriter();
		  try {
			  pw.println(view);
		  } catch(Exception e) {}
	  }else if(bool) {
		  resp.sendRedirect(view);
	  } else {		  
		  try {
			  RequestDispatcher rd = req.getRequestDispatcher(view);
			  rd.forward(req, resp);
		  }catch(Exception e){
			  e.printStackTrace();
		  }    	  
	  }
   }
   
}