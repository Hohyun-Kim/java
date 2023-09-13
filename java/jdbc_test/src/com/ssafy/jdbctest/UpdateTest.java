package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	
	public UpdateTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success !!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UpdateTest it = new UpdateTest();
		String id = "Hohyun";
		String pwd = "12345678";
		int cnt = it.modify(id, pwd);
		if(cnt != 0)
			System.out.println("회원 정보 수정 성공!!!");
		else
			System.out.println("회원 정보 수정 실패!!!");
	}

	private int modify(String id, String pwd) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");
			System.out.println("DB 연결 성공!!!!");
			StringBuilder sql = new StringBuilder("update ssafy_member \n");
			sql.append("set userpwd = '" + pwd + "'\n");
			sql.append("where userid = '" + id + "'\n");
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}
