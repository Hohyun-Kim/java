package com.ssafy.inheritance;

public class Car {
	
	String carName;
	String carColor;
	String maker;
	int speed;
	
	public Car() {
		this("쏘나타", "검정", "현대");
	}
	
	public Car(String carName) {
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
	
	int speedUp(int speed) {
		return this.speed += speed; 
	}
	
	void speedDown() {
		speed -= 10;
		if(speed < 0) stop();
	}
	
	int speedDown(int speed) {
		this.speed -= speed;
		if(this.speed < 0) stop();
		return this.speed;
	}
	
	void stop() {
		this.speed = 0;
	}
	
	@Override
	public String toString() {
		return maker + "에서 만든 " + carColor + "색 " + carName;
	}
	
	void a() {
		
	}

	@Override
	public boolean equals(Object obj) {
		Car other = (Car) obj;
		if(carName.equals(other.carName)) return true;
		else return false;
	}
	

}
