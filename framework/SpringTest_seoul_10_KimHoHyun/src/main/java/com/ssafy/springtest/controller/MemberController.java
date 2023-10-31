package com.ssafy.springtest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.springtest.model.mapper.AttendanceDto;
import com.ssafy.springtest.model.mapper.MemberDto;
import com.ssafy.springtest.service.AttendanceService;
import com.ssafy.springtest.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
//	private final AttendanceService attendanceService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
//		this.attendanceService = attendanceService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	@GetMapping("/list")
	public String list() {
		return "list";
	}
	
	@PostMapping("/login")
	public String login(MemberDto memberDto, HttpSession session, HttpServletRequest request, HttpServletResponse response, boolean saveId) throws Exception {

		MemberDto result = memberService.login(memberDto);
		System.out.println(result);
		if (result != null) {
			session.setAttribute("info", result);
			return "redirect:/regist";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		// 세션 삭제
		session.removeAttribute("info");
		return "redirect:/";
	}
	
//	@PostMapping("/regist")
//	public String regist(AttendanceDto attendanceDto) {
//		System.out.println("dto : " + attendanceDto);
//		try {
//			attendanceService.regist(memberDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "redirect:/list";
//	}
}
