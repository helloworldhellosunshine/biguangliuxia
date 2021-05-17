package com.bishe.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static void main(String[] args) {

	}
	//连接数据库的四要素
	String driver = "com.mysql.jdbc.Driver";//连接数据的驱动
	String url = "jdbc:mysql://localhost:3306/bishe?useUnicode=true&characterEncoding=utf-8";
	String user = "root";
	String password = "2020";
	public Connection conn;
	
	public DBConnection() {

		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);//

			// if(!conn.isClosed())
			// System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
