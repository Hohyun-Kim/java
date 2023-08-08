package fourOpValidTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/fourOpValidTree/input.txt"));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			char[] opTree = new char[N+1];
			int idx;
			int ans = 1;
			if (N%2 == 0) {
				ans = 0;
				for (int i = 0; i < N; i++) {
					br.readLine();
				}
			} else {
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					idx = Integer.parseInt(st.nextToken());
					opTree[idx] = st.nextToken().charAt(0);
				}
				for (int i = 1; i < N+1; i++) {
					if (Character.isDigit(opTree[i])) {
						if (i*2 <= N) {
							ans = 0;
							break;
						}
					} else {
						if (i*2+1 > N) {
							ans = 0;
							break;
						}
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
	}

}
