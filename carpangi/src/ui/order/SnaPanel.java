package ui.order;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnaPanel extends JPanel implements ActionListener{

	public SnaPanel() {

		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.ORANGE);

		JButton dduc = new JButton();
		dduc.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-1dduck.png"));
		dduc.setName("18");
		dduc.setBounds(38, 48, 195, 195);
		add(dduc);
		JLabel dducla = new JLabel("¶±ººÀÌ 3500¿ø");
		dducla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		dducla.setBounds(66, 255, 149, 36);
		add(dducla);

		JButton sun = new JButton();
		sun.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-2soon.jpg"));
		sun.setName("19");
		sun.setBounds(272, 48, 195, 195);
		add(sun);
		JLabel sunla = new JLabel("¼ø´ë 3500¿ø");
		sunla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		sunla.setBounds(309, 255, 119, 36);
		add(sunla);

		JButton ti = new JButton();
		ti.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-3den.png"));
		ti.setName("20");
		ti.setBounds(507, 48, 195, 200);
		add(ti);
		JLabel tila = new JLabel("Æ¢±è 3500¿ø");
		tila.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		tila.setBounds(545, 255, 129, 36);
		add(tila);

		JButton kim = new JButton();
		kim.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-4kimbap.png"));
		kim.setName("21");
		kim.setBounds(38, 305, 195, 195);
		add(kim);
		JLabel kimla = new JLabel("±è¹ä 2500¿ø");
		kimla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		kimla.setBounds(66, 512, 134, 36);
		add(kimla);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}