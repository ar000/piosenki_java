package indexViewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import view.W;


public class IndexCell extends JPanel implements ListCellRenderer<IndexItem> {
	private static final long serialVersionUID = 1L;

	private JLabel label, label2, label3;
	
	private int s1,s2;
	private String text;
	private Color color;
	
	public IndexCell(){
		color = new Color(200,200,230);
		
		setLayout(new FlowLayout(FlowLayout.LEFT,0,-2));
		setBackground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.WHITE);
		setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(0, W.indexCellLeftMargin, 0, 0)));    
		    
		label = new JLabel();
		Font f = label.getFont();
		label.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		label.setFont(label.getFont().deriveFont(W.fontSize12));
		
		
		label2 = new JLabel();
		label2.setFont(label2.getFont().deriveFont(W.fontSize12));
		label2.setForeground(Color.RED);
		
		label3 = new JLabel();
		label3.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		label3.setFont(label3.getFont().deriveFont(W.fontSize12));
		
		
		label3.setPreferredSize(W.indexCellLastLabel);
		
//		label.setOpaque(true);
//		label2.setOpaque(true);
//		label3.setOpaque(true);
//		label.setBackground(Color.YELLOW);
//		label2.setBackground(Color.green);
//		label3.setBackground(Color.ORANGE);
		
		add(label);
		add(label2);
		add(label3);
		
	}
	
	
	
	@Override
	public Component getListCellRendererComponent(JList<? extends IndexItem> arg0, IndexItem value, int arg2,
			boolean arg3, boolean arg4) {
		s1 = value.getStart();
		s2 = value.getEnd();
		
		if(s2 > 0){
			text = value.getText();
			label.setText(text.substring(0, s1));
			label2.setText(text.substring(s1, s2));
			label3.setText(text.substring(s2));
		}else{
			label.setText(value.getText());
			label2.setText("");
			label3.setText("");
		}
		

		
		
		 if (arg3) {
			 this.setBackground(color);
		 } else { // when don't select
			 this.setBackground(Color.white);
		 }
		return this;
	}

}
