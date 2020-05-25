package com.increpas.www.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DoController {
	String exec(HttpServletRequest req,HttpServletResponse resp);
}
