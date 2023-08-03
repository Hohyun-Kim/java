package com.ssafy.basic;

public class Guest {

	String name;
	static int cnt;
	
	public Guest(String name) {
		this.name = name;
	}
	
	public static void visit() {
		cnt++;
	}
	
}
