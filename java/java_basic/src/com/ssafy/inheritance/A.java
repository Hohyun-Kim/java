package com.ssafy.inheritance;

public class A {

//	private static A a = new A();
	private static A a;
	
	static {
		a = new A();
	}

	private A() {}

	public static A getA() {
		if(a == null)
			a = new A();
		return a;
	}
}
