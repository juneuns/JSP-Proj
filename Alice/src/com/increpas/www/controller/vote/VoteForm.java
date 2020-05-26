package com.increpas.www.controller.vote;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.www.controller.DoController;

public class VoteForm implements DoController{
	@Override
	public String exec(HttpServletRequest req,HttpServletResponse resp) {
		String view = "/vote/vote.jsp";
		String id = "ghdzja";
		
		Map ratingOptions = new HashMap();
		ratingOptions.put(0, "�١١١١�");
		ratingOptions.put(1, "�ڡ١١١�");
		ratingOptions.put(2, "�ڡڡ١١�");
		ratingOptions.put(3, "�ڡڡڡ١�");
		ratingOptions.put(4, "�ڡڡڡڡ�");
		ratingOptions.put(5, "�ڡڡڡڡ�");
		Object model;
		//((Object) model).addratingOptions("ratingOptions", ratingOptions);
		
		return view;
	} 
}

