package com.ssafy.abstracttest;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class WindowEvTest extends Frame {
	
//	Frame f = new Frame("Has A Test !!!!");
	Button push = new Button("Push!!!");
	
	public WindowEvTest() {
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
		
		WindowListener l = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("프로그램 닫히기전에 XXX 했다.");
				System.exit(0);
			}
			
		};
		this.addWindowListener(l);
	}
	
	public static void main(String[] args) {
		new WindowEvTest();
	}

}
