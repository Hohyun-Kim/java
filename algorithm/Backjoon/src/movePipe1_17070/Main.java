package movePipe1_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][][] map = new int[N][N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) map[i][j][0] = -1;
			}
		}
		for(int c = 2; c < N; c++) {
			if(map[0][c][0] == -1) break;
			map[0][c][0] = 1;
		}
		if(map[0][2][0] != -1 && map[1][2][0] != -1 && map[1][1][0] != -1) {
			map[1][2][1] = 1;
			for(int r = 2; r < N; r++) {
				if(map[r][2][0] == -1) break;
				map[r][2][2] = 1;
			}
		}
		for(int r = 1; r < N; r++) {
			for(int c = 3; c < N; c++) {
				if(map[r][c][0] == -1) continue;
				for(int d = 0; d < 3; d++) {
					switch(d) {
					case 0:
						map[r][c][d] = map[r][c-1][0]!=-1?map[r][c-1][0]+map[r][c-1][1]:0;
						break;
					case 1:
						if(map[r][c-1][0] == -1 || map[r-1][c][0] == -1) break;
						map[r][c][d] = map[r-1][c-1][0]!=-1?map[r-1][c-1][0]+map[r-1][c-1][1]+map[r-1][c-1][2]:0;
						break;
					case 2:
						map[r][c][d] = map[r-1][c][0]!=-1?map[r-1][c][1]+map[r-1][c][2]:0;
						break;
						
					}
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 3; i++) {
			if(map[N-1][N-1][0] == -1) break;
			answer += map[N-1][N-1][i];
		}
		System.out.println(answer);
	}
}
