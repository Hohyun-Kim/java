package fishingKing_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, M;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	
	public static class shark {
		int row;
		int col;
		int speed;
		int direction;
		int size;
		int N_min = 1;
		int N_max;
		int dir_flag;
		
		public shark(int row, int col, int speed, int direction, int size) {
			this.row = row;
			this.col = col;
			this.direction = direction;
			this.size = size;
			switch (this.direction) {
			case 1:
			case 2:
				this.speed = speed % (2*(R-1));
				N_max = R;
				dir_flag = 0;
				break;
			case 3:
			case 4:
				this.speed = speed % (2*(C-1));
				N_max = C;
				dir_flag = 1;
				break;
			}
		}
		
		public int range() {
			int N = 0;
			switch (this.direction) {
			case 1:
			case 4:
				N = N_min;
				break;
			case 2:
			case 3:
				N = N_max;
				break;
			}
			return N;
		}
		
		public void move() {
			int N = range();
			switch (dir_flag) {
			case 0:
				move_vertical(N);
				break;
			case 1:
				move_horizental(N);
				break;
			}
		}
		
		public void move_vertical(int N) {
			int low = Math.abs(row - N);
			if (low >= speed) {
				row += dr[direction] * speed;
			} else if (low + R-1 >= speed ) {
				direction = 3 - direction;
				row = N + dr[direction] * (speed - low);
			} else {
				row -= dr[direction] * (2*(R-1) - speed);
			}
		}
		
		public void move_horizental(int N) {
			int low = Math.abs(col - N);
			if (low >= speed) {
				col += dc[direction] * speed;
			} else if (low + C-1 >= speed ) {
				direction = 7 - direction;
				col = N + dc[direction] * (speed - low);
			} else {
				col -= dc[direction] * (2*(C-1) - speed);
			}
		}
	}
	
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shark[] sharks = new shark[M];
		Set<Integer> alive = new HashSet<>();
		int num_shark = M;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks[m] = new shark(r, c, s, d, z);
			alive.add(m);
		}
		int sum = 0;
		ArrayList<int[]>[][] map;
		for(int c = 1; c <= C; c++) {
			map = new ArrayList[R+1][C+1];
			int min = Integer.MAX_VALUE;
			int min_shark = Integer.MAX_VALUE;
			for (Integer sharkIdx : alive) {
				if(sharks[sharkIdx].col == c && sharks[sharkIdx].row < min) {
					min = sharks[sharkIdx].row;
					min_shark = sharkIdx;
				}
			}
			if(alive.remove(min_shark)) {
				sum += sharks[min_shark].size;
			};
			if (alive.size() == 0) break;
			for (Integer sharkIdx : alive) {
				shark cur = sharks[sharkIdx];
				cur.move();
				if(map[cur.row][cur.col] == null) {
					map[cur.row][cur.col] = new ArrayList<>();
				}
				map[cur.row][cur.col].add(new int[] {sharkIdx, cur.size});
			}
			for (int h = 1; h <= R; h++) {
				for(int w = 1; w <= C; w++) {
					if(map[h][w] != null && map[h][w].size() > 1) {
						Collections.sort(map[h][w], new Comparator<int[]>() {
							@Override
							public int compare(int[] o1, int[] o2) {
								return o1[1] - o2[1];
							}
						});
						for(int i = 0; i < map[h][w].size()-1; i++) {
							alive.remove(map[h][w].get(i)[0]);
						}
					}
				}
			}
		}
		System.out.println(sum);
	}

}
