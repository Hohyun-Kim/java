package hanaro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static island[] islands;
	static double E;
	
	public static class island {
		int x;
		int y;
		public island(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class tunnel implements Comparable<tunnel>{
		int island1;
		int island2;
		double cost;
		public tunnel(int island1, int island2) {
			this.island1 = island1;
			this.island2 = island2;
			this.cost = E * this.length();
		}
		public long length() {
			return (islands[island1].x - islands[island2].x)^2 + (islands[island1].y - islands[island2].y)^2;
		}
		@Override
		public int compareTo(tunnel o) {
			if(this.cost - o.cost <= 0) return -1;
			else return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			islands = new island[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				islands[i] = new island(x, y);
			}
			E = Double.parseDouble(br.readLine());
			tunnel[] tunnels = new tunnel[N*(N-1)/2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					tunnels[idx++] = new tunnel(i, j);
				}
			}
			boolean[] visit = new boolean[N];
			double[] minTunnel = new double[N];
			Arrays.fill(minTunnel, Double.MAX_VALUE);
			PriorityQueue<tunnel> pq = new PriorityQueue<>();
			minTunnel[0] = tunnels[0].cost;
			pq.offer(new tunnel)
			int cnt = 0;
			int start = 0;
			visit[start] = true;
			while() {
				
			}
		}
	}

}
