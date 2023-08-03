package com.ssafy.basic;

public class IfTest {
	public static void main(String[] args) {
		int score = 86;
		String grade = "F";
//		X5점이상은 X+학점
// Solution1
		if (score >= 90) {
			grade = "A";
			if (score - 90 >= 5) {
				grade += '+';
			}
		} else if (score >= 80) {
			grade = "B";
			if (score - 80 >= 5) {
				grade += '+';
			}
		} else if (score >= 70) {
			grade = "C";
			if (score - 70 >= 5) {
				grade += '+';
			}
		} else {
			grade = "F";
		}
		
// Solution2
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else {
			grade = "F";
		}
		if (grade != "F" && score%10 >= 5 || score == 100) {
			grade += "+";
		}

		System.out.println("Grade : " + grade);
	}

}
