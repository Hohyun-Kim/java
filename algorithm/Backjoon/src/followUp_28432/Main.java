package followUp_28432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int len = 0;
		int i_q = 0;
		String[] words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
			sb.append(words[i]);
			len += words[i].length();
			if(words[i].equals("?")) {
				i_q = len-1;
			}
		}
		char first = ' ';
		char last = ' ';
		if(i_q != 0) first = sb.toString().charAt(i_q-1);
		if(i_q != len-1) last = sb.toString().charAt(i_q+1);
		
		int M = Integer.parseInt(br.readLine());
		boolean pass_dup = false;
		boolean pass_first = false;
		boolean pass_last = false;
		
		String[] answers = new String[M];
		String answer="";
		for(int i = 0; i < M; i++) {
			answers[i] = br.readLine();
		}
		if (first == ' ') {
			pass_first = true;
		}
		if (last == ' ') {
			pass_last = true;
		}
		for (String string : answers) {
			pass_dup = false;
			if(!pass_first) {
				if (string.charAt(0) != first ) {
					continue;
				}
			}
			if(!pass_last) {
				if (string.charAt(string.length()-1) != last) {
					continue;
				}
			}
			for (String dup : words) {
				if (dup.equals(string)) {
					pass_dup = true;
					break;
				}
			}
			if(pass_dup) {
				continue;
			}
			answer = string;
			break;
		}
		System.out.println(answer);

	}

}
