package deliverChicken_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static class place{
		public int row;
		public int col;
		public place(int row, int col) {
			this.row = row;
			this.col = col;
		}		
	}
	
	public static void swap(int[] comb, int i, int j) {
		int temp = comb[i];
		comb[i] = comb[j];
		comb[j] = temp;
	}
	
	public static boolean np(int[] comb, int num_bbq) {
		int i = num_bbq-1;
		while(i>0 && comb[i-1]>=comb[i]) i--;
		if(i==0) return false;
		int j = num_bbq-1;
		while(comb[i-1]>=comb[j]) j--;
		swap(comb, i-1, j);
		j = num_bbq-1;
		while(i<j) swap(comb, i++, j--);
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		ArrayList<place> bbq = new ArrayList<place>();
		ArrayList<place> house = new ArrayList<place>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) house.add(new place(r, c));
				if(map[r][c] == 2) bbq.add(new place(r, c));
			}
		}
		int num_bbq = bbq.size();
		int[] comb = new int[num_bbq];
		for(int i = 0; i < num_bbq && i < M; i++) {
			comb[num_bbq-1-i] = 1;
		}
		place now_house;
		int min = Integer.MAX_VALUE;
		do {
			int dist_sum = 0;
			int cnt = 0;
			for(int i = 0; i < house.size(); i++) {
				now_house = house.get(i);
				int dist = N*N;
				for(int j = 0; j < num_bbq; j++) {
					if(comb[j] == 1) {
						int now = Math.abs((now_house.row - bbq.get(j).row)) + Math.abs((now_house.col - bbq.get(j).col));
						if (dist > now) dist = now;
					}
				}
				dist_sum += dist;
				cnt++;
			}
			if (min > dist_sum) min = dist_sum;
			
		} while(np(comb, num_bbq));
		
		System.out.println(min);
		
	}

}
