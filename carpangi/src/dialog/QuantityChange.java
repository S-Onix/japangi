package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import japangi.FoodTicketMachine;
import ui.PayPanel;

public class QuantityChange extends JDialog implements ActionListener {
	JButton checkButton, plusButton, minusButton;
	private JLabel countLa;
	// ����
	int count = 0;
	int foodNum;
	FoodTicketMachine ftm;
	PayPanel payPanel;

	public QuantityChange(int foodNum) {
		ftm = FoodTicketMachine.getInstance();
		payPanel = PayPanel.getInstance();

		///////////// ���̾�α� â/////////////
		getContentPane().setBackground(new Color(255, 255, 240));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.foodNum = foodNum;

		///////////// ����/////////////
		countLa = new JLabel();
		countLa.setHorizontalAlignment(SwingConstants.CENTER);
		countLa.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 74));
		countLa.setBounds(160, 50, 116, 106);
		getContentPane().add(countLa);
		countLa.setText(String.valueOf(getCount()));

		///////////// Ȯ�ι�ư/////////////
		checkButton = new JButton("Ȯ ��");
		checkButton.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 27));
		checkButton.setName("check");
		checkButton.setBounds(160, 185, 116, 48);
		getContentPane().add(checkButton);
		checkButton.addActionListener(this);

		///////////// ���ϱ� ��ư/////////////
		plusButton = new JButton("+");
		plusButton.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 50));
		plusButton.setName("+");
		plusButton.setBounds(38, 76, 97, 71);
		getContentPane().add(plusButton);
		plusButton.addActionListener(this);

		///////////// ���� ��ư/////////////
		minusButton = new JButton("-");
		minusButton.setFont(new Font("THE�ܰ��μ���", Font.PLAIN, 52));
		minusButton.setName("-");
		minusButton.setBounds(303, 76, 97, 71);
		getContentPane().add(minusButton);
		minusButton.addActionListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton) e.getSource();
		switch (temp.getName()) {
		case "-":
			// label ����
			if (getCount() > 0) {
				setCount(getCount() - 1);
				countLa.setText(String.valueOf(getCount()));
			}
			break;
		case "+":
			if (ftm.getFoodCount(foodNum) >= getCount()) {
				setCount(getCount() + 1);
				countLa.setText(String.valueOf(getCount()));
			} else
				JOptionPane.showMessageDialog(this,
						ftm.getFoodName(foodNum) + "�� ���� ������ " + ftm.getFoodCount(foodNum) + "�� �Դϴ�.");
			break;
		case "check":
			if (getCount() != 0) {
				ftm.selectMenu(foodNum, getCount());
				// ����Ʈ ����
				payPanel.uiUpdate();
				payPanel.getTotalPriceLb().setText(ftm.getPayMoney() + "��");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "������ �����ϼ���");
			}
			break;
		}
	}

}