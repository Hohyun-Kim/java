package yosepuss_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		LinkedList<Integer> LL = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			LL.add(i);
		}
		int index = K-1;
		sb.append("<");
		for (int i = 0; i < N-1; i++) {
			sb.append(LL.remove(index)).append(", ");
			index = (index + K - 1) % LL.size();
		}
		sb.append(LL.remove(index)).append(">");
		System.out.println(sb);
	}

}
