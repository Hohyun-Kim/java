package remoteCharge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	public static class RC {
		public int idx;
		public int power;
		public RC (int idx, int power) {
			this.idx = idx;
			this.power = power;
		}
	}
	
	public static ArrayList<RC>[][] map;
	
	public static int[] dr = {0, -1, 0, 1, 0};
	public static int[] dc = {0, 0, 1, 0, -1};
	
	public static boolean in_range(int r, int c) {
		return r>=0 && r<10 && c>=0 && c<10;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			map = new ArrayList[10][10];
			for(int r = 0; r < 10; r++) {
				for(int c = 0; c < 10; c++) {
					map[r][c] = new ArrayList();
				}
			}
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int num_charger = Integer.parseInt(st.nextToken());
			int[] move_A = new int[M];
			int[] move_B = new int[M];
			RC[] chargers = new RC[num_charger];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				move_A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				move_B[i] = Integer.parseInt(st.nextToken());
			}
			int sr = 0;
			int sc = 0;
			int range = 0;
			for(int i = 0; i < num_charger; i++){
				st = new StringTokenizer(br.readLine());
				sr = Integer.parseInt(st.nextToken())-1;
				sc = Integer.parseInt(st.nextToken())-1;
				range = Integer.parseInt(st.nextToken());
				RC now = new RC(i, Integer.parseInt(st.nextToken()));
				for(int r = sr-range; r <= sr+range; r++) {
					for(int c = sc-range; c <= sc+range; c++) {
						if(Math.abs(r-sr)+Math.abs(c-sc) > range) continue;
						if(in_range(r, c)) {
							map[r][c].add(now);
						}
					}
				}
			}
			int[] A_now = {0, 0};
			int A_power = 0;
			int[] B_now = {99, 99};
			int B_power = 0;
			ArrayList<RC> A_rc;
			ArrayList<RC> B_rc;
			for(int i = 0; i < M; i++) {
				
			}
			
		}

	}

}
