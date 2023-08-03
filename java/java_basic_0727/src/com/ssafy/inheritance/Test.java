package com.ssafy.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		String s = "hi";
		s.replace('i', 'e');
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("hi");
		sb.replace(1, 2, "e");
		System.out.println(sb);
		
//		long st = System.nanoTime();
//		String s1 = "helo ";
//		for(int i=0;i<1000;i++)
//			s1 += "ssafy";
//		System.out.println(s1);
//		System.out.println(System.nanoTime() - st);
//		4489301	3568800	4499800
//		368700
		long st = System.nanoTime();
		StringBuilder s1 = new StringBuilder("helo ");
		for(int i=0;i<1000;i++)
			s1.append("ssafy");
		System.out.println(s1);
		System.out.println(System.nanoTime() - st);
		
		
		
//		List list = new ArrayList();
//		list.add("aaa");
//		list.add(111);
//		for(int i=0;i<list.size();i++) {
//			Object obj = list.get(i);
//			if(obj instanceof String)
//				System.out.println(obj.toString() + "문자열이야");
//			else if(obj instanceof Integer)
//				System.out.println(obj.toString() + "숫자야");
//		}
//		
//		List<String> list2 = new ArrayList<>();
//		list2.add("aaa");
//		list2.add("111");
//		
//		for(String s: list2) {
//			System.out.println(s);
//		}
		
	}
	

	static class A {
		
	}
	
}
