package com.increpas.www.sql;

public class MapSQL {
	public final int SEL_ADDR = 1001;
	public final int SEL_SEARCH = 2001;
	public final int SEL_TMATCHING = 1002;
	public final int SEL_MMATCHING = 1003;
	
	public String getSQL(int code) {
		StringBuilder buff = new StringBuilder();
		
		switch (code){
		case SEL_ADDR:
			buff.append("SELECT ");
			buff.append(" 	uno,id,pw,mail,name,addr1,addr2 ");
			buff.append("FROM ");
			buff.append(" 	users ");
			break;
		
		case SEL_SEARCH:
			buff.append("SELECT ");
			buff.append(" 	name,addr2,mail ");
			buff.append("FROM ");
			buff.append(" 	users ");
			buff.append("WHERE 	 ");
			buff.append(" 	 name like ? ");
			buff.append(" 	 OR addr2 like ? ");
			break;
		
		case SEL_TMATCHING:
			buff.append("SELECT ");
			buff.append("    m.body, m.goal, m.ptime, p.name, p.addr2 ");
			buff.append("FROM" );
			buff.append("    meminfo m, ( ");
			buff.append("        select u.uno ");
			buff.append("        from users u, users t ");
			buff.append("        where t.id = ? and u.ucode = m and u.addr2 = t.addr2) p ");
			buff.append("WHERE ");
			buff.append("    m.uno = p.uno; ");
			break;
		case SEL_MMATCHING:
			buff.append("SELECT ");
			buff.append("    t.career, t.info, p.name, p.addr2 ");
			buff.append("FROM" );
			buff.append("    tinfo t, ( ");
			buff.append("        select u.uno ");
			buff.append("        from users u, users t ");
			buff.append("        where m.id = ? and u.ucode = t and u.addr2 = t.addr2) p ");
			buff.append("WHERE ");
			buff.append("    t.uno = p.uno; ");
			break;
		
		}
		return buff.toString();
	}
}
