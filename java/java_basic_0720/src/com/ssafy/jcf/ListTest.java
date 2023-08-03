package com.ssafy.jcf;

import java.util.List;
import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		List<Car> list = new ArrayList<>();
		System.out.println("list size : " + list.size());
//	coll.add(100);
//	coll.add("홍길동");
		list.add(new Car(1234, "쏘나타", "HD"));
		list.add(new Car(5678, "K5", "KIA"));
		list.add(new Car(0000, "K5", "KIA"));
		list.add(new Car(8888, "K5", "KIA"));
		list.add(new Car(9876, "그랜져", "HD"));
		list.add(new Car(5555, "그랜져", "HD"));
		list.add(new Car(8888, "K5", "KIA"));
		list.add(new Car(4444, "그랜져", "HD"));
		System.out.println("list size : "+ list.size());
		
		Car[] cars = list.toArray(new Car[0]);
//		for (Car car : cars) {
//			System.out.println(car.getCarName());
//		}
		
		
		for(int i = 0; i < list.size(); i++) {
			Car car = list.get(i);
			System.out.println(car.getCarName());
		}
		
		String cn = "K5";
		
		System.out.println("차이름이 "+cn+"인 자동차 제거");
		
		for(int i = list.size()-1; i >= 0; i--) {
			Car car = list.get(i);
			if (car.getCarName().equals(cn)) {
				list.remove(i);
			}
		}
		System.out.println(list);
		
		for(int i = 0; i < list.size(); i++) {
			Car car = list.get(i);
			System.out.println(car.getCarName());
		}
	}
}
