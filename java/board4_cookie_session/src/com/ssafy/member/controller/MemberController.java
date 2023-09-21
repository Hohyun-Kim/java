package com.ssafy.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
	
	public void init() {
		memberService = MemberServiceImpl.getMemberService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		if("mvjoin".equals(action)) {
			path = "/user/join.jsp";
			redirect(request, response, path);
		} else if("idcheck".equals(action)) {
			String ckid = request.getParameter("checkid");
			System.out.println(ckid);
			int cnt;
			try {
				cnt = memberService.idCheck(ckid);
				System.out.println("cnt == " + cnt);
			} catch (Exception e) {
				e.printStackTrace();
				cnt = 1;
			}
			response.setContentType("application/json;charset=utf-8");
			String json = "{\"id\": \"" + ckid + "\",\"cnt\": \"" + cnt + "\"}";
			response.getWriter().print(json);
		} else if("join".equals(action)) {
			path = join(request, response);
			redirect(request, response, path);
		} else if("mvlogin".equals(action)) {
			path = "/user/login.jsp";
			redirect(request, response, path);
		} else if("login".equals(action)) {
			path = login(request, response);
			redirect(request, response, path);
		} else if("logout".equals(action)) {
			path = logout(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	private String join(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 이름, 아이디, 비밀번호, 이메일등 회원정보를 받아 MemberDto로 setting
		MemberDto memberDto = new MemberDto();
		memberDto.setUserName(request.getParameter("username"));
		memberDto.setUserId(request.getParameter("userid"));
		memberDto.setUserPwd(request.getParameter("userpwd"));
		memberDto.setEmailId(request.getParameter("emailid"));
		memberDto.setEmailDomain(request.getParameter("emaildomain"));
		// TODO : 위의 데이터를 이용하여 service의 joinMember() 호출
		int cnt = 0;
		try {
			cnt = memberService.joinMember(memberDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cnt = 0;
			return "";
		}
		// TODO : 정상 등록 후 로그인 페이지로 이동.
		if(cnt == 1) {
			return "/user/login.jsp";
		} else {
			request.setAttribute("msg", "회원가입에 실패했습니다.");
			return "";
		}
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		try {
			MemberDto memberDto = memberService.loginMember(userId, userPwd);
			if(memberDto != null) {
//				session 설정
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
				
//				cookie 설정
				String idsave = request.getParameter("saveid");
				if("ok".equals(idsave)) { //아이디 저장을 체크 했다면.
					Cookie cookie = new Cookie("ssafy_id", userId);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40); //40년간 저장.
					response.addCookie(cookie);
				} else { //아이디 저장을 해제 했다면.
					Cookie cookies[] = request.getCookies();
					if(cookies != null) {
						for(Cookie cookie : cookies) {
							if("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
				return "/index.jsp";
			} else {
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
				return "/user/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.removeAttribute("userinfo");
		session.invalidate();
		return "";
	}

}
