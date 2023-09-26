package sudoku_2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static final int complete = (1 << 9) - 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String line;
		int[][] map = new int[9][9];
		int[][] flag = new int[9][9];
		int[] flag_row = new int[9];
		int[] flag_col = new int[9];
		int[] virtual_flag_row = new int[9];
		int[] virtual_flag_col = new int[9];
		int[] flag_tile = new int[9];
		int[] virtual_flag_tile = new int[9];
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
		
		for(int i = 0; i < 9; i++) {
			virtual_flag_row[i] = flag_row[i];
			virtual_flag_col[i] = flag_col[i];
			virtual_flag_tile[i] = flag_tile[i];
		}
		
		boolean[] cand_row = new boolean[3];
		boolean[] cand_col = new boolean[3];
		int cycle = 0;
		while(cnt!=81) {
			// flag update
			for(int r = 0; r < 9; r++) {
				int row_group = r/3;
				for(int c = 0; c < 9; c++) {
					if(flag[r][c] == complete) continue;
					int col_group = c/3;
					flag[r][c] |= flag_row[r];
					flag[r][c] |= flag_col[c];
					flag[r][c] |= flag_tile[(row_group*3+col_group)];
				}
			}
			
			// 후보 1개인거 채워주기
			for(int r = 0; r < 9; r++) {
				int row_group = r/3;
				for(int c = 0; c < 9; c++) {
					int col_group = c/3;
					if(Integer.bitCount(flag[r][c]) == 8) {
						int put = 0;
						for(int i = 0; i < 9; i++) {
							if((flag[r][c] & (1<<i)) == 0) {
								flag[r][c] = complete;
								put = i+1;
								flag_row[r] |= 1<<i;
								flag_col[c] |= 1<<i;
								flag_tile[(row_group*3+col_group)] |= 1<<i;
								cnt++;
								break;
							}
						}
						map[r][c] = put;
					}
				}
			}

			
			// 들어갈 칸이 1개밖에 없으면 채우기
			for (int num = 0; num < 9; num++) {
				// tile 체크
				for (int tr = 0; tr < 3; tr++) {
					for (int tc = 0; tc < 3; tc++) {
						int tile_idx = tr*3+tc;
						if ((flag_tile[tile_idx] & (1<<num)) != 0) continue;
						int cnt_num = 0;
						int cand_row_num = 0;
						int cand_col_num = 0;
						for(int r = 3*tr; r < 3*(tr+1); r++) {
							cand_row[r%3] = false;
							if ((virtual_flag_row[r] & (1<<num)) != 0) {
								cnt_num += 3;
								continue;
							}
							cand_row_num++;
							cand_row[r%3] = true;
							for(int c = 3*tc; c < 3*(tc+1); c++) {
								cand_col[c%3] = false;
								if ((virtual_flag_col[c] & (1<<num)) != 0) {
									cnt_num++;
									continue;
								}
								cand_col_num++;
								cand_col[c%3] = true;
							}
						}
						
						if(cand_row_num == 1) {
							for(int r = 0; r < 3; r++) {
								int put_row = 3*tr+r;
								if(cand_row[r]) {
									virtual_flag_row[put_row] |= 1<<num;
									virtual_flag_tile[tile_idx] |= 1<<num;
								}
							}
						}
						
						if(cand_col_num == 1) {
							for(int c = 0; c < 3; c++) {
								int put_col = 3*tc+c;
								if(cand_col[c]) {
									virtual_flag_col[put_col] |= 1<<num;
									virtual_flag_tile[tile_idx] |= 1<<num;
								}
							}
						}
						
						if(cnt_num == 8) {
							boolean putsuccess = false;
							for(int r = 0; r < 3; r++) {
								for(int c = 0; c < 3; c++) {
									if(cand_row[r] && cand_col[c]) {
										int put_row = 3*tr+r;
										int put_col = 3*tc+c;
										map[put_row][put_col] = num+1;
										flag[put_row][put_col] = complete;
										flag_row[put_row] |= 1<<num;
										flag_col[put_col] |= 1<<num;
										flag_tile[tile_idx] |= 1<<num;
										cnt++;
										putsuccess = true;
										break;
									}
								}
								if(putsuccess) break;
							}
						}
						
					}
				}
				// row 체크
				for(int tr = 0; tr < 3; tr++) {
					for(int r = tr*3; r < (tr+1)*3; r++) {
						if((flag_row[r] & 1<<num) != 0) continue;
						int cand_col_num = 0;
						int cand_col_idx = -1;
						for(int tc = 0; tc < 3; tc++) {
							int tile_idx = tr*3+tc;
							if((flag_tile[tile_idx] & 1<<num) != 0) continue;
							for(int c = tc*3; c < (tc+1)*3; c++) {
								if((flag_col[c] & 1<<num) != 0) continue;
								if((virtual_flag_tile[tile_idx] & 1<<num) == 0) {
									if((virtual_flag_col[c] & 1<<num) != 0) continue;
								}
								cand_col_num++;
								cand_col_idx = c;
							}
						}
						if(cand_col_num==1) {
							int put_row = 3*tr+r;
							map[put_row][cand_col_idx] = num+1;
							flag[put_row][cand_col_idx] = complete;
							flag_row[put_row] |= 1<<num;
							flag_col[cand_col_idx] |= 1<<num;
							flag_tile[tr*3+cand_col_idx/3] |= 1<<num;
							cnt++;
						}
					}
				}
				// col 체크
				for(int tc = 0; tc < 3; tc++) {
					for(int c = tc*3; c < (tc+1)*3; c++) {
						if((flag_col[c] & 1<<num) != 0) continue;
						int cand_row_num = 0;
						int cand_row_idx = -1;
						for(int tr = 0; tr < 3; tr++) {
							int tile_idx = tr*3+tc;
							if((flag_tile[tile_idx] & 1<<num) != 0) continue;
							for(int r = tr*3; r < (tr+1)*3; r++) {
								if((flag_row[r] & 1<<num) != 0) continue;
								if((virtual_flag_tile[tile_idx] & 1<<num) == 0) {
									if((virtual_flag_row[r] & 1<<num) != 0) continue;
								}
								cand_row_num++;
								cand_row_idx = r;
								if(cycle==3 && c==3 && r==2 && num==1) {
									System.out.println("row_num : " + cand_row_num);
									System.out.println("row_idx : " + cand_row_idx);
								}
							}
						}
						if(cand_row_num==1) {
							int put_col = 3*tc+c;
							map[cand_row_idx][put_col] = num+1;
							flag[cand_row_idx][put_col] = complete;
							flag_col[put_col] |= 1<<num;
							flag_row[cand_row_idx] |= 1<<num;
							flag_tile[(cand_row_idx/3)*3+tc] |= 1<<num;
							cnt++;
						}
					}
				}
				
			}
			for (int r = 0; r < 9; r++) {
				System.out.println(Arrays.toString(map[r]));
			}
			System.out.println();
			cycle++;
			if(cycle == 3) break;
		}
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
