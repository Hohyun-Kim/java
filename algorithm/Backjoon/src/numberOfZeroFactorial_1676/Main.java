package numberOfZeroFactorial_1676;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt_5_1 = N/5;
		int cnt_5_2 = N/25;
		int cnt_5_3 = N/125;
		int numberOfZero = cnt_5_1 + cnt_5_2 + cnt_5_3;
		System.out.println(numberOfZero);		
	}
}
