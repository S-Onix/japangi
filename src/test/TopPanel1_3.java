package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TopPanel1_3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public TopPanel1_3() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 740, 56);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnNewButton_1.setBounds(503, 10, 65, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("장바구니");
		btnNewButton.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 14));
		btnNewButton.setBounds(569, 10, 85, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnNewButton_2.setBounds(655, 10, 73, 36);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Team1");
		lblNewLabel.setFont(new Font("Adobe Arabic", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 10, 104, 36);
		
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 52, 740, 690);
		add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton btnNewButton_3 = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		btnNewButton_3.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		btnNewButton_3.setIcon(null);
		btnNewButton_3.setSelectedIcon(null);
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setBounds(129, 553, 170, 74);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uC120\uD0DD \uC644\uB8CC");
		btnNewButton_4.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setBounds(436, 553, 170, 74);
		panel_1.add(btnNewButton_4);
	}

}
