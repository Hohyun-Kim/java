package tower_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static class tower {
		
		private int index;
		private int height;
		public tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		tower[] towers = new tower[N];
		Deque<tower> send_signal = new ArrayDeque<tower>();
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			towers[i] = new tower(i, Integer.parseInt(st.nextToken()));
		}
		tower now;
		int index;
		for (int i = N-1; i >= 0; i--) {
			now = towers[i];
			while(send_signal.size()!=0 && send_signal.peek().getHeight() <= now.getHeight()) {
				index = send_signal.pop().getIndex();
				ans[index] = now.getIndex()+1;
			}
			send_signal.push(now);
		}
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);

	}

}
