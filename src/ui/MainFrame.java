package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.bottompanel.BottomPanel;
import ui.toppanel.TopPanel;
import ui.toppanel.cardpanel.RanSelPanel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private TopPanel tp;
	private BottomPanel bp;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 906);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initPanel();
		addPanel();
		
		this.setVisible(true);
//		this.setResizable(false);
	}
	
	public void initPanel() {
		tp = new TopPanel();
		tp.setBounds(0, 0, 750, 702);
		tp.setLayout(null);
		

		bp = new BottomPanel();
		bp.setBounds(0, 701, 734, 173);
		bp.setLayout(null);
	}
	
	public void addPanel() {
		contentPane.add(tp);
		contentPane.add(bp);
	}
}
