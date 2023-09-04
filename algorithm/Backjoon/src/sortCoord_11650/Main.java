package sortCoord_11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer(); 
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] numbers = new ArrayList[200001];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken())+100000;
			if(numbers[number] == null) {
				numbers[number] = new ArrayList<>();
			}
			numbers[number].add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < 200001; i++) {
			if(numbers[i] != null) {
				int len = numbers[i].size();
				if(len > 1) {
					Collections.sort(numbers[i]);
				}
				for(int j = 0; j < len; j++) {
					sb.append(i-100000).append(" ").append(numbers[i].get(j)).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
