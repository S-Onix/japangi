package ui.order;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KorPanel extends JPanel implements ActionListener{

	public KorPanel() {

		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.WHITE);

		JButton kimchi = new JButton();
		kimchi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-1kimchi.png"));
		kimchi.setName("1");
		kimchi.setBounds(38, 48, 195, 195);
		add(kimchi);
		JLabel kimla = new JLabel("±èÄ¡Âî°³ 6000¿ø");
		kimla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		kimla.setBounds(59, 253, 164, 36);
		add(kimla);

		JButton soybean = new JButton();
		soybean.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-2soybean.png"));
		soybean.setName("2");
		soybean.setBounds(272, 48, 195, 195);
		add(soybean);
		JLabel soyla = new JLabel("µÈÀåÂî°³ 6000¿ø");
		soyla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		soyla.setBounds(294, 253, 164, 36);
		add(soyla);

		JButton boodae = new JButton();
		boodae.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-3boodae.png"));
		boodae.setName("3");
		boodae.setBounds(507, 48, 195, 200);
		add(boodae);
		JLabel boola = new JLabel("ºÎ´ëÂî°³ 8000¿ø");
		boola.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		boola.setBounds(533, 253, 164, 36);
		add(boola);

		JButton bibim = new JButton();
		bibim.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-4bibimbap.png"));
		bibim.setName("4");
		bibim.setBounds(38, 305, 195, 195);
		add(bibim);
		JLabel bimla = new JLabel("ºñºö¹ä 5500¿ø");
		bimla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		bimla.setBounds(59, 512, 149, 36);
		add(bimla);

		JButton nang = new JButton();
		nang.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-5nang.jpg"));
		nang.setName("5");
		nang.setBounds(272, 305, 195, 195);
		add(nang);
		JLabel nangla = new JLabel("³Ã¸é 6000¿ø");
		nangla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		nangla.setBounds(306, 512, 128, 36);
		add(nangla);

		JButton binang = new JButton();
		binang.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-6beenang.jpg"));
		binang.setName("6");
		binang.setBounds(507, 305, 195, 195);
		add(binang);
		JLabel bila = new JLabel("ºñºö³Ã¸é 6000¿ø");
		bila.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		bila.setBounds(533, 512, 164, 36);
		add(bila);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
