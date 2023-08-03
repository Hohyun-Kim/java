package com.ssafy.iotest;

import java.io.*;
import java.net.Socket;

public class BufferedTest {

	public static void main(String[] args) {
//		network
//		Socket s = new Socket();
//		InputStream is = s.getInputStream();
//		file
//		File file = new File("", "");
//		InputStream is = new FileInputStream(file);
//		system
//		InputStream is = System.in;
//		Reader r = new InputStreamReader(is);
//		BufferedReader in = new BufferedReader(r);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String rfile = null;
		String wfile = null;
		try {
			System.out.print("읽을 파일 이름 : ");
			rfile = in.readLine();
			System.out.print("복사 할 파일 이름 : ");
			wfile = in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		System.out.println(rfile);
		
		try(BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(rfile)));	FileWriter fw = new FileWriter(wfile)) {
			String txt = null;
			while((txt = fin.readLine()) != null) {
				System.out.print(txt + "\n");
				fw.write(txt + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
