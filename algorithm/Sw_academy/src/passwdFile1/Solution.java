package passwdFile1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new FileReader("./src/passwdFile1/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		LinkedList<Integer> LL = new LinkedList<>();
		int C;
		String inst;
		int index;
		int num;
		for (int t = 1; t < 11; t++) {
			LL.clear();
			sb.append("#").append(t);
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				LL.add(Integer.parseInt(st.nextToken()));
			}
			C = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < C; i++) {
				inst = st.nextToken();
				index = Integer.parseInt(st.nextToken());
				num = Integer.parseInt(st.nextToken());
				for (int j = 0; j < num; j++) {
					LL.add(index+j, Integer.parseInt(st.nextToken()));
				}
			}
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(LL.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
