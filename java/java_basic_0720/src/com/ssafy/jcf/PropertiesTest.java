package com.ssafy.jcf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			InputStream instream = new FileInputStream("src\\com\\ssafy\\jcf\\test.properties");
			prop.load(instream);
			String name = prop.getProperty("name_cns");
			System.out.println(name + "님 안녕하세요");
			System.out.println("신기하다");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
