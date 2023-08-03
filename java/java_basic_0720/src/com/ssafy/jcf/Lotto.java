package com.ssafy.jcf;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
	
	public static void main(String[] args) {
		Random random = new Random();
		int num = 0;
		Set<Integer> num_set = new HashSet<>();
		while (num_set.size() < 6) {
			num = random.nextInt(45) + 1;
			num_set.add(Integer.valueOf(num));
		}
		System.out.println(num_set);
	}
	
	

}
