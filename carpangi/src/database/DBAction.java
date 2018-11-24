package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

//21 team1
public class DBAction {
	
	private static DBAction db = new DBAction();
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://192.168.0.21:3306/team1";
//	private static final String USER = "team1";
//	private static final String PW = "team1";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/japangi_system";
	private static final String USER = "root";
	private static final String PW = "root";

	private static Connection conn;

	// DB 기본 설정
	private DBAction() {
		try {
			System.out.println("Driver find before");
			Class.forName(DRIVER);
			System.out.println("Drvier connect success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBAction getInstance() {
		if(db == null) db = new DBAction();
		return db;
		
	}
	
	public static Connection getConnect() {
		conn = null;
		try {
			System.out.println("Database connection before");
			conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println("Database connection success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Error");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void destory(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void destory(Statement stmt, Connection conn) {
		try {
			if(stmt != null) stmt.close();
			if(conn != null) stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
