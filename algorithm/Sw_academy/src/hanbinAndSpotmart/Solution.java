package hanbinAndSpotmart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void calc_weight(int[] snack, int idx, int N, int M, int cnt, int now, int[] max) {
		
		if(cnt == 2) {
			if (now > max[0]) max[0] = now;
			return;
		}
		if(idx == N) {
			if (max[0] == 0) max[0] = -1;
			return;
		}
		if(snack[idx]+now <= M) {
			calc_weight(snack, idx+1, N, M, cnt+1, now+snack[idx], max);
		}
		calc_weight(snack, idx+1, N, M, cnt, now, max);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/hanbinAndSpotmart/sample_input.txt"));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N;
		int M;
		int[] snack;
		int[] max = new int[1];
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			max[0] = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			calc_weight(snack, 0, N, M, 0, 0, max);
			sb.append(max[0]).append("\n");
			
		}
		System.out.println(sb);
		
	}

}
