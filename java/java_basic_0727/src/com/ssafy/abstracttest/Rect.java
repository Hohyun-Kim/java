package com.ssafy.abstracttest;

public class Rect extends Dohyung {

	private int width;
	private int height;
	
	public Rect() {
		this.width = 5;
		this.height = 3;
	}

	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public double calcArea() {
		return width * height;
	}

	@Override
	public double calcRound() {
		return 2 * (width + height);
	}

}
