package remoteCharge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		StringBuffer sb = new StringBuffer();
		Comparator<RC> Comp = new Comparator<RC>() {
			@Override
			public int compare(RC o1, RC o2) {
				return o2.power - o1.power;
			}
		};
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
			int[] move_A = new int[M+1];
			int[] move_B = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < M+1; i++) {
				move_A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < M+1; i++) {
				move_B[i] = Integer.parseInt(st.nextToken());
			}
			int sr = 0;
			int sc = 0;
			int range = 0;
			for(int i = 0; i < num_charger; i++){
				st = new StringTokenizer(br.readLine());
				sc = Integer.parseInt(st.nextToken())-1;
				sr = Integer.parseInt(st.nextToken())-1;
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
			int A_r = 0;
			int A_c = 0;
			int B_r = 9;
			int B_c = 9;
			int total_power = 0;
			ArrayList<RC> A_rc;
			ArrayList<RC> B_rc;
			for(int i = 0; i < M+1; i++) {
				A_r += dr[move_A[i]];
				A_c += dc[move_A[i]];
				B_r += dr[move_B[i]];
				B_c += dc[move_B[i]];
				A_rc = map[A_r][A_c];
				B_rc = map[B_r][B_c];
				
				if(A_rc.size() == 0) { // A 위치 충전기 X
					if (B_rc.size() == 0) continue; // B 위치 충전기 X
					if (B_rc.size() == 1) { // B 위치 충전기 1
						total_power += B_rc.get(0).power;
					} else { // B 위치 충전기 2 이상
						int B_max = 0;
						for(int j = 0; j < B_rc.size(); j++) {
							if(B_rc.get(j).power > B_max) B_max = B_rc.get(j).power;
						}
						total_power += B_max;
					}
				} else if (A_rc.size() == 1) { // A 위치 충전기 1
					if(B_rc.size() == 0) { // B 위치 충전기 X
						total_power += A_rc.get(0).power;
					} else if(B_rc.size() == 1) { // B 위치 충전기 1
						if(A_rc.get(0).idx == B_rc.get(0).idx){ // A, B 충전기 공유
							total_power += A_rc.get(0).power;
						} else { // A, B 충전기 공유 X
							total_power += A_rc.get(0).power + B_rc.get(0).power;
						}
					} else { // B 위치 충전기 2이상
						int A_idx = A_rc.get(0).idx;
						int B_max = 0;
						for(int j = 0; j < B_rc.size(); j++) {
							if(B_rc.get(j).idx == A_idx) continue;
							if(B_rc.get(j).power > B_max) B_max = B_rc.get(j).power;
						}
						total_power += A_rc.get(0).power + B_max;
					}
				} else { // A 위치 충전기 2이상
					if(B_rc.size() == 0) { // B 위치 충전기 X
						int A_max = 0;
						for(int j = 0; j < A_rc.size(); j++) {
							if(A_rc.get(j).power > A_max) A_max = A_rc.get(j).power;
						}
						total_power += A_max;
					} else if(B_rc.size() == 1) { // B 위치 충전기 1
						int B_idx = B_rc.get(0).idx;
						int A_max = 0;
						for(int j = 0; j < A_rc.size(); j++) {
							if(A_rc.get(j).idx == B_idx) continue;
							if(A_rc.get(j).power > A_max) A_max = A_rc.get(j).power;
						}
						total_power += B_rc.get(0).power + A_max;
					} else { // B 위치 충전기 2이상
						int A_max = 0;
						int B_max = 0;
						Collections.sort(A_rc, Comp);
						Collections.sort(B_rc, Comp);
						if(A_rc.get(0).idx == B_rc.get(0).idx) {
							if(A_rc.get(1).idx == B_rc.get(1).idx) {
								A_max = A_rc.get(0).power;
								B_max = B_rc.get(1).power;
							} else {
								if(A_rc.get(1).power > B_rc.get(1).power) {
									A_max = A_rc.get(1).power;
									B_max = B_rc.get(0).power;
								} else {
									A_max = A_rc.get(0).power;
									B_max = B_rc.get(1).power;
								}
							}
						} else {
							A_max = A_rc.get(0).power;
							B_max = B_rc.get(0).power;
						}
						total_power += A_max + B_max;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(total_power).append("\n");
		}
		System.out.println(sb);
	}

}
