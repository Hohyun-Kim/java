package com.ssafy.inheritance;

public class CarDto {
	private String carName;
	private String carColor;
	private String maker;
	private int speed;
	
	public CarDto(String carName, String carColor, String maker) {
		super();
		this.carName = carName;
		this.carColor = carColor;
		this.maker = maker;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
