package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	
	public InsertTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success !!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		String id = "Hohyun";
		String name = "호현";
		String pwd = "9988";
		int cnt = it.register(id, name, pwd);
		if(cnt != 0)
			System.out.println("회원 가입 성공!!!");
		else
			System.out.println("회원 가입 실패!!!");
	}

	private int register(String id, String name, String pwd) {
		int cnt = 0;
		Connection conn = null;
//		normal statement
//		Statement stmt = null;
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");
//			System.out.println("DB 연결 성공!!!!");
//			StringBuilder sql = new StringBuilder("insert into ssafy_member (userid, username, userpwd) \n");
//			sql.append("values ('" + id + "', '" + name + "', '" + pwd + "')");
//			stmt = conn.createStatement();
//			cnt = stmt.executeUpdate(sql.toString());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(stmt != null)
//					stmt.close();
//				if(conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
//		prepared statement
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");
			System.out.println("DB 연결 성공!!!!");
			StringBuilder sql = new StringBuilder("insert into ssafy_member (userid, username, userpwd) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
//	autoclose
//	private int register(String id, String name, String pwd) {
//		int cnt = 0;
//		try (
//				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");
//				Statement stmt = conn.createStatement();){
//			System.out.println("DB 연결 성공!!!!");
//			StringBuilder sql = new StringBuilder("insert into ssafy_member (userid, username, userpwd) \n");
//			sql.append("values ('" + id + "', '" + name + "', '" + pwd + "')");
//			stmt = conn.createStatement();
//			cnt = stmt.executeUpdate(sql.toString());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return cnt;
//	}
}
