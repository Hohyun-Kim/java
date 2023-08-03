package omaenoGPA_25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double pts = 0;
		String rank = "";
		double sum = 0;
		double total = 0;
		for (int i = 0; i < 20; i++) {
			try {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				pts = (double)(Integer.parseInt(st.nextToken().substring(0, 1)));
				double now = 0;
				boolean pass = false;
				rank = st.nextToken();
				switch (rank.charAt(0)) {
				case 'A':
					now = 4.0;
					break;
				case 'B':
					now = 3.0;
					break;
				case 'C':
					now = 2.0;
					break;
				case 'D':
					now = 1.0;
					break;
				case 'P':
					pass = true;
				default :
					break;
				}
				if (pass) continue;
				if (rank.length() == 2) {
					if (rank.charAt(1) == '+') now += 0.5;
				}
				
				sum += pts * now;
				total += pts;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%.6f", (float)(sum/total));
	}

}
