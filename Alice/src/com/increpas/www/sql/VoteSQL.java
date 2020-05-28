package com.increpas.www.sql;

public class VoteSQL {
	public final int SEL_USERS_VOTE =1001;
	public final int SEL_USERS_ALL = 1002;
	public final int SEL_USERS_cVOTE = 1003;
	public final int SEL_USERS_aVOTE = 1004;
	public final int SEL_UPD_CLK = 2001;
	
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
		case SEL_USERS_ALL :
			buff.append("SELECT ");
			buff.append("  uno,id,pw,mail,name,addr1,addr2,addr3,fit,ucode,isshow");
			buff.append("FROM ");
			buff.append("	users");
			break;
		case SEL_USERS_cVOTE :
			buff.append("SELECT ");
			buff.append("	id,name,count ");
			buff.append("FROM ");
			buff.append("	vote");
			buff.append("WHERE ");
			buff.append(" id = ? ");
			buff.append("ORDER BY ");
			buff.append(" count desc");
			break;
		case SEL_USERS_aVOTE :
			buff.append("SELECT ");
			buff.append("  id,name,count,vno");
			buff.append("FROM ");
			buff.append(" users");
			buff.append("WHERE ");
			buff.append(" users");
			break;
		case SEL_UPD_CLK:
			buff.append("UPDATE ");
			buff.append("	VOTE ");
			buff.append("SET ");
			buff.append("	click = click + 1 ");
			buff.append("WHERE ");
			buff.append("	vno = ? ");
			break;	
		}
		     
		return buff.toString();
	}
}
