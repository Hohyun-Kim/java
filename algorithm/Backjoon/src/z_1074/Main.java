package z_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken())+1;
		int C = Integer.parseInt(st.nextToken())+1;
		int L = (int) Math.pow(2, N);
		int target = (int) Math.pow(2, 2*N);
		int[] last = {L, L};
		int ans = 0;
		while(target > 4) {
			if(R > last[0]/2) {
				ans += target/2;
				R -= last[0];
			}
			target /= 4;
			if(C > last[1]/2) {
				ans += target;
				C -= last[1];
			}
			last[0] /= 2;
			last[1] /= 2;
		}
		ans += (R>1)? 2:0;
		ans += (C>1)? 1:0;
		System.out.println(ans);
	}
}
