package ui.toppanel.cardpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.toppanel.TopCardPanel;
import ui.toppanel.TopImg;

public class PaymentWindow extends JPanel {
	JButton jjamButton, tangButton, jajangButton, 
	backButton, checkButton, btnNewButton;
	private JButton payngCardButton;
	private JButton payngCashButton;
	private JList<String> countryList;
	JPanel img;
	TopCardPanel tcp;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public PaymentWindow() {
		img = new TopImg(new ImageIcon("E:/miniimg/img/BasicImg/TopPanel.png").getImage());
		img.setLayout(null);
		
		setLayout(null);
		this.tcp = tcp;

		img.setBounds(0, 0, 730, 646);
		img.setLayout(null);
		
		backButton = new JButton(" µ⁄∑Œ ∞°±‚ ");
		backButton.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 17));
		backButton.setIcon(null);
		backButton.setSelectedIcon(null);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(new Color(192, 192, 192));
		backButton.setBounds(86, 488, 170, 74);
		img.add(backButton);

		payngCardButton = new JButton("\uCE74\uB4DC \uACB0\uC81C");
		payngCardButton.setForeground(new Color(0, 0, 0));
		payngCardButton.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 17));
		payngCardButton.setBackground(new Color(192, 192, 192));
		payngCardButton.setBounds(283, 488, 170, 74);
		img.add(payngCardButton);
		
		payngCashButton = new JButton("\uD604\uAE08 \uACB0\uC81C");
		payngCashButton.setForeground(new Color(0, 0, 0));
		payngCashButton.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 17));
		payngCashButton.setBackground(new Color(192, 192, 192));
		payngCashButton.setBounds(473, 488, 170, 74);
		img.add(payngCashButton);
		
		JList list = new JList();
		list.setBounds(74, 67, 594, 277);
		img.add(list);
		
		JLabel label = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561");
		label.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 20));
		label.setBounds(102, 395, 125, 62);
		img.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("æ»ªÛºˆ2006±Ω¿∫", Font.PLAIN, 42));
		textField.setText("32,000");
		textField.setBounds(239, 409, 429, 49);
		img.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Load Value");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel<String> DLM = new DefaultListModel<>();
				DLM.addElement("¬•¿Â");
				DLM.addElement("¬´ªÕ");
				DLM.addElement("≈¡ºˆ¿∞");
				DLM.addElement("∂±∫∫¿Ã");
				DLM.addElement("±Ëπ‰");
//				list.setModel(DLM);
				countryList = new JList<>(DLM);
			}
		});
		btnNewButton.setBounds(532, 354, 136, 45);
		img.add(btnNewButton);
		
	}
	public static void main(String args[]) {
		new PaymentWindow();
	}
}
