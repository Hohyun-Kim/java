package revolvingSushi_15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken())-1;
		int[] sushi = new int[N];
		int[] final_sushi_pos = new int[d];
		boolean[] eat = new boolean[d];
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine())-1;
		}
		int start = 0;
		int end = 0;
		int max = 0;
		final_sushi_pos[sushi[start]] = start;
		eat[sushi[start]] = true;
		while(start < N) {
			int now = end-start+1;
			if(end < start) now += N;
			int k_temp = eat[c]? now-1 : now;
			if(max < k_temp) max = k_temp;
			if(max == k) break;
			if(now == k) {
				eat[sushi[start++]] = false;
			}
			end++;
			if(end == N) end = 0;
			if(eat[sushi[end]]) {
				for(int i = start; i < final_sushi_pos[sushi[end]]; i++) {
					eat[sushi[i]] = false;
				}
				if(final_sushi_pos[sushi[end]] < start) break;
				start = final_sushi_pos[sushi[end]]+1;
			} else eat[sushi[end]] = true;
			final_sushi_pos[sushi[end]] = end;
			System.out.println("start : " + start + " end : " + end);
		}
		System.out.println(max+1);
	}

}
