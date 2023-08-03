package com.ssafy.classtest;

public class CarTest {
	
	public static void main(String[] args) {
		Car car1 = null;
		car1 = new Car();
		System.out.println("0. "+ car1.maker + "에서 만든 " + car1.carColor + "색 " + car1.carName);
		car1.carName = "쏘나타";
		car1.carColor = "검정";
		car1.maker = "현대";
		
//		System.out.println("1. "+ car1.maker + "에서 만든 " + car1.carColor + "색 " + car1.carName);
		System.out.println("1. "+ car1.info());
		
		Car car2 = new Car();
//		System.out.println("2. "+ car2.maker + "에서 만든 " + car2.carColor + "색 " + car2.carName);
		System.out.println("2. "+ car2.info());
		
		Car car3 = new Car("그랜저");
//		System.out.println("3. "+ car3.maker + "에서 만든 " + car3.carColor + "색 " + car3.carName);
		System.out.println("3. "+ car3.info());
		
		Car car4 = new Car("그랜저", "흰");
//		System.out.println("4. "+ car4.maker + "에서 만든 " + car4.carColor + "색 " + car4.carName);
		System.out.println("4. "+ car4.info());
		
		Car car5 = new Car("EQ5", "진주", "벤츠");
//		System.out.println("5. "+ car5.maker + "에서 만든 " + car5.carColor + "색 " + car5.carName);
		System.out.println("5. "+ car5.info());
		
		System.out.println("car5의 속도 : "+ car5.speed);
		System.out.println("car5의 액셀을 3회 밟음!!!");
//		car5.speedUp();
//		car5.speedUp();
//		car5.speedUp();
		for (int i = 0; i < 3; i++) {
			car5.speedUp();
		}
		System.out.println("car5의 속도 : "+ car5.speed);
		
		System.out.println("car5의 액셀을 10회 밟음!!!");
		for (int i = 0; i < 10; i++) {
			car5.speedDown();
		}
		System.out.println("car5의 속도 : "+ car5.speed);
	}
}
