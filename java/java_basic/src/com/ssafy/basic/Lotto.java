package com.ssafy.basic;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 싸피 로또 =====");
		System.out.print("게임수 입력 : ");
		int cnt = sc.nextInt();
		sc.close();
		int now = 1;
		System.out.println("===== 금주 행운의 로또번호 =====");
//Solution1
//		while (now<=cnt) {
//			int num_cnt=0;
//			int[] game_arr=new int[7];
//			boolean pass = false;
//			System.out.print((now++)+". ");
//			while (num_cnt<game_arr.length) {
//				pass = false;
//				while(!pass) {
//					int num = (int) (Math.random() * 45) + 1;
//					for (int i : game_arr) {
//						if(num == i && num_cnt != 0) {
//							break;
//						} else {
//							System.out.print(num + " ");
//							pass = true;
//							game_arr[num_cnt++] = num;
//							break;
//						}
//					}
//				}
//			}
//			System.out.println("");
//		}
		
//Solution2
		while (now<=cnt) {
			int num_cnt=0;
			boolean[] dup=new boolean[45];
			boolean pass = false;
			System.out.print((now++)+". ");
			while (num_cnt++<7) {
				pass = false;
				while(!pass) {
					int num = (int) (Math.random() * 45) + 1;
					pass = dup[num-1]? false:true;
					if(pass) {
						System.out.print(num + " ");
						dup[num-1] = true;
					}
				}
			}
			System.out.println("");
		}
		
	}
	
}
