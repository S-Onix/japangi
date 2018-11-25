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

		korButton = new JButton("한식");
		korButton.setName("KOREA");
		korButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		korButton.setBounds(38, 48, 195, 195);
		add(korButton);

		chiButton = new JButton("중식");
		chiButton.setName("CHINA");
		chiButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		chiButton.setBounds(272, 48, 195, 195);
		add(chiButton);

		japButton = new JButton("일식");
		japButton.setName("JAPEN");
		japButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		japButton.setBounds(507, 48, 195, 195);
		add(japButton);

		usaButton = new JButton("양식");
		usaButton.setName("USA");
		usaButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		usaButton.setBounds(38, 305, 195, 195);
		add(usaButton);

		snaButton = new JButton("분식");
		snaButton.setName("SNACK");
		snaButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
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
		System.out.println(temp.getName() + "가 눌림");

	}
}