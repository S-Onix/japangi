package test;

import javax.swing.JPanel;
import java.awt.Color;

public class BottomPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BottomPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 801, 277);
		add(panel);
		
	}

}
