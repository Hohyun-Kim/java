package find_1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String T;
	static String P;
	static int[] p;
	static int pLength;
	
	static void make_p() {
		int i = 1;
		int j = 0;
		p[0] = 0;
		while(i < pLength) {
			if(P.charAt(i) == P.charAt(j)) {
				j++;
				p[i] = j;
			} else {
				if(j != 0) {
					j = p[j-1];
					continue;
				}
			}
			i++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		T = br.readLine();
		P = br.readLine();
		pLength = P.length();
		int T_len = T.length();
		p = new int[pLength];
		int[] find = new int[T_len];
		make_p();
		int i = 0;
		int j = 0;
		int cnt = 0;
		while(i < T_len) {
			if(T.charAt(i) == P.charAt(j)) {
				j++;
			} else {
				if(j != 0) {
					j = p[j-1];
					continue;
				}
			}
			i++;
			if(j == pLength) {
				find[cnt++] = i-pLength+1;
				j = p[j-1];
			}
		}
		sb.append(cnt).append("\n");
		for(int k = 0; k < cnt; k++) {
			sb.append(find[k]).append(" ");
		}
		System.out.println(sb);
	}
}
