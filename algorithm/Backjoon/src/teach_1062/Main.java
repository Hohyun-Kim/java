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
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (K < 5) {
			System.out.println(0);
			return;
		}
		String[] words = new String[N];
		String word;
		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			word = br.readLine();
			words[i] = word.substring(4, word.length()-4);
			seq[i] = i;
		}
		K -= 5;
		int cnt;
		int cnt_word;
		int max = 0;
		boolean pass;
		do {
			String now = "acint";
			cnt = 0;
			cnt_word = 0;
			pass = true;
			for(int i = 0; i < N; i++) {
				word = words[seq[i]];
				for(int j = 0; j < word.length(); j++) {
					if (!now.contains(word.subSequence(j, j+1))) {
						now += word.subSequence(j, j+1);
						cnt++;
						if(cnt>K) {
							pass = false;
							break;
						}
					}
				}
				if(!pass) break;
				cnt_word++;
			}
			if (max < cnt_word) max = cnt_word;
		} while(NP(seq, N));
		System.out.println(max);
	}
}
