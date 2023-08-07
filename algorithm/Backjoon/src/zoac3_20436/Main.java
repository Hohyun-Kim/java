package zoac3_20436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static boolean with_left(int r, int c) {
		if ((r < 2) && (c < 5)) return true;
		if ((r == 2) && c < 4 ) return true;
		return false;
	}
	
	public static int time = 0;
	
	public static void calcTimeAndSetNext(String[] keyboard, char now, int[] sL, int[] sR) {
		int c;
		for (int r = 0; r < 3; r++) {
			c = keyboard[r].indexOf(now);
			if(c != -1) {
				if(with_left(r, c)) {
					time += Math.abs(r-sL[0]) + Math.abs(c-sL[1])+1;
					sL[0] = r;
					sL[1] = c;
				} else {
					time += Math.abs(r-sR[0]) + Math.abs(c-sR[1])+1;
					sR[0] = r;
					sR[1] = c;
				}
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] init = br.readLine().toCharArray();
		int[] sL = new int[2];
		int[] sR = new int[2];
		char now;
		for (int i = 0; i < 3; i+=2) {
			now = init[i];
			calcTimeAndSetNext(keyboard, now, sL, sR);
		}
		char[] input = br.readLine().toCharArray();
		int input_size = input.length;
		time = 0;
		for(int i = 0; i < input_size; i++) {
			now = input[i];
			calcTimeAndSetNext(keyboard, now, sL, sR);
		}
		System.out.println(time);
		
	}

}
