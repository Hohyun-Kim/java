package nandm1_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void makePerm(int cnt, int N, int M, int[] visit, StringBuilder sb) throws IOException {
		if (cnt == M) {
			System.out.println(sb.toString());
			return;
		}
		cnt++;
		for (int i = 0; i < N; i++) {
			if (visit[i] == 1) {
				continue;
			}
			visit[i] = 1;
			sb.append((i+1)+ " ");
			makePerm(cnt, N, M, visit, sb);
			visit[i] = 0;
			sb.delete(sb.length()-2, sb.length());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] visit = new int[N];
		int cnt = 0;
		makePerm(cnt, N, M, visit, sb);
		
	}
}
