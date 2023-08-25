package baseball_17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Finishings;

public class Main {
	
	static int N;
	
	public static void swap(int[] seq, int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
	
	public static boolean NP(int[] seq) {
		int i = N-1;
		while(i>0&&seq[i-1]>=seq[i]) i--;
		if(i==0) return false;
		int j = N-1;
		while(seq[i-1]>=seq[j]) j--;
		swap(seq, i-1, j);
		j = N-1;
		while(i<j) swap(seq, i++, j--);
		return true;
	}
	
	public static class game {
		int inning = 0;
		int outCount = 0;
		int seat = 0;
		int playerIdx = 0;
		
		public void finishInning(int pNo) {
			this.inning++;
			this.outCount = 0;
			this.seat = 0;
			this.playerIdx = pNo;
		}
		public void reflectResult(int pid) {
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] game_do = new int[N][9];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				game_do[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] seq = {1, 2, 3, 4, 5, 6, 7, 8};
		do {
			game nowGame = new game();
			int[] player = new int[9];
			player[3] = 0;
			for(int i = 0; i < 9; i++) {
				
				player[i] = seq[i];
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
			
		}while(NP(seq));
		
		

	}

}
