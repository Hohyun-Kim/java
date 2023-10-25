package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	
//	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC";
//	private static final String DB_ID = "ssafy";
//	private static final String DB_PWD = "ssafy";
//	
	private static DBUtil instance = new DBUtil();
//
//	private DBUtil() {
//		try {
//			Class.forName(DRIVER);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public static DBUtil getInstance() {
		return instance;
	}
	

	public Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(URL, DB_ID, DB_PWD);
		DataSource dataSource = null;
		try {
			Context ctx = new InitialContext();
//			Context rootCtx = (Context) ctx.lookup("java:comp/env");
//			dataSource = (DataSource) rootCtx.lookup("jdbc/ssafy");
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/ssafy");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return dataSource.getConnection();
	}
	
//	public static void close(PreparedStatement pstmt, Connection conn) {
//		try {
//			if(pstmt != null)
//				pstmt.close();
//			if(conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
//		try {
//			if(rs != null)
//				rs.close();
//			if(pstmt != null)
//				pstmt.close();
//			if(conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void close(AutoCloseable... autoCloseables) {
		for(AutoCloseable ac : autoCloseables) {
			if(ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
