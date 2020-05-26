package com.increpas.www.sql;

public class VoteSQL {
	public final int SEL_USERS_VOTE =1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_USERS_VOTE : 
			buff.append("INSERT INTO ");
			buff.append("	VOTE(id,name) ");
			buff.append("SELECT ");
			buff.append("	id,name ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		}
		    
		return buff.toString();
	}
}
