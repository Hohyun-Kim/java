package ship_1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int strongest = Integer.MIN_VALUE;
	static int weakest = Integer.MAX_VALUE;
	static int most_heavy = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static Integer[] crane_power;
	static int[] box;
	static int[] crane_box_idx;
	static boolean[] moved;
	static int moved_cnt = 0;
	
	static void find_best_box(int crane_idx) {
		int power = crane_power[crane_idx];
		int best_box_idx = Arrays.binarySearch(box, power);
		if(best_box_idx == -1) return;
		if(best_box_idx < 0) {
			best_box_idx = -best_box_idx-1;
			best_box_idx--;
		}
		int next_box_idx = best_box_idx;
		while(next_box_idx < M-1) {
			next_box_idx++;
			if(box[next_box_idx] > power) {
				next_box_idx--;
				break;
			}
		}
		best_box_idx = next_box_idx;
		while(best_box_idx > 0 && moved[best_box_idx]) {
			best_box_idx--;
		}
		if(best_box_idx == 0 && moved[best_box_idx]) return;
		if(crane_power[crane_idx] < box[best_box_idx]) return;
		moved[best_box_idx] = true;
		moved_cnt++;
		crane_box_idx[crane_idx] = best_box_idx;
//		System.out.println("now crane idx : " + crane_idx);
//		System.out.println("now box idx : " + best_box_idx);
	}
	
	static void move_box(int crane_idx) {
		int best_box_idx = crane_box_idx[crane_idx];
		while(best_box_idx > 0 && moved[best_box_idx]) {
			best_box_idx--;
		}
		if(best_box_idx == 0 && moved[best_box_idx]) return;
		if(crane_power[crane_idx] < box[best_box_idx]) return;
		moved[best_box_idx] = true;
		moved_cnt++;
		crane_box_idx[crane_idx] = best_box_idx;
	}
	
	static void act_crane() {
		for(int i = 0; i < N; i++) {
			find_best_box(i);
		}
		min = 1;
		if(moved_cnt == M) return;
//		System.out.println();
//		System.out.println(Arrays.toString(crane_box_idx));
//		System.out.println(Arrays.toString(moved));
		while(true) {
			for(int i = 0; i < N; i++) {
				move_box(i);
				if(moved_cnt == M) break;
			}
//			System.out.println();
//			System.out.println(Arrays.toString(crane_box_idx));
//			System.out.println(Arrays.toString(moved));
			min++;
			if(moved_cnt == M) break;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		strongest = Integer.MIN_VALUE;
		most_heavy = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		crane_power = new Integer[N];
		crane_box_idx = new int[N];
		for(int i = 0; i < N; i++) {
			crane_power[i] = Integer.parseInt(st.nextToken());
			if(strongest < crane_power[i]) strongest = crane_power[i];
		}
		Arrays.sort(crane_power, Collections.reverseOrder());
		M = Integer.parseInt(br.readLine());
		box = new int[M];
		moved = new boolean[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			box[i] = Integer.parseInt(st.nextToken());
			if(most_heavy < box[i]) most_heavy = box[i];
		}
		Arrays.sort(box);
//		System.out.println("crane power : " + Arrays.toString(crane_power));
//		System.out.println("box weight : " + Arrays.toString(box));
		if(most_heavy > strongest) {
			min = -1;
		} else {
			act_crane();
		}
		System.out.println(min);
	}

}
