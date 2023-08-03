package com.ssafy.sort;

import java.util.*;

public class CarCompareTest {

	public static void main(String[] args) {
		Car car1 = new Car(7893, "SonataB", "HD");
		Car car2 = new Car(1900, "SonataC", "HD");
		Car car3 = new Car(4567, "Avante", "HD");
		Car car4 = new Car(2893, "K5", "KIA");
		Car car5 = new Car(5467, "SonataA", "HD");
		Car car6 = new Car(1908, "SM6", "SS");
		Car car7 = new Car(3489, "GENESIS", "HD");
		Car car8 = new Car(9834, "QM6", "SS");
		Car car9 = new Car(9843, "K7", "KIA");
		Car car10 = new Car(4580, "K5D", "KIA");
		
		List<Car> list = new ArrayList<Car>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);
		list.add(car8);
		list.add(car9);
		list.add(car10);
		viewList(list);
		
		System.out.println(">>>>>>>>>>>>>>>>>>> 차번호로 정렬 후 결과");
		Collections.sort(list);
		viewList(list);
		
		System.out.println(">>>>>>>>>>>>>>>>>>> 차이름으로 오름차순 정렬 후 결과");
		Comparator<Car> carNameComparator = new Comparator<Car>() {
			
			@Override
			public int compare(Car c1, Car c2) {
				return c1.getCarName().compareTo(c2.getCarName());
			}
		};
		Collections.sort(list, carNameComparator);
		viewList(list);
		
		System.out.println(">>>>>>>>>>>>>>>>>>> 제조사로 내림차순 정렬 후 결과");
		Comparator<Car> carMakerComparator = new Comparator<Car>() {
			
			@Override
			public int compare(Car c1, Car c2) {
				return c1.getMaker().compareTo(c2.getMaker()) * -1;
			}
		};
		Collections.sort(list, carMakerComparator);
		viewList(list);
	}

	private static void viewList(List<Car> list) {
		for(Car car : list) {
			System.out.println(car);
		}
	}
	
}
