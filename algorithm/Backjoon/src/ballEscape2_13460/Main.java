package ballEscape2_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final char BLANK = '.';
	static final char WALL = '#';
	static final char EXIT = '0';
	static int N;
	static int M;
	static char[][] map;
	static Ball[] balls = new Ball[2];
	static int[] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;
	
	static class Ball {
		char color;
		int r;
		int c;
		public Ball(char color, int r, int c) {
			this.color = color;
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean in_range(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
	
	public static void find_way(int redRow, int redCol, int blueRow, int blueCol, int cnt) {
		if(cnt == 10) {
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nextRedRow = redRow + dr[d];
			int nextRedCol = redCol + dc[d];
			while(map[nextRedRow][nextRedCol] != WALL) {
				if(map[nextRedRow][nextRedCol] == 'B') break;
				if(map[nextRedRow][nextRedCol] == EXIT) {
					if(min > cnt) min = cnt;
					break;
				}
				nextRedRow += dr[d];
				nextRedCol += dc[d];
			}
			int nextBlueRow = blueRow + dr[d];
			int nextBlueCol = blueCol + dc[d];
			while(map[nextBlueRow][nextBlueCol] != WALL) {
				if(map[nextBlueRow][nextBlueCol] == 'R') break;
				if(map[nextBlueRow][nextBlueCol] == EXIT) {
					if(min > cnt) min = cnt;
					break;
				}
				nextRedRow += dr[d];
				nextRedCol += dc[d];
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'R') {
					balls[0] = new Ball('R', r, c);
				} else if (map[r][c] == 'B') {
					balls[1] = new Ball('B', r, c);
				}
			}
		}
	}

}
