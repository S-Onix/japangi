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

public class ChinaPanel extends JPanel implements ActionListener{
	JButton jjamButton, tangButton, jajangButton, 
			backButton, checkButton;
	JPanel img;
	TopCardPanel tcp;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	/**
	 * Create the panel.
	 */
	public ChinaPanel() {
		
		img = new TopImg(new ImageIcon("E:/miniimg/img/BasicImg/TopPanel.png").getImage());
		img.setLayout(null);

		setBackground(Color.WHITE);
		setLayout(null);
		this.tcp = tcp;

		img.setBounds(0, 0, 730, 646);
		img.setBackground(Color.GRAY);
		img.setLayout(null);

		backButton = new JButton(" 뒤로 가기 ");
		backButton.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		backButton.setIcon(null);
		backButton.setSelectedIcon(null);
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(Color.BLACK);
		backButton.setBounds(128, 523, 170, 74);
		img.add(backButton);

		checkButton = new JButton(" 선택 완료 ");
		checkButton.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 17));
		checkButton.setBackground(new Color(0, 0, 0));
		checkButton.setBounds(416, 523, 170, 74);
		img.add(checkButton);
		
		jjamButton = new JButton("");
		jjamButton.setIcon(new ImageIcon("E:\\miniimg\\img\\2-\uC911\uC2DD\\2-2jjam.png"));
		jjamButton.setBackground(Color.LIGHT_GRAY);
		jjamButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		jjamButton.setBounds(269, 146, 195, 195);
		img.add(jjamButton);

		tangButton = new JButton("");
		tangButton.setIcon(new ImageIcon("E:\\miniimg\\img\\2-\uC911\uC2DD\\2-3tang.jpg"));
		tangButton.setBackground(Color.LIGHT_GRAY);
		tangButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		tangButton.setBounds(476, 146, 195, 195);
		img.add(tangButton);

		
		jajangButton = new JButton("");
		jajangButton.setIcon(new ImageIcon("E:\\miniimg\\img\\2-\uC911\uC2DD\\2-1jajang.png"));
		jajangButton.setBackground(Color.LIGHT_GRAY);
		jajangButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 30));
		jajangButton.setBounds(62, 146, 195, 195);
		img.add(jajangButton);
		
		label = new JLabel("\uC790\uC7A5\uBA74 : 4,500");
		label.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label.setBounds(103, 351, 119, 31);
		img.add(label);
		
		label_1 = new JLabel("\uC9EC\uBF55 : 5,000");
		label_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_1.setBounds(320, 351, 104, 31);
		img.add(label_1);
		
		label_2 = new JLabel("\uD0D5\uC218\uC721 : 13,000");
		label_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_2.setBounds(514, 351, 128, 31);
		img.add(label_2);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton) e.getSource();
		if(temp.getName().equals("BACK")) {
			//홈 화면 및 리스트 제거
			
		}
	}
}
