package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener {

	JButton korButton, chiButton, japButton, usaButton, snaButton;
	Main main;

	public MainPanel(Main main) {
		this.main = main;

		this.setBackground(Color.CYAN);
		setLayout(null);

		korButton = new JButton("ÇÑ½Ä");
		korButton.setName("KOREA");
		korButton.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 56));
		korButton.setBounds(38, 48, 195, 195);
		add(korButton);

		chiButton = new JButton("Áß½Ä");
		chiButton.setName("CHINA");
		chiButton.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 56));
		chiButton.setBounds(272, 48, 195, 195);
		add(chiButton);

		japButton = new JButton("ÀÏ½Ä");
		japButton.setName("JAPEN");
		japButton.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 56));
		japButton.setBounds(507, 48, 195, 195);
		add(japButton);

		usaButton = new JButton("¾ç½Ä");
		usaButton.setName("USA");
		usaButton.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 56));
		usaButton.setBounds(38, 305, 195, 195);
		add(usaButton);

		snaButton = new JButton("ºÐ½Ä");
		snaButton.setName("SNACK");
		snaButton.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 56));
		snaButton.setBounds(272, 305, 195, 195);
		add(snaButton);
		
		addListner();

	}
	
	public void addListner() {
		korButton.addActionListener(this);
		chiButton.addActionListener(this);
		japButton.addActionListener(this);
		usaButton.addActionListener(this);
		snaButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton) e.getSource();
		main.showPanel(temp.getName());
		System.out.println(temp.getName() + "°¡ ´­¸²");

	}
}