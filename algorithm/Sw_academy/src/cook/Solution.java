package cook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int[][] map;
	
	public static int N;
	
	public static int min;
	
	public static int[] A;
	
	public static int[] B;
	
	public static int sum_A;
	
	public static int sum_B;
	
	public static void find_comb(int start, int cnt, int flag) {
		
		if(cnt == N/2){
			int a = 0;
			int b = 0;
			for(int i = 0; i < N; i++) {
				if((flag&1<<i) != 0) {
					A[a++] = i;
				} else B[b++] = i;
			}
			sum_A = 0;
			sum_B = 0;
			for(int i = 0; i < N/2; i++) {
				for(int j = i; j < N/2; j++) {
					sum_A += map[A[i]][A[j]];
					sum_B += map[B[i]][B[j]];
				}
			}
			if(Math.abs(sum_A-sum_B) < min) min = Math.abs(sum_A-sum_B);
			return;
		}
		if(start>N/2+cnt) {
			return;
		}
		find_comb(start+1, cnt+1, flag|1<<start);
		find_comb(start+1, cnt, flag);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new FileReader("./src/cook/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			A = new int[N/2];
			B = new int[N/2];
			min = Integer.MAX_VALUE;
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			for(int r = 0; r < N; r++) {
				for(int c = r; c < N; c++) {
					map[r][c] += map[c][r];
				}
			}
			find_comb(0, 0, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
