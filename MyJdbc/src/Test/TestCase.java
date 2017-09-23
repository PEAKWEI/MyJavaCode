package Test;

import org.dgw.conjdbc.JdbcUtil;

import stubeans.Student;

public class TestCase {
         
	  public static void main(String[] args) {
		  Student stu=new Student();
		  stu.setStu_name("dgw");
		  stu.setStu_age("25");
		  stu.setStu_tel(123456789);
		  stu.setStu_adree("四川德阳");
		  stu.setStu_bak("努力向上！");
		  JdbcUtil.insert(stu);
		  System.out.println("执行成功！");
	}
	

}
