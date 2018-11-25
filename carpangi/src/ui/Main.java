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

public class Main extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel topPanel, bottomPanel;
	private JButton homeButton, payButton, resetButton;
	private CardLayout cards;
	private MainPanel mainPanel;
	private PayPanel payPanel;
	private ChiPanel chiPanel;
	
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
		 * */
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 740, 56);
		topPanel.setLayout(null);
		
		homeButton = new JButton("New button");
		homeButton.setBounds(418, 10, 97, 36);
		homeButton.setName("home");
		
		payButton = new JButton("New button");
		payButton.setBounds(516, 10, 97, 36);
		payButton.setName("pay");
		
		resetButton = new JButton("New button");
		resetButton.setBounds(613, 10, 97, 36);	
		resetButton.setName("reset");
		
		topPanel.add(homeButton);
		topPanel.add(payButton);
		topPanel.add(resetButton);
		
		/*
		 * BottomPanel 초기화
		 * */
		bottomPanel = new JPanel();
		cards = new CardLayout();
		bottomPanel.setBounds(0, 56, 740, 690);
		bottomPanel.setLayout(cards);
		
		
		
		/*
		 * 카드 레이아웃 구성 요소 초기화
		 * */
		newPanels();
		addPanels();
		
		/*
		 * contentPane 구성요소 추가
		 * */
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
		payPanel = new PayPanel();
		chiPanel = new ChiPanel();
		
	}
	
	
	public void addPanels() {
		bottomPanel.add(mainPanel, "MAIN");
		bottomPanel.add(payPanel, "PAY");
		bottomPanel.add(chiPanel, "CHINA");
	}
	
	public void showPanel(String panelName) {
		cards.show(bottomPanel, panelName);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton temp = (JButton) e.getSource();
		switch(temp.getName()) {
		case "home":
			this.showPanel("MAIN");
			break;
		case "pay":
			this.showPanel("PAY");
			break;
		case "reset":
			this.showPanel("MAIN");
			ftm.clearAllOrderMenu();
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
