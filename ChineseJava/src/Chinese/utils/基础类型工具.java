package Chinese.utils;


public class 基础类型工具 {

	public static final boolean 假=false;
	public static final boolean 真=true;
	
	public static 字符串 声明字符串(String 内容) {
		return new 字符串(内容);
	}

	public static 数字 声明数字(String 内容) {
		return new 数字(内容);
	}
	
	public static void main(String[] args) {
		字符串 字符串 = 基础类型工具.声明字符串("搜索");
		控制台.标准换行输出(字符串);
	}
}




