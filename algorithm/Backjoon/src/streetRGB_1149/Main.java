package streetRGB_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] RGB = new int[N][3];
		st = new StringTokenizer(br.readLine());
		for(int rgb = 0; rgb < 3; rgb++) {
			RGB[0][rgb] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int rgb = 0; rgb < 3; rgb++) {
				switch(rgb) {
				case 0:
					RGB[i][rgb] = Integer.parseInt(st.nextToken()) + Integer.min(RGB[i-1][1], RGB[i-1][2]);
					break;
				case 1:
					RGB[i][rgb] = Integer.parseInt(st.nextToken()) + Integer.min(RGB[i-1][0], RGB[i-1][2]);
					break;
				case 2:
					RGB[i][rgb] = Integer.parseInt(st.nextToken()) + Integer.min(RGB[i-1][0], RGB[i-1][1]);
					break;
				}
			}
		}
		int min = Integer.min(RGB[N-1][0], Integer.min(RGB[N-1][1], RGB[N-1][2]));
		System.out.println(min);
	}
}