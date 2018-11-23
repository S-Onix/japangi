package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Test1_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1_main frame = new Test1_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test1_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(12, 68, 710, 593);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton(" 한 식 ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(24, 59, 200, 200);
		panel.add(btnNewButton);
		
		JButton button_1 = new JButton(" 분 식 ");
		button_1.setBounds(252, 59, 200, 200);
		panel.add(button_1);
		
		JButton button_2 = new JButton(" 일 식 ");
		button_2.setBounds(478, 59, 200, 200);
		panel.add(button_2);
		
		JButton button_3 = new JButton(" 양 식 ");
		button_3.setBounds(253, 322, 200, 200);
		panel.add(button_3);
		
		JButton button_4 = new JButton("  ?  ");
		button_4.setBounds(480, 322, 200, 200);
		panel.add(button_4);
		
		JButton button = new JButton(" 중 식 ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(24, 322, 200, 200);
		panel.add(button);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(12, 10, 710, 60);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JButton home = new JButton("home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		home.setBounds(490, 23, 65, 33);
		panel_7.add(home);
		
		JButton btnNewButton_1 = new JButton("장바구니");
		btnNewButton_1.setBounds(553, 23, 81, 33);
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("reset");
		btnNewButton_2.setBounds(633, 23, 65, 33);
		panel_7.add(btnNewButton_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.BLUE);
		panel_8.setBounds(12, 658, 710, 194);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(143, 83, 452, 82);
		panel_8.add(panel_9);
	}
}
