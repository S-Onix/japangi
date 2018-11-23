package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.toppanel.TopCardPanel;

public class TestFrame extends JPanel {
	JButton jjamButton, tangButton, jajangButton, 
	backButton, checkButton, btnNewButton;
	private JButton payngCardButton;
	private JButton payngCashButton;
	TopCardPanel tcp;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public TestFrame() {
		setBackground(Color.WHITE);
		setLayout(null);
		this.tcp = tcp;

		this.setBounds(0, 0, 740, 690);
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		
		backButton = new JButton(" µ⁄∑Œ ∞°±‚ ");
		backButton.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 17));
		backButton.setIcon(null);
		backButton.setSelectedIcon(null);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(new Color(192, 192, 192));
		backButton.setBounds(40, 553, 170, 74);
		this.add(backButton);

		payngCardButton = new JButton("\uCE74\uB4DC \uACB0\uC81C");
		payngCardButton.setForeground(new Color(0, 0, 0));
		payngCardButton.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 17));
		payngCardButton.setBackground(new Color(192, 192, 192));
		payngCardButton.setBounds(286, 553, 170, 74);
		this.add(payngCardButton);
		
		payngCashButton = new JButton("\uD604\uAE08 \uACB0\uC81C");
		payngCashButton.setForeground(new Color(0, 0, 0));
		payngCashButton.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 17));
		payngCashButton.setBackground(new Color(192, 192, 192));
		payngCashButton.setBounds(506, 553, 170, 74);
		this.add(payngCashButton);
		
		JList list = new JList();
		list.setBounds(74, 48, 594, 277);
		add(list);
		
		JLabel label = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561");
		label.setFont(new Font("πÆ√º∫Œ ¡¶∏Ò πŸ≈¡√º", Font.PLAIN, 20));
		label.setBounds(74, 396, 125, 62);
		add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("æ»ªÛºˆ2006±Ω¿∫", Font.PLAIN, 42));
		textField.setText("32,000");
		textField.setBounds(239, 409, 429, 49);
		add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Load Value");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel DLM = new DefaultListModel();
				DLM.addElement("¬•¿Â");
				DLM.addElement("¬´ªÕ");
				DLM.addElement("≈¡ºˆ¿∞");
				DLM.addElement("∂±∫∫¿Ã");
				DLM.addElement("±Ëπ‰");
				list.setModel(DLM);
			}
		});
		btnNewButton.setBounds(540, 354, 136, 45);
		add(btnNewButton);
		
	}
	public static void main(String args[]) {
		new TestFrame();
	}
}
