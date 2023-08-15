package foldPaper_20187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static int change_hole(int num, boolean updown) {
		int hole;
		if(updown) {
			switch(num) {
			case 0:
				hole = 2;
				break;
			case 1:
				hole = 3;
				break;
			case 2:
				hole = 0;
				break;
			case 3:
				hole = 1;
				break;
			default:
				hole = -1;
				break;
			}
		} else {
			switch(num) {
			case 0:
				hole = 1;
				break;
			case 1:
				hole = 0;
				break;
			case 2:
				hole = 3;
				break;
			case 3:
				hole = 2;
				break;
			default:
				hole = -1;
				break;
			}
		}
		return hole;
	}
	
	public static void fold(String op, ArrayList<ArrayList<Integer>> paper) {
		if (op.equals("D")) {
			int R = paper.size();
			int C = paper.get(0).size();
			for(int r = 0; r < R; r++) {
				ArrayList<Integer> now = new ArrayList<Integer>();
				int r_copy = 2*r;
				for(int c = 0; c < C; c++) {
					now.add(change_hole(paper.get(r_copy).get(c), true));
				}
				paper.add(0, now);
			}
		} else if (op.equals("U")) {
			int R = paper.size();
			int C = paper.get(0).size();
			for(int r = 0; r < R; r++) {
				ArrayList<Integer> now = new ArrayList<Integer>();
				int r_copy = R-1-r;
				for(int c = 0; c < C; c++) {
					now.add(change_hole(paper.get(r_copy).get(c), true));
				}
				paper.add(now);
			}
		} else if (op.equals("R")) {
			int R = paper.size();
			int C = paper.get(0).size();
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					paper.get(r).add(0, change_hole(paper.get(r).get(c*2), false));
				}
			}
		} else if (op.equals("L")) {
			int R = paper.size();
			int C = paper.get(0).size();
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					int c_copy = C-1-c;
					paper.get(r).add(change_hole(paper.get(r).get(c_copy), false));
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Deque<String> op = new ArrayDeque<String>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 2*k; i++) {
			op.addLast(st.nextToken());
		}
		ArrayList<ArrayList<Integer>> paper = new ArrayList<>();
		ArrayList<Integer> init = new ArrayList<>();
		init.add(Integer.parseInt(br.readLine()));
		paper.add(init);
		while(op.size() != 0) {
			fold(op.pollLast(), paper);
		}
		int size = (int) Math.pow(2, k);
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				sb.append(paper.get(r).get(c)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
