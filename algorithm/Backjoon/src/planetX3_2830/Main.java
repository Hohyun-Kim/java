package planetX3_2830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int sum = 0;
	
	public static void calc(int[] people, int start, int cnt, boolean[] visit, int[] couple) {
		
		
		if(cnt == 2) {
			sum += couple[0]^couple[1];
			return;
		}
		for (int i = start; i < people.length; i++) {
			visit[i] = true;
			couple[cnt] = people[i];
			calc(people, i+1, cnt+1, visit, couple);
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] people = new int[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
		boolean[] visit = new boolean[N];
		int[] couple = new int[2];
		if (N==1) {
			System.out.println(sum);
			return;
		}
		calc(people, 0, 0, visit, couple);
		System.out.println(sum);
	}

}
