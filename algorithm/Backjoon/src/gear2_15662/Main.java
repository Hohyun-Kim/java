package gear2_15662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static int[] gear;
	static int[] directions;
	static int visited;

	public static void checkRotate(int idx, int direction) {
		if ((visited & 1 << idx) != 0)
			return;
		directions[idx] = direction;
		visited |= 1 << idx;
		int right = (gear[idx] & 1 << 5) != 0 ? 1 : 0;
		int left = (gear[idx] & 1 << 1) != 0 ? 1 : 0;
		int leftOfRightGear = 0;
		int rightOfLeftGear = 0;
		if (idx < T-1) {
			leftOfRightGear = (gear[idx + 1] & 1 << 1) != 0 ? 1 : 0;
			if ((leftOfRightGear ^ right) != 0) {
				checkRotate(idx + 1, -direction);
			}
		}
		if (idx > 0) {
			rightOfLeftGear = (gear[idx - 1] & 1 << 5) != 0 ? 1 : 0;
			if ((rightOfLeftGear ^ left) != 0) {
				checkRotate(idx - 1, -direction);
			}
		}
	}

	public static void rotateGear(int direction, int idx) {
		switch (direction) {
		case 1:
			gear[idx] |= (gear[idx] & 1 << 0) << 8;
			gear[idx] >>= 1;
			break;
		case -1:
			gear[idx] <<= 1;
			gear[idx] |= (gear[idx] & 1 << 8) != 0 ? 1 : 0;
			gear[idx] &= ~(1 << 8);
			break;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine()); 
		gear = new int[T];
		directions = new int[T];
		String input;
		for (int i = 0; i < T; i++) {
			input = br.readLine();
			gear[i] = Integer.parseInt(input, 2);
		}
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			visited = 0;
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			for (int d = 0; d < T; d++) {
				directions[d] = 0;
			}
			checkRotate(idx, direction);
			for (int i = 0; i < T; i++) {
				rotateGear(directions[i], i);
			}
		}
		int cnt = 0;
		for (int i = 0; i < T; i++) {
			if ((gear[i] & 1 << 7) != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
