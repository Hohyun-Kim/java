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
	static int K;
	static int H;
	static int W;
	static int[][] map;
	static int[][] visit;
	static Queue<monkey> mq;
	static boolean find_goal;
	static int answer = -1;
	
	public static boolean in_range(int nr, int nc) {
		return nr<H && nc<W && nr>=0 && nc>=0;
	}
	
	static class monkey {
		int r;
		int c;
		int k;
		int move;
		public monkey(int r, int c, int k, int move) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.move = move;
		}
		public boolean move(int d, boolean jump) {
			int nr = jump? r+jr[d]:r+dr[d];
			int nc = jump? c+jc[d]:c+dc[d];
			if(jump) k--;
			if(in_range(nr, nc) && map[nr][nc] != 1 && ((visit[nr][nc]&1<<k) == 0)) {
				visit[nr][nc] |= 1<<k;
				r = nr;
				c = nc;
				move++;
				return true;
			}
			return false;
		}
	}
	
	public static void shadow_clone_teqnique(int row, int col, int jump_remain, int move, int d_num) {
		boolean jump = d_num==8? true:false;
		for(int d = 0; d < d_num; d++) {
			monkey move_monkey = new monkey(row, col, jump_remain, move);
			if(move_monkey.move(d, jump)) {
				if(move_monkey.r == H-1 && move_monkey.c == W-1) {
					find_goal = true;
					answer = move_monkey.move;
					return;
				}
				mq.add(move_monkey);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new int[H][W];
		for(int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		mq = new ArrayDeque<>();
		mq.offer(new monkey(0, 0, K, 0));
		int row;
		int col;
		int jump_remain;
		int move;
		visit[0][0] |= 1<<K;
		find_goal = false;
		if(mq.peek().r == H-1 && mq.peek().c == W-1) {
			find_goal = true;
			answer = mq.peek().move;
		}
		while(!mq.isEmpty()) {
			monkey now_monkey = mq.poll();
			row = now_monkey.r;
			col = now_monkey.c;
			jump_remain = now_monkey.k;
			move = now_monkey.move;
			if(jump_remain>0) {
				shadow_clone_teqnique(row, col, jump_remain, move, 8);
			}
			shadow_clone_teqnique(row, col, jump_remain, move, 4);
			if(find_goal) break;
		}
		System.out.println(answer);
	}

}
