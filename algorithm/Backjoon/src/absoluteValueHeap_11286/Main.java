package absoluteValueHeap_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1-o2;
				}
				return Math.abs(o1)-Math.abs(o2);
			}
			
		});
		int n;
		for(int i = 0; i < N; i++) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if (pq.size() == 0) sb.append(0);
				else sb.append(pq.poll());
				sb.append("\n");
			}
			else pq.offer(n);
		}
		System.out.println(sb);
	}
}
