package pooling222_17829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int pooling_core(int sr, int sc, int[][] map) {
		int[] num = new int[4];
		int idx = 0;
		for(int r = sr; r < sr+2; r++) {
			for(int c = sc; c < sc+2; c++) {
				num[idx++] = map[r][c];
			}
		}
		Arrays.sort(num);
		return num[2];
	}
	
	public static int pooling222(int N, int sr, int sc, int[][] map) {
		if(N == 2) {
			return pooling_core(sr, sc, map);
		};
		int half = N/2;
		int[][] new_map = new int[2][2];
		new_map[0][0] = pooling222(half, sr, sc, map);
		new_map[0][1] = pooling222(half, sr, sc+half, map);
		new_map[1][0] = pooling222(half, sr+half, sc, map);
		new_map[1][1] = pooling222(half, sr+half, sc+half, map);
		return pooling_core(0, 0, new_map);		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] featureMap = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				featureMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(pooling222(N, 0, 0, featureMap));
	}
}
