package peachy.md.sql;

public class AddressSQL {
	public static final String SEL = "select * from ADDRESS order by SEQ desc";
	public static final String IN 
		= "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
	public static final String DEL = "delete from ADDRESS where SEQ=?";
}
