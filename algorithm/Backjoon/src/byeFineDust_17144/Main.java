package byeFineDust_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, T;
	static int airtop = 0;
	static int airbottom = 0;
	static int[][] map;
	static int[][] diff;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static boolean in_range(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C; 
	}
	
	public static void diffusion() {
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int diff_cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(in_range(nr, nc) && map[nr][nc] != -1) {
						diff[nr][nc] += map[r][c]/5;
						diff_cnt++;
					}
				}
				map[r][c] -= (map[r][c]/5)*diff_cnt;
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] += diff[r][c];
				diff[r][c] = 0;
			}
		}
	}
	
	public static void actCleaner() {
		int r = airtop-1;
		int c = 0;
		int d = 0;
		int nr = r + dr[d];
		int nc = c;
		while(nr != airtop || nc != 0) {
			if(in_range(nr, nc) && nr < airbottom) {
				map[r][c] = map[nr][nc];
				r = nr;
				c = nc;
			} else {
				d++;
				if(d > 3) d = 0;
			}
			nr = r + dr[d];
			nc = c + dc[d];
		}
		map[r][c] = 0;
		r = airbottom+1;
		c = 0;
		d = 2;
		nr = r + dr[d];
		nc = c;
		while(nr != airbottom || nc != 0) {
			if(in_range(nr, nc) && nr > airtop) {
				map[r][c] = map[nr][nc];
				r = nr;
				c = nc;
			} else {
				d--;
				if(d < 0) d = 3;
			}
			nr = r + dr[d];
			nc = c + dc[d];
		}
		map[r][c] = 0;
	}
	
	public static void Tlater() {
		for(int t = 0; t < T; t++) {
			diffusion();
			actCleaner();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		diff = new int[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0; r < R; r++) {
			if(map[r][0] == -1) {
				airtop = r;
				airbottom = r+1;
				break;
			}
		}
		
		Tlater();
		
		int finedust = 2;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				finedust += map[r][c]; 
			}
		}
		
		System.out.println(finedust);
	}
	
}