package solvedac_18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
		}
		Arrays.sort(num);
		int r = (int)Math.round((float)N * 0.15);
		for(int i = 0; i < r; i++) {
			sum -= num[i] + num[N-1-i];
		}
		sum = (int)Math.round((float)sum/(N-2*r));
		System.out.println(sum);
	}

}
