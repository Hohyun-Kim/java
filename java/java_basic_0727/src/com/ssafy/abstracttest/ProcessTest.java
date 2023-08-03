package com.ssafy.abstracttest;

import java.io.IOException;

public class ProcessTest {

	public static void main(String[] args) throws IOException, InterruptedException {
//		3. 외부클래스 참조
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("notepad.exe");
		Thread.sleep(3000);
		p.destroy();
	}
	
}
