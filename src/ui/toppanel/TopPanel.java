package ui.toppanel;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	TopButtonPanel buttonPanel;
	TopCardPanel cardPanel;
	JFrame parent;
	
	/**
	 * Create the panel.
	 */
	public TopPanel() {
		this.setBackground(Color.GREEN);
		setLayout(null);
		
		cardPanel = new TopCardPanel();
		cardPanel.setBounds(0, 52, 740, 690);
		add(cardPanel);
		
		buttonPanel = new TopButtonPanel(cardPanel);
		buttonPanel.setBounds(0, 0, 740, 56);
		add(buttonPanel);
		
		
	}
}
