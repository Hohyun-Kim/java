package com.ssafy.hello.service;

import org.springframework.stereotype.Service;

import com.ssafy.hello.dao.HelloDao;

@Service
public class HelloServiceImpl implements HelloService {
	
	private HelloDao helloDao;
	
	public HelloServiceImpl(HelloDao helloDao) {
		super();
		this.helloDao = helloDao;
	}

	@Override
	public String greeting() {
		return helloDao.greeting();
	}

}
