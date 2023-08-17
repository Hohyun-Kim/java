package bestPath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void swap(int[] seq, int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
	
	public static boolean NP(int[] seq, int N) {
		int i = N-1;
		while(i>0 && seq[i-1]>=seq[i]) i--;
		if(i==0) return false;
		int j = N-1;
		while(seq[i-1]>=seq[j]) j--;
		swap(seq, i-1, j);
		j = N-1;
		while(i<j) swap(seq, i++, j--);
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("./src/bestPath/input.txt"));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int[][] customers;
		int[] seq;
		int[] company = new int[2];
		int[] house = new int[2];
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			house[0] = Integer.parseInt(st.nextToken());
			house[1] = Integer.parseInt(st.nextToken());
			customers = new int[N][2];
			seq = new int[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 2; j++) {
					customers[i][j] = Integer.parseInt(st.nextToken());
				}
				seq[i] = i;
			}
			int[] now = new int[2];
			int distance;
			int min = Integer.MAX_VALUE;
			do {
				now = house;
				distance = 0;
				for(int i = 0; i < N; i++) {
					distance += Math.abs(customers[seq[i]][0]-now[0]) + Math.abs(customers[seq[i]][1]-now[1]);
					if(distance > min) break;
					now = customers[seq[i]];
				}
				distance += Math.abs(company[0]-now[0]) + Math.abs(company[1]-now[1]);
				if(min > distance) min = distance;
			} while(NP(seq, N));
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
