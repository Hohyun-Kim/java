package laboratory_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[] map;
	static int N;
	static int M;
	static int total;
	static int[] dr;
	static int[] dc = {0, 1, 0, -1};
	static List<Integer> init_virus = new ArrayList<>();
	static int len_virus;
	static int len_blank;
	static List<Integer> init_blank = new ArrayList<>();
	static long init_visit = 0;
	static final long one_bit = 1;
	static int max = Integer.MIN_VALUE;
	
	static boolean in_range(int next, int nc) {
		return next < total && nc < M && next >= 0 && nc >= 0;
	}
	
	static void make_wall (int start, long visit, int cnt) {
		if(cnt == 3) {
			virus_spread(visit);
			return;
		}
		
		for(int i = start; i < len_blank; i++) {
			make_wall(i+1, visit|(one_bit<<init_blank.get(i)), cnt+1);
		}
	}
	
	static void virus_spread(long visit) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = 0; i < len_virus; i++) {
			q.offer(init_virus.get(i));
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int d = 0; d < 4; d++) {
				int next = now + dr[d] + dc[d];
				if((visit & one_bit<<next) != 0) continue;
				int nc = now%M + dc[d];
				if(in_range(next, nc)) {
					visit |= one_bit<<next;
					q.offer(next);
				}
			}
		}
		int safe = (total-Long.bitCount(visit));
		if(max < safe) {
			max = safe;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		total = N*M;
        dr = new int[]{-M, 0, M, 0};
		map = new char[total];
		int idx = 0;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				idx = M*r+c;
				map[idx] = st.nextToken().charAt(0);
				switch(map[idx]) {
				case '2':
					init_virus.add(idx);
				case '1':
					init_visit |= one_bit<<(idx);
					break;
				case '0':
					init_blank.add(idx);
					break;
				}
			}
		}
		len_virus = init_virus.size();
		len_blank = init_blank.size();
		make_wall(0, init_visit, 0);
		
		System.out.println(max);
	}

}

