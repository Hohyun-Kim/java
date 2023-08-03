package com.ssafy.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarCompareTest {

	public static void main(String[] args) {
		Car c1 = new Car(1111, "SonataB", "HD");
		Car c2 = new Car(2222, "SonataC", "HD");
		Car c3 = new Car(3333, "Avante", "HD");
		Car c4 = new Car(4444, "K5", "KIA");
		Car c5 = new Car(5555, "SonataA", "HD");
		Car c6 = new Car(6666, "SM6", "SS");
		Car c7 = new Car(7777, "GENESIS", "HD");
		Car c8 = new Car(8888, "QM6", "SS");
		Car c9 = new Car(9999, "K7", "KIA");
		Car c10 = new Car(0000, "K5D", "KIA");

		List<Car> list = new ArrayList<>();
		list.add(c2);
		list.add(c1);
		list.add(c5);
		list.add(c9);
		list.add(c3);
		list.add(c4);
		list.add(c10);
		list.add(c7);
		list.add(c6);
		list.add(c8);
		viewList(list);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> 차번호로 정렬 후 결과");
		Collections.sort(list);
		viewList(list);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> 차이름으로 오름차순 정렬 후 결과");
		Comparator<Car> carNameComparator = new Comparator<Car>() {
			@Override
			public int compare(Car c1, Car c2) {
				return c1.getCarName().compareTo(c2.getCarName());
			}
		};
		Collections.sort(list, carNameComparator);
		viewList(list);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> 차제조사로 오름차순 정렬 후 결과");
		Comparator<Car> carMakerComparator = new Comparator<Car>() {
			@Override
			public int compare(Car c1, Car c2) {
				return c1.getMaker().compareTo(c2.getMaker());
			}
		};
		Collections.sort(list, carMakerComparator);
		viewList(list);
	}

	public static void viewList(List<Car> list) {
		for (Car car : list) {
			System.out.println(car);
		}
	}

}
