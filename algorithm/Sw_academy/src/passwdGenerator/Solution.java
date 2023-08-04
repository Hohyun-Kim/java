package passwdGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/passwdGenerator/input.txt"));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] list = new int[8];
		int temp;
		int less_than_10;
		boolean at_least_one_zero = false;
		int index;
		boolean pass;
		for(int t = 1; t < 11; t++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			less_than_10 = 0;
			pass = true;
			at_least_one_zero = false;
			for(int i = 0; i < 8; i++) {
				temp = Integer.parseInt(st.nextToken());
				index = i;
				if (temp < 10) {
					less_than_10 = (less_than_10|(1<<index));
				}
				list[index] = temp;
			}
			index = 0;
			while(pass) {
				for (int dec = 1; dec < 6; dec++) {
					list[index] -= dec;
					if (list[index] < 10) {
						less_than_10 = (less_than_10|(1<<index));
					}
					
					if (list[index] < 1) {
						list[index] = 0;
						at_least_one_zero = true;
					}
					
					if (less_than_10 == 255) {
						if (at_least_one_zero) {
							index++;
							index %= 8;
							pass = false;
							break;
						}
					}
					
					index++;
					index %= 8;				
				}
			}
			sb.append("#").append(t).append(" ");
			int cnt = 0;
			while (cnt < 8) {
				sb.append(list[index]).append(" ");
				index++;
				index %= 8;
				cnt++;
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
