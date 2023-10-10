package crachBrick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, W, H;
	static int[][] map;
	static int min;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean all_crash;
	
	static class Ball {
		int r;
		int c;
		int val;
		public Ball(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}
	
	public static void clone(int[][] map_clone, int[][] map_) {
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				map_clone[h][w] = map_[h][w];
			}
		}
	}
	
	public static boolean in_range(int nr, int nc) {
		return nr < H && nc < W && nr >= 0 && nc >= 0;
	}
	
	public static void dropBall(int cnt, int[][] map_) {
		if(cnt == N) {
			int remain = remainBrick(map_);
			if (min > remain) min = remain;
			return;
		}		
		for(int c = 0; c < W; c++) {
			int[][] map_clone = new int[H][W];
			clone(map_clone, map_);
			boolean success = crashBrick(map_clone, c);
			int remain = remainBrick(map_clone);
			if(success) {
				if(remain == 0) {
					all_crash = true;
					return;
				}
				orderBrick(map_clone);
			} else {
				if(remain != 0) continue;
			}

			dropBall(cnt+1, map_clone);
			if(all_crash) return;
		}
	}
	
	public static int remainBrick(int[][] map_clone) {
		int cnt = 0;
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				if(map_clone[r][c] != 0) cnt++;
			}
		}
		return cnt;
	}
	
	public static boolean crashBrick(int[][] map_clone, int col) {
		Queue<Ball> q = new ArrayDeque<>();
		for(int row = 0; row < H; row++) {
			if(map_clone[row][col] != 0) {
				q.offer(new Ball(row, col, map_clone[row][col]));
				map_clone[row][col] = 0;
				break;
			}
		}
		if(q.isEmpty()) return false;
		while(!q.isEmpty()) {
			Ball now = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = now.r;
				int nc = now.c;
				for(int range = 1; range < now.val; range++) {
					nr += dr[d];
					nc += dc[d];
					if(in_range(nr, nc)) {
						if (map_clone[nr][nc] == 0) continue;
						if (map_clone[nr][nc] > 1) q.offer(new Ball(nr, nc, map_clone[nr][nc]));
						map_clone[nr][nc] = 0;
					} else break;
				}
			}
		}
		return true;
	}
	
	public static void orderBrick(int[][] map_clone) {
		int r_blank = -1;
		boolean hasBlank = false;
		for(int c = 0; c < W; c++) {
			hasBlank = false;
			for(int r = H-1; r >= 0; r--) {
				if(map_clone[r][c] != 0) {
					if(hasBlank) {
						map_clone[r_blank][c] = map_clone[r][c];
						map_clone[r][c] = 0;
						r_blank--;
					}
				} else {
					if(!hasBlank) {
						r_blank = r;
						hasBlank = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			min = Integer.MAX_VALUE;
			all_crash = false;
			
			for(int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			dropBall(0, map);
			if(all_crash) sb.append("0").append("\n");
			else sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
}
