package com.ssafy.jcf;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> lotto = new HashSet<>();
		while(lotto.size() != 6) {
			lotto.add(random.nextInt(45) + 1);
		}
		System.out.println(lotto);
	}
	
}
