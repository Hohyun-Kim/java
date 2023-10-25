package com.ssafy.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mybatis.MemberDto;

public interface MemberDao {

	void joinMember(MemberDto memberDto) throws SQLException;
	List<MemberDto> listMember() throws SQLException;
	MemberDto getMember(String userId) throws SQLException;
	void deleteMember(String userId) throws SQLException;
	
}
