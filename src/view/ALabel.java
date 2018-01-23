package view;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JLabel;

import com.sun.prism.Image;

public class ALabel extends JLabel{
	private Dimension textDimension;
	
	@Override
	public void setText(String text) {
		
		super.setText(text);
	}

	   public void paint(Graphics g){
		   //g.setFont(f);
//		   FontMetrics fm = g.getFontMetrics(this.getFont());
//		   textDimension.width = fm.stringWidth(this.getText());
//		   textDimension.height = fm.getHeight();
		   super.paint(g);
	     
	   }
	   
	   public Dimension getTextDimension(){
		   Graphics g = this.getGraphics();
			FontMetrics fm = g.getFontMetrics(this.getFont());
			textDimension.width = fm.stringWidth(this.getText());
			textDimension.height = fm.getHeight();
		   return textDimension;
	   }
	
}
