package com.ssafy.abstracttest;

public class Circle extends Dohyung {

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

	@Override
	public double calcRound() {
		return 2 * Math.PI * radius;
	}
	
}
