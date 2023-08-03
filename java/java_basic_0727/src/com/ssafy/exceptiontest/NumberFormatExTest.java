package com.ssafy.exceptiontest;

public class NumberFormatExTest {

	public static void main(String[] args) {
		String ageStr = "20";
		if(isNumber(ageStr)) {
			int age = Integer.parseInt(ageStr);
			System.out.println("10년 후 나이 : " + (age + 10));
		} else {
			System.out.println("나이는 숫자만!!!!");
		}
		
		
	}

	private static boolean isNumber(String ageStr) { // 12a3
		boolean flag = true;
		for(int i=0;i<ageStr.length();i++) {
			int n = ageStr.charAt(i) - 48;
			if(n < 0 || n > 9) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
}
