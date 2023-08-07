package tower_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] towers = new int[N];
		Stack<Integer> send_signal = new Stack<>();
		for (int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		int now;
		for (int i = N-1; i >= 0; i--) {
			now = towers[i];
			if(send_signal.size() == 0) {
				send_signal.push(now);
				continue;
			}
			while(send_signal.peek() <= now) {
				send_signal.pop();
			}
		}

	}

}
