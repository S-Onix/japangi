package ui.toppanel.cardpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.toppanel.TopCardPanel;
import ui.toppanel.TopImg;
import javax.swing.JLabel;

public class JapanPanel extends JPanel {
	JButton donButton, occoButton, dupButton, sushiButton, 
			backButton, checkButton;
	JPanel img;
	TopCardPanel tcp;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	/**
	 * Create the panel.
	 */
	public JapanPanel() {

		img = new TopImg(new ImageIcon("E:/miniimg/img/BasicImg/TopPanel.png").getImage());
		img.setLayout(null);
		
		setBackground(Color.WHITE);
		setLayout(null);
		this.tcp = tcp;

		img.setBounds(0, 0, 730, 646);
		img.setBackground(Color.GRAY);
		img.setLayout(null);

		backButton = new JButton(" µÚ·Î °¡±â ");
		backButton.setFont(new Font("¹®Ã¼ºÎ Á¦¸ñ ¹ÙÅÁÃ¼", Font.PLAIN, 17));
		backButton.setIcon(null);
		backButton.setSelectedIcon(null);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(new Color(192, 192, 192));
		backButton.setBounds(128, 523, 170, 74);
		img.add(backButton);

		checkButton = new JButton(" ¼±ÅÃ ¿Ï·á ");
		checkButton.setForeground(new Color(0, 0, 0));
		checkButton.setFont(new Font("¹®Ã¼ºÎ Á¦¸ñ ¹ÙÅÁÃ¼", Font.PLAIN, 17));
		checkButton.setBackground(new Color(192, 192, 192));
		checkButton.setBounds(416, 523, 170, 74);
		img.add(checkButton);
		
		donButton = new JButton("");
		donButton.setIcon(new ImageIcon("E:\\miniimg\\img\\3-\uC77C\uC2DD\\3-1don.png"));
		donButton.setBackground(Color.LIGHT_GRAY);
		donButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		donButton.setBounds(272, 33, 195, 195);
		img.add(donButton);

		occoButton = new JButton("");
		occoButton.setIcon(new ImageIcon("E:\\miniimg\\img\\3-\uC77C\uC2DD\\3-2occono.png"));
		occoButton.setBackground(Color.LIGHT_GRAY);
		occoButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		occoButton.setBounds(483, 33, 195, 195);
		img.add(occoButton);

		dupButton = new JButton("");
		dupButton.setIcon(new ImageIcon("E:\\miniimg\\img\\3-\uC77C\uC2DD\\3-3dup.png"));
		dupButton.setBackground(Color.LIGHT_GRAY);
		dupButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		dupButton.setBounds(65, 276, 195, 195);
		img.add(dupButton);

		
		sushiButton = new JButton("");
		sushiButton.setIcon(new ImageIcon("E:\\miniimg\\img\\3-\uC77C\uC2DD\\3-4sushi.png"));
		sushiButton.setBackground(Color.LIGHT_GRAY);
		sushiButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		sushiButton.setBounds(65, 33, 195, 195);
		img.add(sushiButton);
		
		label = new JLabel("\uCD08\uBC25 : 12,000");
		label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label.setBounds(101, 235, 107, 31);
		img.add(label);
		
		label_1 = new JLabel("\uB3C8\uAE4C\uC2A4 : 8,000");
		label_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_1.setBounds(311, 235, 119, 31);
		img.add(label_1);
		
		label_2 = new JLabel("\uC624\uCF54\uB178\uBBF8 : 9,000");
		label_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_2.setBounds(518, 235, 126, 31);
		img.add(label_2);
		
		label_3 = new JLabel("\uB77C\uBA58 : 9,000");
		label_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_3.setBounds(114, 481, 94, 31);
		img.add(label_3);
		
	}

}
