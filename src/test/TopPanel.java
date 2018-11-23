package test;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class TopPanel extends JPanel {

   /**
    * Create the panel.
    */
   public TopPanel() {
      setBackground(Color.WHITE);
      setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.DARK_GRAY);
      panel.setBounds(0, 0, 740, 56);
      add(panel);
      panel.setLayout(null);
      
      JButton btnNewButton_1 = new JButton("Home");
      btnNewButton_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
      btnNewButton_1.setBounds(503, 10, 65, 36);
      panel.add(btnNewButton_1);
      
      JButton btnNewButton = new JButton("Àå¹Ù±¸´Ï");
      btnNewButton.setFont(new Font("³ª´®½ºÄù¾î ExtraBold", Font.PLAIN, 14));
      btnNewButton.setBounds(569, 10, 85, 36);
      panel.add(btnNewButton);
      
      JButton btnNewButton_2 = new JButton("Reset");
      btnNewButton_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
      btnNewButton_2.setBounds(655, 10, 73, 36);
      panel.add(btnNewButton_2);
      
      JLabel lblNewLabel = new JLabel("Team1");
      lblNewLabel.setFont(new Font("Adobe Arabic", Font.PLAIN, 23));
      lblNewLabel.setBounds(12, 10, 104, 36);
      
      panel.add(lblNewLabel);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBackground(Color.GRAY);
      panel_1.setBounds(0, 52, 740, 690);
      add(panel_1);
      panel_1.setLayout(null);
      
      
      
      
      
   }
}