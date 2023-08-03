package com.ssafy.jcf;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			InputStream inStream = new FileInputStream("src\\com\\ssafy\\jcf\\test.properties");
			prop.load(inStream);
			String name = prop.getProperty("name_eng");
			System.out.println(name + "님 안녕하세요");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
