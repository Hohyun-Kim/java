package com.ssafy.interfacetest;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class WindowListenerTest extends Frame implements WindowListener {
	
//	Frame f = new Frame("Has A Test !!!!");
	Button push = new Button("Push!!!");
	
	public WindowListenerTest() {
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
		
//		WindowListener wl = new WindowListenerTest();
//		WindowListener wl = this;
//		this.addWindowListener(wl);
		this.addWindowListener(new MyWindowAdapter());
	}
	
	public static void main(String[] args) {
		new WindowListenerTest();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
