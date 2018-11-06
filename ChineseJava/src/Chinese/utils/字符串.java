package Chinese.utils;

public final class ×Ö·û´® {
	private static String val;
	
	public static void ÉùÃ÷×Ö·û´®(String val) {
		×Ö·û´®.val = val;
	}
	
	public ×Ö·û´®(String val) {
		super();
		×Ö·û´®.val = val;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		×Ö·û´®.val = val;
	}

	@Override
	public String toString() {
		return val;
	}
}