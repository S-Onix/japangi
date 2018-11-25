package ui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import japangi.FoodTicketMachine;
import ui.order.ChiPanel;
import ui.order.JapPanel;
import ui.order.KorPanel;
import ui.order.SnaPanel;
import ui.order.UsaPanel;
import java.awt.Font;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel topPanel, bottomPanel;
	private JButton homeButton, payButton, resetButton;
	private CardLayout cards;
	private MainPanel mainPanel;
	private PayPanel payPanel;
	private KorPanel korPanel;
	private ChiPanel chiPanel;
	private JapPanel japPanel;
	private UsaPanel usaPanel;
	private SnaPanel snaPanel;

	FoodTicketMachine ftm;

	/**
	 * Create the frame.
	 */
	public Main() {
		ftm = FoodTicketMachine.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 746);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * TopPanel 구성 초기화
		 */
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 740, 56);
		topPanel.setLayout(null);

		homeButton = new JButton("HOME");
		homeButton.setFont(new Font("휴먼옛체", Font.PLAIN, 22));
		homeButton.setBounds(418, 10, 97, 46);
		homeButton.setName("home");

		payButton = new JButton("PAY");
		payButton.setFont(new Font("휴먼옛체", Font.PLAIN, 22));
		payButton.setBounds(516, 10, 97, 46);
		payButton.setName("pay");

		resetButton = new JButton("RE");
		resetButton.setFont(new Font("휴먼옛체", Font.PLAIN, 22));
		resetButton.setBounds(613, 10, 97, 46);
		resetButton.setName("reset");

		topPanel.add(homeButton);
		topPanel.add(payButton);
		topPanel.add(resetButton);

		/*
		 * BottomPanel 초기화
		 */
		bottomPanel = new JPanel();
		cards = new CardLayout();
		bottomPanel.setBounds(0, 56, 740, 690);
		bottomPanel.setLayout(cards);

		/*
		 * 카드 레이아웃 구성 요소 초기화
		 */
		newPanels();
		addPanels();

		/*
		 * contentPane 구성요소 추가
		 */
		this.showPanel("MAIN");
		addActionListener();
		contentPane.add(topPanel);
		contentPane.add(bottomPanel);
	}

	public void addActionListener() {
		homeButton.addActionListener(this);
		payButton.addActionListener(this);
		resetButton.addActionListener(this);
	}

	public void newPanels() {
		mainPanel = new MainPanel(this);
		payPanel = PayPanel.getInstance();
		korPanel = new KorPanel();
		chiPanel = new ChiPanel();
		japPanel = new JapPanel();
		usaPanel = new UsaPanel();
		snaPanel = new SnaPanel();

	}

	public void addPanels() {
		bottomPanel.add(mainPanel, "MAIN");
		bottomPanel.add(payPanel, "PAY");
		bottomPanel.add(korPanel, "KOREA");
		bottomPanel.add(chiPanel, "CHINA");
		bottomPanel.add(japPanel, "JAPEN");
		bottomPanel.add(usaPanel, "USA");
		bottomPanel.add(snaPanel, "SNACK");

	}

	public void showPanel(String panelName) {
		cards.show(bottomPanel, panelName);
	}

	public void initButtonStatus() {
		chiPanel.initButtonStatus();
		japPanel.initButtonStatus();
		korPanel.initButtonStatus();
		snaPanel.initButtonStatus();
		usaPanel.initButtonStatus();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton) e.getSource();
		switch (temp.getName()) {
		case "home":
			this.showPanel("MAIN");
			break;
		case "pay":
			this.showPanel("PAY");
			break;
		case "reset":
			this.showPanel("MAIN");
			ftm.clearAllOrderMenu();
			payPanel.clearTable();
			initButtonStatus();
			break;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
