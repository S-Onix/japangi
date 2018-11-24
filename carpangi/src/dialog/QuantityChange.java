package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

public class QuantityChange extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField QuantityField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			QuantityChange dialog = new QuantityChange();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public QuantityChange() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 222, 173));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton minusButton = new JButton("-");
			minusButton.setFont(new Font("메이플스토리", Font.PLAIN, 30));
			minusButton.setBounds(49, 69, 50, 50);
			contentPanel.add(minusButton);
		}
		{
			JButton plusButton_1 = new JButton("+");
			plusButton_1.setFont(new Font("메이플스토리", Font.PLAIN, 30));
			plusButton_1.setBounds(331, 69, 50, 50);
			contentPanel.add(plusButton_1);
		}
		{
			QuantityField = new JTextField();
			QuantityField.setBounds(159, 42, 116, 100);
			contentPanel.add(QuantityField);
			QuantityField.setColumns(10);
		}
		{
			JButton cancelButton = new JButton(" \uCDE8 \uC18C ");
			cancelButton.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 18));
			cancelButton.setBounds(71, 176, 97, 59);
			contentPanel.add(cancelButton);
		}
		{
			JButton checkButton_3 = new JButton(" \uD655 \uC778 ");
			checkButton_3.setFont(new Font("문체부 제목 바탕체", Font.PLAIN, 18));
			checkButton_3.setBounds(256, 176, 97, 59);
			contentPanel.add(checkButton_3);
		}
	}

}
