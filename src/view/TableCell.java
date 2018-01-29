package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

import piosenki.Dane;

public class TableCell extends JPanel implements ListCellRenderer<String>{

	private JLabel label;
	
	public TableCell(){
		
		label = new JLabel();
		Font f = label.getFont();
		label.setBackground(Color.WHITE);
		label.setOpaque(true);
		//label.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		label.setFont(Dane.oxygenFont);
		label.setFont(label.getFont().deriveFont(W.fontSize12));
		setLayout(null);
		
		int wys = (int)(label.getFont().getSize() * 1.3);
		W.labelIndexCell.height = wys;
		setPreferredSize(W.labelIndexCell);
		
		

	    label.setBounds(4,-2,800,20);
		
	    add(label);
		
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends String> arg0, String arg1, int arg2, boolean arg3,
			boolean arg4) {
		
		label.setText(arg1);
		
	    if (arg3) {
	        label.setBackground(Color.LIGHT_GRAY);
	    } else { // when don't select
	    	label.setBackground(Color.WHITE);
	    }
	    
	    
		return this;
	}

}
