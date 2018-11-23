package ui.toppanel.cardpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.toppanel.TopImg;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class ShoppingBasket extends JPanel {
	JButton backButton, checkButton;
	JPanel img;
	private JLabel lblNewLabel;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public ShoppingBasket() {
		img = new TopImg(new ImageIcon("E:/miniimg/img/BasicImg/TopPanel.png").getImage());
		img.setLayout(null);
		
		backButton = new JButton(" 뒤로 가기 ");
		backButton.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		backButton.setIcon(null);
		backButton.setSelectedIcon(null);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(new Color(192, 192, 192));
		backButton.setBounds(128, 523, 170, 74);
		img.add(backButton);

		checkButton = new JButton(" 선택 완료 ");
		checkButton.setForeground(new Color(0, 0, 0));
		checkButton.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		checkButton.setBackground(new Color(192, 192, 192));
		checkButton.setBounds(416, 523, 170, 74);
		img.add(checkButton);
		
		lblNewLabel = new JLabel("\uC74C\uC2DD");
		lblNewLabel.setBounds(99, 116, 195, 195);
		img.add(lblNewLabel);
		
		label = new JLabel("\uC74C\uC2DD");
		label.setBounds(415, 116, 195, 195);
		img.add(label);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(99, 317, 115, 23);
		img.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(379, 317, 115, 23);
		img.add(chckbxNewCheckBox_1);

	}
}
