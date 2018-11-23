package ui.toppanel.cardpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.toppanel.TopCardPanel;

public class SchoolfoodPanel extends JPanel {
	JButton soonButton, denButton, kimbabButton, dduckButton, backButton, checkButton;
	TopCardPanel tcp;

	/**
	 * Create the panel.
	 */
	public SchoolfoodPanel() {

		setBackground(Color.WHITE);
		setLayout(null);

		this.setBounds(0, 0, 740, 690);
		this.setBackground(Color.GRAY);
		this.setLayout(null);

		backButton = new JButton(" 뒤로 가기 ");
		backButton.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		backButton.setIcon(null);
		backButton.setSelectedIcon(null);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(Color.BLACK);
		backButton.setBounds(129, 553, 170, 74);
		this.add(backButton);

		checkButton = new JButton(" 선택 완료 ");
		checkButton.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		checkButton.setBackground(new Color(0, 0, 0));
		checkButton.setBounds(436, 553, 170, 74);
		this.add(checkButton);

		dduckButton = new JButton("");
		dduckButton.setIcon(new ImageIcon("E:\\miniimg\\img\\5-\uBD84\uC2DD\\5-1dduck.png"));
		dduckButton.setBackground(Color.LIGHT_GRAY);
		dduckButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		dduckButton.setBounds(38, 48, 195, 195);
		this.add(dduckButton);

		soonButton = new JButton("");
		soonButton.setIcon(new ImageIcon("E:\\miniimg\\img\\5-\uBD84\uC2DD\\5-2soon.jpg"));
		soonButton.setBackground(Color.LIGHT_GRAY);
		soonButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		soonButton.setBounds(272, 48, 195, 195);
		this.add(soonButton);

		denButton = new JButton("");
		denButton.setIcon(new ImageIcon("E:\\miniimg\\img\\5-\uBD84\uC2DD\\5-3den.png"));
		denButton.setBackground(Color.LIGHT_GRAY);
		denButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		denButton.setBounds(507, 48, 195, 195);
		this.add(denButton);

		kimbabButton = new JButton("");
		kimbabButton.setIcon(new ImageIcon("E:\\miniimg\\img\\5-\uBD84\uC2DD\\5-4kimbap.png"));
		kimbabButton.setBackground(Color.LIGHT_GRAY);
		kimbabButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		kimbabButton.setBounds(38, 305, 195, 195);
		this.add(kimbabButton);

	}

}
