package specialMagnet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] magnet;
	static int[] directions;
	static int visited;
	
	public static void checkRotate(int idx, int direction) {
		if((visited & 1<<idx) != 0) return;
		directions[idx] = direction;
		visited |= 1<<idx;
		int right = (magnet[idx] & (1<<5)) != 0? 1 : 0;
		int left = (magnet[idx] & (1<<1)) != 0? 1 : 0;
		int rightleft = 0;
		int leftright = 0;
		if(idx < 3) {
			rightleft = (magnet[idx+1] & (1<<1)) != 0? 1 : 0;
		}
		if(idx > 0) {
			leftright = (magnet[idx-1] & (1<<5)) != 0? 1 : 0;
		}
		if((idx < 3) && (rightleft ^ right) != 0) {
			checkRotate(idx+1, -direction);
		}
		if((idx > 0) && (leftright ^ left) != 0) {
			checkRotate(idx-1, -direction);
		}
	}
	
	public static void rotateMagnet(int direction, int idx) {
		switch(direction) {
		case 1:
			magnet[idx] |= (magnet[idx]%2)<<8;
			magnet[idx] >>= 1;
			break;
		case -1:
			magnet[idx] <<= 1;
			magnet[idx] |= (magnet[idx] & (1 << 8)) != 0? 1:0;
			magnet[idx] &= ~(1<<8);
			break;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			magnet = new int[4];
			directions = new int[4];
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					magnet[i] |= Integer.parseInt(st.nextToken());
					magnet[i] <<= 1; 
				}
			}
			for(int i = 0; i < K; i++) {
				visited = 0;
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken())-1;
				int direction = Integer.parseInt(st.nextToken());
				for(int d = 0; d < 4; d++) {
					directions[d] = 0;
				}
				checkRotate(idx, direction);
				for(int d = 0; d < 4; d++) {
					rotateMagnet(directions[d], idx);
				}
			}
			int sum = 0;
			for(int i = 0; i < 4; i++) {
				if((magnet[i] & (1<<7)) != 0) {
					sum |= (1<<i);
				}
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
