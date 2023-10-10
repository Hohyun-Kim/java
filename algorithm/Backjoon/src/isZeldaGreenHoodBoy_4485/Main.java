package isZeldaGreenHoodBoy_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static boolean in_range(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
	
	static class thief implements Comparable<thief>{
		int r;
		int c;
		int steal;
		public thief(int r, int c, int steal) {
			this.r = r;
			this.c = c;
			this.steal = steal;
		}
		@Override
		public int compareTo(thief o) {
			return this.steal - o.steal;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int problem = 1;
		PriorityQueue<thief> pq;
		while(N != 0) {
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			dist = new int[N][N];
			for(int r = 0; r < N; r++) {
				Arrays.fill(dist[r], Integer.MAX_VALUE);
			}
			pq = new PriorityQueue<>();
			pq.offer(new thief(0, 0, map[0][0]));
			while(!pq.isEmpty()) {
				thief now = pq.poll();
				if(now.r == N-1 && now.c == N-1) break;
				visited[now.r][now.c] = true;
				for(int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if(in_range(nr, nc) && !visited[nr][nc] && dist[nr][nc] > now.steal + map[nr][nc]) {
						dist[nr][nc] = now.steal + map[nr][nc];
						pq.offer(new thief(nr, nc, dist[nr][nc]));
					}
				}
			}
			
			sb.append("Problem ").append(problem++).append(": ").append(dist[N-1][N-1]).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());
	}

}
