package gerrymandering_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer>[] graph;
	static int N;
	static int[] people;
	static int num_people;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int start, int[] flag) {
		
		List<Integer> now = graph[start];
		flag[0] |= 1<<start;
		for(int i = 0; i < now.size(); i++) {
			if((flag[0] & 1<<now.get(i)) == 0) {
				dfs(now.get(i), flag);
			}
		}
	}
	
	public static boolean check_valid(int start, int flag) {
		int[] dfs_flag = new int[1];
		dfs_flag[0] |= flag;
		dfs(start, dfs_flag);
		if((dfs_flag[0] | flag) == (1<<(N)) - 1) return true;
		return false;
	}
	
	public static int set_start(int flag) {
		for(int i = 0; i < N; i++) {
			if((flag & 1<<i) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void find_balance() {
		
		Queue<List<Integer>> q = new ArrayDeque<List<Integer>>(); // 그룹이 들어갈 큐
		List<Integer> first = new ArrayList<>(); // 초기 큐
		first.add(0);
		q.add(first);
		int[] flags;
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			int q_size = q.size(); // 특정 크기의 그룹을 가진 큐만 계산
			flags = new int[q_size]; // 특정 크기의 그룹을 가진 큐가 가질 flag들(방문확인용)
			ArrayList<Integer> next_flags = new ArrayList<Integer>(); // 다음 크기의 큐들이 가질 flag들
			for(int i = 0; i < q_size; i++) {
				
				List<Integer> now = q.poll(); // 이번에 처리할 그룹 뽑기
				int start = -1;
				for(int j = 0; j < now.size(); j++) { // 이번에 처리할 그룹이 가진 노드들 방문처리
					flags[i] |= 1<<now.get(j);
				}
				start = set_start(flags[i]); // 그룹구분이 유효한지 검사할 다른그룹의 노드 설정
				if(start == -1) return; // 그룹이 1개이면 종료
				
				if(check_valid(start, flags[i])) { // 그룹구분이 유효한지 검사
					int sum = 0;
					for(int j = 0; j < now.size(); j++) { // 유효하다면 현재 그룹 인원수 총합 계산
						sum += people[now.get(j)];
					}
					int temp = Math.abs(2*sum - num_people); // 현재그룹과 다른 그룹 사이의 인원수 차이 계산
					if(min > temp) min = temp; // 최솟값과 비교하여 더 작으면 갱신
				}
				if(min == 0) return;
				for(int j = 0; j < now.size(); j++) { // 현재 그룹의 노드들마다 인접한 노드들 체크
					List<Integer> adj = graph[now.get(j)]; // 현재 그룹의 j번째 노드에 인접한 노드 리스트
					if(cnt == 1) {
						System.out.println("0번 노드에 인접한 노드 : " + Arrays.toString(adj.toArray()));
					}
					for(int k = 0; k < adj.size(); k++) { // j번째 노드에 인접한 k번째 노드 체크
						List<Integer> next = new ArrayList<>(); // 다음 그룹 선언
						for(int l = 0; l < now.size(); l++) {
							next.add(now.get(l));
						}
						if((flags[i] & 1<<k) == 0) { // k번째 노드 방문여부 확인
							boolean add_ok = true;
							int next_flag = flags[i] | 1<<k; // k번째 노드 방문했다고 처리
							for (int f = 0; f < next_flags.size(); f++) {
								if(next_flags.get(f) == next_flag) { // 이미 전에 방문처리 한적 있으면 그룹 추가 안해도 됨
									add_ok = false;
								}
							}
							if(add_ok) { // 전에 체크해보지 않았던 그룹이라면 q에 추가
								next.add(adj.get(k));
								next_flags.add(next_flag);
								q.add(next);
							}
						}
					}
				}
			}
			if(cnt == 1) {
				System.out.println(q.size());
				System.out.println(Arrays.toString(q.peek().toArray()));
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		num_people = 0;
		for(int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			num_people += people[i];
		}
		graph = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			graph[i] = new ArrayList<>();
			int l = split.length;
			for(int j = 1; j < l; j++) {
				graph[i].add(Integer.parseInt(split[j])-1);
			}
		}
		find_balance();
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);

	}

}
