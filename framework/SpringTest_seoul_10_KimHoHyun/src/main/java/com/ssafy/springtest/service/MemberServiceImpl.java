package com.ssafy.springtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.springtest.model.mapper.MemberDto;
import com.ssafy.springtest.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public MemberDto login(MemberDto memberdto) throws Exception {
		System.out.println(memberdto);
		return memberMapper.login(memberdto);
	}
}
