package com.ssafy.inheritance;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		
		if(s1 == s2)
			System.out.println("s1 s2 는 주소값이 같다");
		if(s1 == s3)
			System.out.println("s1 s3 는 주소값이 같다");
		if(s1 == s4)
			System.out.println("s1 s4 는 주소값이 같다");
		if(s2 == s3)
			System.out.println("s2 s3 는 주소값이 같다");
		if(s2 == s4)
			System.out.println("s2 s4 는 주소값이 같다");
		if(s3 == s4)
			System.out.println("s3 s4 는 주소값이 같다");
	}
	
}
