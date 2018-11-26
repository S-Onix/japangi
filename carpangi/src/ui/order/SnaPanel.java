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

public class SnaPanel extends JPanel implements ActionListener{

	FoodTicketMachine ftm;
	JToggleButton dduc, sun, ti, kim;
	PayPanel payPanel;
	
	public SnaPanel() {
		this.ftm = FoodTicketMachine.getInstance();
		payPanel = PayPanel.getInstance();
		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.ORANGE);

		dduc = new JToggleButton();
		dduc.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-1dduckclick.png"));
		dduc.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-1dduck.png"));
		dduc.setName("18");
		dduc.setBounds(38, 48, 195, 195);
		add(dduc);
		JLabel dducla = new JLabel("¶±ººÀÌ 3500¿ø");
		dducla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		dducla.setBounds(66, 255, 149, 36);
		add(dducla);

		sun = new JToggleButton();
		sun.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-2soonclick.jpg"));
		sun.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-2soon.jpg"));
		sun.setName("19");
		sun.setBounds(272, 48, 195, 195);
		add(sun);
		JLabel sunla = new JLabel("¼ø´ë 3500¿ø");
		sunla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		sunla.setBounds(309, 255, 119, 36);
		add(sunla);

		ti = new JToggleButton();
		ti.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-3denclick.png"));
		ti.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-3den.png"));
		ti.setName("20");
		ti.setBounds(507, 48, 195, 200);
		add(ti);
		JLabel tila = new JLabel("Æ¢±è 3500¿ø");
		tila.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		tila.setBounds(545, 255, 129, 36);
		add(tila);

		kim = new JToggleButton();
		kim.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-4kimbapclick.png"));
		kim.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\5-\uBD84\uC2DD\\5-4kimbap.png"));
		kim.setName("21");
		kim.setBounds(38, 305, 195, 195);
		add(kim);
		JLabel kimla = new JLabel("±è¹ä 2500¿ø");
		kimla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		kimla.setBounds(66, 512, 134, 36);
		add(kimla);

		addButtonListner();
	}
	
	public void addButtonListner() {
		dduc.addActionListener(this);
		kim.addActionListener(this);
		ti.addActionListener(this);
		sun.addActionListener(this);
	}
	
	public void initButtonStatus() {
		dduc.setSelected(false);
		kim.setSelected(false);
		ti.setSelected(false);
		sun.setSelected(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JToggleButton temp = (JToggleButton) e.getSource();
		int foodNum = Integer.parseInt(temp.getName());
		if (temp.isSelected()) {
			new QuantityChange(foodNum);
		}else {
			ftm.cancelOrderMenu(ftm.getFoodName(foodNum));
			payPanel.uiUpdate();
			payPanel.getTotalPriceLb().setText(ftm.getPayMoney() + "¿ø");
		}
	}
}