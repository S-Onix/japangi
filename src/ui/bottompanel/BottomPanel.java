package ui.bottompanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	public JPanel img;
	/**
	 * Create the panel.
	 */
	public BottomPanel() {
		img = new BottomImg(new ImageIcon("E:/miniimg/img/BasicImg/BottomPanel.png").getImage());
		this.add(img);
	}

}
