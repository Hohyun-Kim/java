package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] sort_arr;
	static int[] answer_arr;
	static boolean[] visited_idx;
	static boolean[] visited_num;
	static int[] index_arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		sort_arr = new int[n];
		answer_arr = new int[n];
		visited_idx = new boolean[n];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sort_arr[i] = arr[i];
			if (max < arr[i]) max = arr[i];
		}
		visited_num = new boolean[max+1];
		index_arr = new int[max+1];
		Arrays.sort(sort_arr);
		for(int i = 0; i < n; i++) {
			if (visited_num[sort_arr[i]]) {
				continue;
			}
			visited_num[sort_arr[i]] = true;
			int lower_bound = Arrays.binarySearch(sort_arr, sort_arr[i]);
			int upper_bound = Arrays.binarySearch(sort_arr, sort_arr[i]+1);
			if(upper_bound < 0) {
				upper_bound = -upper_bound - 1;
			}
			if(upper_bound >= sort_arr.length) {
				index_arr[sort_arr[i]] = 0;
				continue;
			}
			if(upper_bound - lower_bound == 1) {
				index_arr[sort_arr[i]] = upper_bound;
				continue;
			}
			int mid = (upper_bound + lower_bound) / 2;
			while(true) {
				if(sort_arr[mid] == sort_arr[i]) {
					lower_bound = mid;
				} else if (sort_arr[mid] > sort_arr[i]) {
					upper_bound = mid;
				}
				mid = (upper_bound + lower_bound) / 2;
				if(upper_bound - lower_bound == 1) {
					index_arr[sort_arr[i]] = upper_bound;
					break;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(index_arr[arr[i]] == n) index_arr[arr[i]] = 0;
			while(visited_idx[index_arr[arr[i]]]) {
				index_arr[arr[i]]++;
				if(index_arr[arr[i]] == n) index_arr[arr[i]] = 0;
			}
			visited_idx[index_arr[arr[i]]] = true;
			answer_arr[i] = sort_arr[index_arr[arr[i]]++];
			if(answer_arr[i] > arr[i]) cnt++;
		}
		System.out.println(cnt);
		
	}
}
