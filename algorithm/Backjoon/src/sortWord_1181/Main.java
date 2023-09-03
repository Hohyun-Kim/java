package sortWord_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		Set<String> word_set = new HashSet<>();
		List<String> words = new ArrayList<String>();
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			if(!word_set.contains(word)) {
				word_set.add(word);
				words.add(word);
			}
		}
		Collections.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int l1 = o1.length();
				int l2 = o2.length();
				if(l1 == l2) return o1.compareTo(o2); 
				return l1-l2;
			}
		});
		for(int i = 0; i < words.size(); i++) {
			sb.append(words.get(i)).append("\n");
		}
		System.out.println(sb);

	}

}
