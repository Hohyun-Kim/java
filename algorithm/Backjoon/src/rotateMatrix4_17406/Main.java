package rotateMatrix4_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
		
	public static boolean in_range(int nr, int nc, int N) {
		return (nr < N && nr >= 0 && nc < N && nc >= 0);
	}
	
	public static void rotate_mat(int[][] map, int s_r, int s_c, int N) {
		
		int r_next = s_r;
		int c_next = s_c+1;
		int d = 0;
		int temp_next = map[r_next][c_next];
		int temp_now = map[s_r][s_c];
		while (true) {
			map[r_next][c_next] = temp_now;
			temp_now = temp_next;
			if(!in_range(r_next+dr[d]-s_r, c_next+dc[d]-s_c, N)) {
				d++;
				if (d > 3) break;
			}
			r_next += dr[d];
			c_next += dc[d];
			temp_next = map[r_next][c_next];
		}
	}
	
	private static boolean np(int[][] R, int K) {
		
		int i = K-1;
		while(i>0 && R[i-1][0] >= R[i][0]) --i;
		if (i==0) return false;
		int j = K-1;
		while(R[i-1][0] >= R[j][0]) --j;
		swap(R, i-1, j);
		j = K-1;
		while(i < j) {
			swap(R, i++, j--);
		}
		return true;
		
	}
	
	private static void swap(int[][] R, int i, int j) {
		int[] temp = R[i];
		R[i] = R[j];
		R[j] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] R = new int[K][4];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			R[k][0] = k;
			R[k][1] = Integer.parseInt(st.nextToken())-1;
			R[k][2] = Integer.parseInt(st.nextToken())-1;
			R[k][3] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		int temp = 0;
		int cnt = 0;
		do {
			int[][] rot = new int[N][M];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					rot[r][c] = map[r][c];
				}
			}
			for(int i = 0; i < K; i++) {
				for(int s = R[i][3]; s > 0; s--) {
					rotate_mat(rot, R[i][1]-s, R[i][2]-s, 2*s+1);
				}
			}
			for(int r = 0; r < N; r++) {
				temp = 0;
				for(int c = 0; c < M; c++) {
					temp += rot[r][c];
				}
				if(min > temp) {
					min = temp; 
				}
			}
		} while(np(R, K));
		
		System.out.println(min);
	}
}
