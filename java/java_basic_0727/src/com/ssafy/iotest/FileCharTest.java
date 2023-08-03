package com.ssafy.iotest;

import java.io.*;

public class FileCharTest {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		File file = new File("src\\com\\ssafy\\classtest\\Car.java");
		int size = (int) file.length();
		System.out.println("읽을 파일의 크기 : " + size + " bytes");
		char[] c = new char[size];
		try {
			fr = new FileReader(file);
			int r = fr.read(c);
			System.out.println(r + "character read");
			String s = new String(c, 0, r - 2);
			System.out.println(s);
			fw = new FileWriter("c:\\test\\copy2.txt");
//			fw.write(c, 0, r - 2);
			fw.write(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null)
					fr.close();
				if(fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
