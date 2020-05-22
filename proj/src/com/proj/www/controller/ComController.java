package com.proj.www.controller;

/**
 * 이 클래스는 디스패치 컨트롤러에 요청을 처리할 때 사용할 클래스들의
 * 다형성 구현을 위해 만든 인터페이스
 * @author	주재석
 *
 */
import javax.servlet.http.*;
public interface ComController {
	String exec(HttpServletRequest req, HttpServletResponse resp);
	
}
