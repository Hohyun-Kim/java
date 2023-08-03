package com.ssafy.iotest;

import java.io.IOException;
import java.io.InputStreamReader;

public class CharInputTest {

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			char[] c = new char[100];
			System.out.print("입력 : ");
			int r = isr.read(c);
			System.out.println(r + "characters read");
			String s = new String(c, 0, r - 2);
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
