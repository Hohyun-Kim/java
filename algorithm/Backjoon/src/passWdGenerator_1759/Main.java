package passWdGenerator_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void swap(int[] comb, int i, int j) {
		int temp = comb[i];
		comb[i] = comb[j];
		comb[j] = temp;
	}
	
	public static boolean NP(int[] comb, int C) {
		int i = C-1;
		while(i>0 && comb[i-1]>=comb[i]) i--;
		if(i == 0) return false;
		int j = C-1;
		while(comb[i-1]>=comb[j]) j--;
		swap(comb, i-1, j);
		j = C-1;
		while(i<j) swap(comb, i++, j--);
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		char[] chars = new char[C];
		int[] comb = new int[C];
		for(int i = 0; i < C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		for(int i = 0; i < C-L; i++) {
			comb[C-1-i] = 1;
		}
		Arrays.sort(chars);
		boolean has_consonant;
		boolean has_vowel;
		int cnt;
		int idx;
		char[] res = new char[L];
		do {
			cnt = 0;
			idx = 0;
			has_consonant = false;
			has_vowel = false;
			for(int i = 0; i < C; i++) {
				if(comb[i] == 0) {
					res[idx] = chars[i];
					if(res[idx] == 'a' || res[idx] == 'e' || res[idx] == 'i' || res[idx] == 'o' || res[idx] == 'u') {
						has_vowel = true;
					} else {
						cnt++;
					}
					idx++;
				}
			}
			if(cnt >= 2) has_consonant = true;
			if(has_consonant && has_vowel) {
				for(int i = 0; i < L; i++) {
					sb.append(res[i]);
				}
				sb.append("\n");
			}
		} while(NP(comb, C));
		System.out.println(sb);
	}
}
