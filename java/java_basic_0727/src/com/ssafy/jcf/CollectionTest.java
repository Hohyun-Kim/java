package com.ssafy.jcf;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		/*
		Collection coll = new ArrayList();
		System.out.println("coll size : " + coll.size());
		coll.add(100);
		coll.add("홍길동");
		coll.add(new Car(1234, "쏘나타", "HD"));
		System.out.println("coll size : " + coll.size());
		
		Iterator it = coll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Object[] objs = coll.toArray();
		for(Object obj : objs) {
			if(obj instanceof Car) {
				Car c = (Car) obj;
				System.out.println(c.getCarName());
			} else {
				System.out.println(obj);
			}
		}
		*/
//		Collection<Car> coll = new ArrayList<>();
		Collection<Car> coll = new HashSet<>();
		System.out.println("coll size : " + coll.size());
//		coll.add(100);
//		coll.add("홍길동");
		coll.add(new Car(1234, "쏘나타", "HD"));
		coll.add(new Car(5678, "K5", "KIA"));
		coll.add(new Car(9876, "그랜저", "HD"));
		coll.add(new Car(9876, "그랜저", "HD"));
		coll.add(new Car(9876, "그랜저", "HD"));
		System.out.println("coll size : " + coll.size());
		
		Car[] cars = coll.toArray(new Car[0]);
		for(Car car: cars) {
			System.out.println(car.getCarName());
		}
	}
	
}
