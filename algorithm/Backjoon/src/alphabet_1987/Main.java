package alphabet_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int R;
	public static int C;
	public static char[][] map;
	public static int max = 1;
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public static boolean in_range(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
	
	public static void find_best(int r, int c, int flag, int cnt){
		if(cnt > max) {
			max = cnt;
		}
		flag |= 1<<(map[r][c]-'A');
		for(int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(in_range(nr, nc) && ((flag&(1<<(map[nr][nc]-'A')))==0)) {
				find_best(nr, nc, flag, cnt+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int flag = 0;
		String row;
		for(int r = 0; r < R; r++) {
			row = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = row.charAt(c);
			}
		}
		find_best(0, 0, 0, 1);
		System.out.println(max);

	}

}
