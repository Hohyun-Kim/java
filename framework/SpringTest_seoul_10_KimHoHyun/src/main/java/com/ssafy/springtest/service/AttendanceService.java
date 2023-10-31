package com.ssafy.springtest.service;

import com.ssafy.springtest.model.mapper.AttendanceDto;

public interface AttendanceService {
	void regist(AttendanceDto attendanceDto) throws Exception;
}
