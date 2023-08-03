package com.ssafy.abstracttest;

public class Rect extends Dohyung {
	
	private double width;
	private double height;
	
	public Rect() {
		width = 5;
		height = 3;
	}

	public Rect(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double calcArea() {
		return width * height;
	}

	@Override
	public double calcRound() {
		return 2 * (width+height);
	}

}
