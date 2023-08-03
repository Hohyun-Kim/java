package com.ssafy.jcf;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		List<Car> list = new ArrayList<>();
		System.out.println("list size : " + list.size());
		list.add(new Car(1234, "쏘나타", "HD"));
		list.add(new Car(5678, "K5", "KIA"));
		list.add(new Car(7777, "K5", "KIA"));
		list.add(new Car(9876, "그랜저", "HD"));
		list.add(new Car(0000, "그랜저", "HD"));
		list.add(new Car(9999, "K5", "KIA"));
		list.add(new Car(8888, "그랜저", "HD"));
		System.out.println("list size : " + list.size());

//		Car[] cars = list.toArray(new Car[0]);
//		for(Car car: cars) {
//			System.out.println(car.getCarName());
//		}

		for (int i = 0; i < list.size(); i++) {
			Car car = list.get(i);
			System.out.println(car.getCarName());
		}
		String cn = "K5";
		System.out.println("차이름이 " + cn + "인 자동차 제거");

//		int size = list.size();
//		for (int i = 0; i < size; i++) {
//			Car car = list.get(i);
//			if(cn.equals(car.getCarName()))
//				list.remove(i);
//		}
		
//		int size = list.size();
//		for (int i = 0; i < list.size(); i++) {
//			Car car = list.get(i);
//			if(cn.equals(car.getCarName())) {
//				list.remove(i);
//				i--;
//			}
//		}
		
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			Car car = list.get(i);
			if(cn.equals(car.getCarName()))
				list.remove(i);
		}

		for (int i = 0; i < list.size(); i++) {
			Car car = list.get(i);
			System.out.println(car.getCarName());
		}
	}

}
