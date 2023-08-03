package com.ssafy.exceptiontest;

public class NullPointerExTest {

	public static void main(String[] args) {
		String s = getString(1);
		if(s != null)
			System.out.println("문자열 길이 : " + s.length());
	}

	private static String getString(int i) {
		if(i % 2 == 0)
			return "짝수입니다.";
		return null;
	}
	
}
