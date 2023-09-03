package gcdlcm_2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = a;
		int y = b;
		int z = x%y;
		int gcd = 1;
		while(z != 0) {
			x = y;
			y = z;
			z = x%y;
		}
		gcd = y;
		int lcm = a * b / gcd;
		sb.append(gcd).append("\n").append(lcm);
		System.out.println(sb);
	}

}
