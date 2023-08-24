package contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] contact = new ArrayList[101];
			boolean[] visit = new boolean[101];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < 101; i++) {
				contact[i] = new ArrayList();
			}
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact[from].add(to);
			}
			Queue<Integer> q = new ArrayDeque<Integer>();
			q.offer(start);
			visit[start] = true;
			int from;
			int max = -1;
			ArrayList<Integer> tos;
			while(!q.isEmpty()) {
				int q_size = q.size();
				max = -1;
				for(int i = 0; i < q_size; i++) {
					from = q.poll();
					tos = contact[from];
					for (Integer to : tos) {
						if(!visit[to]) {
							visit[to] = true;
							q.add(to);
						}
					}
					if(max < from) max = from;
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
