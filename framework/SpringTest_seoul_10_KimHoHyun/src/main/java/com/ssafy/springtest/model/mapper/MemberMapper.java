package com.ssafy.springtest.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	MemberDto login(MemberDto memberdto) throws Exception;
}
