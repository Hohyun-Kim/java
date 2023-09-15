package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao = new MemberDaoImpl();
	
	private MemberDaoImpl() {
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public void registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("insert into members (user_id, user_password, user_name) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserPass());
			pstmt.setString(3, memberDto.getUserName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		MemberDto memberDto = new MemberDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from members\n");
			sql.append("where user_id = ? ");
			sql.append("and user_password = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto.setUserName(rs.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return memberDto;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("update members \n");
			sql.append("set user_password = ?\n");
			sql.append(", user_name = ?\n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserPass());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}

	@Override
	public void deleteMember(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("delete \n");
			sql.append("from members\n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}

}
