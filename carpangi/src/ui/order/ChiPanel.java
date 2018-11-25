package ui.order;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import dialog.QuantityChange;
import japangi.FoodTicketMachine;
import ui.PayPanel;

public class ChiPanel extends JPanel implements ActionListener {

	JToggleButton jjajang, jjam, tang;
	FoodTicketMachine ftm;
	PayPanel payPanel;

	public ChiPanel() {
		this.ftm = FoodTicketMachine.getInstance();
		payPanel = PayPanel.getInstance();
		setLayout(null);
		setBounds(100, 100, 756, 746);
		setBackground(Color.RED);

		jjajang = new JToggleButton();
		jjajang.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\2-\uC911\uC2DD\\2-1jajangclick.png"));
		jjajang.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\2-\uC911\uC2DD\\2-1jajang.png"));
		jjajang.setName("7");
		jjajang.setBounds(38, 48, 195, 195);
		jjajang.setSelected(false);
		
		add(jjajang);
		JLabel jjala = new JLabel("Â¥Àå¸é 4500¿ø");
		jjala.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		jjala.setBounds(66, 255, 149, 36);
		add(jjala);

		jjam = new JToggleButton();
		jjam.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\2-\uC911\uC2DD\\2-2jjamclick.png"));
		jjam.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\2-\uC911\uC2DD\\2-2jjam.png"));
		jjam.setName("8");
		jjam.setBounds(272, 48, 195, 195);
		add(jjam);
		JLabel jjamla = new JLabel("Â«»Í 5500¿ø");
		jjamla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		jjamla.setBounds(311, 255, 130, 36);
		add(jjamla);

		tang = new JToggleButton();
		tang.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\2-\uC911\uC2DD\\2-3tangclick.jpg"));
		tang.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\2-\uC911\uC2DD\\2-3tang.jpg"));
		tang.setName("9");
		tang.setBounds(507, 48, 195, 200);
		add(tang);
		JLabel tangla = new JLabel("ÅÁ¼öÀ° 12000¿ø");
		tangla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		tangla.setBounds(527, 255, 160, 36);
		add(tangla);

		addButtonListner();
	}

	public void addButtonListner() {
		jjajang.addActionListener(this);
		jjam.addActionListener(this);
		tang.addActionListener(this);
	}

	
	public void initButtonStatus() {
		jjajang.setSelected(false);
		jjam.setSelected(false);
		tang.setSelected(false);
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