package goodWord_3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)  throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		String word;
		char now;
		int index;
		int len;
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < N; i++) {
			word = br.readLine();
			len = word.length();
			index = 0;
			s.clear();
			s.push('O');
			while(index < len) {
				now = word.charAt(index);
				if(s.peek() == now) {
					s.pop();
				} else {
					s.push(now);
				}
				index++;
			}
			s.pop();
			if (s.size() == 0) cnt++;
		}
		System.out.println(cnt);
	}
}
