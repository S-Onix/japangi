package test;

import javax.swing.JFrame;

import ui.toppanel.cardpanel.ChinaPanel;

public class FrameTest extends JFrame{
	public FrameTest() {
		this.add(new ChinaPanel());
		this.setVisible(true);
		this.setSize(760, 694);
	}
	
	public static void main(String [] args) {
		new FrameTest();
	}
}
