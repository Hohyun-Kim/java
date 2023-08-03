package com.ssafy.classtest;

public class Car {
	
	String carName;
	String carColor;
	String maker;
	int speed;
	
	public Car() {
//		carName = "쏘나타";
//		carColor = "검정";
//		maker = "현대";
		this("쏘나타", "검정", "현대");
	}
	
	public Car(String carName) {
//		this.carName = carName;
//		carColor = "검정";
//		maker = "현대";
		this(carName, "검정", "현대");
	}
	
	public Car(String carName, String carColor) {
//		this.carName = carName;
//		this.carColor = carColor;
//		maker = "현대";
		this(carName, carColor, "현대");
	}
	
	public Car(String carName, String carColor, String maker) {
		this.carName = carName;
		this.carColor = carColor;
		this.maker = maker;
	}
	
	void speedUp() {
		this.speed += 10;
	}
	
	void speedDown() {
		speed -= 10;
		if(speed < 0) stop();
	}
	
	void stop() {
		this.speed = 0;
	}
	
	String info() {
		return maker + "에서 만든 " + carColor + "색 " + carName;
	}

}
