package com.ssafy.inheritance;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TaxiTest {

	public static void main(String[] args) {
		Taxi t = new Taxi();
		
		Taxi t1 = new Taxi("K5", "감홍", "기아");
		System.out.println(t1.toString());
		
		int km = 10;
		System.out.println("강남역에서 잠실까지 " + km + "km 이동!!!");
		System.out.println("요금 : " + t1.calcPrice(km) + "원");
		
		System.out.println("잠실에서 강남역까지 " + km + "km 이동!!!");
		System.out.println("요금 : " + t1.calcPrice(km) + "원");
		
		int speed = 200;
		System.out.println("t1 택시의 속도 " + speed + "만큼 증가!!!");
		System.out.println("t1 택시 속도 : " + t1.speedUp(speed));
		System.out.println("t1 택시 속도 : " + t1.speed);
		
		Taxi t2 = new Taxi(new String("K5"), "감홍", "기아");
		System.out.println(t2);
		
		System.out.println(t1.hashCode() + "\t" + t2.hashCode());
		System.out.println(t1 + "\t" + t2.toString());
		
		if(t1 == t2)
			System.out.println("t1과 t2는 같은 차종입니다.");
		else
			System.out.println("t1과 t2는 다른 차종입니다.");
		
		if(t1.equals(t2))
			System.out.println("t1과 t2는 같은 차종입니다.");
		else
			System.out.println("t1과 t2는 다른 차종입니다.");
		
		
//		Car car = t1;
////		Taxi t2 = new Car();
//		Car car2 = new Taxi();
//		Car car2 = new Car();
//		System.out.println(car2.info());
////		car2.b();
//		
//		Calendar cal = new GregorianCalendar();
//		
//		Taxi t2 = (Taxi) car2;
	}
	
}
