package connectProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map;
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int max_core;
	static int min_len;
	static ArrayList<core> coreList;
	
	
	static boolean is_edge(int r, int c) {
		return r == 0 || r == N-1 || c == 0 || c == N-1;
	}
	
	static boolean in_range(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N ;
	}
	
	static class core {
		int row;
		int col;
		public core(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static int[] putLine(int row, int col, int d) {
		int now_len = 0;
		int nr = row + dr[d];
		int nc = col + dc[d];
		while(in_range(nr, nc) && map[nr][nc] == 0) {
			map[nr][nc] = 1;
			now_len++;
		}
		return new int[]{nr, nc, now_len};
	}
	
	public static void removeLine(int row, int col, int d) {
		int nr = row + dr[d];
		int nc = col + dc[d];
		while(in_range(nr, nc) && map[nr][nc] == 1) {
			map[nr][nc] = 0;
		}
	}
	
	public static void connectLine(int cnt, int len, int flag, int num_core) {
		
		if(cnt == coreList.size()) {
			if (len < min_len) min_len = len;
			if (num_core > max_core) max_core = num_core;
			return;
		}
		
		if(num_core + coreList.size() - cnt < max_core) return;
		
		for(int i = 0; i < coreList.size(); i++) {
			if((flag & 1<<i) == 0) {
				int row = coreList.get(i).row;
				int col = coreList.get(i).col;
				boolean able = false;
				for(int d = 0; d < 4; d++) {
					int[] line = putLine(row, col, d);
					int nr = line[0];
					int nc = line[1];
					int now_len = line[2];
					if(is_edge(nr, nc)) {
						able = true;
						connectLine(cnt+1, len+now_len, flag|1<<i, num_core+1);
					}
					removeLine(row, col, d);
				}
				if(!able) connectLine(cnt+1, len, flag, num_core);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) {
						if(!is_edge(r, c)) coreList.add(new core(r, c));
						map[r][c] = 2;
					}
				}
			}
			int[] seq = new int[coreList.size()];
			for(int i = 0; i < coreList.size(); i++) {
				seq[i] = i;
			}
			max_core = 0;
			min_len = 0;
			connectLine(0, 0, 0, 0);
			sb.append("#").append(t).append(" ").append(min_len).append("\n");
		}
		System.out.println(sb);
	}

}
