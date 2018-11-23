package ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Price extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public Price() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("\uD655\uC778");
			okButton.setFont(new Font("문체부 궁체 정자체", Font.PLAIN, 20));
			okButton.setBounds(169, 176, 78, 34);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblNewLabel = new JLabel("\uAE08\uC561\uC774 \uBD80\uC871\uD569\uB2C8\uB2E4");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("문체부 궁체 정자체", Font.PLAIN, 34));
		lblNewLabel.setBounds(67, 46, 331, 75);
		contentPanel.add(lblNewLabel);
	}
}
