package putBridge_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int[][] B = new int[31][31];
		for (int i = 0; i <= 30; i++) {
			for (int j = 0, end = i; j <= end; j++) {
				if (j == 0 || i==j) B[i][j] = 1;
				else B[i][j] = B[i-1][j-1] + B[i-1][j];
			}
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			sb.append(B[N][K]).append("\n");
		}
		System.out.println(sb);
	}

}
