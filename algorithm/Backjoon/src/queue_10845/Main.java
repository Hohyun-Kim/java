package queue_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static ArrayDeque<String> queue = new ArrayDeque<>();
	static StringBuffer sb = new StringBuffer();
	
	static void do_operation(String[] command) {
		String op = command[0];
		if(op.equals("push")) {
			queue.offer(command[1]);
		} else {
			if(op.equals("pop")) {
				if(queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.poll());
				}
			} else if(op.equals("size")) {
				sb.append(queue.size());
			} else if(op.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			} else if(op.equals("front")) {
				if(queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.getFirst());
				}
			} else if(op.equals("back")) {
				if(queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.getLast());
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
