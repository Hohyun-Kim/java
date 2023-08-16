package parttimerGangho_1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] customer = new Integer[N];
		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			customer[i] = Integer.parseInt(br.readLine());
			seq[i] = i;
		}
		Arrays.sort(customer, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		long tip = 0;
		for(int i = 0; i < N; i++) {
			if (customer[i]-i > 0) tip += customer[i] - i;
			else break;
		}
		System.out.println(tip);
	}

}
