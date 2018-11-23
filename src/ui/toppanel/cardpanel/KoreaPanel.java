package ui.toppanel.cardpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.toppanel.TopCardPanel;
import ui.toppanel.TopImg;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class KoreaPanel extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */

	JButton kimchiButton, boodaeButton, soyBeanButton, bibimButton, nangButton, binangButton, backButton, checkButton;
	JPanel img;
	TopCardPanel tcp;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;


	public KoreaPanel() {
		
		img = new TopImg(new ImageIcon("E:/miniimg/img/BasicImg/TopPanel.png").getImage());
		img.setLayout(null);
		
		setBackground(Color.WHITE);
		setLayout(null);

		img.setBounds(0, 0, 730, 646);
		img.setBackground(Color.GRAY);
		img.setLayout(null);
		
		backButton = new JButton(" µÚ·Î °¡±â ");
		backButton.setFont(new Font("¹®Ã¼ºÎ Á¦¸ñ ¹ÙÅÁÃ¼", Font.PLAIN, 17));
		backButton.setIcon(null);
		backButton.setSelectedIcon(null);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(Color.BLACK);
		backButton.setBounds(128, 523, 170, 74);
		img.add(backButton);

		checkButton = new JButton(" ¼±ÅÃ ¿Ï·á ");
		checkButton.setFont(new Font("¹®Ã¼ºÎ Á¦¸ñ ¹ÙÅÁÃ¼", Font.PLAIN, 17));
		checkButton.setBackground(new Color(0, 0, 0));
		checkButton.setBounds(416, 523, 170, 74);
		img.add(checkButton);

		kimchiButton = new JButton("");
		kimchiButton.setIcon(new ImageIcon("E:\\miniimg\\img\\1-\uD55C\uC2DD\\1-1kimchi.png"));
		kimchiButton.setBackground(Color.LIGHT_GRAY);
		kimchiButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		kimchiButton.setBounds(65, 30, 195, 195);
		img.add(kimchiButton);

		soyBeanButton = new JButton("");
		soyBeanButton.setIcon(new ImageIcon("E:\\miniimg\\img\\1-\uD55C\uC2DD\\1-2soybean.png"));
		soyBeanButton.setBackground(Color.LIGHT_GRAY);
		soyBeanButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		soyBeanButton.setBounds(272, 30, 195, 195);
		img.add(soyBeanButton);

		boodaeButton = new JButton("");
		boodaeButton.setIcon(new ImageIcon("E:\\miniimg\\img\\1-\uD55C\uC2DD\\1-3boodae.png"));
		boodaeButton.setBackground(Color.LIGHT_GRAY);
		boodaeButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		boodaeButton.setBounds(479, 30, 195, 195);
		img.add(boodaeButton);

		bibimButton = new JButton("");
		bibimButton.setIcon(new ImageIcon("E:\\miniimg\\img\\1-\uD55C\uC2DD\\1-4bibimbap.png"));
		bibimButton.setBackground(Color.LIGHT_GRAY);
		bibimButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		bibimButton.setBounds(65, 269, 195, 195);
		img.add(bibimButton);

		nangButton = new JButton("");
		nangButton.setIcon(new ImageIcon("E:\\miniimg\\img\\1-\uD55C\uC2DD\\1-5nang.jpg"));
		nangButton.setBackground(Color.LIGHT_GRAY);
		nangButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		nangButton.setBounds(272, 269, 195, 195);
		img.add(nangButton);

		binangButton = new JButton("");
		binangButton.setIcon(new ImageIcon("E:\\miniimg\\img\\1-\uD55C\uC2DD\\1-6beenang.jpg"));
		binangButton.setName("");
		binangButton.setBackground(Color.LIGHT_GRAY);
		binangButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		binangButton.setBounds(479, 269, 195, 195);
		img.add(binangButton);
		
		label = new JLabel("\uAE40\uCE58\uCC0C\uAC1C : 7,000");
		label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label.setBounds(102, 228, 126, 31);
		img.add(label);
		
		label_1 = new JLabel("\uB41C\uC7A5\uCC0C\uAC1C : 7,000");
		label_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_1.setBounds(304, 228, 126, 31);
		img.add(label_1);
		
		label_2 = new JLabel("\uBD80\uB300\uCC0C\uAC1C : 8,000");
		label_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_2.setBounds(514, 228, 126, 31);
		img.add(label_2);
		
		label_3 = new JLabel("\uBE44\uBE54\uBC25 : 6,000");
		label_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_3.setBounds(102, 474, 126, 31);
		img.add(label_3);
		
		label_4 = new JLabel("\uBB3C\uB0C9\uBA74 : 5,000");
		label_4.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_4.setBounds(304, 474, 126, 31);
		img.add(label_4);
		
		label_5 = new JLabel("\uBE44\uBE54\uB0C9\uBA74 : 5,000");
		label_5.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_5.setBounds(514, 474, 126, 31);
		img.add(label_5);

		setListener();

	}

	public void setListener() {
		kimchiButton.addActionListener(this);
		boodaeButton.addActionListener(this);
		soyBeanButton.addActionListener(this);
		bibimButton.addActionListener(this);
		nangButton.addActionListener(this);
		binangButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
