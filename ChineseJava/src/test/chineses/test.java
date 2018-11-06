package test.chineses;

import Chinese.utils.列表;
import Chinese.utils.基础类型工具;
import Chinese.utils.工具;
import Chinese.utils.控制台;
import Chinese.utils.系统;

public class test {

	public static void main(String[] args) {

		列表<学生> 学生列表 = new 列表<学生>();

		学生 学生1 = new 学生();
		学生1.设置姓名("tomcat");
		学生1.设置年龄(20);
		
		学生 学生2 = new 学生();
		学生2.设置姓名("apache");
		学生2.设置年龄(33);
		
		学生列表.增加(学生1);
		学生列表.增加(学生2);
		
		if(!(工具.不为空(学生列表.获取长度())==基础类型工具.真)) {
			控制台.标准换行输出(基础类型工具.声明字符串("列表中没有数据"));
			系统.退出();
		}
		for(学生 学生详情:学生列表){
			控制台.标准换行输出(学生详情.获取姓名());
			控制台.标准换行输出(学生详情.获取年龄());
		}
	}
}
