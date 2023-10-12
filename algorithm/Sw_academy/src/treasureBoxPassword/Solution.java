package treasureBoxPassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	public static int change_to_number(char C) {
		if(C >= '0' && C <= '9') return C - '0';
		else if(C >= 'A' && C <= 'F') return C - 'A' + 10;
		else return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String S = br.readLine();
			int line = N/4;
			S = S.concat(S.substring(0, line-1));
			int start = 0;
			int end = line-1;
			int num = 0;
			for(int i = 0; i < line-1; i++) {
				num += change_to_number(S.charAt(i));
				num *= 16;
			}
			Set<Integer> numSet = new HashSet<>();
			List<Integer> arr = new ArrayList<>();
			while(end<S.length()) {
				num += change_to_number(S.charAt(end++));
				if(!numSet.contains(num)) {
					numSet.add(num);
					arr.add(num);
				}
				num -= change_to_number(S.charAt(start++))*(int)Math.pow(16, line-1);
				num *= 16;
			}
			Collections.sort(arr, Collections.reverseOrder());
			int answer = arr.get(K-1);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
