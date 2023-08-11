package hamburgerDiet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int best;
	public static int N;
	public static int L;
	
	public static void calc_cal(int[][] ingredient, int start, int score, int cal) {
		
		if(start == N) {
			if (best < score) best = score;
			return;
		}
		
		if(cal+ingredient[start][1] <= L) {
			calc_cal(ingredient, start+1, score+ingredient[start][0], cal+ingredient[start][1]);
		} else {
			if (best < score) best = score;
		}
		calc_cal(ingredient, start+1, score, cal);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/hamburgerDiet/sample_input.txt"));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int[][] ingredient = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}
			best = 0;
			calc_cal(ingredient, 0, 0, 0);
			sb.append("#").append(t).append(" ").append(best).append("\n");
		}
		System.out.println(sb);
	}
}
