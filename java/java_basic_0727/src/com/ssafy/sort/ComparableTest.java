package com.ssafy.sort;

import java.util.*;

public class ComparableTest {

	public static void main(String[] args) {
//		primitive type의 경우 Arrays.sort() 이용
		int[] num1 = {50, 24, 67, 85, 72, 31, 9, 7, 36};
		Arrays.sort(num1);
		System.out.print("0. [");
		int len = num1.length;
		for (int i = 0; i < len; i++) {
			System.out.print(num1[i]);
			if(i != len - 1)
				System.out.print(", ");
			else
				System.out.print("]");
		}
		System.out.println();
		
//		Integer와 같은 Wrapper Class나 String, Date, File 클래스들은 Comparable<T> 가 구현되어 있다.
		Integer[] num2 = {50, 24, 67, 85, 72, 31, 9, 7, 36};
		List<Integer> list = Arrays.asList(num2);
		Collections.sort(list); // default : 오름차순
		System.out.println("1. " + list);
		
//		내림차순
		Collections.reverse(list);
		System.out.println("2. " + list);
		
//		Comparator 이용
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
//				return o1.intValue() - o2.intValue(); // 오름차순
				return o2.intValue() - o1.intValue(); // 내림차순
			}
			
		});
		System.out.println("3. " + list);
	}
	
}
