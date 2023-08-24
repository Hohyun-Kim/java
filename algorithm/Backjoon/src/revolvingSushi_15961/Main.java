package revolvingSushi_15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, d, k, c;
	
	static class sushiManager {
		int[] Dish = new int[d];
		int max = 0;
		int numKind = 0;
		int coupon = c;
		boolean[] have = new boolean[d];
		public void put(int sushi) {
			if(have[sushi]) {
				Dish[sushi]++;
			} else {
				have[sushi] = true;
				Dish[sushi]++;
				numKind++;
			}
		}
		public void remove(int sushi) {
			if(--Dish[sushi] == 0) {
				have[sushi] = false;
				numKind--;
			}
		}
		public void setMax() {
			int realNumKind = have[coupon]? numKind-1 : numKind;
			if(max < realNumKind) max = realNumKind;
		}
		public boolean haveBest() {
			return max == k;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken())-1;
		int[] sushi = new int[N];
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine())-1;
		}
		sushiManager mySushi = new sushiManager(); 
		for(int i = 0; i < k; i++) {
			mySushi.put(sushi[i]);
		}
		mySushi.setMax();
		int start = 0;
		int end = k-1;
		while(start < N) {
			if(mySushi.haveBest()) break;
			if(++end == N) end = 0;
			mySushi.put(sushi[end]);
			mySushi.remove(sushi[start++]);
			mySushi.setMax();
		}
		System.out.println(mySushi.max+1);
	}
}
