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
		public double length() {
			return Math.pow((double)(islands[island1].x - islands[island2].x), 2) + Math.pow((double)(islands[island1].y - islands[island2].y), 2);
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
			st = new StringTokenizer(br.readLine());
			int[] x = new int[N];
			int[] y = new int[N];
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
				islands[i] = new island(x[i], y[i]);
			}
			E = Double.parseDouble(br.readLine());
			boolean[] visit = new boolean[N];
			double[] minTunnel = new double[N];
			Arrays.fill(minTunnel, Double.MAX_VALUE);
			PriorityQueue<tunnel> pq = new PriorityQueue<>();
			pq.offer(new tunnel(0, 0));
			minTunnel[0] = 0;
			double cost_sum = 0;
			int cnt = 0;
			int minIsland = 0;
			while (true) {
				tunnel cur = pq.poll();
				if(visit[cur.island1] && visit[cur.island2]) continue;
				minIsland = visit[cur.island1]? cur.island2:cur.island1;
				visit[minIsland] = true;
				cost_sum += cur.cost;
				if(++cnt==N) break;
				for (int i = 0; i < N; i++) {
					tunnel now = new tunnel(minIsland, i);
					if(!visit[i] && minTunnel[i] > now.cost) {
						minTunnel[i] = now.cost;
						pq.offer(now);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(Math.round(cost_sum)).append("\n");
		}
		System.out.println(sb);
	}

}
