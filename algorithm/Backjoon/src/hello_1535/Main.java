package hello_1535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int max_joy = 0;
	
	public static void calc_joy(int[] health, int[] joy, int now_health, int now_joy, int index, int N) {
		
		if (index == N) {
			if (now_joy > max_joy) {
				max_joy = now_joy;
			}
			return;
		}
		
		if (now_health-health[index] <= 0) {
			if (now_joy > max_joy) {
				max_joy = now_joy;
			}
		} else {
			calc_joy(health, joy, now_health-health[index], now_joy+joy[index], index+1, N);
		}
		calc_joy(health, joy, now_health, now_joy, index+1, N);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] health = new int[N];
		int[] joy = new int[N];
		int now_joy = 0;
		int now_health = 100;
		int index = 0;
		for (int i = 0; i < N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}
		calc_joy(health, joy, now_health, now_joy, index, N);
		System.out.println(max_joy);
		
	}
}
