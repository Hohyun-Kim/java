package com.ssafy.inheritance;

import java.io.*;
import java.util.StringTokenizer;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

public class AlgoThest {
	
//	4
//	1 2 3 4
//	6 7 8 5
	static String tc = "4\r\n" + 
			"1 2 3 4\r\n" + 
			"6 7 8 5";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(tc));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			String s = in.readLine();
			st = new StringTokenizer(s, " ");
			for(int j=0;j<4;j++) {
				System.out.println(st.nextToken());
			}
		}
	}
	
}
