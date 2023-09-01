package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while(true) {
			String word = br.readLine();
			if(word.equals("0")) break;
			int index = 0;
			int len = word.length();
			if (len == 1) {
				sb.append("yes").append("\n");
				continue;
			}
			int check_length = len/2;
			boolean is_palendrom = true;
			while(index < check_length) {
				if (word.charAt(index) != word.charAt(len-1-index)) {
					is_palendrom = false;
					break;
				}
				index++;
			}
			if (is_palendrom) sb.append("yes");
			else sb.append("no");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
