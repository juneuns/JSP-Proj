package com.increpas.www.sql;

/**
 * 이 클래스는 디비작업에 필요한 질의명령을 저장하는 클래스입니다.
 * @author	주재석
 * @since	2020.05.25
 *
 */

public class TboardSQL {
	public final int SEL_ALL = 1001;
	public final int SEL_CONT = 1002;
	public final int SEL_BRD = 1003;
	public final int SEL_IMG = 1004;
	public final int SEL_RPL = 1005;
	public final int SEL_UPL = 1008;
	public final int SEL_RCON = 1006;
	public final int SEL_BNO = 1007;
	public final int SEL_UNO = 1009;

	public final int UPD_CLK = 2001;
	public final int UPD_BRD = 2002;
	public final int UPD_IMG = 2003;
	public final int UPD_RPL = 2004;

	public final int ADD_BRD = 3001;
	public final int ADD_IMG = 3002;
	public final int ADD_RPL = 3003;

	
	public final int DEL_BRD = 4001;
	public final int DEL_IMG = 4002;
	public final int DEL_RPL = 4003;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ALL:
			buff.append("SELECT     "); 
			buff.append("	rno, bno, title, b_uno, bcontent, hiredate, click "); 
			buff.append("FROM "); 
			buff.append("	(     "); 
			buff.append("    SELECT "); 
			buff.append("		ROWNUM rno, bno, title, b_uno, bcontent, hiredate, click "); 
			buff.append("	FROM "); 
			buff.append("		( "); 
			buff.append("		SELECT "); 
			buff.append("			bno, title, b_uno, bcontent, board.hiredate, click "); 
			buff.append("		FROM "); 
			buff.append("            board, users "); 
			buff.append("		WHERE "); 
			buff.append("			board.isshow = 'Y' "); 
			buff.append("        	AND board.b_uno = users.uno "); 
			buff.append("		ORDER BY "); 
			buff.append("			hiredate DESC "); 
			buff.append("        ) "); 
			buff.append("    ) "); 
			buff.append("WHERE "); 
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		case SEL_UNO:
			buff.append("SELECT ");
			buff.append("	uno ");
			buff.append("FROM ");
			buff.append("	users ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case SEL_CONT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	board ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_RCON:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	reply ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND r_bno = ? ");
			break;
		case SEL_BRD:
			buff.append("SELECT   "); 
			buff.append("	bno, title, b_uno, bcontent, hiredate, click "); 
			buff.append("FROM   "); 
			buff.append("	board "); 
			buff.append("WHERE "); 
			buff.append("	isshow = 'Y' "); 
			buff.append("	AND bno = ? ");
			break;
		case SEL_IMG:
			buff.append("SELECT ");
			buff.append("    ino, i_bno, oriname, savename "); 
			buff.append("FROM ");
			buff.append("    image "); 
			buff.append("WHERE "); 
			buff.append("    i_bno = ? ");
			break;
		case SEL_RPL:
			buff.append("SELECT    "); 
			buff.append("    rnum, rno, r_uno, rcontent, runo, rdate, step    "); 
			buff.append("FROM    "); 
			buff.append("	(SELECT    "); 
			buff.append("    	ROWNUM rnum, R.* "); 
			buff.append("	FROM    "); 
			buff.append("		(SELECT    "); 
			buff.append("        	rno, r_uno, rcontent, r_bno, rdate, runo, (LEVEL - 1) step "); 
			buff.append("		FROM  "); 
			buff.append("        	reply r, board b "); 
			buff.append("		WHERE    "); 
			buff.append("			r.isShow = 'Y' "); 
			buff.append("			AND r_bno = bno "); 
			buff.append("			AND bno = ? "); 
			buff.append("		START WITH    "); 
			buff.append("			runo IS NULL "); 
			buff.append("		CONNECT BY "); 
			buff.append("			PRIOR rno = runo "); 
			buff.append("		ORDER SIBLINGS BY   "); 
			buff.append("			rdate DESC) R  "); 
			buff.append("		) ");
			buff.append("WHERE    ");
			buff.append("	rnum BETWEEN ? AND ? ");
			break;
		case SEL_BNO:
			buff.append("SELECT ");
			buff.append("    MAX(bno) bno "); 
			buff.append("FROM ");
			buff.append("    board ");
			break;
		case SEL_UPL:
			buff.append("SELECT ");
			buff.append("    rno, r_uno, rcontent, r_bno, runo "); 
			buff.append("FROM ");
			buff.append("    reply ");
			buff.append("WHERE ");
			buff.append("    rno = ? ");
			break;
		case UPD_CLK:
			buff.append("UPDATE ");
			buff.append("	board ");
			buff.append("SET ");
			buff.append("	click = click + 1 ");
			buff.append("WHERE ");
			buff.append("	bno = ? ");
			break;
		case UPD_BRD:
			buff.append("UPDATE "); 
			buff.append("    board "); 
			buff.append("SET "); 
			buff.append("    title = ?, "); 
			buff.append("    bcontent = ? ");
			buff.append("WHERE "); 
			buff.append("    bno = ? ");
			break;
		case UPD_RPL:
			buff.append("UPDATE "); 
			buff.append("    reply "); 
			buff.append("SET "); 
			buff.append("    rcontent = ? "); 
			buff.append("WHERE "); 
			buff.append("    rno = ? "); 
			break;
		case ADD_BRD:
			buff.append("INSERT INTO "); 
			buff.append("    board(bno, title, b_uno, bcontent) "); 
			buff.append("VALUES( "); 
			buff.append("    (SELECT NVL(MAX(bno) + 1, 1000) FROM board), "); 
			buff.append("    ?, "); 
			buff.append("    ?, ? "); 
			buff.append(") ");
			break;
		case ADD_IMG:
			buff.append("INSERT INTO ");
			buff.append("	image(ino, i_bno, oriname, savename, len) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(ino)+1, 1000) FROM image), ");
			buff.append("	?, ?, ?, ?) ");
			break;
		case ADD_RPL:
			buff.append("INSERT INTO ");
			buff.append("	reply(rno, r_uno, rcontent, r_bno@) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(rno)+1, 1000) FROM reply), ");
			buff.append("	?, ?, ?#) ");
			break;
		case DEL_BRD:
			buff.append("UPDATE "); 
			buff.append("    board "); 
			buff.append("SET ");
			buff.append("    isshow = 'N' "); 
			buff.append("WHERE "); 
			buff.append("    bno = ? ");
			break;
		case DEL_RPL:
			buff.append("UPDATE "); 
			buff.append("    reply "); 
			buff.append("SET "); 
			buff.append("    isshow = 'N' "); 
			buff.append("WHERE "); 
			buff.append("    rno = ? ");
			break;
		}
		return buff.toString();
	}
}
