package sortNumber2_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		Set<Integer> n_set = new HashSet<>();
		ArrayList<Integer> n_list = new ArrayList<>();
		int n;
		for(int i = 0; i < N; i++) {
			n = Integer.parseInt(br.readLine());
			if(!n_set.contains(n)) {
				n_set.add(n);
				n_list.add(n);
			}
		}
		Collections.sort(n_list);
		for(int i = 0; i < n_list.size(); i++) {
			sb.append(n_list.get(i)).append("\n");
		}
		System.out.println(sb);
	}

}
