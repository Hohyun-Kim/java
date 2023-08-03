package com.ssafy.classtest;

public class StarCraft {

	public static void main(String[] args) {
		Marine my = new Marine();
		Marine com = new Marine();
//		나 : 100	컴 : 100
		info(my, com);
		System.out.println("내가 컴을 2회 공격!!!");
//		2회 공격
		my.attack(com, 2);

		info(my, com);

		System.out.println("컴이 나를 5회 공격!!!");
//		5회 공격
		com.attack(my, 5);

		info(my, com);

		System.out.println("내 마린 모드 변경!!!");
		my.changeMode();
		System.out.println("내가 컴을 5회 공격!!!");
//		5회 공격
		my.attack(com, 5);

		info(my, com);

		System.out.println("내 마린 모드 변경!!!");
//		체력이 40이하일 경우 모드 변경 불가!!!		
		my.changeMode();
		System.out.println("내가 컴을 2회 공격!!!");
//		2회 공격
		my.attack(com, 2);

		info(my, com);

	}

	private static void info(Marine my, Marine com) {
		System.out.println("나 : " + my.Info() + "\t컴 : " + com.Info());
	}
}
