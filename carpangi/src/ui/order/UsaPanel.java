package ui.order;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsaPanel extends JPanel implements ActionListener {

	JButton chi, pi, ham, sand, cu;

	public UsaPanel() {

		setLayout(null);
		setBounds(100, 100, 756, 746);
		this.setBackground(Color.YELLOW);

		chi = new JButton();
		chi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-1chicken.png"));
		chi.setName("13");
		chi.setBounds(38, 48, 195, 195);
		add(chi);
		JLabel chila = new JLabel("ġŲ 16000��");
		chila.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		chila.setBounds(66, 255, 138, 36);
		add(chila);

		pi = new JButton();
		pi.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-2pizza.jpg"));
		pi.setName("14");
		pi.setBounds(272, 48, 195, 195);
		add(pi);
		JLabel pila = new JLabel("���� 18000��");
		pila.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		pila.setBounds(302, 255, 132, 36);
		add(pila);

		ham = new JButton();
		ham.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-3hambuger.jpg"));
		ham.setName("15");
		ham.setBounds(507, 48, 195, 200);
		add(ham);
		JLabel hamla = new JLabel("�ܹ��� 6000��");
		hamla.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		hamla.setBounds(536, 255, 150, 36);
		add(hamla);

		sand = new JButton();
		sand.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-4sandwich.png"));
		sand.setName("16");
		sand.setBounds(38, 305, 195, 195);
		add(sand);
		JLabel sandla = new JLabel("������ġ 4500��");
		sandla.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		sandla.setBounds(58, 512, 159, 36);
		add(sandla);

		cu = new JButton();
		cu.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\4-\uC591\uC2DD\\4-6curry.png"));
		cu.setName("17");
		cu.setBounds(272, 305, 195, 195);
		add(cu);
		JLabel cula = new JLabel("ī�� 6000��");
		cula.setFont(new Font("HY�߰��", Font.PLAIN, 20));
		cula.setBounds(302, 512, 149, 36);
		add(cula);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton) e.getSource();
		int foodNum = Integer.parseInt(temp.getName());

		// ���̾�α� ȣ��

		// ���

	}

}
