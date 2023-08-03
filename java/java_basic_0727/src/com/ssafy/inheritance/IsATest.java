package com.ssafy.inheritance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class IsATest extends Frame {
	
//	Frame f = new Frame("Has A Test !!!!");
	Button push = new Button("Push!!!");
	
	public IsATest() {
		super("Is A Test!!!");
		setLayout(new FlowLayout());
//		push.setLabel("Push!!!");
		add(push);
//		setTitle("Has A Test !!!!");
		setSize(400, 500);
		setLocation(200, 300);
		setVisible(true);
		
		push.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int r = random.nextInt(256);
				int g = random.nextInt(256);
				int b = random.nextInt(256);
				setBackground(new Color(r, g, b));
			}
		});
	}
	
	public static void main(String[] args) {
		new IsATest();
	}

}
