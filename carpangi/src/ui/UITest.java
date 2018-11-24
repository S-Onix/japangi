package ui;

import javax.swing.JFrame;

public class UITest extends JFrame{
	PayPanel pay;
	public UITest() {
		this.setVisible(true);
		this.setSize(740, 690);
		
		pay = new PayPanel();
		this.add(pay);
	}
	
	public static void main(String[] args) {
		new UITest();
	}
	
}
