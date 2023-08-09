package squareRoom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N;
	public static int start;
	public static int max;
	public static int temp = 0;
	public static int[][] map;
	
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public static boolean in_range(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
		return false;
	}
	
	public static void find(int i, int j, int now, int cnt) {
				
		
		for(int d = 0; d < dr.length; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(in_range(nr, nc)) {
				if(map[nr][nc] - now == 1) {
					find(nr, nc, map[nr][nc], cnt+1);
				}
			}
		}
		if (max < cnt) {
			max = cnt;
			start = temp;
		} else if (max == cnt) {
			if (start > temp) {
				start = temp;
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/squareRoom/input.txt"));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		boolean[][]	visit;
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;
			start = -1;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					temp = map[i][j];
					find(i, j, temp, 1);
				}
			}
			sb.append(start).append(" ").append(max).append("\n");			
		}
		System.out.println(sb);

	}

}
