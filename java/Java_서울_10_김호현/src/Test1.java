import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			if (input.equals("*")) {
				for (int i = 0 ; i < 4; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print("  ");
					}
					for (int j = 4-i; j > 0; j--) {
						System.out.print("* ");
					}
					System.out.println();
				}
			} else if (input.equals("A")) {
				int Alphabet = 65;
				for (int i = 0 ; i < 5; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print("  ");
					}
					for (int j = 2*(5-i)-1; j > 0; j--) {
						System.out.print((char)Alphabet+" ");
						Alphabet++;
					}
					System.out.println();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
