package com.ssafy.exceptiontest;

public class IndexOutOfBoundsExTest {

	public static void main(String[] args) {
//		int[] x = {1,2,3,4,5};
//		for(int i=0;i<=x.length;i++) {
//			System.out.println(x[i]);
//		}
		
		String s = "hello ssafy";
		for(int i=0;i<=s.length();i++)
			System.out.println(s.charAt(i));
		
		System.out.println("프로그램 종료!!!");
		
	}
	
}
