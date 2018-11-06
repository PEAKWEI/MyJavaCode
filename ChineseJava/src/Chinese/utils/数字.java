package Chinese.utils;

import java.math.BigDecimal;

public class Êý×Ö {
	private BigDecimal bDecimal;

	public Êý×Ö(String val) {
		super();
		this.bDecimal = new BigDecimal(val);
	}

	public BigDecimal getbDecimal() {
		return bDecimal;
	}

	public void setbDecimal(BigDecimal bDecimal) {
		this.bDecimal = bDecimal;
	}
	
	@Override
	public String toString() {
		return bDecimal.toString();
	}
}