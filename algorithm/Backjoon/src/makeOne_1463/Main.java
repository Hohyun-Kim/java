package makeOne_1463;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		for(int i = 2; i < n+1; i++) {
			if(i%6 == 0) {
				int temp = Math.min(dp[i/2]+1, dp[i/3]+1);
				dp[i] = Math.min(dp[i-1]+1, temp);
			} else {
				if(i%2 == 0) {
					dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
					continue;
				}
				if(i%3 == 0) {
					dp[i] = Math.min(dp[i-1]+1, dp[i/3]+1);
					continue;
				}
				dp[i] = dp[i-1]+1;
			}
		}
		System.out.println(dp[n]);
	}
}
