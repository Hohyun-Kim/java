package set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int[] parents;
	
	public static StringBuffer sb = new StringBuffer();
	
	public static void setAct(int op, int a, int b) {
		switch (op) {
		case 0:
			union(a, b);
			break;
		case 1:
			if(find(a) == find(b)) sb.append(1);
			else sb.append(0);
			break;
		}
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		parents[bRoot] = aRoot;
		return;
	}
	
	public static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			for(int i = 1; i < N+1; i++) {
				parents[i] = i;
			}
			int M = Integer.parseInt(st.nextToken());
			int op;
			int a;
			int b;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				op = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				setAct(op, a, b);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
