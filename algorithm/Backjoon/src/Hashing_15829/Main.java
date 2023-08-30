package Hashing_15829;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		BigInteger answer = new BigInteger("0");
		BigInteger multiplier = new BigInteger("1");
		BigInteger thirtyone = new BigInteger("31");
		for(int i = 0; i < n; i++) {
			BigInteger now = new BigInteger(Integer.toString(s.charAt(i)-'a'+1));
			answer = answer.add(multiplier.multiply(now));
			multiplier = multiplier.multiply(thirtyone);
		}
		answer = answer.mod(new BigInteger("1234567891"));
		System.out.println(answer);
	}

}
