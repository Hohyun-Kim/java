package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success !!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		System.out.println("전체회원목록!!!!");
		st.memberList();
		String id = "hohyun";
		MemberDto memberDto = st.searchById(id);
		if(memberDto != null) {
			
		} else {
			System.out.println(id + "님은 없음!!!");
		}
		System.out.println(memberDto);
	}
	
	private MemberDto searchById(String id) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from ssafy_member \n");
			sql.append("where userid = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(rs.getString("userid"));
				memberDto.setUserName(rs.getString("username"));
				memberDto.setUserPwd(rs.getString("userpwd"));
				memberDto.setEmailId(rs.getString("emailid"));
				memberDto.setEmailDomain(rs.getString("emaildomain"));
				memberDto.setJoinDate(rs.getString("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDto;
	}

	public Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");
		return conn;
	}
	
	private void memberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from ssafy_member \n");
			sql.append("order by joindate");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			System.out.println("아이디\t이름\t비밀번호\t이메일아이디\t이메일도메인\t가입일");
			System.out.println("---------------------------------------------------");
			while(rs.next()) {
				String id = rs.getString("userid");
				String name = rs.getString("username");
				String pwd = rs.getString("userpwd");
				String emailid = rs.getString("emailid");
				String emaildomain = rs.getString("emaildomain");
				String joindate = rs.getString("joindate");
				System.out.println((id + "\t" + name + "\t" + pwd + "\t" + emailid + "\t" + emaildomain + "\t" + joindate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

