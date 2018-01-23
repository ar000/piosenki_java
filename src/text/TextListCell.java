package text;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import piosenki.Dane;
import view.W;

public class TextListCell extends JPanel implements ListCellRenderer<LineText>{

	private JLabel line, chords;
	Rectangle lin, cho, tmpRect;
	int wys;
	int odLewej, odPrawej, szer, odstep;
	public TextListCell(){
		Font f;
		line = new JLabel();
		chords = new JLabel();
		line.setBackground(Color.WHITE);
		Color color = new Color(248,248,255);
		chords.setBackground(color);
		f = line.getFont();
		
		line.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		
		line.setFont(Dane.oxygenFont);
		
		f = chords.getFont();
		chords.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		chords.setFont(Dane.chordFont);
		
		Dane.textFont = chords.getFont();
		
		line.setOpaque(true);
		chords.setOpaque(true);
		
		wys = (int)(Dane.oxygenFont.getSize() * 1.3);
		odLewej = 5;
		odstep = wys/2;
		
		lin = new Rectangle(odLewej,0,250,wys);
		cho = new Rectangle(255,0,200,16);
		
		line.setBounds(lin);
		chords.setBounds(cho);
		
		
		setPreferredSize(new Dimension(200, 16));
		setLayout(null);
		setBackground(Color.WHITE);
		add(line);
		add(chords);
		
		szer = W.panelLeftDim.width;
	}
	

	@Override
	public Component getListCellRendererComponent(JList<? extends LineText> list, LineText value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		line.setText(value.text);
		chords.setText(value.chords);
		
		if(value.getChords().trim().equals("") && value.getText().trim().equals(""))
			setPreferredSize(new Dimension(400, 10));
        else
        	setPreferredSize(new Dimension(400, wys));

		
		
		int startX = (szer-(value.getLineWidth() + odstep + value.getChordWidth()))/2;
		
		
		tmpRect = new Rectangle(lin.x, lin.y, value.getLineWidth(), lin.height);
		line.setBounds(tmpRect);
		
		int chX = (lin.x + value.getLineWidth() + odstep );
		
		tmpRect = new Rectangle(chX, cho.y, value.getChordWidth(), cho.height);
		chords.setBounds(tmpRect);
		
		return this;
	}

}
