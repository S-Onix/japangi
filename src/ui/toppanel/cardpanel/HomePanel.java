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

public class HomePanel extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */

	JButton hanButton, joogButton, ilButton, bunButton, yangButton, ranButton;
	JPanel img;
	TopCardPanel tcp;

	//무작위 버튼만 동작됨(RanSelPanel 만 존재하기 때문에)
	public HomePanel(TopCardPanel tcp) {
		
//		img = new TopImg(new ImageIcon("E:/miniimg/img/BasicImg/TopPanel.png").getImage());
//		img.setBounds(0, 0, 731, 645);
//		img.setLayout(null);
		
		setBackground(Color.WHITE);
		setLayout(null);
		this.tcp = tcp;

		img.setBounds(0, 0, 730, 646);
		img.setBackground(Color.GRAY);
		img.setLayout(null);

		hanButton = new JButton(" 한 식 ");
		hanButton.setBackground(Color.LIGHT_GRAY);
		hanButton.setName("KOREA");
		hanButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		hanButton.setBounds(84, 135, 170, 170);
		img.add(hanButton);

		joogButton = new JButton(" 중 식 ");
		joogButton.setBackground(Color.LIGHT_GRAY);
		joogButton.setName("CHINA");
		joogButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		joogButton.setBounds(490, 135, 170, 170);
		img.add(joogButton);

		ilButton = new JButton(" 일 식 ");
		ilButton.setBackground(Color.LIGHT_GRAY);
		ilButton.setName("JAPAN");
		ilButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		ilButton.setBounds(290, 135, 170, 170);
		img.add(ilButton);

		bunButton = new JButton(" 분 식 ");
		bunButton.setBackground(Color.LIGHT_GRAY);
		bunButton.setName("SCHOOL");
		bunButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		bunButton.setBounds(84, 351, 170, 170);
		img.add(bunButton);

		yangButton = new JButton(" 양 식 ");
		yangButton.setBackground(Color.LIGHT_GRAY);
		yangButton.setName("YANG");
		yangButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		yangButton.setBounds(290, 351, 170, 170);
		img.add(yangButton);

		ranButton = new JButton(" 무작위 ");
		ranButton.setName("RAND");
		ranButton.setBackground(Color.LIGHT_GRAY);
		ranButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		ranButton.setBounds(490, 351, 170, 170);
		img.add(ranButton);
		
		setListener();

	}
	
	public void setListener() {
		hanButton.addActionListener(this);
		joogButton.addActionListener(this);
		ilButton.addActionListener(this);
		bunButton.addActionListener(this);
		yangButton.addActionListener(this);
		ranButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		System.out.println(button.getName());
		tcp.show(button.getName());
	}

}
