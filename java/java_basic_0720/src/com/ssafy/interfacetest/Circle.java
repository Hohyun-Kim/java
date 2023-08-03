package com.ssafy.interfacetest;

public class Circle implements DohyungArea {
	
	private double radius;
	
	public Circle() {
		radius = 3;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return 3.14 * Math.pow(radius, 2);
	}

}
