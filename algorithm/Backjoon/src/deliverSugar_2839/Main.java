package deliverSugar_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int s_3;
		int s_5 = N/5;
		int remain;
		int min = Integer.MAX_VALUE;
		boolean deliver = false;
		
		while (true) {
			if (s_5 == -1) break;
			remain = N-5*s_5;
			if (remain%3 == 0) {
				deliver = true;
				s_3 = remain/3;
				min = s_5+s_3;
				break;
			}
			s_5--;
		}
		if(deliver) System.out.println(min);
		else System.out.println(-1);
	}
	
}
