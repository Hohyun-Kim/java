package connectProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map;
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int max_core;
	static int min_len;
	static ArrayList<core> coreList;
	static int coreList_size;
	static int test_case;
	
	
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
			map[nr][nc] = 2;
			nr += dr[d];
			nc += dc[d];
			now_len++;
		}
		return new int[]{nr-dr[d], nc-dc[d], now_len};
	}
	
	public static void removeLine(int row, int col, int d) {
		int nr = row;
		int nc = col;
		while(in_range(nr, nc) && map[nr][nc] == 2) {
			map[nr][nc] = 0;
			nr -= dr[d];
			nc -= dc[d];
		}
	}
	
	public static void connectLine(int cnt, int len, int num_core) {
		
		if(cnt == coreList_size) {
			if (num_core > max_core) {
				max_core = num_core;
				min_len = len;
			} else if (num_core == max_core) {
				if (min_len > len) min_len = len;
			}
			return;
		}
		
		if(num_core + coreList_size - cnt < max_core) return;
		
		int row = coreList.get(cnt).row;
		int col = coreList.get(cnt).col;
		for(int d = 0; d < 4; d++) {
			int[] line = putLine(row, col, d);
			int nr = line[0];
			int nc = line[1];
			int now_len = line[2];
			if(is_edge(nr, nc)) {
				connectLine(cnt+1, len+now_len, num_core+1);
			}
			removeLine(nr, nc, d);
		}
		connectLine(cnt+1, len, num_core);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int t = 1; t <= T; t++) {
			test_case = t;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) {
						if(!is_edge(r, c)) coreList.add(new core(r, c));
					}
				}
			}
			coreList_size = coreList.size();
			max_core = 0;
			min_len = Integer.MAX_VALUE;
			connectLine(0, 0, 0);
			sb.append("#").append(t).append(" ").append(min_len).append("\n");
		}
		System.out.println(sb);
	}

}
