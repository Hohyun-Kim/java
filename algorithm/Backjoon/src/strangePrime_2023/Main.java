package strangePrime_2023;

import java.util.Scanner;

public class Main {
	
	public static void isPrime(int n, int cnt, int N, StringBuffer sb) {
		
		if (n%2 == 0 && n != 2) return;
		for(int i = 3; i*i <= n; i+=2) {
			if (n%i == 0) return;
		}
		if (cnt == N) {
			sb.append(n).append("\n");
			return;
		}
		for(int i = 1; i < 10; i+=2) {
			isPrime(n*10+i, cnt+1, N, sb);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int N = sc.nextInt();
		int cnt = 1;
		for (int n = 2; n < 10; n++) {
			isPrime(n, cnt, N, sb);
		}
		System.out.println(sb);
	}

}