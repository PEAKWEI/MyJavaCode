package Chinese.utils;

import java.math.BigDecimal;

public class ���� {
	private BigDecimal bDecimal;

	public ����(String val) {
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