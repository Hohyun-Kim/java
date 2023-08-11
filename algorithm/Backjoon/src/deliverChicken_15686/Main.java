package deliverChicken_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static class bbq{
		public int row;
		public int col;
		public bbq(int row, int col) {
			this.row = row;
			this.col = col;
		}		
	}	
	
	public static boolean np(int[] comb, int num_bbq) {
		int i = num_bbq-1;
		while(i>0 && comb[i-1]>=comb[i]) i--;
		if(i==0) return false;
		int j = num_bbq-1;
		while(comb[i-1]>=comb[j]) j--;
		comb[i-1] = 1 - comb[i-1];
		comb[j] = 1 - comb[j];
		j = num_bbq-1;
		while(i<j) {
			comb[i] = 1 - comb[i];
			comb[j] = 1 - comb[j];
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		ArrayList<bbq> bbqs = new ArrayList<bbq>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) bbqs.add(new bbq(r, c));
			}
		}
		int num_bbq = bbqs.size();
		int[] comb = new int[num_bbq];
		for(int i = 0; i < num_bbq && i < M; i++) {
			comb[num_bbq-1-i] = 1;
		}
		
		do {
			for(int i = 0; i < num_bbq; i++) {
				if(comb[i] == 1) {
					
				}
			}			
		} while(np(comb, num_bbq));
		
		

	}

}
