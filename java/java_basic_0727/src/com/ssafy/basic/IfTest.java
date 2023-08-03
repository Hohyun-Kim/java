package com.ssafy.basic;

//90	A
//80	B
//70	C
//70	F
//단 X5는 +
public class IfTest {

	public static void main(String[] args) {
//		int score = 98;
//		char grade = 'F';
		String grade = "F";
//		90점은 XX학점
//		if (score >= 95) {
//			System.out.println(score + "는 A+학점");
//		} else if (score >= 90) {
//			System.out.println(score + "는 A학점");
//		} else if (score >= 85) {
//			System.out.println(score + "는 B+학점");
//		} else if (score >= 80) {
//			System.out.println(score + "는 B학점");
//		} else if (score >= 75) {
//			System.out.println(score + "는 C+학점");
//		} else if (score >= 70) {
//			System.out.println(score + "는 C학점");
//		} else {
//			System.out.println(score + "는 F학점");
//		}

//		if (score >= 95) {
//			grade = "A+";
//		} else if (score >= 90) {
//			grade = "A";
//		} else if (score >= 85) {
//			grade = "B+";
//		} else if (score >= 80) {
//			grade = "B";
//		} else if (score >= 75) {
//			grade = "C+";
//		} else if (score >= 70) {
//			grade = "C";
//		} else {
//			grade = "F";
//		}

		int score = 68;
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else {
			grade = "F";
		}
		if(score > 70 && score % 10 >= 5 || score == 100)
			grade += "+";
		System.out.println(score + "는 " + grade + "학점");
	}

}
