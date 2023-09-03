package christmasPresent_14235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> present = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) {
				if(present.isEmpty()) sb.append(-1);
				else sb.append(present.poll());
				sb.append("\n");
			}
			if(n != 0) {
				for(int j = 0; j < n; j++) {
					present.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}

}
