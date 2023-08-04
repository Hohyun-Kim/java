package pairBracket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	public static boolean is_open_bracket(char now) {
		if (now == '(' || now == '[' || now == '{' || now == '<') {
			return true;
		}
		return false;
	}
	
	public static boolean check_valid(char now, char recent) {
		char temp;
		switch(now) {
		case ')' :
			temp = '(';
			break;
		case ']' :
			temp = '[';
			break;
		case '}' :
			temp = '{';
			break;
		case '>' :
			temp = '<';
			break;
		default:
			temp = 'X';			
		}
		if (temp == recent) return true;
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/pairBracket/input.txt"));
		StringBuilder sb = new StringBuilder();
		int len;
		char now;
		String brackets;
		int res;
		Stack<Character> br_stack = new Stack<>();
		for (int t = 1; t < 11; t++) {
			len = Integer.parseInt(br.readLine());
			brackets = br.readLine();
			res = 1;
			for(int l = 0; l < len; l++) {
				now = brackets.charAt(l);
				if (is_open_bracket(now)) {
					br_stack.push(Character.valueOf(now));
				} else {
					if(check_valid(now, br_stack.pop().charValue())) continue;
					else {
						res = 0;
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

}
