package rotateMatrix3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static int N;
	public static int M;
	public static int[][] map;
	
	public static void rotate1() {
		int[][]	temp = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				temp[r][c] = map[N-1-r][c];
			}
		}
		map = temp;		
	}
	public static void rotate2() {
		int[][]	temp = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				temp[r][c] = map[r][M-1-c];
			}
		}
		map = temp;
	}
	public static void rotate3() {
		int[][]	temp = new int[M][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				temp[c][N-1-r] = map[r][c];
			}
		}
		map = temp;
	}
	public static void rotate4() {
		int[][]	temp = new int[M][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				temp[M-1-c][r] = map[r][c];
			}
		}
		map = temp;
	}
	public static void rotate5() {
		int[][]	temp = new int[N][M];
		for (int t_r = 0; t_r < 2; t_r++) {
			for (int t_c = 0; t_c < 2; t_r++) {
				for (int r = t_r*N/2; r < (t_r+1)*N/2; r++) {
					for (int c = t_c*M/2; c < (t_c+1)*M/2; c++) {
						if (t_r == 0 && t_c == 0) {
							temp[r][c+N/2] = map[r][c];
							return;
						}
						if (t_r == 0 && t_c == 1) {
							temp[r+N/2][c] = map[r][c];
							return;
						}
						if (t_r == 1 && t_c == 0) {
							temp[r-N/2][c] = map[r][c];
							return;
						}
						if (t_r == 1 && t_c == 1) {
							temp[r][c-N/2] = map[r][c];
							return;
						}
					}
				}
			}
		}
		map = temp;		
	}
	public static void rotate6() {
		
	}
	
	public static void rotate(int op) {
		switch(op) {
		case 1:
			rotate1();
			break;
		case 2:
			rotate2();
			break;
		case 3:
			rotate3();
			break;
		case 4:
			rotate4();
			break;
		case 5:
			rotate5();
			break;
		case 6:
			rotate6();
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			rotate(Integer.parseInt(st.nextToken()));
		}
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
