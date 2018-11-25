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

public class UsaPanel extends JPanel implements ActionListener {

	JToggleButton chi, pi, ham, sand, cu;
	FoodTicketMachine ftm;
	PayPanel payPanel;

	public UsaPanel() {
		this.ftm = FoodTicketMachine.getInstance();
		payPanel = PayPanel.getInstance();
		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.YELLOW);

		chi = new JToggleButton();
		chi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-1chicken.png"));
		chi.setName("13");
		chi.setBounds(38, 48, 195, 195);
		add(chi);
		JLabel chila = new JLabel("Ä¡Å² 16000¿ø");
		chila.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		chila.setBounds(66, 255, 138, 36);
		add(chila);

		pi = new JToggleButton();
		pi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-2pizza.jpg"));
		pi.setName("14");
		pi.setBounds(272, 48, 195, 195);
		add(pi);
		JLabel pila = new JLabel("ÇÇÀÚ 18000¿ø");
		pila.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		pila.setBounds(302, 255, 132, 36);
		add(pila);

		ham = new JToggleButton();
		ham.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-3hambuger.jpg"));
		ham.setName("15");
		ham.setBounds(507, 48, 195, 200);
		add(ham);
		JLabel hamla = new JLabel("ÇÜ¹ö°Å 6000¿ø");
		hamla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		hamla.setBounds(536, 255, 150, 36);
		add(hamla);

		sand = new JToggleButton();
		sand.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-4sandwich.png"));
		sand.setName("16");
		sand.setBounds(38, 305, 195, 195);
		add(sand);
		JLabel sandla = new JLabel("»÷µåÀ§Ä¡ 4500¿ø");
		sandla.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		sandla.setBounds(58, 512, 159, 36);
		add(sandla);

		cu = new JToggleButton();
		cu.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-6curry.png"));
		cu.setName("17");
		cu.setBounds(272, 305, 195, 195);
		add(cu);
		JLabel cula = new JLabel("Ä«·¹ 6000¿ø");
		cula.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		cula.setBounds(302, 512, 149, 36);
		add(cula);
		
		addButtonListner();

	}
	public void addButtonListner() {
		chi.addActionListener(this);
		pi.addActionListener(this);
		ham.addActionListener(this);
		sand.addActionListener(this);
		cu.addActionListener(this);
	}
	
	public void initButtonStatus() {
		chi.setSelected(false);
		pi.setSelected(false);
		ham.setSelected(false);
		sand.setSelected(false);
		cu.setSelected(false);
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
