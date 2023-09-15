package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberServiceImpl;

public class MemberMain {
	
	private BufferedReader in;

	public MemberMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 회원 메뉴 ----------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerMember();
					break;
				case 2:
					login();
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					deleteMember();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void registerMember() throws IOException {
		MemberDto memberDto = new MemberDto();
		System.out.println("=== 회원 가입 ===");
		System.out.print("아이디 : ");
		memberDto.setUserId(in.readLine());
		System.out.print("비밀번호 : ");
		memberDto.setUserPass(in.readLine());
		System.out.print("이름 : ");
		memberDto.setUserName(in.readLine());
		MemberServiceImpl.getMemberService().registerMember(memberDto);
	}

	private void login() throws IOException {
		System.out.println("********** 로그인 **********");
		System.out.print("아이디 : ");
		String userId = in.readLine();
		System.out.print("비밀번호 : ");
		String userPass = in.readLine();
		MemberDto memberDto = MemberServiceImpl.getMemberService().login(userId, userPass);
		if(memberDto.getUserName() != null) {
			System.out.println("********** 로그인 성공!! **********");
			System.out.println(memberDto.getUserName() + "님 안녕하세요!");
		} else {
			System.out.println("********** 로그인 실패!! **********");
		}
	}

	private void modifyMember() throws IOException {
		MemberDto memberDto = new MemberDto();
		System.out.println("********** 회원 정보 수정 **********");
		System.out.print("아이디 : ");
		memberDto.setUserId(in.readLine());
		System.out.print("비밀번호 : ");
		memberDto.setUserPass(in.readLine());
		System.out.print("이름 : ");
		memberDto.setUserName(in.readLine());
		MemberServiceImpl.getMemberService().modifyMember(memberDto);
	}

	private void deleteMember() throws IOException {
		System.out.println("********** 회원 탈퇴 **********");
		System.out.print("아이디 : ");
		String userId = in.readLine();
		MemberServiceImpl.getMemberService().deleteMember(userId);
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
