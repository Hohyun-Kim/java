package guitar_1497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static String[] guitar;
	public static int[][] flags;
	public static int min = Integer.MAX_VALUE;
	public static int[] total_flag;
	public static int total_cnt;
	
	public static int bitCount(int flag) {
		int cnt = 0;
		while(flag>1) {
			if(flag%2 == 1) cnt++;
			flag /= 2;
		}
		return flag%2 == 1? cnt+1:cnt;
	}
	
	public static void find_min(int start, int cnt, int flag1, int flag2) {
		if(total_flag[0]==flag1 && total_flag[1]==flag2) {
			if(cnt < min) min = cnt;
			return;
		}
		if(start == N) {
			return;
		}
		find_min(start+1, cnt+1, flag1|flags[start][0], flag2|flags[start][1]);
		find_min(start+1, cnt, flag1, flag2);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		guitar = new String[N];
		flags = new int[N][2];
		total_flag = new int[2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			guitar[i] = st.nextToken();
			String music = st.nextToken();
			for(int j = 0; j < M; j++) {
				if(j < 25) {
					flags[i][0] |= (music.charAt(j)=='Y'? 1<<j:0);
					total_flag[0] |= (music.charAt(j)=='Y'? 1<<j:0);
				} else {
					flags[i][1] |= (music.charAt(j)=='Y'? 1<<(j-25):0);
					total_flag[1] |= (music.charAt(j)=='Y'? 1<<(j-25):0);
				}
			}
		}
		if(total_flag[0]==0 && total_flag[1]==0) System.out.println(-1);
		else {
			find_min(0, 0, 0, 0);
			System.out.println(min);
		}
	}

}
