package baseball_17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void swap(int[] seq, int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
	
	public static boolean NP(int[] seq) {
		int i = 7;
		while(i>0&&seq[i-1]>=seq[i]) i--;
		if(i==0) return false;
		int j = 7;
		while(seq[i-1]>=seq[j]) j--;
		swap(seq, i-1, j);
		j = 7;
		while(i<j) swap(seq, i++, j--);
		return true;
	}
	
	public static class game {
		int inning = 0;
		int outCount = 0;
		int seat = 0;
		int playerIdx = 0;
		int score = 0;
		
		public void finishInning(int pNo) {
			this.inning++;
			this.outCount = 0;
			this.seat = 0;
			this.playerIdx = pNo;
		}
		public void reflectResult(int pid) {
			if(pid == 0) {
				this.outCount++;
				return;
			}
			if(pid == 4) {
				score += Integer.bitCount(seat) + 1;
				seat = 0;
				return;
			}
			seat <<= pid;
			seat |= 1<<(pid-1);
			if(seat > 7) {
				score += Integer.bitCount(seat&56);
				seat &= 7;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] game_do = new int[N][9];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				game_do[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] seq = {1, 2, 3, 4, 5, 6, 7, 8};
		int max = 0;
		do {
			game nowGame = new game();
			int[] player = new int[9];
			player[3] = 0;
			int idx = 0;
			for(int i = 0; i < 9; i++) {
				if(i == 3) continue;
				player[i] = seq[idx++];
			}
			for(int inning = 0; inning < N; inning++) {
				int pNo = nowGame.playerIdx;
				while(nowGame.outCount<3) {
					nowGame.reflectResult(game_do[inning][player[pNo]]);
					pNo++;
					pNo %= 9;
				}
				nowGame.finishInning(pNo);
			}
			if(max < nowGame.score) max = nowGame.score;
		}while(NP(seq));		
		System.out.println(max);
	}

}
