package com.ssafy.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCompareTest {

	public static void main(String[] args) {
		String[] word = {"I", "want", "to", "go", "home", "always", "Everytime", "Everyday", "Everyweek", "Everymonth", "Everyyear", "then", "happy"};
		List<String> list = Arrays.asList(word);
		System.out.println("1. " + list);
		Collections.sort(list);
		System.out.println("2. " + list);
		
//		문자열의 길이로 오름차순 정렬한 후 사전순 정렬
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareToIgnoreCase(s2); 
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		System.out.println("3. " + list);
	}
}
