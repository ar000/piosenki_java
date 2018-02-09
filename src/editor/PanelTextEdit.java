package editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.DefaultEditorKit;

import view.W;

public class PanelTextEdit extends JPanel {
	private static final long serialVersionUID = 1L;

	JTextArea title, info;
	JTextArea textArea;
	
	private JScrollPane scrollView;
	
	public PanelTextEdit(){
		setBounds(W.panelTextViewer);
		setLayout(null);
		
		int b = W.indexCellLeftMargin;
		Border border = BorderFactory.createLineBorder(Color.WHITE);
		JLabel t = new JLabel("TYTU£:", SwingConstants.RIGHT);
		t.setFont(t.getFont().deriveFont(W.fontSize12));
		t.setBounds(W.textEditTitleLabel);
		
		title = new JTextArea();
		title.setEditable(true);
		title.setFont(title.getFont().deriveFont(W.fontSize12));
	    title.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(0, b, 0, 0)));
	    title.setTabSize(2);
	    title.setBounds(W.textEditTitle);
	    title.setText("tytu³");
	    
	    JLabel i = new JLabel("INFO:", SwingConstants.RIGHT);
		i.setFont(i.getFont().deriveFont(W.fontSize12));
		i.setBounds(W.textEditInfoLabel);
		
	    info = new JTextArea();
		info.setEditable(true);
		info.setFont(info.getFont().deriveFont(W.fontSize12));
	    info.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(0,b, 0, 0)));
	    info.setTabSize(2);
	    info.setBounds(W.textEditInfo);
	    info.setText("tytu³");
	    
		textArea = new JTextArea();
		textArea.setEditable(true);
		textArea.getDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
		textArea.setFont(new Font("monospaced", Font.PLAIN, 20));
		textArea.setFont(textArea.getFont().deriveFont(W.fontSize12));
	    textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(b,b,b,b)));
	    textArea.setTabSize(2);
	    textArea.addKeyListener(new KeyListener(){
	        @Override
	        public void keyPressed(KeyEvent e){
	        	if(e.getKeyCode() == KeyEvent.VK_F1){
	        		e.consume();
	        		pressF1();
	        	}
	        	if(e.getKeyCode() == KeyEvent.VK_ENTER){
	        		
//	        	e.consume();
//	        		pasteBR();
	        	}
	        }

	        @Override
	        public void keyTyped(KeyEvent e) {
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
//	        	if(e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN 
//	        			&& e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_LEFT){
//	        	//	Editor.changeNewText();
//	        	}
	        }
	    });

		scrollView = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollView.setBounds(W.textEditText);
	    
//	    add(t);
//	    add(title);
//	    add(i);
//	    add(info);
	    add(scrollView);
	    setVisible(false);
	}
	
	private void pressF1(){
		addSymbol("|");
	}
	private void addSymbol(String s){
		int position = -1;
		position = textArea.getCaretPosition();
		textArea.setCaretPosition(position);
	}
	public List<String> getTextFromEdit() {
		List<String> e = new ArrayList<String>();
		String[] ww = textArea.getText().split("\n");
		for(String g : ww){
			e.add(g);
		}
		return e;
	}
}
