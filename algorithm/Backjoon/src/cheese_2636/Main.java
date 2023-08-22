package cheese_2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] map;
	public static int R;
	public static int C;
	public static int cnt;
	public static int total;
	public static boolean[][] visit;
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};
	
	public static boolean in_range(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
	
	public static int meltCheese() {
		int melt = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		int[] start = {0, 0};
		visit[0][0] = true;
		q.offer(start);
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			if(map[r][c] == 1) {
				map[r][c]++;
				continue;
			}
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(in_range(nr, nc) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					int[] next = {nr, nc};
					q.add(next);
				}
			}
		}
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 2) {
					total--;
					melt++;
					map[r][c] = 0;
				}
			}
		}
		return melt;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cnt = 0;
		total = 0;
		map = new int[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				total += map[r][c];
			}
		}
		int melt = 0;
		while(total!=0) {
			visit = new boolean[R][C];
			melt = meltCheese();
			cnt++;
		}
		sb.append(cnt).append("\n").append(melt);
		System.out.println(sb);
	}

}
