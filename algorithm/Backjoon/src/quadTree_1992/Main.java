package quadTree_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static int[][] map;
	public static StringBuffer sb = new StringBuffer();
	
	public static void encode(int sr, int sc, int size) {
		int sum = 0;
		for(int r = sr; r < sr+size; r++) {
			for(int c = sc; c < sc+size; c++) {
				sum += map[r][c];
			}
		}
		if(sum == 0) {
			sb.append(0);
			return;
		}
		if(sum == size*size) {
			sb.append(1);
			return;
		}
		int half = size/2;
		sb.append("(");
		encode(sr, sc, half);
		encode(sr, sc+half, half);
		encode(sr+half, sc, half);
		encode(sr+half, sc+half, half);
		sb.append(")");
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String row;
		map = new int[N][N];
		for(int r = 0; r < N; r++) {
			row = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = row.charAt(c) - '0';
			}
		}
		encode(0, 0, N);
		System.out.println(sb);
		
	}

}
