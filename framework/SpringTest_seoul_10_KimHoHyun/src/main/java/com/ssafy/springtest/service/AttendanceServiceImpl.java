package com.ssafy.springtest.service;

import com.ssafy.springtest.model.mapper.AttendanceDto;
import com.ssafy.springtest.model.mapper.AttendanceMapper;

public class AttendanceServiceImpl implements AttendanceService{
	@Override
	public void regist(AttendanceDto attendanceDto) throws Exception {
		AttendanceMapper.regist(attendanceDto);
	}
}
