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

	//������ ��ư�� ���۵�(RanSelPanel �� �����ϱ� ������)
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

		hanButton = new JButton(" �� �� ");
		hanButton.setBackground(Color.LIGHT_GRAY);
		hanButton.setName("KOREA");
		hanButton.setFont(new Font("��ü�� �ƹ�����ü", Font.PLAIN, 30));
		hanButton.setBounds(84, 135, 170, 170);
		img.add(hanButton);

		joogButton = new JButton(" �� �� ");
		joogButton.setBackground(Color.LIGHT_GRAY);
		joogButton.setName("CHINA");
		joogButton.setFont(new Font("��ü�� �ƹ�����ü", Font.PLAIN, 30));
		joogButton.setBounds(490, 135, 170, 170);
		img.add(joogButton);

		ilButton = new JButton(" �� �� ");
		ilButton.setBackground(Color.LIGHT_GRAY);
		ilButton.setName("JAPAN");
		ilButton.setFont(new Font("��ü�� �ƹ�����ü", Font.PLAIN, 30));
		ilButton.setBounds(290, 135, 170, 170);
		img.add(ilButton);

		bunButton = new JButton(" �� �� ");
		bunButton.setBackground(Color.LIGHT_GRAY);
		bunButton.setName("SCHOOL");
		bunButton.setFont(new Font("��ü�� �ƹ�����ü", Font.PLAIN, 30));
		bunButton.setBounds(84, 351, 170, 170);
		img.add(bunButton);

		yangButton = new JButton(" �� �� ");
		yangButton.setBackground(Color.LIGHT_GRAY);
		yangButton.setName("YANG");
		yangButton.setFont(new Font("��ü�� �ƹ�����ü", Font.PLAIN, 30));
		yangButton.setBounds(290, 351, 170, 170);
		img.add(yangButton);

		ranButton = new JButton(" ������ ");
		ranButton.setName("RAND");
		ranButton.setBackground(Color.LIGHT_GRAY);
		ranButton.setFont(new Font("��ü�� �ƹ�����ü", Font.PLAIN, 30));
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
