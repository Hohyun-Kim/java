package com.ssafy.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.mybatis.MemberDto;
import com.ssafy.mybatis.config.SqlMapConfig;

public class MemberDaoImpl implements MemberDao {
	
	private final String NAMESPACE = "com.ssafy.mybatis.dao.MemberDao.";

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert(NAMESPACE + "joinMember",	memberDto);
			sqlSession.commit();
		}
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList(NAMESPACE + "listMember");
		}
	}

	@Override
	public MemberDto getMember(String userId) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "getMember", userId);
		}
	}

	@Override
	public void deleteMember(String userId) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.delete(NAMESPACE + "deleteMember",	userId);
			sqlSession.commit();
		}
	}

}
