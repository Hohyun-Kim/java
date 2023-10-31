package com.ssafy.hello.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDaoImpl implements HelloDao {

	@Override
	public String greeting() {
		return "안녕 난 DAO야!!!";
	}

}
