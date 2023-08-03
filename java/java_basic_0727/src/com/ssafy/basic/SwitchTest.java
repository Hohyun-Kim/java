package com.ssafy.basic;

public class SwitchTest {

	public static void main(String[] args) {
		int score = 68;
		String grade = "F";
		switch(score / 10) {
		case 10: case 9: grade = "A";break;
		case 8: grade = "B";break;
		case 7: grade = "C";break;
		default: grade = "F";
		}
		if(score > 70 && score % 10 >= 5 || score == 100)
			grade += "+";
		System.out.println(score + "는 " + grade + "학점");
		
		String s = "ad";
		switch(s) {
		case "a": System.out.println("a입니다.");break;
		default: System.out.println("a아닙니다.");
		}
	}
	
}
