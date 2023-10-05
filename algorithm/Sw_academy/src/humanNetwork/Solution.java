package humanNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] adjMatrix;
	static int[] cc;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		adjMatrix = new int[1000][1000];
		cc = new int[1000];
		for(int t = 1; t < T+1; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; i++) {
				Arrays.fill(adjMatrix[i], 1001);
			}
			Arrays.fill(cc, 0);
			int n = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					n = Integer.parseInt(st.nextToken());
					if(n != 0) adjMatrix[i][j] = n;
				}
			}
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						adjMatrix[i][j] = Integer.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			int min_idx = -1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i==j) continue;
					cc[i] += adjMatrix[i][j]; 
				}
				if(min > cc[i]) {
					min = cc[i];
				}
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
}
