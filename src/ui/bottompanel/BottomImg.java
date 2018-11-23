package ui.bottompanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BottomImg extends JPanel {

	  private Image img;
	  public BottomImg() {		   
	  }
	  public BottomImg(String img) {
	    this(new ImageIcon(img).getImage());
	  }
	  public BottomImg(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);	    
	    setSize(size);
	  }
	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, this);
	  }

	}

