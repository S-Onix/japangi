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

public class AmericaPanel extends JPanel {
	JButton pizzaButton, hambugerButton, sandwichButton, chickenButton, steakButton, curryButton, 
			backButton, checkButton;
	JPanel img;
	TopCardPanel tcp;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	/**
	 * Create the panel.
	 */
	public AmericaPanel() {

		setBackground(Color.WHITE);
		setLayout(null);
		this.tcp = tcp;

		img = new TopImg(new ImageIcon("E:/miniimg/img/BasicImg/TopPanel.png").getImage());
		img.setBounds(0, 0, 731, 645);
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
		
		pizzaButton = new JButton("");
		pizzaButton.setIcon(new ImageIcon("E:\\miniimg\\img\\4-\uC591\uC2DD\\4-2pizza.jpg"));
		pizzaButton.setBackground(Color.LIGHT_GRAY);
		pizzaButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		pizzaButton.setBounds(272, 28, 195, 195);
		img.add(pizzaButton);

		hambugerButton = new JButton("");
		hambugerButton.setIcon(new ImageIcon("E:\\miniimg\\img\\4-\uC591\uC2DD\\4-3hambuger.jpg"));
		hambugerButton.setBackground(Color.LIGHT_GRAY);
		hambugerButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		hambugerButton.setBounds(479, 28, 195, 195);
		img.add(hambugerButton);

		sandwichButton = new JButton("");
		sandwichButton.setIcon(new ImageIcon("E:\\miniimg\\img\\4-\uC591\uC2DD\\4-4sandwich.png"));
		sandwichButton.setBackground(Color.LIGHT_GRAY);
		sandwichButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		sandwichButton.setBounds(65, 274, 195, 195);
		img.add(sandwichButton);

		
		steakButton = new JButton("");
		steakButton.setIcon(new ImageIcon("E:\\miniimg\\img\\4-\uC591\uC2DD\\4-5steak.png"));
		steakButton.setBounds(272, 274, 195, 195);
		img.add(steakButton);

		curryButton = new JButton("");
		curryButton.setIcon(new ImageIcon("E:\\miniimg\\img\\4-\uC591\uC2DD\\4-6curry.png"));
		curryButton.setBounds(479, 274, 195, 195);
		img.add(curryButton);

		
		chickenButton = new JButton("");
		chickenButton.setIcon(new ImageIcon("E:\\miniimg\\img\\4-\uC591\uC2DD\\4-1chicken.png"));
		chickenButton.setBackground(Color.LIGHT_GRAY);
		chickenButton.setFont(new Font("¹®Ã¼ºÎ ÈÆ¹ÎÁ¤À½Ã¼", Font.PLAIN, 30));
		chickenButton.setBounds(65, 28, 195, 195);
		img.add(chickenButton);
		
		this.add(img);
		
		label = new JLabel("\uCE58\uD0A8 : 17,000");
		label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label.setBounds(112, 233, 119, 31);
		img.add(label);
		
		label_1 = new JLabel("\uD53C\uC790 : 10,000");
		label_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_1.setBounds(314, 233, 119, 31);
		img.add(label_1);
		
		label_2 = new JLabel("\uD584\uBC84\uAC70 : 6,000");
		label_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_2.setBounds(517, 233, 119, 31);
		img.add(label_2);
		
		label_3 = new JLabel("\uC0CC\uB4DC\uC704\uCE58 : 4,000");
		label_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_3.setBounds(100, 479, 131, 31);
		img.add(label_3);
		
		label_4 = new JLabel("\uD584\uBC84\uADF8 : 11,000");
		label_4.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_4.setBounds(302, 479, 131, 31);
		img.add(label_4);
		
		label_5 = new JLabel("\uCE74\uB808 : 7,000");
		label_5.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		label_5.setBounds(537, 479, 99, 31);
		img.add(label_5);
		
	}

}
