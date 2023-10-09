package makeBridge2_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] bridge_Matrix;
	static int num_island = 0;
	static int all_check;
	
	static class bridge implements Comparable<bridge> {
		int toisland;
		int length;
		public bridge(int toisland, int length) {
			this.toisland = toisland;
			this.length = length;
		}
		@Override
		public int compareTo(bridge o) {
			return this.length - o.length;
		}
	}
	
	static boolean in_range(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
	
	public static void find_island() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(!visited[r][c]) {
					if(map[r][c] == 1) {
						num_island++;
						visited[r][c] = true;
						map[r][c] = num_island;
						mark_island(r, c, num_island);
					}
				}
			}
		}
		all_check = (1<<num_island+1)-1;
	}
	
	public static void mark_island(int r, int c, int id) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(in_range(nr, nc) && map[nr][nc] != 0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				map[nr][nc] = id;
				mark_island(nr, nc, id);
			}
		}
	}
	
	public static void init_bridge() {
		bridge_Matrix = new int[num_island+1][num_island+1];
		for(int i = 1; i <= num_island; i++) {
			Arrays.fill(bridge_Matrix[i], Integer.MAX_VALUE);
		}
	}
	
	public static void make_bridge(boolean horizontal) {
		int outer = horizontal? N:M;
		int inner = horizontal? M:N;
		int island1;
		int island2;
		int length;
		int icnt;
		boolean wasland;
		boolean island;
		boolean bridge;
		for(int i = 0; i < outer; i++) {
			island1 = -1;
			island2 = -1;
			icnt = 0;
			length = 0;
			wasland = false;
			island = false;
			bridge = false;
			for(int j = 0; j < inner; j++) {
				int now = horizontal? map[i][j]:map[j][i];
				if(now == 0) island = false;
				else island = true;
				if (wasland&&!island) bridge = true;
				else if (!wasland&&island) {
					icnt++;
					if(icnt==1) island1 = now;
					else if(icnt==2) {
						island2 = now;
						if(bridge_Matrix[island1][island2] > length && length!=1) {
							bridge_Matrix[island1][island2] = length;
							bridge_Matrix[island2][island1] = length;
						}
						length = 0;
						icnt--;
						island1 = now;
					}
					bridge = false;
				}
				if(bridge) length++;
				wasland = island;
			}
		}
	}
	
	public static int find_bridge() {
		PriorityQueue<bridge> pq = new PriorityQueue<>();
		int check = 1;
		int[] shortestLength = new int[num_island+1];
		Arrays.fill(shortestLength, Integer.MAX_VALUE);
		shortestLength[1] = 0;
		pq.add(new bridge(1, 0));
		int sum = 0;
		while(!pq.isEmpty()) {
			bridge now = pq.poll();
			int from = now.toisland;
			if((check & 1<<from) != 0) continue;
			check |= 1<<from;
			sum += now.length;
			if(check == all_check) return sum;
			for(int to = 1; to <= num_island; to++) {
				if((check & 1<<to) == 0 && bridge_Matrix[from][to] != Integer.MAX_VALUE && shortestLength[to] > bridge_Matrix[from][to]) {
					shortestLength[to] = bridge_Matrix[from][to];
					pq.add(new bridge(to, shortestLength[to]));
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find_island();
		init_bridge();
		make_bridge(true);
		make_bridge(false);
		System.out.println(find_bridge());
		
	}
}
