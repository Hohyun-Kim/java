package com.ssafy.inheritance;

import java.util.List;
import static java.lang.Integer.parseInt;
public class WrapperTest {

	public static void main(String[] args) {
		
//		똑같은 이름의 class를 사용하는 경우
		List l1;
		java.awt.List l2;
		
		int x = 10;
		double d = x;
		int y = (int) d;

		char c = 'a';
		int z = c;

//		boolean b = true;
//		int a = b;

//		Car car = new Car();
//		Taxi t = (Taxi) car;

//		Taxi t1 = new Taxi();
//		Car c1 = t1;
//		Bus b = (Bus) c1;

//		auto boxing
		int i = 10;
//		boxing
		Integer it = i;
//		unboxing
		int i2 = it;

//		7
		String s = "7";
		Integer i3 = new Integer(s);
		int s2 = i3.intValue();
		System.out.println(s2 + 10);
		
		int s3 = parseInt(s);
		System.out.println(s3 + 10);
	}

}
