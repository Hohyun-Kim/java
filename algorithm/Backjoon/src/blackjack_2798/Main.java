package blackjack_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] cards;
	
	public static void swap(int[] comb, int i, int j) {
		int temp = comb[i];
		comb[i] = comb[j];
		comb[j] = temp;
	}
	
	public static boolean NP(int[] comb) {
		int i = N-1;
		while(i>0 && comb[i-1] >= comb[i]) i--;
		if(i==0) return false;
		int j = N-1;
		while(comb[i-1] >= comb[j]) j--;
		swap(comb, i-1, j);
		j = N-1;
		while(i<j) swap(comb, i++, j--);
		return true;		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		cards = new int[N];
		for(int i = 0; i < N; i ++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		int[] comb = new int[N];
		for(int i = 0; i < 3; i++) {
			comb[N-1-i] = 1;
		}
		int min = Integer.MAX_VALUE;
		do {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(comb[i] == 1) {
					sum += cards[i];
				}
			}
			if(sum <= M && min > M-sum) {
				min = M-sum;
				if(min == 0) break;
			}
		} while(NP(comb));
		System.out.println(M-min);
	}

}
