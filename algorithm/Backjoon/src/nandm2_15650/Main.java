package nandm2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void makeComb(int cnt, int start, int N, int M, int[] num, StringBuilder sb) throws IOException {
		if (cnt == M) {
			for (int n: num) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N+1; i++) {
			num[cnt] = i;
			makeComb(cnt+1, i+1, N, M, num, sb);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int num[] = new int[M];
		makeComb(cnt, 1, N, M, num, sb);
		System.out.println(sb.toString());
		
	}
}
