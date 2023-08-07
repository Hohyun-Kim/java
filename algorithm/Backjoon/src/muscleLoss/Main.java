package muscleLoss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int cnt = 0;
	
	public static void check_routine(int[] workout_kit, boolean[] visit, int N, int K, int use,  int now_power) {
		if (now_power < 0) {
			return;
		}
		if (use == N) {
			cnt++;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				check_routine(workout_kit, visit, N, K, use+1, now_power+workout_kit[i]-K);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int use = 0;
		int now_power = 0;
		int[] workout_kit = new int[N];
		boolean[] visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			workout_kit[i] = Integer.parseInt(st.nextToken());
		}
		check_routine(workout_kit, visit, N, K, use, now_power);
		System.out.println(cnt);
		
	}

}
