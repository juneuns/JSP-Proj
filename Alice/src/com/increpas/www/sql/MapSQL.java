package com.increpas.www.sql;

public class MapSQL {
	public final int SEL_ADDR = 1001;
	public final int SEL_MSEARCH = 2001;
	public final int SEL_TSEARCH = 2002;
	public final int SEL_TMATCHING = 1002;
	public final int SEL_MMATCHING = 1003;
	public final int SEL_PTNO = 1004;
	public final int SEL_MYPTNO = 1005;
	public final int SEL_MYPT = 1006;
	public final int SEL_TMYPT = 1007;
	public final int SEL_MMYPT = 1008;
	
	
	public String getSQL(int code) {
		StringBuilder buff = new StringBuilder();
		
		switch (code){
		case SEL_ADDR:
			buff.append("SELECT ");
			buff.append(" 	uno,id,pw,mail,name,addr1,addr2 ");
			buff.append("FROM ");
			buff.append(" 	users ");
			break;
		
		case SEL_MSEARCH:
			buff.append("SELECT ");
			buff.append("    fno,fname,f.tel tel,f.addr2 addr2,u.name name ");
			buff.append("FROM ");
			buff.append("    fit f,users u ");
			buff.append("WHERE ");
			buff.append("    fno  = fit ");
			buff.append("    and ucode = 'T' ");
			buff.append("    or fname  like ? ");
			buff.append("    or f.addr2  like ? ");
			break;
		case SEL_TSEARCH:
			buff.append("SELECT" );
			buff.append("    name,addr2,body,goal ");
			buff.append("FROM ");
			buff.append("    users,meminfo ");
			buff.append("WHERE ");
			buff.append(" name like ? ");
			buff.append(" addr2 like ? ");
			break;
		
		case SEL_TMATCHING:
			buff.append("SELECT ");
			buff.append("  m.pagree pagree,m.body body,m.goal goal,m.ptime ptime,u.name name,u.addr2 addr2 ");
			buff.append("FROM ");
			buff.append(" meminfo m,users u ");
			buff.append("WHERE ");
			buff.append(" u.addr2 = ( ");
			buff.append("     select t.addr2 ");
			buff.append("     from  users t ");
			buff.append("      where t.id = ?) and u.uno = m.uno ");
			break;
		case SEL_MMATCHING:
			buff.append("SELECT ");
			buff.append("    t.career career, t.info info, u.name name, u.addr2 addr2,t.agree agree ");
			buff.append("FROM " );
			buff.append("    tinfo t,users u ");
			buff.append("WHERE ");
			buff.append(" u.addr2 = ( ");
			buff.append("     select m.addr2 ");
			buff.append("     from  users m ");
			buff.append("     where m.id = ?) and u.uno = m.uno ");
			break;
		case SEL_PTNO:
			buff.append("INSERT INTO ");
			buff.append(" matching(ptno,mno,tno) ");
			buff.append("VALUES( ");
			buff.append(" (SELECT NVL(MAX(ptno)+1,100) FROM matching), ");
			buff.append("  ? , ? ");
			buff.append(" ) ");			
			break;			
		case SEL_MYPTNO:
			buff.append("UPDATE ");
			buff.append(" matching ");
			buff.append("SET ");
			buff.append("WHERE ");
			buff.append(" id = ? AND act = 'Y' ");
			buff.append(" ) ");
			break;
		case SEL_MYPT:
			buff.append("SELECT ");
			buff.append(" u.name,u.uno,m.ptno ");
			buff.append("FROM ");
			buff.append(" users u, matching m ");
			buff.append("WHERE ");
			buff.append(" u.uno = (SELECT " );
			buff.append("     uno ");
			buff.append("FROM ");
			buff.append("   users ");
			buff.append("WHERE ");
			buff.append("   id = ?) " );				
			break;
		case SEL_TMYPT:
			buff.append("SELECT ");
			buff.append("    m.pno, a.body,a.goal , a.ptime ");
			buff.append("FROM ");
			buff.append("    matching m,meminfo a ");
			buff.append("WHERE ");
			buff.append("    m.mno = (SELECT   mno ");
			buff.append("FROM    matching ");
			buff.append("  WHERE    id = ?) ");
			break;
		case SEL_MMYPT:
			buff.append("SELECT ");
			buff.append("    m.pno, t.career, t.info ");
			buff.append("FROM ");
			buff.append("    matching m,meminfo t ");
			buff.append("WHERE ");
			buff.append("    m.tno = (SELECT  tno ");
			buff.append("FROM  matching ");
			buff.append(" WHERE  id = ?) ");
			break;
		}
		return buff.toString();
	}
}
