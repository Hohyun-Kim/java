package parenthesis_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static String yes = "YES";
	static String no = "NO";

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			String parenthesis = br.readLine();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			int len = parenthesis.length();
			boolean pass = true;
			for(int i = 0; i < len; i++) {
				char c = parenthesis.charAt(i);
				switch (c) {
				case '(':
					stack.push(c);
					break;
				case ')':
					if(stack.size()!=0) stack.pop();
					else pass = false;
					break;
				}
				if(!pass) break;
			}
			sb.append(pass & stack.size()==0?yes:no).append("\n");
		}
		System.out.println(sb);
	}
}
