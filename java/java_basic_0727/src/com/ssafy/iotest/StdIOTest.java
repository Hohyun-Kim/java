package com.ssafy.iotest;

import java.io.*;

public class StdIOTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String s = "안효인";
//		byte[] b = s.getBytes("ISO-8859-1");
//		for(int i=0;i<b.length;i++)
//			System.out.print(b[i] + " ");
//		System.out.println();
//		String s2 = new String(b, "utf-8");
//		System.out.println(s2);
//		byte[] b2 = s.getBytes("utf-8");
//		s2 = new String(b2, "ISO-8859-1");
//		System.out.println(s2);
		try {
			System.out.print("문자열 입력 : ");
			InputStream in = System.in;
//			int r = in.read();
//			System.out.println("읽은 문자열 : " + (char) r);
			byte[] b = new byte[100];
			int x = in.read(b);
			System.out.println(x + "bytes read");
			for (int i = 0; i < b.length; i++) {
				System.out.print((char)b[i]);
			}
			String s = new String(b);
			System.out.println(s);
			System.out.println(s.length());
			String s2 = new String(b, 0, x-2);
			System.out.println(s2);
			System.out.println(s2.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
