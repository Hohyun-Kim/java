package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			sum += a * Integer.parseInt(st.nextToken());
		}
		System.out.println(X==sum?"Yes":"No");
	}

}
