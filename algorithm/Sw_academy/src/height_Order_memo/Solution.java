package height_Order_memo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int gtCnt, ltCnt, cnt, N, M;
	static int[][] adj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine().trim()); // 학생 수
			M = Integer.parseInt(in.readLine().trim()); // 관계 수
			adj = new int[N+1][N+1]; // 인접행렬
			// 모든 행의 0열 : 자신보다 큰 학생수 메모함, 초기값은 -1로 채워 미탐색상태를 나타냄!!
			for(int i = 0; i <= N; ++i) adj[i][0] = -1;
			
			StringTokenizer st = null;
			
			for(int m = 0; m < M; ++m) { // 관계정보 : 학생번호 1번부터 시작
				st = new StringTokenizer(in.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i키 < j키를 인접행렬과 역인접행렬에 표현
			}
			int answer = 0;
			for(int k = 1; k<=N; ++k){
				if(adj[k][0] == -1) gtDFS(k); // 탐색되지 않은 학생만 탐색
			}
			// 메모된 인접행렬의 상태를 이용하여 자신보다 작은학생수 카운팅!!
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					adj[0][j] += adj[i][j];
				}
			}
			// 자신보다 키가 큰 학생수와 작은 학생수의 합이 N-1인지 확인!!
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] + adj[0][i] == N-1) answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void gtDFS(int k) {
		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 처리
			if(adj[k][i] == 1) { // 나보다 크고
				if(adj[i][0] == -1) { //미탐색된 상태
					// 탐색하러 고고씽!
					gtDFS(i);
				}
				// 탐색을 완료했거나 이미 탐색된 대상이어서 탐색하지 않고 내려온 경우
				// i보다 큰 대상이 1명이상이면 k보다 큰 간접대상이 존재가능한 상황!
				// ==> 새롭게 알게된 간접관계를 나와의 직접 관계로 인접행렬에 반영
				if(adj[i][0]>0) {
					for(int j = 1; j <= N; j++) {
						if(adj[i][j] == 1) {
							adj[k][j] = 1;
						}
					}
				}
			}
		}
		
		// 자신의 인접행렬을 모두 처리 ==> 직/간접 관계가 인접행렬에 다 반영되어 있는 상태!!
		// 자신보다 큰 학생수를 카운팅해서 메모하고 리턴하기
		int cnt = 0;
		for (int j = 1; j <= N; j++) {
			cnt += adj[k][j];
		}
		adj[k][0] = cnt;
		return;
	}

}
