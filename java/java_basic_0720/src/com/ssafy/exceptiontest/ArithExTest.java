package com.ssafy.exceptiontest;

import java.util.Random;

public class ArithExTest {

	public static void main(String[] args) {
		Random ra = new Random();
		int x = ra.nextInt(4)+1;
		int y = 10;
		int z = y/x;
		System.out.println(y+"/"+x+"="+z);

	}

}
