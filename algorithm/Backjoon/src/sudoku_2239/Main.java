package sudoku_2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static final int complete = (1 << 9) - 1;
	static int[][] map = new int[9][9];
	static int[][] flag = new int[9][9];
	static int[] flag_row = new int[9];
	static int[] flag_col = new int[9];
	static int[] virtual_flag_row = new int[9];
	static int[] virtual_flag_col = new int[9];
	static int[] flag_tile = new int[9];
	static int[] virtual_flag_tile = new int[9];
	static boolean success = false;
	
	static class Point{
		int r;
		int c;
		int num;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static void find_solution(int idx, int cnt) {
		if(cnt == 81) {
			success = true;
			return;
		}
		int r = idx/9;
		int c = idx%9;
		if(map[r][c] == 0) {
			for(int num = 0; num < 9; num++) {
				int tile_idx = (r/3)*3+(c/3);
				if ((flag_row[r] & 1 << num) != 0) continue;
				if ((flag_col[c] & (1 << num)) != 0) continue;
				if ((flag_tile[tile_idx] & (1 << num)) != 0) continue;
				map[r][c] = num + 1;
				flag_row[r] |= 1 << num;
				flag_col[c] |= 1 << num;
				flag_tile[tile_idx] |= 1 << num;
				find_solution(idx+1, cnt+1);
				if(success) return;
				map[r][c] = 0;
				int off = complete ^ (1<<num);
				flag_row[r] &= off;
				flag_col[c] &= off;
				flag_tile[tile_idx] &= off;
			}
		} else {
			find_solution(idx+1, cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String line;
		int cnt = 0;
		for (int r = 0; r < 9; r++) {
			line = br.readLine();
			int row_group = r / 3;
			for (int c = 0; c < 9; c++) {
				map[r][c] = line.charAt(c) - '0';
				if (map[r][c] != 0) {
					flag[r][c] = complete;
					flag_row[r] |= 1 << map[r][c] - 1;
					flag_col[c] |= 1 << map[r][c] - 1;
					flag_tile[(row_group * 3 + c / 3)] |= 1 << map[r][c] - 1;
					cnt++;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			virtual_flag_row[i] = flag_row[i];
			virtual_flag_col[i] = flag_col[i];
			virtual_flag_tile[i] = flag_tile[i];
		}
		int before_cnt = 0;
		boolean[] cand_row = new boolean[9];
		boolean[] cand_col = new boolean[9];
		boolean update = false;
		int cycle = 0;
		Queue<Point> q = new ArrayDeque<>();
		while (cnt != 81) {
			if(before_cnt == cnt) {
				if(cycle == 2) break;
			} else {
				cycle = 0;
			}
			before_cnt = cnt;
			cycle++;
			if(update) {
				// flag update
				while(!q.isEmpty()) {
					Point p = q.poll();
					for (int r = 0; r < 9; r++) {
						int tile_idx = (r/3)*3 + p.c/3;
						flag[r][p.c] |= flag_row[r];
						flag[r][p.c] |= flag_col[p.c];
						flag[r][p.c] |= flag_tile[tile_idx];
					}
					for (int c = 0; c < 9; c++) {
						int tile_idx = (p.r/3)*3 + c/3;
						flag[p.r][c] |= flag_row[p.r];
						flag[p.r][c] |= flag_col[c];
						flag[p.r][c] |= flag_tile[tile_idx];
					}
				}
			}
			update = false;
			for (int r = 0; r < 9; r++) {
				int row_group = r / 3;
				for (int c = 0; c < 9; c++) {
					if (flag[r][c] == complete)
						continue;
					int col_group = c / 3;
					flag[r][c] |= flag_row[r];
					flag[r][c] |= flag_col[c];
					flag[r][c] |= flag_tile[(row_group * 3 + col_group)];
				}
			}

			// 후보 1개인거 채워주기
			for (int r = 0; r < 9; r++) {
				int row_group = r / 3;
				for (int c = 0; c < 9; c++) {
					int col_group = c / 3;
					if (Integer.bitCount(flag[r][c]) == 8) {
						int put = 0;
						for (int i = 0; i < 9; i++) {
							if ((flag[r][c] & (1 << i)) == 0) {
								flag[r][c] = complete;
								put = i + 1;
								flag_row[r] |= 1 << i;
								flag_col[c] |= 1 << i;
								flag_tile[(row_group * 3 + col_group)] |= 1 << i;
								cnt++;
								break;
							}
						}
						map[r][c] = put;
						q.offer(new Point(r, c));
						update = true;
					}
				}
			}
			if (update) {
				continue;
			}

			// 들어갈 칸이 1개밖에 없으면 채우기
			for (int num = 0; num < 9; num++) {
				// tile 체크
				for (int tr = 0; tr < 3; tr++) {
					for (int tc = 0; tc < 3; tc++) {
						int tile_idx = tr * 3 + tc;
						if ((flag_tile[tile_idx] & (1 << num)) != 0)
							continue;
						int cnt_num = 0;
						int cand_row_num = 0;
						int cand_row_idx = -1;
						int cand_col_num = 0;
						int cand_col_idx = -1;
						for (int r = 3 * tr; r < 3 * (tr + 1); r++) {
							cand_row[r] = true;
						}
						for (int c = 3 * tc; c < 3 * (tc + 1); c++) {
							cand_col[c] = false;
						}
						for (int r = 3 * tr; r < 3 * (tr + 1); r++) {
							if ((flag_row[r] & 1 << num) != 0) {
								cnt_num += 3;
								continue;
							}
							if ((virtual_flag_tile[tile_idx] & 1 << num) == 0) {
								if ((virtual_flag_row[r] & 1 << num) != 0) {
									cnt_num += 3;
									continue;
								}
							}
							for (int c = 3 * tc; c < 3 * (tc + 1); c++) {
								if (flag[r][c] == complete) {
									cnt_num++;
									continue;
								}
								if ((flag_col[c] & (1 << num)) != 0) {
									cnt_num++;
									continue;
								}
								if ((virtual_flag_tile[tile_idx] & (1 << num)) == 0) {
									if ((virtual_flag_col[c] & 1 << num) != 0) {
										cnt_num++;
										continue;
									}
									
								}
								cand_col[c] = true;
								cand_row_idx = r;
								cand_col_idx = c;
							}
						}
						if(cand_row_idx == -1 && cand_col_idx == -1) continue;
						for (int r = 3 * tr; r < 3 * (tr + 1); r++) {
							if (cand_row[r]) {
								cand_row_num++;
							}
						}

						if (cand_row_num == 1) {
							virtual_flag_row[cand_row_idx] |= 1 << num;
							virtual_flag_tile[tile_idx] |= 1 << num;
						}

						for (int c = 3 * tc; c < 3 * (tc + 1); c++) {
							if (cand_col[c]) {
								cand_col_num++;
							}
						}

						if (cand_col_num == 1) {
							virtual_flag_col[cand_col_idx] |= 1 << num;
							virtual_flag_tile[tile_idx] |= 1 << num;
						}

						if (cnt_num == 8) {
							update = true;
							map[cand_row_idx][cand_col_idx] = num + 1;
							flag[cand_row_idx][cand_col_idx] = complete;
							flag_row[cand_row_idx] |= 1 << num;
							flag_col[cand_col_idx] |= 1 << num;
							flag_tile[tile_idx] |= 1 << num;
							q.offer(new Point(cand_row_idx, cand_col_idx));
							cnt++;
						}
					}
				}
				if (update) {
					break;
				}

				// row 체크
				for (int tr = 0; tr < 3; tr++) {
					for (int r = tr * 3; r < (tr + 1) * 3; r++) {
						if ((flag_row[r] & 1 << num) != 0)
							continue;
						int cand_col_num = 0;
						int cand_col_idx = -1;
						for (int tc = 0; tc < 3; tc++) {
							int tile_idx = tr * 3 + tc;
							if ((flag_tile[tile_idx] & 1 << num) != 0)
								continue;
							for (int c = tc * 3; c < (tc + 1) * 3; c++) {
								if (flag[r][c] == complete)
									continue;
								if ((flag_col[c] & 1 << num) != 0)
									continue;
								if ((virtual_flag_tile[tile_idx] & 1 << num) == 0) {
									if ((virtual_flag_col[c] & 1 << num) != 0)
										continue;
								}
								cand_col_num++;
								cand_col_idx = c;
							}
						}
						if (cand_col_num == 1) {
							update = true;
							map[r][cand_col_idx] = num + 1;
							flag[r][cand_col_idx] = complete;
							virtual_flag_row[r] |= 1 << num;
							flag_row[r] |= 1 << num;
							flag_col[cand_col_idx] |= 1 << num;
							virtual_flag_tile[tr * 3 + cand_col_idx / 3] |= 1 << num;
							flag_tile[tr * 3 + cand_col_idx / 3] |= 1 << num;
							q.offer(new Point(r, cand_col_idx));
							cnt++;
						}
					}
				}
				if (update) {
					break;
				}

				// col 체크
				for (int tc = 0; tc < 3; tc++) {
					for (int c = tc * 3; c < (tc + 1) * 3; c++) {
						if ((flag_col[c] & 1 << num) != 0)
							continue;
						int cand_row_num = 0;
						int cand_row_idx = -1;
						for (int tr = 0; tr < 3; tr++) {
							int tile_idx = tr * 3 + tc;
							if ((flag_tile[tile_idx] & 1 << num) != 0)
								continue;
							for (int r = tr * 3; r < (tr + 1) * 3; r++) {
								if (flag[r][c] == complete)
									continue;
								if ((flag_row[r] & 1 << num) != 0)
									continue;
								if ((virtual_flag_tile[tile_idx] & 1 << num) == 0) {
									if ((virtual_flag_row[r] & 1 << num) != 0)
										continue;
								}
								cand_row_num++;
								cand_row_idx = r;
							}
						}
						if (cand_row_num == 1) {
							update = true;
							map[cand_row_idx][c] = num + 1;
							flag[cand_row_idx][c] = complete;
							virtual_flag_col[c] |= 1 << num;
							flag_col[c] |= 1 << num;
							flag_row[cand_row_idx] |= 1 << num;
							virtual_flag_tile[(cand_row_idx / 3) * 3 + tc] |= 1 << num;
							flag_tile[(cand_row_idx / 3) * 3 + tc] |= 1 << num;
							q.offer(new Point(cand_row_idx, c));
							cnt++;
						}
					}
				}
				if (update) {
					break;
				}
			}
		}
		
		find_solution(0, cnt);
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
