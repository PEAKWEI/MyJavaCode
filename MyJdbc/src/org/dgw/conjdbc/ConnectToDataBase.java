package org.dgw.conjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDataBase {

	public static Connection getDataBaseConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "123456";
		// 加载驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 连接数据库
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed()) {
				System.out.println("连接成功!");
			}
		} catch (SQLException e) {
			System.out.println("连接失败!");
			e.printStackTrace();
		}
	

		return con;

	}

}
