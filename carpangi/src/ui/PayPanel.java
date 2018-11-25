package ui;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import japangi.FoodTicketMachine;
import java.awt.Font;
import javax.swing.JLabel;

public class PayPanel extends JPanel implements ActionListener {

	FoodTicketMachine ftm;
	JTable table;
	static PayPanel payPanel;
	JButton bu1, bu2;
	DefaultTableModel model;
	private JLabel totalPriceLb;

	public static PayPanel getInstance() {
		if (payPanel == null)
			payPanel = new PayPanel();
		return payPanel;
	}

	public PayPanel() {
		ftm = FoodTicketMachine.getInstance();

		Vector<String> columnNames = new Vector<>();
		columnNames.add("�޴�");
		columnNames.add("����");
		columnNames.add("����");

		setBounds(100, 100, 756, 746);
		setVisible(true);
		setLayout(null);
		model = new DefaultTableModel(ftm.getOrderList(), columnNames);
		table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 0, 730, 400);
		add(scrollpane);

		bu1 = new JButton("����");
		bu1.setFont(new Font("�޸տ�ü", Font.BOLD, 26));
		bu1.setName("pay");
		bu1.setBounds(180, 512, 134, 84);
		add(bu1);

		bu2 = new JButton("���");
		bu2.setFont(new Font("�޸տ�ü", Font.BOLD, 26));
		bu2.setName("cancel");
		bu2.setBounds(440, 512, 134, 84);
		add(bu2);

		bu1.addActionListener(this);
		bu2.addActionListener(this);

		JLabel lblNewLabel = new JLabel("�� ������");
		lblNewLabel.setFont(new Font("�޸տ�ü", Font.PLAIN, 26));
		lblNewLabel.setBounds(180, 429, 134, 31);
		add(lblNewLabel);

		totalPriceLb = new JLabel("New label");
		totalPriceLb.setFont(new Font("�޸տ�ü", Font.PLAIN, 26));
		totalPriceLb.setBounds(338, 429, 216, 27);
		add(totalPriceLb);

	}

	public void uiUpdate() {
		model.fireTableDataChanged();
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getTotalPriceLb() {
		return totalPriceLb;
	}

	public void setTotalPriceLb(JLabel totalPriceLb) {
		this.totalPriceLb = totalPriceLb;
	}

	public void clearTable() {
		model.getDataVector().removeAllElements();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton) e.getSource();
		switch (temp.getName()) {
		case "pay":
			// ����â �̵�
			String moneyStr = JOptionPane.showInputDialog(this, "�ݾ��� �Է��ϼ���", "����");
			StringBuilder sb = new StringBuilder();
			char[] c = moneyStr.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (Character.isDigit(c[i])) {
					sb.append(c[i]);
				} else {
					sb.delete(0, sb.length());
					JOptionPane.showMessageDialog(this, "���ڸ� �Է��ϼ���");
					break;
				}

				if (i == c.length - 1) {
					moneyStr = sb.toString();
					int money = Integer.parseInt(moneyStr);
					if (ftm.checkMoney(money)) {
						ftm.calculateMenu();
					} else {
						JOptionPane.showMessageDialog(this, "�ݾ��� �����մϴ�");
					}
				}
			}

			break;
		case "cancel":
			// ������ �߻��ϴ� ������ �𸣰���
			String foodName = (String) table.getValueAt(table.getSelectedRow(), 0);
			ftm.cancelOrderMenu(foodName);
			model.removeRow(table.getSelectedRow());
			break;

		}
	}
}