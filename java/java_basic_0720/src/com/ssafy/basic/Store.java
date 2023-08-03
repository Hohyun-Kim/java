package com.ssafy.basic;

public class Store {

	public static void main(String[] args) {
		Guest g1 = new Guest("이성목");
		Guest g2 = new Guest("정승환");
		System.out.println("방문자수 : " + g1.cnt);
		System.out.println(g1.name + "님 방문");
		g1.visit();
		System.out.println("방문자수 : " + g2.cnt);
//		System.out.println(g1.name + "님 방문");
//		g1.visit();
//		System.out.println("방문자수 : " + g1.cnt);
//		System.out.println(g2.name + "님 방문");
//		g2.visit();
//		System.out.println("방문자수 : " + g2.cnt);
		
		System.out.println("손님 방문");
		Guest.visit();
		System.out.println("방문자수 : " + Guest.cnt);
		System.out.println("손님 방문");
		Guest.visit();
		System.out.println("방문자수 : " + Guest.cnt);
		System.out.println("손님 방문");
		Guest.visit();
		System.out.println("방문자수 : " + Guest.cnt);
		System.out.println("손님 방문");
		Guest.visit();
		System.out.println("방문자수 : " + Guest.cnt);
		System.out.println("손님 방문");
		Guest.visit();
		System.out.println("방문자수 : " + Guest.cnt);
	}
}
