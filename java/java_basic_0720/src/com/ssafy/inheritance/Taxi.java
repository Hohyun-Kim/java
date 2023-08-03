package com.ssafy.inheritance;

public class Taxi extends Car {

	int initPrice;
	
	public Taxi() {
//		super();
		initPrice = 4800;
	}
	
	public Taxi(String carName, String carColor, String maker) {
		super(carName, carColor, maker);
//		this.carName = carName;
//		this.carColor = carColor;
//		this.maker = maker;
		initPrice = 4800;
	}
	
	int calcPrice(int km) {
		int price = initPrice + km * 100;
		
		return price;
	}
	
	@Override
	public int speedUp(int speed) {
		int s = super.speedUp(speed);
		if(s > 150)
			this.speed = 150;
		return this.speed;
	}
	
	@Override
	public String toString() {
		return super.toString() + "택시";
	}
	
	void b( ) {}
	
}
