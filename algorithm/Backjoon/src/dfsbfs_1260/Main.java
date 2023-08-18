package dfsbfs_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[][] AdjacentMatrix;
	
	public static boolean[] visit_DFS;
	
	public static boolean[] visit_BFS;
	
	public static int N;
	
	public static StringBuffer sb = new StringBuffer();
	
	public static void DFS(int r) {
		sb.append(r+1).append(" ");
		visit_DFS[r] = true;
		for(int c = 0; c < N; c++) {
			if(AdjacentMatrix[r][c] && !visit_DFS[c]) {
				DFS(c);
			}
		}
	}
	
	public static void BFS(int r) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		visit_BFS[r] = true;
		q.offer(r);
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+1).append(" ");
			for(int c = 0; c < N; c++) {
				if(AdjacentMatrix[now][c] && !visit_BFS[c]) {
					visit_BFS[c] = true;
					q.offer(c);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		AdjacentMatrix = new boolean[N][N];
		visit_DFS = new boolean[N];
		visit_BFS = new boolean[N];
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			AdjacentMatrix[i][j] = true;
			AdjacentMatrix[j][i] = true;
		}
		DFS(V-1);
		sb.append("\n");
		BFS(V-1);
		System.out.println(sb);
	}

}
