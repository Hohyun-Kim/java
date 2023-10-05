package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] lis = new int[N];
			int max = Integer.MIN_VALUE;
//			1. solution 1 - DP
//			for(int i = 0; i < N; i++) {
//				lis[i] = 1;
//				for(int j = 0; j < i; j++) {
//					if((arr[i] > arr[j]) && (lis[i] < lis[j]+1)) lis[i] = lis[j]+1;
//				}
//			}
//			for(int i = 0; i < N; i++) {
//				if(lis[i] > max) max = lis[i];
//			}
			
//			2. solution 2 - Binary Search DP
			int idx = 0;
			int n = 0;
			Arrays.fill(lis, Integer.MAX_VALUE);
			lis[0] = arr[0];
			for(int i = 1; i < N; i++) {
				if(arr[i] > lis[idx]) {
					lis[++idx] = arr[i];
					continue;
				}
				n = Arrays.binarySearch(lis, arr[i]);
				if(n >= 0) continue;
				n = n*(-1) - 1;
				lis[n] = arr[i];
			}
			max = idx+1;
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
