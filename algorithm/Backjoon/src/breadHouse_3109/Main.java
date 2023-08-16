package breadHouse_3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int R;
	public static int C;
	public static boolean[][] map;
	public static boolean success;
	
	public static int[] dr = {-1, 0, 1};
	
	public static boolean in_range(int nr) {
		return nr>=0 && nr<R;
	}
	
	public static void find_way(int nr, int nc) {
		map[nr][nc] = true;
		if(nc == C-1) {
			success = true;
			return;
		}
		for(int d = 0; d < 3; d++) {
			if(in_range(nr+dr[d])&&!map[nr+dr[d]][nc+1]) {
				find_way(nr+dr[d], nc+1);
				if(success) return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		String row;
		for(int r = 0; r < R; r++) {
			row = br.readLine();
			for(int c = 0; c < C; c++) {
				if(row.charAt(c) == 'x') map[r][c] = true;
			}
		}
		int cnt = 0;
		for(int r = 0; r < R; r++) {
			success = false;
			find_way(r, 0);
			if(success) cnt++;
		}
		System.out.println(cnt);
	}
}
