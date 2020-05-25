package com.proj.www.sql;

public class TboardSQL {
	public final int SEL_ALL = 1001;

	public final int ADD_ONE = 2001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case ADD_ONE:
			buff.append("INSERT INTO "); 
			buff.append("    board(bno, title, b_empno, bcontent) "); 
			buff.append("VALUES( "); 
			buff.append("    (SELECT NVL(MAX(bno) + 1, 1000) FROM board), "); 
			buff.append("    ?, ?, "); 
			buff.append("    (SELECT empno FROM member WHERE ename = ? "); 
			buff.append(") ");
			break;
		}
		return buff.toString();
	}
}
