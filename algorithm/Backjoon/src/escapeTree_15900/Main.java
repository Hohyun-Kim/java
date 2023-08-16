package escapeTree_15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static ArrayList<Integer>[] edges;
	
	public static int res = 0;
	
	public static void dfs(int now, int depth, boolean[] visit) {
		
		visit[now] = true;
		ArrayList<Integer> edge = edges[now];
		if(edge.size() == 1 && visit[edge.get(0)]) {
			res += depth;
			return;
		}
		
		for(int i = 0; i < edge.size(); i++) {
			if(!visit[edge.get(i)]) {
				dfs(edge.get(i), depth+1, visit);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		boolean[] visit = new boolean[N+1];
		int n1;
		int n2;
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			edges[n1].add(n2);
			edges[n2].add(n1);
		}
		
		dfs(1, 0, visit);
		String ans = res%2==0? "No":"Yes";
		System.out.println(ans);

	}

}
