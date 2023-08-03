package com.ssafy.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		File file = new File(new File("src\\com\\ssafy\\classtest"), "Car.java");
		File file = new File("src\\com\\ssafy\\classtest\\Car.java");
		int size = (int) file.length();
		System.out.println("읽을 파일의 크기 : " + size + " bytes");
		byte[] b = new byte[size];
		try {
			fis = new FileInputStream(file);
			int r = fis.read(b);
			String s = new String(b, 0, r-2);
			System.out.println(s);
			fos = new FileOutputStream("c:\\test\\copy.txt");
			fos.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)
					fis.close();
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
