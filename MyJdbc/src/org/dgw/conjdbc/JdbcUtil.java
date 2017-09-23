package org.dgw.conjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import stubeans.Student;
/**
 * 
 * @author Administrator
 *  "update students set Age='" + student.getAge() + "' where Name='" + student.getName() + "'";
 */
public class JdbcUtil {
	private static  Connection con;
	private  static PreparedStatement pStatement;
	static int i=0;
	//updata 方法不够完善
	public static int updata(Student student) {
		con=ConnectToDataBase.getDataBaseConnection();
		try {
			pStatement=con.prepareStatement("update student set stu_name='"+student.getStu_name()+"'where stu_name='"+student.getStu_name()+"'");
			i=pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pStatement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return i;
	}
	public static int  select(Student student) {
		con=ConnectToDataBase.getDataBaseConnection();
		try {
			pStatement=con.prepareStatement("SELECT ? FROM student");
			pStatement.setString(1, student.getStu_name());
			i=pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询失败");
			e.printStackTrace();
		}finally {
			try {
				pStatement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
		
	}
	public static int insert(Student student) {
	       con=ConnectToDataBase.getDataBaseConnection();
	       pStatement = null;
	      int i = 0;
	      try {
			pStatement=con.prepareStatement("insert into student"
					+ "(stu_name,stu_age,stu_tel,stu_adree,stu_bak) "
					+ "VALUES(?,?,?,?,?)");
			pStatement.setString(1, student.getStu_name());
			pStatement.setString(2, student.getStu_age());
			pStatement.setLong(3, student.getStu_tel());
			pStatement.setString(4, student.getStu_adree());
			pStatement.setString(5, student.getStu_bak());
			i=pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入失败！");
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	      
	      
		return i;
	}

}
