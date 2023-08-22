package jumpKingJelly_16174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] map;
	public static boolean[][] visit;
	public static int N;
	public static int[] dr = {0, 1};
	public static int[] dc = {1, 0};
	public static boolean success = false;
	
	public static boolean in_range(int nr, int nc) {
		return nr < N && nc < N;
	}
	
	public static void find_way(int r, int c) {
		
		visit[r][c] = true;
		
		if(r==N-1 && c==N-1) {
			success = true;
			return;
		}
		
		for(int d = 0; d < 2; d++) {
			int nr = r+map[r][c]*dr[d];
			int nc = c+map[r][c]*dc[d];
			if(in_range(nr, nc) && !visit[nr][nc]) find_way(nr, nc);
			if(success) return;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		find_way(0, 0);
		if(success) System.out.println("HaruHaru");
		else System.out.println("Hing");
		
	}

}
