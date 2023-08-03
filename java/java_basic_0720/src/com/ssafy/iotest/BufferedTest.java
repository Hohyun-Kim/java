package com.ssafy.iotest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.Socket;

public class BufferedTest {
	
	public static void main(String[] args) {
//		system
//		InputStream is = System.in;
		
//		file
//		File file = new File("src\\com\\ssafy\\classtest\\Marine.java")
//		InputStream is = new FileInputStream(file);
		
//		network
//		Socket s = new Socket();
//		InputStream is = s.getInputStream();
				
		
//		with input stream reader
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 한글이 있기 때문에 Writer사용
		try (BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(rfile)));
				FileWriter fw = new FileWriter(wfile);){
			String txt = null;
			while((txt = fin.readLine()) != null){
				System.out.println(txt);
//				c:\\test\\마린.txt
//				fw.write(txt);
				
//				c:\\test\\마린2.txt
				fw.write(txt+"\n"); 
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
