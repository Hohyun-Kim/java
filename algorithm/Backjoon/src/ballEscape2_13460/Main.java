package ballEscape2_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final char BLANK = '.';
	static final char WALL = '#';
	static final char EXIT = 'O';
	static int N;
	static int M;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;
	static boolean success = false;
	
	static class Balls {
		Ball red;
		Ball blue;
		public Balls(Ball red, Ball blue) {
			this.red = red;
			this.blue = blue;
		}
	}
	
	static class Ball {
		int r;
		int c;
		public Ball(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean in_range(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
	
	static boolean ball_move(Ball ball, int d, boolean isRed) {
		int nextRow = ball.r + dr[d];
		int nextCol = ball.c + dc[d];
		boolean blueEscape = false;
		while(map[nextRow][nextCol] != WALL) {
			if(map[nextRow][nextCol] == EXIT) {
				success = isRed? true:false;
				blueEscape = isRed? false:true;
				break;
			}
			nextRow += dr[d];
			nextCol += dc[d];
		}
		ball.r = nextRow - dr[d];
		ball.c = nextCol - dc[d];
		return blueEscape;
	}
	
	static boolean balls_move(Balls balls, int d) {
		
		Ball red = balls.red;
		Ball blue = balls.blue;
		
		int oldRedRow = red.r;
		int oldRedCol = red.c;
		int oldBlueRow = blue.r;
		int oldBlueCol = blue.c;
		ball_move(red, d, true);
		boolean blueEscape = ball_move(blue, d, false);
		
		if(success == true) return true;
		int redMove = Math.abs(red.r - oldRedRow) + Math.abs(red.c - oldRedCol);
		int blueMove = Math.abs(blue.r - oldBlueRow) + Math.abs(blue.c - oldBlueCol);
		if((redMove == 0 && blueMove == 0) || blueEscape) return false;
		if(red.r == blue.r && red.c == blue.c) {
			if(redMove > blueMove) {
				red.r -= dr[d];
				red.c -= dc[d];
			} else {
				blue.r -= dr[d];
				blue.c -= dc[d];
			}
		}
		return true;
	}
	
	public static int find_way(int redRow, int redCol, int blueRow, int blueCol) {
		
		Queue<Balls> q = new ArrayDeque<>();
		q.add(new Balls(new Ball(redRow, redCol), new Ball(blueRow, blueCol)));
		int cnt = 0;
		while(!q.isEmpty() && cnt < 10) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Balls now = q.poll();
				for(int d = 0; d < 4; d++) {
					Balls new_balls = new Balls(new Ball(now.red.r, now.red.c), new Ball(now.blue.r, now.blue.c));
					if(balls_move(new_balls, d) && !visited[new_balls.red.r][new_balls.red.c][new_balls.blue.r][new_balls.blue.c]) {
						if(success) break;
						visited[new_balls.red.r][new_balls.red.c][new_balls.blue.r][new_balls.blue.c] = true;
						q.add(new_balls);
					};
				}
				if(success) break;
			}
			cnt++;
			if(success) break;
		}
		return success? cnt:-1;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		int redRow = -1;
		int redCol = -1;
		int blueRow = -1;
		int blueCol = -1;
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'R') {
					redRow = r;
					redCol = c;
				} else if (map[r][c] == 'B') {
					blueRow = r;
					blueCol = c;
				}
			}
		}
		int answer = find_way(redRow, redCol, blueRow, blueCol);
		System.out.println(answer);
	}

}
