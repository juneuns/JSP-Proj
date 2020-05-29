package com.increpas.www.sql;

public class CenterBoardSQL {
	public final int SEL_NLIST = 1001;
	public final int SEL_SLIST = 1002;
	public final int SEL_FINFO = 1003;
	public final int SEL_TINFO = 1004;
	public final int SEL_IMG = 1005;
	public final int SEL_SFFNO = 1006;
	public final int SEL_SUFNO = 1007;
	public final int SEL_CBLIST = 1008;
	
	
	public final int ADD_NOTICE = 2001;
	public final int ADD_REPLY = 2002;
	public final int ADD_SONG = 2003;
	public final int ADD_IMG = 2004;
	
	public final int EDT_NOTICE = 3001;
	public final int EDT_SONG = 3002;
	public final int EDT_IMG = 3003;
	
	public final int DEL_NOTICE = 4001;
	public final int DEL_SONG = 4002;
	public final int DEL_IMG = 4003;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_NLIST:
			buff.append("SELECT "); 
			buff.append("	bno, c.fno, sdate gdate, foname , fname ,body,edit "); 
			buff.append("FROM ");
			buff.append("	cboard c, fit f ");
			buff.append("WHERE ");
			buff.append("	f.fno = ? and c.fno = f.fno and isshow = 'Y' and bcode = 'N' "); 
			buff.append("ORDER BY bno desc "); 
			break;
		case SEL_SLIST:
			buff.append("SELECT "); 
			buff.append("	bno, c.fno, sdate gdate, foname , fname ,body,edit "); 
			buff.append("FROM ");
			buff.append("	cboard c, fit f ");
			buff.append("WHERE ");
			buff.append("	f.fno = ? and c.fno = f.fno and isshow = 'Y' and bcode = 'S' "); 
			buff.append("ORDER BY bno desc "); 
			break;
		case SEL_FINFO:
			buff.append("SELECT "); 
			buff.append("	fno, foname , fname "); 
			buff.append("FROM ");
			buff.append("	fit ");
			buff.append("WHERE ");
			buff.append("	fno = ? "); 
			break;
		case SEL_TINFO:
			buff.append("SELECT	");
			buff.append("	name,mail,tel,career,info	");
			buff.append("FROM	");
			buff.append("	users u, tinfo t	");
			buff.append("WHERE	");
			buff.append("	u.fit = ? AND u.uno = t.uno ");
			break;
		case SEL_IMG:
			buff.append("SELECT "); 
			buff.append("	savename,fno "); 
			buff.append("FROM ");
			buff.append("	cimage ");
			buff.append("WHERE ");
			buff.append("	fno = ? and divno = ?"); 
			break;
		case SEL_SFFNO:
			buff.append("SELECT "); 
			buff.append("	fno	 "); 
			buff.append("FROM ");
			buff.append("	fit	 ");
			buff.append("WHERE ");
			buff.append("	id = ? 	"); 
			break;
		case SEL_SUFNO:
			buff.append("SELECT "); 
			buff.append("	fno	 "); 
			buff.append("FROM ");
			buff.append("	users	 ");
			buff.append("WHERE ");
			buff.append("	id = ? 	"); 
			break;
		case SEL_CBLIST:
			buff.append("SELECT "); 
			buff.append("	fno,fname	 "); 
			buff.append("FROM ");
			buff.append("	fit	 decs");
			break;
		case ADD_NOTICE:
			buff.append("INSERT INTO ");
			buff.append("    cboard(bno, fno,body,bcode) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(BNO)+1, 1000) FROM cboard),?,?,'N' )");
			break;
		case ADD_REPLY:
			buff.append("INSERT INTO ");
			buff.append("    recboard(rno,bno, fno,rebody,prno) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(RNO)+1, 1000) FROM recboard),?,?,?,? )");
			break;
		case ADD_SONG:
			buff.append("INSERT INTO ");
			buff.append("    cboard(bno, fno,body,bcode) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(BNO)+1, 1000) FROM cboard),?,?,'S' )");
			break;
		case ADD_IMG:
			buff.append("INSERT INTO ");
			buff.append("    cimage(ino, oriname, savename, len,fno,divno) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(INO)+1, 1000) FROM cimage),?,?,?,?,? )");
			break;
		case EDT_NOTICE:
			buff.append("UPDATE cboard ");
			buff.append("	SET body = ? , sdate ");
			buff.append(" = sysdate , edit = 'Y' ");
			buff.append("	WHERE bno ");
			buff.append(" = ? ");
			break;
		case EDT_SONG:
			buff.append("UPDATE cboard ");
			buff.append("	SET body = ? , sdate ");
			buff.append(" = sysdate , edit = 'Y' ");
			buff.append("	WHERE bno ");
			buff.append(" = ? ");
			break;
		case DEL_NOTICE:
			buff.append("UPDATE cboard ");
			buff.append("	SET isshow = 'N' ");
			buff.append("	WHERE bno ");
			buff.append(" = ? ");
			break;
		case DEL_SONG:
			buff.append("UPDATE cboard ");
			buff.append("	SET isshow = 'N' ");
			buff.append("	WHERE bno ");
			buff.append(" = ? ");
			break;
		case DEL_IMG:
			buff.append("UPDATE cimage ");
			buff.append("	SET isshow = 'N' ");
			buff.append("	WHERE fno ");
			buff.append(" = ? and divno = ? ");
			break;
		}
		return buff.toString();
	}
}
