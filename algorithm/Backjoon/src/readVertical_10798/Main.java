package readVertical_10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[][] word_list = new String[5][15];
		String now = "";
		String now_line = "";
		for (int row = 0; row < 5; row++) {
			try {
				now_line = br.readLine();
				for(int col = 0; col < now_line.length(); col++) {
					now = now_line.substring(col, col+1);
					word_list[row][col] = now;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (int col = 0; col < 15; col++) {
			for (int row = 0; row < 5; row++) {
				now = word_list[row][col];
				if (now == null) continue;
				System.out.print(now);
			}
		}
	}

}
