package com.ssafy.basic;

public class SwitchTest {
	public static void main(String[] args) {
		int score = 86;
		String grade = "F";
//		X5점이상은 X+학점
//Solution1
		switch(score / 10) {
		case 10: case 9: grade = "A";break;
		case 8: grade = "B";break;
		case 7: grade = "C";break;
		default: grade = "F";
		}
		if (grade != "F" && score%10 >= 5 || score == 100) {
			grade += "+";
		}
		System.out.println("Grade : " + grade);
		
		char s = 'a';
		switch(s) {
		case 65: System.out.println("a입니다.");break;
		default: System.out.println("a아닙니다.");break;
		}
	}
}
