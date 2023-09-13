package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	
	public DeleteTest() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		String id = "Hohyun";
		int cnt = dt.delete(id);
		if(cnt != 0)
			System.out.println("회원 삭제 성공!!!");
		else
			System.out.println("회원 삭제 실패!!!");
	}
	
	private int delete(String id) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");
			StringBuilder sql = new StringBuilder("delete \n from ssafy_member\n");
			sql.append("where userid = '" + id +"'");
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
