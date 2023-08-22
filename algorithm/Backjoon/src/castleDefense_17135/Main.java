package castleDefense_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void swap(int[] comb, int i, int j) {
		int temp = comb[i];
		comb[i] = comb[j];
		comb[j] = temp;
	}
	
	public static boolean NP(int[] comb, int N) {
		int i = N-1;
		while(i>0&&comb[i-1]>=comb[i])i--;
		if(i==0) return false;
		int j = N-1;
		while(comb[i-1]>=comb[j])j--;
		swap(comb, i-1, j);
		j = N-1;
		while(i<j) swap(comb, i++, j--);
		return true;
	}
	
	public static boolean in_range(int r, int c, int N, int M) {
		return r>=0 && r < N && c>=0 && c<M;
	}
	
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int[] comb = new int[M];
		for(int i = 0; i < 3; i++) {
			comb[M-1-i] = 1;
		}
		for(int i = N-1; i >= 0; i--) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		do {
			int[][] map_now = new int[N][M];
			for(int i = 0; i < N; i++) {
				map_now[i] = Arrays.copyOf(map[i], M);
			}
			int kill = 0;
			int archer_num = 0;
			int[] archers = new int[3];
			for(int i = 0; i < M; i++) {
				if(comb[i]==1) archers[archer_num++] = i;
				if(archer_num == 3) break;
			}
			for(int time = 0; time < N; time++) {
				int[][] targets = {{-1, -1}, {-1, -1}, {-1, -1}};
				for(int a_i = 0; a_i < 3; a_i++) {
					boolean shot = false;
					for(int d = 0; d < D; d++) {
						for(int dc = -d; dc <= d; dc++) {
							int r = time+d-(int)Math.abs(dc);
							int c = archers[a_i]+dc;
							
							if(in_range(r, c, N, M) && map_now[r][c] == 1) {
								targets[a_i][0] = r;
								targets[a_i][1] = c;
								shot = true;
								break;
							}
						}
						if(shot) break;
					}
				}
				for(int a_i = 0; a_i < 3; a_i++) {
					int t_r = targets[a_i][0];
					int t_c = targets[a_i][1];
					if(in_range(t_r, t_c, N, M) && map_now[t_r][t_c] == 1) {
						kill++;
						map_now[t_r][t_c] = 0;
					}
				}
			}
			if(max < kill) max = kill;
		} while(NP(comb, M));
		System.out.println(max);
	}

}