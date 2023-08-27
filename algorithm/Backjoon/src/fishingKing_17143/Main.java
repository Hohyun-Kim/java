package fishingKing_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, M;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	
	public static class shark {
		int row;
		int col;
		int speed;
		int direction;
		int size;
		public shark(int row, int col, int speed, int direction, int size) {
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.direction = direction;
			switch (this.direction) {
			case 1:
			case 2:
				this.size = size % (2*(row-1));
				break;
			case 3:
			case 4:
				this.size = size % (2*(col-1));
				break;
			}
		}
		public void move() {
			switch (this.direction) {
			case 1:
			case 2:
				move_vertical();
				break;
			case 3:
			case 4:
				move_horizental();
				break;
			}
		}
		public void move_vertical() {
			
		}
		public void move_horizental() {
			
			
		}
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
	}

}
