package ui;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import japangi.FoodTicketMachine;

public class PayPanel extends JPanel {

	FoodTicketMachine ftm;
	JTable table;
	static PayPanel payPanel;
	
	public static PayPanel getInstance() {
		if(payPanel == null) payPanel = new PayPanel();
		return payPanel;
	}

	public PayPanel() {
		ftm = FoodTicketMachine.getInstance();

		Vector<String> columnNames = new Vector<>();
		columnNames.add("메뉴");
		columnNames.add("수량");
		columnNames.add("가격");

		setBounds(100, 100, 756, 746);
		setVisible(true);
		setLayout(null);
		DefaultTableModel dtm = new DefaultTableModel();
		table = new JTable(ftm.getOrderList(), columnNames);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 0, 730, 400);
		add(scrollpane);

		JButton bu1 = new JButton("결제");
		bu1.setBounds(180, 449, 134, 84);
		add(bu1);

		JButton bu2 = new JButton("취소");
		bu2.setBounds(440, 449, 134, 84);
		add(bu2);

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}