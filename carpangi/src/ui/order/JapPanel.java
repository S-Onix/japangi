package ui.order;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import dialog.QuantityChange;
import japangi.FoodTicketMachine;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JapPanel extends JPanel implements ActionListener{

	FoodTicketMachine ftm;
	JButton don, lamen, sushi;
	
	public JapPanel() {
		this.ftm = FoodTicketMachine.getInstance();
		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.PINK);

		JButton don = new JButton();
		don.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-1don.png"));
		don.setName("10");
		don.setBounds(38, 48, 195, 195);
		add(don);
		JLabel donla = new JLabel("��� 7500��");
		donla.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		donla.setBounds(65, 255, 139, 36);
		add(donla);

		JButton lamen = new JButton();
		lamen.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-3dup.png"));
		lamen.setName("11");
		lamen.setBounds(272, 48, 195, 195);
		add(lamen);
		JLabel lamenla = new JLabel("��� 6000��");
		lamenla.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		lamenla.setBounds(307, 255, 119, 36);
		add(lamenla);

		JButton sushi = new JButton();
		sushi.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-4sushiclick.png"));
		sushi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-4sushi.png"));
		sushi.setName("12");
		sushi.setBounds(507, 48, 195, 200);
		add(sushi);
		JLabel sushila = new JLabel("���� 13000��");
		sushila.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		sushila.setBounds(535, 255, 143, 36);
		add(sushila);

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton) e.getSource();
		int foodNum = Integer.parseInt(temp.getName());
		//���̾�α� ���
		//��ư�� ���� ���°� �ƴϸ�
		new QuantityChange(foodNum);
		//��ư�� ���� ���¶�� �ֹ� ���
		ftm.cancelOrderMenu(ftm.getFoodName(foodNum));
	}
}