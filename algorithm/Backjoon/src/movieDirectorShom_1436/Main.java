package movieDirectorShom_1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int i = 665;
		while(cnt < N) {
			i++;
			if(Integer.toString(i).contains("666")) cnt++;
		}
		
		System.out.println(i);
	}

}
