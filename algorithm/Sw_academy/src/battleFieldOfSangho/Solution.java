package battleFieldOfSangho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int H;
	public static int W;
	public static char[][] map;
	public static int tank_watch;
	public static int[] tank_now;
	public static char[] tank_icon = {'^', '>', 'v', '<'};
	public static int[] tank_dr = {-1, 0, 1, 0};
	public static int[] tank_dc = {0, 1, 0, -1};
	
	public static boolean in_map(int nr, int nc) {
		return nr<H && nr>=0 && nc<W && nc>=0;
	}
	
	public static void act(char command) {
		switch(command) {
		case 'S':
			shoot();
			break;
		case 'U':
			tank_watch = 0;
			move();
			break;
		case 'R':
			tank_watch = 1;
			move();
			break;
		case 'D':
			tank_watch = 2;
			move();
			break;
		case 'L':
			tank_watch = 3;
			move();
			break;
		}
	}
	
	public static void shoot() {
		int dr = tank_dr[tank_watch];
		int dc = tank_dc[tank_watch];
		int nr = tank_now[0] + dr;
		int nc = tank_now[1] + dc;
		while(in_map(nr, nc)) {
			if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				return;
			}
			if(map[nr][nc] == '#') {
				return;
			}
			nr += dr;
			nc += dc;
		}
	}
	
	public static void move() {
		int nr = tank_now[0]+tank_dr[tank_watch];
		int nc = tank_now[1]+tank_dc[tank_watch];
		if(in_map(nr, nc) && map[nr][nc] == '.') {
			map[tank_now[0]][tank_now[1]] = '.';
			tank_now[0] = nr;
			tank_now[1] = nc;
		}
		map[tank_now[0]][tank_now[1]] = tank_icon[tank_watch];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/battleFieldOfSangho/input.txt"));
//		BufferedReader bo = new BufferedReader(new FileReader("./src/battleFieldOfSangho/output.txt"));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			tank_now = new int[2];
			tank_watch = 0;
			boolean tank_check = true;
			for(int h = 0; h < H; h++) {
				String temp = br.readLine();
				for(int w = 0; w < W; w++) {
					map[h][w] = temp.charAt(w);
					if(tank_check && map[h][w] == '^' || map[h][w] == '>' || map[h][w] == 'v' || map[h][w] == '<') {
						tank_check = false;
						tank_now[0] = h;
						tank_now[1] = w;
						for(int i = 0; i < 4; i++) {
							if(map[h][w] == tank_icon[i]) {
								tank_watch = i;
								break;
							}
						}
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String instruction = br.readLine();
			for(int i = 0; i < N; i++) {
				act(instruction.charAt(i));
			}
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
//			for(int h = 0; h < H; h++) {
//				StringBuilder temp = new StringBuilder();
//				for(int w = 0; w < W; w++) {
//					sb.append(map[h][w]);
//					temp.append(map[h][w]);
//				}
//				if(!temp.toString().equals(bo.readLine())&&h!=0) {
//					System.out.println("#" + t);
//					System.out.println("h : " + h);
//					System.out.println(temp);
//				};
//				sb.append("\n");
//			}
		}
		System.out.println(sb);
		
	}

}
