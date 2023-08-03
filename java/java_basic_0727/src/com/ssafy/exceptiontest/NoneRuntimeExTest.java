package com.ssafy.exceptiontest;

import java.io.*;

public class NoneRuntimeExTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			Class.forName("com.ssafy.basic.Lotto");
			System.out.println("클래스 로딩 성공!!!!");
			fis = new FileInputStream("c:\\test\\a2.txt");
			System.out.println("a.txt 연결 성공!!!");
			int x = fis.read();
			System.out.println("읽음?? " + x);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 없어!!!");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("a.txt 없어!!!");
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("읽다 에러 발생!!");
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
