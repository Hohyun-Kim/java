package com.ssafy.abstracttest;

public class Circle extends Dohyung {
	
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

	@Override
	public double calcRound() {
		// TODO Auto-generated method stub
		return 3.14 * 2 * radius;
	}

}
