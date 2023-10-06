package makeBridge2_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean wasland = false;
		boolean island = false;
		boolean bridge = false;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wasland = false;
			island = false;
			bridge = false;
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) island = false;
				else island = true;
				if (wasland&&!island) bridge = true;
				else if (!wasland&&island) bridge = false;
				if(bridge) map[i][j] = -1;
				wasland = island;
			}
		}
		
		for(int j = 0; j < M; j++) {
			wasland = false;
			island = false;
			bridge = false;
			for(int i = 0; i < N; i++) {
				if(map[i][j] == 0) island = false;
				else island = true;
				if (wasland&&!island) bridge = true;
				else if (!wasland&&island) bridge = false;
				if(bridge) map[i][j] = -1;
				wasland = island;
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		
	}
}
