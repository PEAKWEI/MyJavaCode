package Test;

import org.dgw.conjdbc.JdbcUtil;

import stubeans.Student;

public class TestCase {
         
	  public static void main(String[] args) {
		  Student stu=new Student();
		  stu.setStu_name("dgw");
		  stu.setStu_age("25");
		  stu.setStu_tel(123456789);
		  stu.setStu_adree("�Ĵ�����");
		  stu.setStu_bak("Ŭ�����ϣ�");
		  JdbcUtil.insert(stu);
		  System.out.println("ִ�гɹ���");
	}
	

}
