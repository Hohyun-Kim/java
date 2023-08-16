package worldCup_6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] answer = new int[4];
	
	public static void swap(int[] seq, int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
	
	public static boolean NP(int[] seq, int N) {
		int i = N-1;
		while(i>0 && seq[i-1] >= seq[i]) i--;
		if(i==0) return false;
		int j = N-1;
		while(seq[i-1] >= seq[j]) j--;
		swap(seq, i-1, j);
		j = N-1;
		while(i<j) swap(seq, i++, j--);
		
		return true;
	}
	
	public static void make_match(int[][] seq_mat, int[][] group, int idx, int[][][] match) {
		
		if(idx==15) {
			for(int i = 0; i < 4; i++) {
				if(answer[i] == 1) continue;
				int[][] group_in_match = match[i];
				boolean pass = true;
				for(int j = 0; j < 6; j++) {
					for(int k = 0; k < 3; k++) {
						if(group_in_match[j][k] != group[j][k]) {
							pass = false;
							break;
						}
					}
					if(!pass) break;
				}
				if(pass) answer[i] = 1;
			}
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			switch(i) {
			case 0:
				group[seq_mat[idx][0]][0]++;
				group[seq_mat[idx][1]][2]++;
				break;
			case 1:
				group[seq_mat[idx][0]][1]++;
				group[seq_mat[idx][1]][1]++;
				break;
			case 2:
				group[seq_mat[idx][0]][2]++;
				group[seq_mat[idx][1]][0]++;
				break;
			}
			make_match(seq_mat, group, idx+1, match);
			switch(i) {
			case 0:
				group[seq_mat[idx][0]][0]--;
				group[seq_mat[idx][1]][2]--;
				break;
			case 1:
				group[seq_mat[idx][0]][1]--;
				group[seq_mat[idx][1]][1]--;
				break;
			case 2:
				group[seq_mat[idx][0]][2]--;
				group[seq_mat[idx][1]][0]--;
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int[][][] match = new int[4][6][3];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				for(int k = 0; k < 3; k++) {
					match[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int[] comb = {0, 0, 0, 0, 1, 1};
		int[] seq = {0, 1, 2, 3, 4, 5};
		int[][] seq_mat = new int[15][2];
		int cnt = 0;
		do {
			int idx = 0;
			for(int i = 0; i < 6; i++) {
				if(comb[i] == 1) {
					seq_mat[cnt][idx++] = seq[i];
				}
			}
			cnt++;
			
		} while (NP(comb, 6));
		int[][] group = new int[6][3];
		
		make_match(seq_mat, group, 0, match);
		
		for(int i = 0; i < 4; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);

	}

}
