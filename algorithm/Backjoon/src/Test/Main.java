package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] basket = new int[N+1];
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int n = i; n <= j; n++) {
				basket[n] = k;
			}
		}
		for(int i = 1; i <= N; i++) {
			sb.append(basket[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}

//2
//6 7
//#######
//##.##.#
//#...#O#
//#R....#
//#B....#
//#######

//3
//6 7
//#######
//##.##.#
//#B..#O#
//#R....#
//#.....#
//#######

//4
//6 7
//#######
//##.##.#
//#..B#O#
//#....R#
//#.....#
//#######