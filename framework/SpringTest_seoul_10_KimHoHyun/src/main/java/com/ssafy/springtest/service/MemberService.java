package com.ssafy.springtest.service;

import java.util.List;

import com.ssafy.springtest.model.mapper.MemberDto;

public interface MemberService {
	
	MemberDto login(MemberDto memberdto) throws Exception;
}
