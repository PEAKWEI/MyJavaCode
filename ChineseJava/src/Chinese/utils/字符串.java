package Chinese.utils;

public final class �ַ��� {
	private static String val;
	
	public static void �����ַ���(String val) {
		�ַ���.val = val;
	}
	
	public �ַ���(String val) {
		super();
		�ַ���.val = val;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		�ַ���.val = val;
	}

	@Override
	public String toString() {
		return val;
	}
}