package com.ssafy.sort;

import java.util.*;

public class StringCompareTest {

	public static void main(String[] args) {
		String[] word = {"boy", "Cat", "Lion", "dog", "elephant", "Dog", "i", "girl", "Dogcat", "giraffe", "Any", "dragon", "animal"};
		List<String> list = Arrays.asList(word);
		System.out.println("1. " + list);
		Collections.sort(list);
		System.out.println("2. " + list);
		
//		문자열의 길이로 오름차순 정렬한 후 사전순 정렬 
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int len1 = s1.length();
				int len2 = s2.length();
				if(len1 != len2)
					return len1 - len2;
				return s1.compareToIgnoreCase(s2) * -1;
			}
		});
		System.out.println("3. " + list);
	}
	
}
