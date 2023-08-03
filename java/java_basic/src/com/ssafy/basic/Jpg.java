package com.ssafy.basic;

public class Jpg {
	public static void main(String[] args) {
		
		int money = 10000;
		int price = 2370;
		int change = money-price;
		
		System.out.println("투입금액 : "+money+"원");
		System.out.println("물건금액 : "+price+"원");
		System.out.println("거스름돈 : "+change+"원");
		System.out.println("----------------------");
		
		int[] change_unit = {5000, 1000, 500, 100, 50, 10, 1};
		char unit = '장';
		for (int i : change_unit) {
			unit = i % 1000 == 0? '장':'개';
			System.out.println(i+"원 : "+(change/i)+unit);
			change %= i;
		}
	}

}
