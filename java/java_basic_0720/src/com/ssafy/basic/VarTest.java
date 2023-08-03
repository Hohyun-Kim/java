package com.ssafy.basic;

public class VarTest {

	/**
	 * 
	 * @param args 머머머머머
	 */
	public static void main(String[] args) {
		int x = 10;
//									출	실
		System.out.println(++x);//	11	11
		System.out.println(x--);//	11 	10
		System.out.println(x++);//	10	11
		System.out.println(++x);//	12	12
		System.out.println(--x);//	11	11
		System.out.println(x++);//	11	12
		System.out.println(++x);//	13	13
		System.out.println(x);// 13
		
		String a = "";
		if(a instanceof String)
			System.out.println("a는 문자열 타입니다.");
		
		
		if(x % 2 == 0)
			System.out.println(x + "는 짝수");
		else
			System.out.println(x + "는 홀수");
		
		
//		x % 2 == 0 ? System.out.println(x + "는 짝수") : System.out.println(x + "는 홀수");
		String str = x % 2 == 0 ? "짝수" : "홀수";
		System.out.println(x + "는 " + str);
		
	}

}
