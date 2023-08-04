package card2_2164;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < N+1; i++) {
			q.add(i);
		}
		int temp;
		int cnt = 1;
		while (q.size() > 1) {
			temp = q.poll();
			if (cnt % 2 == 0) {
				q.add(temp);
			}
			cnt++;
		}
		System.out.println(q.poll());
	}

}
