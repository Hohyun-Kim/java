package clockOven_2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C =  Integer.parseInt(br.readLine());
		int C_min = C%60;
		int C_hour = C/60;
		int adder = B+C_min > 59? 1:0;
		B = (B+C_min)%60;
		A = (A+C_hour+adder)%24;
		sb.append(A).append(" ").append(B);
		System.out.println(sb);
	}

}
