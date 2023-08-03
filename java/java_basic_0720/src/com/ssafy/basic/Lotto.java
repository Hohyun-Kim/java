package com.ssafy.basic;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 싸피 로또 =====");
		System.out.print("게임수 입력 : ");
		int cnt = sc.nextInt();
//		System.out.println("게임수 : " + cnt);
		for(int i=0;i<cnt;i++) {
			int num1 = (int) (Math.random() * 3) + 1;
			int num2 = 0;
			int num3 = 0;
			do {
				num2 = (int) (Math.random() * 3) + 1;
			} while(num1 == num2);
			do {
				num3 = (int) (Math.random() * 3) + 1;
			} while(num1 == num3 || num2 == num3);
			System.out.println(num1+ "\t" + num2 + "\t" + num3);
		}
	}
	
	
}
