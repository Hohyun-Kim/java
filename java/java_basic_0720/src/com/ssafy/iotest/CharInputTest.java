package com.ssafy.iotest;

import java.io.IOException;
import java.io.InputStreamReader;

public class CharInputTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		char[] c = new char[100];
		System.out.println("입력 : ");
		
		int r = isr.read(c);
		String str = new String(c, 0, r-2);
		System.out.println(str + " " + str.length());
	}
}
