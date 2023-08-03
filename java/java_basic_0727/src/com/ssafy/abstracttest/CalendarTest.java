package com.ssafy.abstracttest;

import java.text.*;
import java.util.*;

public class CalendarTest {

	public static void main(String[] args) {
//		Calendar cal = new Calendar(); // error (abstract는 객체 생성 불가능)
//		1. 하위 클래스 참조 (다형성)
//		Calendar cal = new GregorianCalendar();
//		2. 자신의 객체를 return 하는 static method.
		Calendar cal = Calendar.getInstance();
		
//		현재시간 : 2023년 7월 21일 15시 20분 15초
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println("현재시간 : " + year + "년 " + month + "월 " + day + "일 " + 
				hour + "시 " + minute + "분 " + second + "초");
		
		Format f = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss DDD");
		String cur = f.format(new Date());
		System.out.println(cur);
	}
	
}
