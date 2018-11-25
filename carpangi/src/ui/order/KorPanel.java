package ui.order;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import dialog.QuantityChange;
import japangi.FoodTicketMachine;
import ui.PayPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KorPanel extends JPanel implements ActionListener {

	JToggleButton kimchi, soybean, boodae, bibim, nang, binang;
	FoodTicketMachine ftm;
	PayPanel payPanel;
	
	public KorPanel() {
		this.ftm = FoodTicketMachine.getInstance();
		payPanel = PayPanel.getInstance();
		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.WHITE);

		kimchi = new JToggleButton();
		kimchi.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-1kimchiclick.png"));
		kimchi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-1kimchi.png"));
		kimchi.setName("1");
		kimchi.setBounds(38, 48, 195, 195);
		add(kimchi);
		JLabel kimla = new JLabel("±èÄ¡Âî°³ 6000¿ø");
		kimla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		kimla.setBounds(59, 253, 164, 36);
		add(kimla);

		soybean = new JToggleButton();
		soybean.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-2soybeanclick.png"));
		soybean.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-2soybean.png"));
		soybean.setName("2");
		soybean.setBounds(272, 48, 195, 195);
		add(soybean);
		JLabel soyla = new JLabel("µÈÀåÂî°³ 6000¿ø");
		soyla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		soyla.setBounds(294, 253, 164, 36);
		add(soyla);

		boodae = new JToggleButton();
		boodae.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-3boodaeclick.png"));
		boodae.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-3boodae.png"));
		boodae.setName("3");
		boodae.setBounds(507, 48, 195, 200);
		add(boodae);
		JLabel boola = new JLabel("ºÎ´ëÂî°³ 8000¿ø");
		boola.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		boola.setBounds(533, 253, 164, 36);
		add(boola);

		bibim = new JToggleButton();
		bibim.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-4bibimbapclick.png"));
		bibim.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-4bibimbap.png"));
		bibim.setName("4");
		bibim.setBounds(38, 305, 195, 195);
		add(bibim);
		JLabel bimla = new JLabel("ºñºö¹ä 5500¿ø");
		bimla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		bimla.setBounds(59, 512, 149, 36);
		add(bimla);

		nang = new JToggleButton();
		nang.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-5nangclick.jpg"));
		nang.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-5nang.jpg"));
		nang.setName("5");
		nang.setBounds(272, 305, 195, 195);
		add(nang);
		JLabel nangla = new JLabel("³Ã¸é 6000¿ø");
		nangla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		nangla.setBounds(306, 512, 128, 36);
		add(nangla);

		binang = new JToggleButton();
		binang.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-6beenangclick.jpg"));
		binang.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\1-\uD55C\uC2DD\\1-6beenang.jpg"));
		binang.setName("6");
		binang.setBounds(507, 305, 195, 195);
		add(binang);
		JLabel bila = new JLabel("ºñºö³Ã¸é 6000¿ø");
		bila.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		bila.setBounds(533, 512, 164, 36);
		add(bila);
		addButtonListner();
	}
	
	
	public void addButtonListner() {
		kimchi.addActionListener(this);
		soybean.addActionListener(this);
		boodae.addActionListener(this);
		bibim.addActionListener(this);
		nang.addActionListener(this);
		binang.addActionListener(this);
	}
	public void initButtonStatus() {
		kimchi.setSelected(false);
		soybean.setSelected(false);
		boodae.setSelected(false);
		bibim.setSelected(false);
		nang.setSelected(false);
		binang.setSelected(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JToggleButton temp = (JToggleButton) e.getSource();
		int foodNum = Integer.parseInt(temp.getName());
		if (temp.isSelected()) {
			new QuantityChange(foodNum);
		} else {
			ftm.cancelOrderMenu(ftm.getFoodName(foodNum));
			payPanel.uiUpdate();
			payPanel.getTotalPriceLb().setText(ftm.getPayMoney() + "¿ø");
		}
	}
}
