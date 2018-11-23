package ui.toppanel.cardpanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class RanSelPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RanSelPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 0, 740, 690);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" 밥 ");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBackground(new Color(255, 192, 203));
		lblNewLabel_1.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 80));
		lblNewLabel_1.setBounds(66, 61, 170, 170);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" 면 ");
		lblNewLabel_2.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 80));
		lblNewLabel_2.setBounds(292, 61, 170, 170);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("찌개");
		lblNewLabel_3.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 75));
		lblNewLabel_3.setBounds(518, 63, 170, 170);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("튀김");
		lblNewLabel_4.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 75));
		lblNewLabel_4.setBounds(66, 286, 170, 170);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("고기");
		lblNewLabel_5.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 75));
		lblNewLabel_5.setBounds(292, 286, 170, 170);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("무작위");
		lblNewLabel_6.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 55));
		lblNewLabel_6.setBounds(518, 293, 170, 170);
		panel_1.add(lblNewLabel_6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("선택해주세요");
		rdbtnNewRadioButton.setBackground(new Color(128, 128, 128));
		rdbtnNewRadioButton.setFont(new Font("한양해서", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(88, 237, 121, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("선택해주세요");
		rdbtnNewRadioButton_1.setBackground(new Color(128, 128, 128));
		rdbtnNewRadioButton_1.setFont(new Font("한양해서", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(317, 237, 121, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("선택해주세요");
		rdbtnNewRadioButton_2.setBackground(new Color(128, 128, 128));
		rdbtnNewRadioButton_2.setFont(new Font("한양해서", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(528, 239, 121, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("선택해주세요");
		rdbtnNewRadioButton_3.setBackground(new Color(128, 128, 128));
		rdbtnNewRadioButton_3.setFont(new Font("한양해서", Font.PLAIN, 16));
		rdbtnNewRadioButton_3.setBounds(88, 462, 121, 23);
		panel_1.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("선택해주세요");
		rdbtnNewRadioButton_4.setBackground(new Color(128, 128, 128));
		rdbtnNewRadioButton_4.setFont(new Font("한양해서", Font.PLAIN, 16));
		rdbtnNewRadioButton_4.setBounds(317, 462, 121, 23);
		panel_1.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("선택해주세요");
		rdbtnNewRadioButton_5.setBackground(new Color(128, 128, 128));
		rdbtnNewRadioButton_5.setFont(new Font("한양해서", Font.PLAIN, 16));
		rdbtnNewRadioButton_5.setBounds(528, 462, 121, 23);
		panel_1.add(rdbtnNewRadioButton_5);
		
		JButton btnNewButton_3 = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		btnNewButton_3.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		btnNewButton_3.setIcon(null);
		btnNewButton_3.setSelectedIcon(null);
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(129, 553, 170, 74);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uC120\uD0DD \uC644\uB8CC");
		btnNewButton_4.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(436, 553, 170, 74);
		panel_1.add(btnNewButton_4);
	}
}
