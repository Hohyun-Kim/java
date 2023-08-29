package scale_2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int now = Integer.parseInt(st.nextToken());
		int next = Integer.parseInt(st.nextToken());
		int flag = now>next? 1:0;
		
		for(int i = 2; i < 8; i++) {
			now = next;
			next = Integer.parseInt(st.nextToken());
			if((flag == 0 & now > next) || (flag == 1 & now < next)) {
				flag = 2;
				break;
			}
		}
		
		switch(flag) {
		case 0:
			System.out.println("ascending");
			break;
		case 1:
			System.out.println("descending");
			break;
		case 2:
			System.out.println("mixed");
			break;
		}
	}
}
