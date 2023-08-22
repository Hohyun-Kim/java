package abcde_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int M;
	public static ArrayList<Integer>[] AM;
	public static boolean[] friend;
	public static boolean pass = false;
	
	public static void checkValid(int start, int cnt) {
		
		friend[start] = true;
		
		if(cnt == 4) {
			pass = true;
			return;
		}
		
		for(int c = 0; c < AM[start].size(); c++) {
			if(!friend[AM[start].get(c)]) {
				checkValid(AM[start].get(c), cnt+1);
				friend[AM[start].get(c)] = false;
			}
			if(pass) return;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		AM = new ArrayList[N];
		friend = new boolean[N];
		for(int i = 0; i < N; i++) {
			AM[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			AM[v1].add(v2);
			AM[v2].add(v1);
		}
		for(int r = 0; r < N; r++) {
			checkValid(r, 0);
			friend[r] = false;
			if(pass) break;
		}
		if(pass) System.out.println(1);
		else System.out.println(0);
	}

}
