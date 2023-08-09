package colorPaper_2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int bitCount(int n) {
		if (n==0) return 0;
		return n%2 + bitCount(n/2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] ans = new int[100][10];
		int N = Integer.parseInt(br.readLine());
		int r, c, c_remainder, c_share;
		int[] c_index = new int[2];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			c_remainder = c%10;
			c_share = c/10;
			c_index[0] = c_share;
			if (c%10 == 0) c_index[1] = -1;
			else c_index[1] = c_share+1;
			for(int i = r; i < r+10; i++) {
				for(int j = c_remainder; j < 10; j++) {
					ans[i][c_index[0]] |= 1<<j;
				}
				if (c_index[1]!=-1) {
					for(int j = 0; j < c_remainder; j++) {
						ans[i][c_index[1]] |= 1<<j;
					}
				}
			}
		}
		int area = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 10; j++) {
				area += bitCount(ans[i][j]);
			}
		}
		System.out.println(area);
	}
}
