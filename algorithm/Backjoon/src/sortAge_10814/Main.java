package sortAge_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static class person implements Comparable<person>{
		int age;
		String name;
		public person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(person o) {
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		person[] people = new person[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i] = new person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(people);
		for(int i = 0; i < N; i++) {
			sb.append(people[i].age).append(" ").append(people[i].name).append("\n");
		}
		System.out.println(sb);

	}

}
