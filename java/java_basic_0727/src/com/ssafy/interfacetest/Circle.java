package com.ssafy.interfacetest;

public class Circle implements DohyungArea {

	private int radius;

	public Circle() {
		this.radius = 3;
	}
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
}
