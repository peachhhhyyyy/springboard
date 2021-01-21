package peachy.md.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
	String keyword;
	
	private int cp;
	private int ps;
	
	{
		cp = 1;
		ps = 5;
	}
	
	public int getStartRow() {
		return (cp-1) * ps;
	}
	public int getEndRow() {
		return cp * ps;
	}
}
