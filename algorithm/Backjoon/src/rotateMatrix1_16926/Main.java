package rotateMatrix1_16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public static int[] ans_init(int R, int s_r, int s_c, int N, int M) {
		
		int ans_r = s_r;
		int ans_c = s_c;
		int ans_d = 0;
		
		if (R < N) {
			ans_r = s_r + R;
			ans_d = 3;
		} else if (R >= N && R < N+M-1) {
			ans_r = s_r + (N-1);
			ans_c = s_c + R - (N-1);
			ans_d = 2;
		} else if (R >= N+M-1 && R < 2*N+M-2) {
			ans_r = s_r + (2*N+M-3 - R);
			ans_c = s_c + (M-1);
			ans_d = 1;
		} else {
			ans_c = s_c + 2*(N+M-2) - R;
			ans_d = 0;
		}
		int[] ans_rc = {ans_r, ans_c, ans_d};
		
		return ans_rc;
	}
	
	public static boolean in_range(int nr, int nc, int s_r, int s_c, int N, int M) {
		if (nr < s_r+N && nr >= s_r && nc < s_c+M && nc >= s_c) return true;
		return false;
	}
	
	public static void rotate_mat(int[][] map, int[][] ans, int R, int s_r, int s_c, int N, int M) {
		
		int[] ans_rcd = ans_init(R, s_r, s_c, N, M);
		int ans_r = ans_rcd[0];
		int ans_c = ans_rcd[1];
		int ans_d = ans_rcd[2];
		int s_d = 0;
		int s_nr = s_r;
		int s_nc = s_c;
		int cnt = 2*(N+M-2);
		while (cnt > 0) {
			ans[ans_r][ans_c] = map[s_nr][s_nc];
			
			if(!in_range(s_nr+dr[s_d], s_nc+dc[s_d], s_r, s_c, N, M)) {
				s_d = (s_d+1)%4;
			}
			s_nr += dr[s_d];
			s_nc += dc[s_d];
			
			if(!in_range(ans_r+dr[ans_d], ans_c+dc[ans_d], s_r, s_c, N, M)) {
				ans_d = (ans_d+1)%4;
			}
			ans_r += dr[ans_d];
			ans_c += dc[ans_d];
			
			cnt--;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] ans = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Math.min(N, M);
		int rotate;
		for (int i = 0; i < min/2; i++) {
			rotate = R%(2*(N+M-2-4*i));
			rotate_mat(map, ans, rotate, 0+i, 0+i, N-2*i, M-2*i);
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(ans[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
