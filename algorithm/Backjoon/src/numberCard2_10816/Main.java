package numberCard2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int[] number_cnt = new int[20000001];
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			number_cnt[Integer.parseInt(st.nextToken())+10000000]++;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			sb.append(number_cnt[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		}
		System.out.println(sb);

	}

}
