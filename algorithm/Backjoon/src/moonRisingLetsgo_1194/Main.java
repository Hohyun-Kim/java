package moonRisingLetsgo_1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static final char BLANK = '.';
	static final char WALL = '#';
	static final char START = '0';
	static final char EXIT = '1';
	static final Set<Character> doors = new HashSet<Character>();
	static char[][] map;
	static boolean[][][] visit;
	static int N;
	static int M;
	static Queue<Minsick> minsick = new ArrayDeque<>();
	static boolean escape = false;
	static int time = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Minsick {
		int r;
		int c;
		int has_key = 0;

		public Minsick(int r, int c, int has_key) {
			this.r = r;
			this.c = c;
			this.has_key = has_key;
		}
	}

	static boolean in_range(int nr, int nc) {
		return nr < N && nc < M && nr >= 0 && nc >= 0;
	}

	static void maze_escape() {
		while (!minsick.isEmpty()) {
			int branch = minsick.size();
			for (int m = 0; m < branch; m++) {
				Minsick now = minsick.poll();
				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if (in_range(nr, nc) && map[nr][nc] != WALL && !visit[nr][nc][now.has_key]) {
						switch (map[nr][nc]) {
						case BLANK:
							minsick.offer(new Minsick(nr, nc, now.has_key));
							visit[nr][nc][now.has_key] = true;
							break;
						case WALL:
							break;
						case EXIT:
							escape = true;
							break;
						default:
							if (doors.contains(map[nr][nc])) {
								if ((now.has_key & 1 << (map[nr][nc] - 'A')) != 0) {
									visit[nr][nc][now.has_key] = true;
									minsick.offer(new Minsick(nr, nc, now.has_key));
								}
								break;
							}
							int new_key = now.has_key | 1 << (map[nr][nc] - 'a');
							visit[nr][nc][new_key] = true;
							minsick.offer(new Minsick(nr, nc, new_key));
							break;
						}
					}
				}
				if (escape) break;
			}
			time++;
			if (escape) break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M][64];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				switch (map[r][c]) {
				case BLANK:
				case EXIT:
				case WALL:
					break;
				case START:
					minsick.offer(new Minsick(r, c, 0));
					map[r][c] = '.';
					visit[r][c][0] = true;
					break;
				default:
					if ((map[r][c] - '0') < 23) {
						doors.add(map[r][c]);
					}
					break;
				}
			}
		}
		maze_escape();
		System.out.println(escape ? time : -1);
	}

}
