package com.ssafy.exceptiontest;

public class LoginTest {

	public static void main(String[] args) {
		String id = "ssafy";
		String pwd = "12324";
		
		LoginTest lt = new LoginTest();
		try {
			String name = lt.login(id, pwd);
			System.out.println(name + "님 안녕하세요");
		} catch (IdNotMatchException | PasswordNotMatchException e) {
			System.out.println(e.getMessage());
			System.out.println("아이디 또는 비밀번호 확인 후 다시 로그인하세요!!!");
		}
	}

	private String login(String id, String pwd) throws IdNotMatchException, PasswordNotMatchException {
		if(id.equals("ssafy")) {
			if(pwd.equals("1234")) {
				return "안효인";
			} else {
				throw new PasswordNotMatchException("비번 입력 오류!!!");
			}
		} else {
			throw new IdNotMatchException("아이디 잘못 입력!!!");
		}
	}
	
}
