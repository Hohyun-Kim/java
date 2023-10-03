package deque_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static ArrayDeque<String> deque = new ArrayDeque<>();
	static StringBuffer sb = new StringBuffer();
	
	static void do_operation(String[] command) {
		String op = command[0];
		if(op.equals("push_front")) {
			deque.offerFirst(command[1]);
		} 
		else if(op.equals("push_back")) {
			deque.offerLast(command[1]);
		}
		else {
			if(op.equals("pop_front")) {
				if(deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.pollFirst());
				}
			} else if(op.equals("pop_back")) {
				if(deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.pollLast());
				}
			} else if(op.equals("size")) {
				sb.append(deque.size());
			} else if(op.equals("empty")) {
				if(deque.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			} else if(op.equals("front")) {
				if(deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.getFirst());
				}
			} else if(op.equals("back")) {
				if(deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.getLast());
				}
			}
			sb.append("\n");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] command = new String[2];
		for(int n = 0; n < N; n++) {
			command = br.readLine().split(" ");
			do_operation(command);
		}
		System.out.println(sb);
	}

}
