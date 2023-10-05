package escape_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final char DEST = 'D';
	static final char START = 'S';
	static final char ROAD = '.';
	static final char STONE = 'X';
	static final char WATER = '*';
	static char[][] map;
	static Queue<Location> flood = new ArrayDeque<>();
	static Queue<Location> hog = new ArrayDeque<>();
	static Location dest;
	static boolean escape = false;
	static int time = 0;
	static int R;
	static int C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	
	static class Location {
		int r;
		int c;
		public Location() {
		}
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean in_range(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
	
	static void flow(Location water) {
		for(int d = 0; d < 4; d++) {
			int nr = water.r + dr[d];
			int nc = water.c + dc[d];
			if(in_range(nr, nc) && (map[nr][nc] == ROAD)) {
				map[nr][nc] = WATER;
				flood.offer(new Location(nr, nc));
			}
		}
	}
	
	static void move(Location now) {
		for(int d = 0; d < 4; d++) {
			int nr = now.r + dr[d];
			int nc = now.c + dc[d];
			if(in_range(nr, nc)) {
				switch(map[nr][nc]) {
				case ROAD:
					map[nr][nc] = START;
					hog.offer(new Location(nr, nc));
					break;
				case DEST:
					escape = true;
					break;
				default:
					break;
				}
			}
		}
	}
	
	public static void find_way() {
		while(!hog.isEmpty()) {
			int flood_size = flood.size();
			for(int f = 0; f < flood_size; f++) {
				flow(flood.poll());
			}
			int possible_way = hog.size();
			for(int h = 0; h < possible_way; h++) {
				move(hog.poll());
			}
			time++;
			if(escape) break;
		}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				switch(map[r][c]) {
				case ROAD:
				case STONE:
					break;
				case WATER:
					flood.offer(new Location(r, c));
					break;
				case DEST:
					dest = new Location(r, c);
					break;
				case START:
					hog.offer(new Location(r, c));
					break;
				}
			}
		}
		find_way();
		System.out.println(escape?time:"KAKTUS");
	}
}
