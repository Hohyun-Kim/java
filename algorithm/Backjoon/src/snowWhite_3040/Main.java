package snowWhite_3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[] hats;
	
	public static int answer = 0;
	
	public static void swap(int[] seq, int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
	
	public static boolean np(int[] seq) {
		int i = 8;
		while(i>0 && seq[i-1] >= seq[i]) i--;
		if(i==0) return false;
		int j = 8;
		while(seq[i-1] >= seq[j]) j--;
		swap(seq, i-1 , j);
		j = 8;
		while(i<j) swap(seq, i++, j--);
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		hats = new int[9];
		int[] seq = {0, 0, 1, 1, 1, 1, 1, 1, 1};
		for(int i = 0; i < 9; i++) {
			hats[i] = Integer.parseInt(br.readLine());
		}
		int sum;
		do {
			sum = 0;
			for (int i = 0; i < 9; i++) {
				if(seq[i]==1) sum += hats[i];
			}
			if(sum == 100) break;
		} while(np(seq));
		
		for(int i = 0; i < 9; i++) {
			if(seq[i]==1) sb.append(hats[i]).append("\n");
		}
		System.out.println(sb);
	}
}
