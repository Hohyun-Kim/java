package com.ssafy.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.hello.service.HelloService;

@Controller
public class HelloController {
	
	@Value("${file.uploadpath}")
	private String fileUpPath;
	
	@Value("${my.name}")
	private String name;
	
	private HelloService helloService;
	
	public HelloController(HelloService helloService) {
		super();
		this.helloService = helloService;
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "안녕 " + name + "!!");
		model.addAttribute("greet", helloService.greeting());
		System.out.println("파일 업로드 경로 : " + fileUpPath);
		return "hello";
	}
}
