package cutLanLine_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] lans = new int[K];
		int cutLength = 0;
		int upperBound = Integer.MIN_VALUE;
		int lowerBound = 1;
		for(int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			if(upperBound < lans[i]) {
				upperBound = lans[i];
			}
		}
		cutLength = (upperBound + lowerBound)/2;
		int numLan = 0;
		while(true) {
			numLan = 0;
			for(int i = 0; i < K; i++) {
				numLan += lans[i]/cutLength;
			}
			if (numLan == N) break;
			else if (numLan < N) {
				upperBound = cutLength;
			} else if (numLan > N) {
				lowerBound = cutLength;
			}
			cutLength = (upperBound+lowerBound)/2;
		}
		while (numLan == N) {
			numLan = 0;
			cutLength++;
			for(int i = 0; i < K; i++) {
				numLan += lans[i]/cutLength;
			}
			System.out.println(cutLength);
		}
		System.out.println(cutLength-1);
	}
}
