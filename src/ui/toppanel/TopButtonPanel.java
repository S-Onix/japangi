package ui.toppanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyleConstants.ColorConstants;

public class TopButtonPanel extends JPanel implements ActionListener {
	TopCardPanel tcp;
	JButton homeButton, cartButton, resetButton;
	JLabel team1;

	/**
	 * Create the panel.
	 */
	public TopButtonPanel(TopCardPanel tcp) {
		setLayout(null);
		Color Bgc = Color.decode("#F0EDDA");
		setBackground(Bgc);
		this.tcp = tcp;
		this.setBounds(0, 0, 740, 56);

		homeButton = new JButton("HOME");
		homeButton.setName("HOME");
		homeButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		homeButton.setBounds(495, 10, 73, 36);
		add(homeButton);

		cartButton = new JButton("Àå¹Ù±¸´Ï");
		cartButton.setName("CART");
		cartButton.setFont(new Font("³ª´®½ºÄù¾î ExtraBold", Font.PLAIN, 14));
		cartButton.setBounds(569, 10, 85, 36);
		add(cartButton);
		
		resetButton = new JButton("Reset");
		resetButton.setName("RESET");
		resetButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		resetButton.setBounds(655, 10, 73, 36);
		add(resetButton);
		
		team1 = new JLabel("Team 1");
		team1.setForeground(new Color(160, 82, 45));
		team1.setFont(new Font("Adobe Arabic", Font.PLAIN, 23));
		team1.setBounds(12, 6, 110, 36);
		add(team1);

		setListener();

	}

	public void setListener() {
		homeButton.addActionListener(this);
		cartButton.addActionListener(this);
		resetButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		System.out.println(button.getName());
		tcp.show(button.getName());
	}
}
