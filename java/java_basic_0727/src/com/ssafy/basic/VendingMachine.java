package com.ssafy.basic;

public class VendingMachine {

	public static void main(String[] args) {
		int money = 10000;
		int price = 2370;
		int change = money - price;
		
		System.out.println("투입금액 : " + money);
		System.out.println("물건가격 : " + price);
		System.out.println("거스름돈 : " + change);
		System.out.println("-----------------------");
		System.out.println("5000원 : " + change / 5000);
		System.out.println("1000원 : " + change % 5000 / 1000);
		System.out.println("500원 : " + change % 1000 / 500);
		System.out.println("100원 : " + change % 500 / 100);
		System.out.println("50원 : " + change % 100 / 50);
		System.out.println("10원 : " + change % 50 / 10);
	}
	
}
