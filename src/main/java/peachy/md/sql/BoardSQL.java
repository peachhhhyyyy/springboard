package peachy.md.sql;

public class BoardSQL {
	   public static final String LIST = "select * from BOARD order by SEQ desc";
	   public static final String INSERT 
	   = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";
	   public static final String DEL="delete from BOARD where SEQ=?";
	   public static final String CONTENT = "select * from BOARD where SEQ=?";
	   public static final String UPDATE1 = "select * from BOARD where SEQ=?";
	   public static final String UPDATE2
	   = "update BOARD set WRITER=?, EMAIL=?, SUBJECT=?, CONTENT=?, RDATE=SYSDATE where SEQ=?";
}