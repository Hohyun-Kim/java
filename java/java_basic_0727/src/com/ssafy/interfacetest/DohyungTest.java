package com.ssafy.interfacetest;

public class DohyungTest {

	public static void main(String[] args) {
//		가로가 5이고 세로가 3인 사각형의 넓이는 15이고 둘레는 16입니다.
		Rect r1 = new Rect();
		System.out.println("가로가 " + r1.getWidth() + "이고 세로가 " + r1.getHeight() + 
				"인 사각형의 넓이는 " + r1.calcArea() + "이고 둘레는 " + r1.calcRound() + "입니다.");
		
//		가로가 6이고 세로가 4인 사각형의 넓이는 24이고 둘레는 20입니다.
		Rect r2 = new Rect(6, 4);
//		r2.setWidth(6);
		System.out.println("가로가 " + r2.getWidth() + "이고 세로가 " + r2.getHeight() + 
				"인 사각형의 넓이는 " + r2.calcArea() + "이고 둘레는 " + r2.calcRound() + "입니다.");
		
		
//		반지름이 3인 원의 넓이는 27.xxx입니다.
		Circle c1 = new Circle();
		System.out.println("반지름이 " + c1.getRadius() + "인 원의 넓이는 " + c1.calcArea() + "입니다.");
		
		
//		반지름이 4인 원의 넓이는 48.xxx입니다.
		Circle c2 = new Circle(4);
		System.out.println("반지름이 " + c2.getRadius() + "인 원의 넓이는 " + c2.calcArea() + "입니다.");
		
		
	}
	
}
