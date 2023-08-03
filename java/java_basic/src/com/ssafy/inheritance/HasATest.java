package com.ssafy.inheritance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HasATest {
	
//	Frame f = new Frame();
	Frame f = new Frame("Has A Test !!!!");
//	Button push = new Button();
	Button push = new Button("Push!!!");
	
	public HasATest() {
		f.setLayout(new FlowLayout());
//		push.setLabel("Push!!!");
		f.add(push);
//		f.setTitle("Has A Test !!!!");
		f.setSize(400, 500);
		f.setLocation(200, 300);
		f.setVisible(true);
		
		push.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int r = random.nextInt(256);
				int g = random.nextInt(256);
				int b = random.nextInt(256);
				f.setBackground(new Color(r, g, b));
				
			}
		});
	}
	
	public static void main(String[] args) {
		new HasATest();
	}
}
