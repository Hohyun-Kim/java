package teach_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void swap(int[] seq, int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
	
	public static boolean NP(int[] seq) {
		int i = 25;
		while(i>0 && seq[i-1]>=seq[i]) i--;
		if(i==0) return false;
		int j = 25;
		while(seq[i-1]>=seq[j]) j--;
		swap(seq, i-1, j);
		j = 25;
		while(i<j) swap(seq, i++, j--);
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (K < 5) {
			System.out.println(0);
			return;
		}
		if (K > 25) {
			System.out.println(N);
			return;
		}
		String word;
		int[] flags = new int[N];
		int[] comb = new int[26];
		for(int i = K; i > 0; i--) {
			comb[26-i] = 1;
		}
		for (int i = 0; i < N; i++) {
			int now_flag = 0;
			word = br.readLine();
			for(int j = 0; j < word.length(); j++) {
				now_flag |= 1<<(word.charAt(j)-'a');
			}
			flags[i] = now_flag;
		}
		int cnt_word;
		int max = 0;
		do {
			cnt_word = 0;
			int now_flag = 0;
			for(int i = 0; i < 26; i++) {
				if(comb[i] == 1) now_flag |= 1<<i;
			}
			for(int i = 0; i < N; i++) {
				if((now_flag | flags[i]) != now_flag) continue;
				cnt_word++;
			}
			if (max < cnt_word) max = cnt_word;
		} while(NP(comb));
		System.out.println(max);
	}
}
