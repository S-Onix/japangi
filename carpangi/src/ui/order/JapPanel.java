package ui.order;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import dialog.QuantityChange;
import japangi.FoodTicketMachine;
import ui.PayPanel;

public class JapPanel extends JPanel implements ActionListener{

	FoodTicketMachine ftm;
	JToggleButton don, lamen, sushi;
	PayPanel payPanel;
	
	public JapPanel() {
		this.ftm = FoodTicketMachine.getInstance();
		payPanel = PayPanel.getInstance();
		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.PINK);

		don = new JToggleButton();
		don.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-1donclick.png"));
		don.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-1don.png"));
		don.setName("10");
		don.setBounds(38, 48, 195, 195);
		add(don);
		JLabel donla = new JLabel("µ·±î½º 7500¿ø");
		donla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		donla.setBounds(65, 255, 139, 36);
		add(donla);

		lamen = new JToggleButton();
		lamen.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-3dupclick.png"));
		lamen.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-3dup.png"));
		lamen.setName("11");
		lamen.setBounds(272, 48, 195, 195);
		add(lamen);
		JLabel lamenla = new JLabel("¶ó¸à 6000¿ø");
		lamenla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		lamenla.setBounds(307, 255, 119, 36);
		add(lamenla);

		sushi = new JToggleButton();
		sushi.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-4sushiclick.png"));
		sushi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-4sushi.png"));
		sushi.setName("12");
		sushi.setBounds(507, 48, 195, 200);
		add(sushi);
		JLabel sushila = new JLabel("½º½Ã 13000¿ø");
		sushila.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		sushila.setBounds(535, 255, 143, 36);
		add(sushila);
		
		addButtonListner();
	
	}

	public void addButtonListner() {
		don.addActionListener(this);
		lamen.addActionListener(this);
		sushi.addActionListener(this);
	}
	
	public void initButtonStatus() {
		don.setSelected(false);
		lamen.setSelected(false);
		sushi.setSelected(false);
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