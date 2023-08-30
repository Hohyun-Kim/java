package monkeywantedtobehorse_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] jr = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] jc = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int k;
	static int H;
	static int W;
	static int[][] map;
	static boolean[][] visit;
	static Queue<monkey> mq;
	static boolean find_goal;
	
	public static boolean in_range(int nr, int nc) {
		return nr<H && nc<W && nr>=0 && nc>=0;
	}
	
	static class monkey {
		int r;
		int c;
		int k;
		public monkey(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
		public boolean move(int d, boolean jump) {
			int nr = jump? r+jr[d]:r+dr[d];
			int nc = jump? c+jc[d]:c+dc[d];
			if(jump) k--;
			if(in_range(nr, nc) && map[nr][nc] != 1 && !visit[nr][nc]) {
				visit[nr][nc] = true;
				r = nr;
				c = nc;
				return true;
			}
			return false;
		}
	}
	
	public static void shadow_clone_teqnique(int row, int col, int jump_remain, int d_num) {
		boolean jump = d_num==8? true:false;
		for(int d = 0; d < d_num; d++) {
			monkey move_monkey = new monkey(row, col, jump_remain);
			if(move_monkey.move(d, jump)) {
				if(move_monkey.r == H-1 && move_monkey.c == W-1) {
					find_goal = true;
					return;
				}
				mq.add(move_monkey);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new boolean[H][W];
		for(int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		mq = new ArrayDeque<>();
		mq.offer(new monkey(0, 0, k));
		int cnt = 0;
		int row;
		int col;
		int jump_remain;
		find_goal = false;
		while(!mq.isEmpty()) {
			int q_size = mq.size();
			for(int i =0; i < q_size; i++) {
				monkey now_monkey = mq.poll();
				row = now_monkey.r;
				col = now_monkey.c;
				jump_remain = now_monkey.k;
				if(jump_remain>0) {
					shadow_clone_teqnique(row, col, jump_remain, 8);
				}
				shadow_clone_teqnique(row, col, jump_remain, 4);
				if(find_goal) break;
			}
			cnt++;
			if(find_goal) break;
		}
		if(find_goal) System.out.println(cnt); 
		else System.out.println(-1);
	}

}
