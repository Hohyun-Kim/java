package paintChess_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, min;
	static char[][] origin;
	static char[] color = {'B', 'W'};
	
	public static void check_map(int r_start, int c_start, int color_idx) {
		int r_final = r_start+8;
		int c_final = c_start+8;
		char first = color[color_idx];
		int cnt = 0;
		for(int r = r_start; r < r_final; r++) {
			char now = (r-r_start)%2==0? (first=='B'? 'B':'W'): (first=='B'? 'W':'B');
			for(int c = c_start; c < c_final; c++) {
				cnt += (c-c_start)%2==0? (origin[r][c]==now? 0:1): (origin[r][c]==now? 1:0);
				if(cnt >= min) return;
			}
		}
		if(cnt < min) min = cnt;
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		origin = new char[R][C];
		for(int r = 0; r < R; r++) {
			origin[r] = br.readLine().toCharArray();
		}
		min = Integer.MAX_VALUE;
		for(int r = 0; r < R-7; r++) {
			for(int c = 0; c < C-7; c++) {
				for(int i = 0; i < 2; i++) {
					check_map(r, c, i);
				}
				if(min == 0) break;
			}
			if(min == 0) break;
		}
		System.out.println(min);
	}

}
