package ui;

import javax.swing.JFrame;

import ui.order.ChiPanel;

public class UITest extends JFrame{
	ChiPanel pay;
	public UITest() {
		this.setVisible(true);
		this.setSize(740, 690);
		
		pay = new ChiPanel();
		this.add(pay);
	}
	
	public static void main(String[] args) {
		new UITest();
	}
	
}
