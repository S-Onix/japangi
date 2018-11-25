package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class Quantity extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Quantity dialog = new Quantity();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Quantity() {
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
		
		JLabel lblNewLabel = new JLabel("\uC218\uB7C9\uC774 \uBD80\uC871\uD569\uB2C8\uB2E4");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("문체부 궁체 정자체", Font.PLAIN, 34));
		lblNewLabel.setBounds(67, 46, 331, 75);
		contentPanel.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-3dup.png"));
		tglbtnNewToggleButton.setSelectedIcon(new ImageIcon("C:\\work\\miniimg\\img\\3-\uC77C\uC2DD\\3-3dupclick.png"));
		tglbtnNewToggleButton.setBounds(28, 80, 135, 137);
		contentPanel.add(tglbtnNewToggleButton);
	}
}
