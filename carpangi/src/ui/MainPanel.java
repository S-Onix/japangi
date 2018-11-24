package ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		this.setBackground(Color.red);
		setLayout(null);
		
		JButton btnNewButton = new JButton("ÇÑ½Ä");
		btnNewButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		btnNewButton.setBounds(38, 48, 200, 200);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(272, 48, 195, 195);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(507, 48, 195, 195);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(38, 305, 195, 195);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(272, 305, 195, 195);
		add(btnNewButton_4);
	}

}
