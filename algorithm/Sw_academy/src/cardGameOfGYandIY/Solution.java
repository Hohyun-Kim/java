package cardGameOfGYandIY;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void swap(int[] seq, int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
	public static boolean NP(int[] seq) {
		int i = 8;
		while(i>0&&seq[i-1]>=seq[i]) --i;
		if(i==0) return false;
		int j = 8;
		while(seq[i-1]>=seq[j]) --j;
		swap(seq, i-1, j);
		int k = 8;
		while(i<k) swap(seq, i++, k--);
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/cardGameOfGYandIY/s_input.txt"));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		int[] GY = new int[9];
		int[] IY = new int[9];
		int flag;
		int total = 9*8*7*6*5*4*3*2*1;
		int win_std = 18*19/4;
		for(int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine());
			flag = 0;
			int[] seq = new int[9];
			for(int i = 0; i < 9; i++) {
				GY[i] = Integer.parseInt(st.nextToken());
				flag |= 1<<GY[i];
				seq[i] = i;
			}
			int cnt = 0;
			for(int i = 1; i < 19; i++) {
				if ((flag & 1<<i) == 0) IY[cnt++] = i;
			}
			int gy_win = 0;
			int iy_win = 0;
			do {
				int gy = 0;
				int iy = 0;
				int gy_now;
				int iy_now;
				for(int i = 0; i < 9; i++) {
					gy_now = GY[i];
					iy_now = IY[seq[i]];
					if(gy_now > iy_now) gy += gy_now + iy_now;
				}
				if (gy > win_std) gy_win++;
			} while(NP(seq));
			sb.append("#").append(t).append(" ").append(gy_win).append(" ").append(total-gy_win).append("\n");
		}
		System.out.println(sb);
	}

}
