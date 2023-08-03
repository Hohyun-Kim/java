package com.ssafy.iotest;

import java.io.IOException;
import java.io.InputStream;

public class StdIOTest {
	
	public static void main(String[] args) {
		String s = "김호현";
		byte[] b = s.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		System.out.print( "문자열 입력 : ");
		InputStream in = System.in;
		try {
//			int r = in.read();
//			System.out.println("읽은 문자열 : " + (char) r);
			byte[] b1 = new byte[100];
			int x = in.read(b1);
			System.out.println(x + "bytes read");
			for (int i = 0; i < b1.length; i++) {
				System.out.print((char)b1[i]);
			}
			String s1 = new String(b1);
			System.out.println(s1);
			System.out.println(s1.length());
			String s2 = new String(b1, 0, x-2);
			System.out.println(s2);
			System.out.println(s2.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
