package com.ssafy.jcf;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, Car> map = new HashMap<>();
		Car c1 = new Car(1234, "쏘나타", "HD");
		Car c2 = new Car(5678, "K5", "KIA");
		Car c3 = new Car(9876, "그랜저1", "HD");
		Car c4 = new Car(9999, "그랜저2", "HD");
		Car c5 = new Car(8888, "그랜저3", "HD");
		
		map.put(c1.getCarNum(), c1);
		map.put(c2.getCarNum(), c2);
		map.put(c3.getCarNum(), c3);
		map.put(c4.getCarNum(), c4);
		map.put(c5.getCarNum(), c5);
		
		int carNum = 9999;
		System.out.println("차번호가 " + carNum + "인 자동차 정보");
		Car car = map.get(carNum);
		System.out.println(car);
		
		System.out.println(map.size());
		System.out.println(carNum + "지우기!!!");
		map.remove(carNum);
		System.out.println(map.size());
		
		map.put(8888, new Car(8888, "아반떼", "HD"));
		car = map.get(8888);
		System.out.println(car);
	}
	
}
