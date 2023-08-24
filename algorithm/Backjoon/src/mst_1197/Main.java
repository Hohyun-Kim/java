package mst_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	static int[] rank;
	static int[][] edgeList;

	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		if (rank[a] >= rank[b]) {
			parents[bRoot] = aRoot;
			if (rank[a] == rank[b]) {
				rank[a]++;
			}
		} else {
			parents[aRoot] = bRoot;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parents = new int[V];
		rank = new int[V];
		edgeList = new int[E][3];
		for (int v = 0; v < V; v++) {
			parents[v] = v;
			rank[v] = 0;
		}
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			edgeList[e][0] = Integer.parseInt(st.nextToken()) - 1;
			edgeList[e][1] = Integer.parseInt(st.nextToken()) - 1;
			edgeList[e][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edgeList, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int answer = 0;
		int cnt = 0;
		for (int e = 0; e < E; e++) {
			if (union(edgeList[e][0], edgeList[e][1])) {
				answer += edgeList[e][2];
				if (++cnt == V - 1)
					break;
			}
		}
		System.out.println(answer);
	}
}
