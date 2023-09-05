package distributeProcess_1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		int a;
		int b;
		int[][] computers = {{10}, {1}, {2, 4, 8, 6}, {3, 9, 7, 1}, {4, 6}, {5}, {6}, {7, 9, 3, 1}, {8, 4, 2, 6}, {9, 1}};
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())%10;
			b = (Integer.parseInt(st.nextToken())-1)%computers[a].length;
			sb.append(computers[a][b]).append("\n");
		}
		System.out.println(sb);
	}

}
