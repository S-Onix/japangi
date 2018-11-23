package ui.toppanel;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ui.toppanel.cardpanel.AmericaPanel;
import ui.toppanel.cardpanel.ChinaPanel;
import ui.toppanel.cardpanel.HomePanel;
import ui.toppanel.cardpanel.JapanPanel;
import ui.toppanel.cardpanel.KoreaPanel;
import ui.toppanel.cardpanel.RanSelPanel;
import ui.toppanel.cardpanel.SchoolfoodPanel;

public class TopCardPanel extends JPanel {

	private CardLayout card;

	/*
	 * 패널들 추가
	 */
	
	HomePanel hp;
	KoreaPanel kp;
	ChinaPanel cp;
	JapanPanel jp;
	AmericaPanel ap;
	SchoolfoodPanel sfp;
	
	RanSelPanel rsp;
	

	/**
	 * Create the panel.
	 */
	public TopCardPanel() {
		this.setBounds(0, 52, 740, 690);
		card = new CardLayout();
		this.setLayout(card);
		
		newPanels();
		addPanels();
		
		this.setVisible(true);

	}
	
	public void newPanels() {
		hp = new HomePanel(this);
		kp = new KoreaPanel();
		cp = new ChinaPanel();
		jp = new JapanPanel();
		ap = new AmericaPanel();
		sfp = new SchoolfoodPanel();
		rsp = new RanSelPanel();
		
		
	}

	public void addPanels() {
		this.add(hp, "HOME");
		this.add(kp, "KOREA");
		this.add(cp, "CHINA");
		this.add(jp, "JAPAN");
		this.add(ap, "YANG");
		this.add(sfp, "SCHOOL");
		this.add(rsp, "RAND");
	}

	public void show(String panelName) {
		card.show(this, panelName);
	}
}
