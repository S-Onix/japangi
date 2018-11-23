package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuDAO {
	DBAction db;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;

	public MenuDAO() {
		db = DBAction.getInstance();
		conn = null;
		stmt = null;
		rs = null;
		rsmd = null;
	}

	/*
	 * TODO : SQL Äõ¸®¹® Ãß°¡
	 */
	public ArrayList<String> selectAllMenu() {
		String sql = "SELECT * FROM MENU";
		ArrayList<String> dataSet = new ArrayList<>();

		stmt = null;
		rs = null;

		try {
			if (conn == null) {
				conn = db.getConnect();
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			int columCount = rsmd.getColumnCount();
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				for (int i = 1; i <= columCount; i++) {
					if (i == columCount) {
						sb.append(rs.getString(i));
					}else if (i == 1 || i == 4 || i == 5) {
						sb.append(rs.getInt(i) + "|");
					} else {
						sb.append(rs.getString(i) + "|");
					}
				}
				String result = sb.toString();
				sb.delete(0, sb.length());
				dataSet.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Query error check please");
			e.printStackTrace();
		} finally {
			db.destory(rs, stmt, conn);
		}

		return dataSet;
	}

	/*
	 * TODO : SQL Äõ¸®¹® Ãß°¡
	 */
	public void insertMenu(int foodNum, String menuName, String menuType, int price, int foodCount, String recipe) {
		String sql = "INSERT INTO MENU VALUES("
					+ foodNum + ",'"
					+ menuName + "','"
					+ menuType + "',"
					+ price+ ","
					+ foodCount + ",'"
					+ recipe + "');"
				;
		stmt = null;

		try {
			if (conn == null) {
				conn = db.getConnect();
			}
			conn = db.getConnect();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > 0 ? "successful" : "fail";
			System.out.println(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.destory(stmt, conn);
		}

	}

	
	public void deleteMenu(String foodNum) {
		String sql = "DELETE FROM MENU WHERE COLUM = " + "'" + foodNum + "';";

		stmt = null;
		try {
			if (conn == null) {
				conn = db.getConnect();
			}
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > 0 ? "successful" : "fail";
			System.out.println(msg);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.destory(stmt, conn);
		}
	}
	
	
	public void updateMenu(int updateCount, int foodNum) {
		String sql = "UPDATE MENU SET foo_cnt = " 
					+ updateCount + " WHERE foo_no = " + foodNum;
		
		stmt = null;
		try {
			if (conn == null) {
				conn = db.getConnect();
			}
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > 0 ? "successful" : "fail";
			System.out.println(msg);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.destory(stmt, conn);
		}
					 
	}

}
