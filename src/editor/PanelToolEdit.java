package editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import piosenki.Const;
import view.W;

public class PanelToolEdit extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel l_info;
	private JLabel warningTitle, warningLine1, warningLine2;
	public JLabel l_capo;
	public JButton b_save;
	public JButton b_saveAs;
	public JButton b_saveNew;
	private JTextArea title, info, line1, line2;
	
	public PanelToolEdit(){
		
		setBounds(W.panelEditor);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		Border bf = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		ImageIcon ikona;
		JLabel l1 = new JLabel(Const.EDITINFO,SwingConstants.CENTER);
		l1.setFont(l1.getFont().deriveFont(W.fontSize12));
	
		ikona = new ImageIcon(getClass().getResource("/uwaga.png"));
		JPanel pTitle = new JPanel();
		pTitle.setPreferredSize(W.panelEditField);  //new Dimension(340,65)
		pTitle.setBorder(bf);
		pTitle.setLayout(null);
		
		JButton b_title = new JButton("TYTU£");
		b_title.setFocusable(false);
		b_title.setFont(b_title.getFont().deriveFont(W.fontSize12));
		b_title.setBounds(W.panelEditFieldButton);//(8, 2, 325, 25)
		b_title.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickTitle();
	        }
	    });
		
		title = new JTextArea();
		title.setBounds(W.panelEditFieldText);
		title.setFont(title.getFont().deriveFont(W.fontSize12));
		title.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				Editor.changeTitle();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Editor.changeTitle();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
			}
		});
		warningTitle = new JLabel(ikona);
		warningTitle.setBounds(W.panelEditFieldIcon);
		pTitle.add(b_title);
		pTitle.add(title);
		pTitle.add(warningTitle);
		
		JPanel pInfo = new JPanel();
		pInfo.setPreferredSize(W.panelEditField);
		pInfo.setBorder(bf);
		pInfo.setLayout(null);
		JButton b_author = new JButton("INFO");
		b_author.setFocusable(false);
		b_author.setBounds(W.panelEditFieldButton);
		b_author.setFont(b_author.getFont().deriveFont(W.fontSize12));
		b_author.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickInfo();
	        }
	    });
		info = new JTextArea();
		info.setBounds(W.panelEditFieldText);
		info.setFont(title.getFont().deriveFont(W.fontSize12));
		info.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				Editor.changeInfo();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Editor.changeInfo();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
			}
		});
		pInfo.add(b_author);
		pInfo.add(info);
		
		JPanel pLine1 = new JPanel();
		pLine1.setPreferredSize(W.panelEditField);
		pLine1.setBorder(bf);
		pLine1.setLayout(null);
		JButton b_words1 = new JButton("ZWROTKA");
		b_words1.setFocusable(false);
		b_words1.setBounds(W.panelEditFieldButton);
		b_words1.setFont(b_words1.getFont().deriveFont(W.fontSize12));
		b_words1.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickWord1();
	        }
	    });
		line1 = new JTextArea();
		line1.setBounds(W.panelEditFieldText);
		line1.setFont(title.getFont().deriveFont(W.fontSize12));
		line1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				Editor.changeLine1();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Editor.changeLine1();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
			}
		});
		warningLine1 = new JLabel(ikona);
		warningLine1.setBounds(W.panelEditFieldIcon);
		pLine1.add(b_words1);
		pLine1.add(line1);
		pLine1.add(warningLine1);
		
		JPanel pLine2 = new JPanel();
		pLine2.setPreferredSize(W.panelEditField);
		pLine2.setBorder(bf);
		pLine2.setLayout(null);
		JButton b_words2 = new JButton("REFREN");
		b_words2.setFocusable(false);
		b_words2.setBounds(W.panelEditFieldButton);
		b_words2.setFont(b_words2.getFont().deriveFont(W.fontSize12));
		b_words2.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickWord2();
	        }
	    });
		line2 = new JTextArea();
		line2.setBounds(W.panelEditFieldText);
		line2.setFont(title.getFont().deriveFont(W.fontSize12));
		line2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				Editor.changeLine2();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Editor.changeLine2();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
			}
		});
		warningLine2 = new JLabel(ikona);
		warningLine2.setBounds(W.panelEditFieldIcon);
		pLine2.add(b_words2);
		pLine2.add(line2);
		pLine2.add(warningLine2);
		
		JPanel pCapo = new JPanel();
		pCapo.setPreferredSize(W.panelEditFieldCapo);
		pCapo.setBorder(bf);
		pCapo.setLayout(null);	
		JLabel i = new JLabel("Kapodaster : ");
		i.setFont(i.getFont().deriveFont(W.fontSize12));
		i.setBounds(8,0,280,18);		
		JButton b_capoMinus = new JButton("<<");
		b_capoMinus.setFocusable(false);
		b_capoMinus.setBounds(W.panelEditFieldCapoMinus);
		b_capoMinus.setFont(b_capoMinus.getFont().deriveFont(W.fontSize12));
		b_capoMinus.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	int cap = Integer.parseInt(l_capo.getText());
	        	if(cap>0) cap--;
	        	l_capo.setText(String.valueOf(cap));
	        }
	    });
		l_capo = new JLabel("0");
		l_capo.setBounds(W.panelEditFieldCapoLabel);
		l_capo.setFont(new Font(l_capo.getFont().getName(), Font.PLAIN, 34));	
		JButton b_capoPlus = new JButton(">>");
		b_capoPlus.setFocusable(false);
		b_capoPlus.setBounds(W.panelEditFieldCapoPlus);
		b_capoPlus.setFont(b_capoPlus.getFont().deriveFont(W.fontSize12));
		b_capoPlus.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	int cap = Integer.parseInt((l_capo.getText()));
	        	if(cap<9) cap++;
	        	l_capo.setText(String.valueOf(cap));
	        }
	    });
		pCapo.add(i);
		pCapo.add(b_capoMinus);
		pCapo.add(l_capo);
		pCapo.add(b_capoPlus);
		
		JPanel sep = new JPanel();
		sep.setPreferredSize(W.panelEditorSeparator);
		
		JPanel pSave = new JPanel();
		pSave.setPreferredSize(W.panelEditSave);
		pSave.setBorder(bf);
		pSave.setLayout(null);	
		b_save = new JButton("Zapisz pisenkê do bazy");
		b_save.setFocusable(false);
		b_save.setBounds(W.panelEditButtonSave);
		b_save.setFont(b_save.getFont().deriveFont(W.fontSize12));
		b_save.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickSave();
	        }
	    });
		
		l_info = new JLabel("Taki tytu³ ju¿ istnieje, wpisz inny");
		l_info.setBounds(W.panelEditLabelInfoSave);
		l_info.setFont(l_info.getFont().deriveFont(W.fontSize14));
		l_info.setForeground(Color.RED);
		b_saveAs = new JButton("Zapisz jako now¹");
		b_saveAs.setFocusable(false);
		b_saveAs.setBounds(W.panelEditButtonSaveAs);
		b_saveAs.setFont(b_saveAs.getFont().deriveFont(W.fontSize12));
		b_saveAs.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickSaveAs();
	        }
	    });
		
		b_saveNew = new JButton("Dodaj piosenkê do bazy");
		b_saveNew.setFocusable(false);
		b_saveNew.setBounds(W.panelEditButtonSaveNew);
		b_saveNew.setFont(b_saveAs.getFont().deriveFont(W.fontSize12));
		b_saveNew.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickSaveNewSong();
	        }
	    });
		
		
		JButton b_exit = new JButton("Wyjdz bez zapisywania");
		b_exit.setFocusable(false);
		b_exit.setBounds(W.panelEditButtonCancel);
		b_exit.setFont(b_exit.getFont().deriveFont(W.fontSize12));
		b_exit.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Editor.clickCancel();
	        }
	    });
		pSave.add(b_save);
		pSave.add(l_info);
		pSave.add(b_saveAs);
		pSave.add(b_saveNew);
		pSave.add(b_exit);
		
		JPanel sep2 = new JPanel();
		sep2.setPreferredSize(W.panelEditorSeparator);
		
		
		
		JPanel pHelp = new JPanel();
		pHelp.setPreferredSize(W.panelEditHelp);
		pHelp.setBorder(bf);
		pHelp.setLayout(null);	
		JLabel l_help = new JLabel(Const.EDITHELP);
		l_help.setBounds(W.panelEditLabelHelp);
		l_help.setBackground(Color.red);
		l_help.setOpaque(true);
		l_help.setFont(l_help.getFont().deriveFont(W.fontSize12));
	
		pHelp.add(l_help);
		
		JPanel sep3 = new JPanel();
		sep3.setPreferredSize(new Dimension(300,5));
		
		
		add(l1);
		add(pTitle);
		add(pInfo);
		add(pLine1);
		add(pLine2);
		
		add(pCapo);
		add(sep);
		add(pSave);
		add(sep2);
		add(pHelp);
		add(sep3);
		
		setVisible(false);
		
		
		
	}
	public void setButtonsToEdit(){
		b_save.setVisible(true);
		b_saveAs.setVisible(true);
		b_saveNew.setVisible(false);
	}
	public void setButtonsToNew(){
		b_save.setVisible(false);
		b_saveAs.setVisible(false);
		b_saveNew.setVisible(true);
	}
	
	public void setWarningSameTitle(boolean stan){
		l_info.setVisible(stan);
	}
	
	public void setLine2(String value){
		line2.setText(value);
	}
	public String getLine2(){
		return line2.getText().trim();
	}
	public void setLine1(String value){
		line1.setText(value);
	}
	public String getLine1(){
		return line1.getText().trim();
	}
	public void setInfo(String value){
		info.setText(value);
	}
	public String getInfo(){
		return info.getText().trim();
	}
	public void setTitle(String value){
		title.setText(value);
	}
	public String getTitle(){
		return title.getText().trim();
	}
	public void setCapo(String value){
		l_capo.setText(value);
	}
	public String getCapo(){
		return l_capo.getText();
	}
	public void setWarningTitle(boolean state){
		warningTitle.setVisible(state);
	}
	public void setWarningLine1(boolean state){
		warningLine1.setVisible(state);
	}
	public void setWarningLine2(boolean state){
		warningLine2.setVisible(state);
	}
}
