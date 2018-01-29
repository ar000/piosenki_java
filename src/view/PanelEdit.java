package view;

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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import piosenki.Dane;
import textViewer.TextViewer;

public class PanelEdit extends JPanel{

	private static final long serialVersionUID = 1L;
	private ActionsController ac;
	private JButton b_title, b_author, b_words1, b_words2, b_capoMinus, b_capoPlus;
	JLabel l_title, l_author, l_words1, l_words2, l_capo, l_info, l_help;
	JLabel u_title, u_word1, u_word2;
	JButton b_save, b_saveAs;
	public int capo;
	
	public void init(ActionsController ac){
		this.ac = ac;
	}
	
	public PanelEdit(){
		setPreferredSize(W.panelEditDim);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		Border bf = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		ImageIcon ikona;
		JLabel l1 = new JLabel("Zaznacz tekst i kliknij odpowiedni przycisk.",SwingConstants.CENTER);
		l1.setPreferredSize(new Dimension(350,25));
	
		ikona = new ImageIcon(getClass().getResource("/uwaga.png"));
		JPanel pt = new JPanel();
		pt.setPreferredSize(new Dimension(340,65));
		pt.setBorder(bf);
		pt.setLayout(null);
		b_title = new JButton("Tytu³");
		b_title.setFocusable(false);
		b_title.setBounds(8, 2, 325, 25);
		b_title.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickEditTitle();
	        }
	    });
		l_title = new JLabel("Tytu³");
		l_title.setBounds(8, 35, 300, 25);
		l_title.setOpaque(true);
		u_title = new JLabel(ikona);
		u_title.setBounds(310, 35, 25, 25);
		pt.add(b_title);
		pt.add(l_title);
		pt.add(u_title);
		
		JPanel pa = new JPanel();
		pa.setPreferredSize(new Dimension(340,65));
		pa.setBorder(bf);
		pa.setLayout(null);
		b_author = new JButton("Autor");
		b_author.setFocusable(false);
		b_author.setBounds(8, 2, 325, 25);
		b_author.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickEditAuthor();
	        }
	    });
		l_author = new JLabel("");
		l_author.setBounds(8, 35, 280, 25);
		pa.add(b_author);
		pa.add(l_author);
		
		JPanel pl1 = new JPanel();
		pl1.setPreferredSize(new Dimension(340,65));
		pl1.setBorder(bf);
		pl1.setLayout(null);
		b_words1 = new JButton("Pierwsze s³owa zwrotki.");
		b_words1.setFocusable(false);
		b_words1.setBounds(8, 2, 325, 25);
		b_words1.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickEditLine1();
	        }
	    });
		l_words1 = new JLabel("");
		l_words1.setBounds(8, 35, 280, 25);
		u_word1 = new JLabel(ikona);
		u_word1.setBounds(310, 35, 25, 25);
		pl1.add(b_words1);
		pl1.add(l_words1);
		pl1.add(u_word1);
		
		JPanel pl2 = new JPanel();
		pl2.setPreferredSize(new Dimension(340,65));
		pl2.setBorder(bf);
		pl2.setLayout(null);
		b_words2 = new JButton("Pierwsze s³owa refrenu");
		b_words2.setFocusable(false);
		b_words2.setBounds(8, 2, 325, 25);
		b_words2.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickEditLine2();
	        }
	    });
		l_words2 = new JLabel("");
		l_words2.setBounds(8, 35, 280, 25);
		u_word2 = new JLabel(ikona);
		u_word2.setBounds(310, 35, 25, 25);
		pl2.add(b_words2);
		pl2.add(l_words2);
		pl2.add(u_word2);
		
		JPanel pc = new JPanel();
		pc.setPreferredSize(new Dimension(340,65));
		pc.setBorder(bf);
		pc.setLayout(null);	
		JLabel i = new JLabel("Kapodaster : ");
		i.setBounds(8,0,280,18);		
		b_capoMinus = new JButton("<<");
		b_capoMinus.setFocusable(false);
		b_capoMinus.setBounds(100, 20, 50, 25);
		b_capoMinus.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	int cap = Integer.parseInt((Dane.editCapo));
	        	if(cap>0) cap--;
	        	Dane.editCapo = String.valueOf(cap);
	        	l_capo.setText(Dane.editCapo);
	        }
	    });
		l_capo = new JLabel("0");
		l_capo.setBounds(160, 20, 50, 25);
		l_capo.setFont(new Font(l_capo.getFont().getName(), Font.PLAIN, 34));	
		b_capoPlus = new JButton(">>");
		b_capoPlus.setFocusable(false);
		b_capoPlus.setBounds(190, 20, 50, 25);
		b_capoPlus.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	int cap = Integer.parseInt((Dane.editCapo));
	        	if(cap<9) cap++;
	        	Dane.editCapo = String.valueOf(cap);
	        	l_capo.setText(Dane.editCapo);
	        }
	    });
		pc.add(i);
		pc.add(b_capoMinus);
		pc.add(l_capo);
		pc.add(b_capoPlus);
		
		JPanel sep = new JPanel();
		sep.setPreferredSize(new Dimension(300,10));
		
		JPanel ps = new JPanel();
		ps.setPreferredSize(new Dimension(300,95));
		ps.setBorder(bf);
		ps.setLayout(null);	
		b_save = new JButton("Zapisz pisenkê do bazy");
		b_save.setFocusable(false);
		b_save.setBounds(8, 2, 280, 25);
		b_save.setEnabled(false);
		b_save.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickEditSavePostEdit();
	        }
	    });
		
		l_info = new JLabel("");
		l_info.setBounds(8, 35, 280, 25);
		l_info.setForeground(Color.RED);
		b_saveAs = new JButton("Zapisz jako now¹");
		b_saveAs.setFocusable(false);
		b_saveAs.setBounds(8, 60, 280, 25);
		b_saveAs.setEnabled(false);
		b_saveAs.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickEditSaveAs();
	        }
	    });
		ps.add(b_save);
		ps.add(l_info);
		ps.add(b_saveAs);
		
		JPanel sep2 = new JPanel();
		sep2.setPreferredSize(new Dimension(300,10));
		
		JPanel ex = new JPanel();
		ex.setPreferredSize(new Dimension(300,31));
		ex.setBorder(bf);
		ex.setLayout(null);	
		JButton b_exit = new JButton("Wyjdz bez zapisywania");
		b_exit.setFocusable(false);
		b_exit.setBounds(8, 2, 280, 25);
		b_exit.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickEditCancel();
	        	TextViewer.showViewer();
	        }
	    });
		//b_exit.addActionListener(TextViewer.ActionViewView());
		ex.add(b_exit);
		
		JPanel sep3 = new JPanel();
		sep3.setPreferredSize(new Dimension(300,5));
		l_help = new JLabel(Dane.helpEdit);
		
		
		add(l1);
		add(pt);
		add(pa);
		add(pl1);
		add(pl2);
		add(pc);
		add(sep);
		add(ps);
		add(sep2);
		add(ex);
		add(sep3);
		add(l_help);
		setVisible(false);
		
	}
}
