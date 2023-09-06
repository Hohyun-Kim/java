package searchNum_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] numbers;
	
	static boolean find = false;
	
	public static void binarySearch(int left, int right, int target) {
		int mid = (left+right)/2;
		if(numbers[mid] == target) {
			find = true;
			return;
		}
		if(left == right) return;
		if(numbers[mid] < target) {
			binarySearch(mid+1, right, target);		
		} else {
			binarySearch(left, mid, target);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for(int n = 0; n < N; n++) {
			numbers[n] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(numbers);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			find = false;
			int target = Integer.parseInt(st.nextToken());
			binarySearch(0, numbers.length-1, target);
			sb.append(find?1:0).append("\n");
		}
		System.out.println(sb);
	}
}
