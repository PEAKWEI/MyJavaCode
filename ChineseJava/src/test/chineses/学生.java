package test.chineses;


public class 学生 {

	//private 字符串 姓名;
	
	private String 姓名;
	
	private Integer 年龄;

	public String 获取姓名() {
		return 姓名;
	}

	public void 设置姓名(String 姓名) {
		this.姓名 = 姓名;
	}

	public Integer 获取年龄() {
		return 年龄;
	}

	public void 设置年龄(Integer 年龄) {
		this.年龄 = 年龄;
	}

	@Override
	public String toString() {
		return "学生 [姓名=" + 姓名 + ", 年龄=" + 年龄 + "]";
	}
}

