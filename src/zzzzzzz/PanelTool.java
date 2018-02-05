package zzzzzzz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import piosenki.Const;
import piosenki.Dane;
import textViewer.TextViewer;
import view.ActionsController;
import view.W;

public class PanelTool extends JPanel{
	private static final long serialVersionUID = 1L;
	private ActionsController ac;
	JButton share;
//	JLabel capo;
	JButton b_gr_remowe, menuSong;
	JPanel p_tools;
	
	public void init(ActionsController ac){
		this.ac = ac;
	}
	
	public PanelTool(){
		FlowLayout fl = new FlowLayout();
		fl.setHgap(0);
		fl.setVgap(0);
		
//		setBounds(W.panelTool);
		
		setBackground(Color.RED);
		setLayout(fl);
		ImageIcon ikona;

		
		p_tools = new JPanel();
		p_tools.setLayout(fl);
		
//		p_tools.setPreferredSize(W.panelToolsDim);
		
		
//		JPanel panelCapo = new JPanel();
//		panelCapo.setPreferredSize(W.panelCapo);
//		panelCapo.setLayout(new FlowLayout());
//		JLabel c = new JLabel("Capo:",SwingConstants.CENTER);
//		c.setFont(c.getFont().deriveFont(W.fontSize12));
//		c.setPreferredSize(W.labelCapoNapis);
//		capo = new JLabel("0",SwingConstants.CENTER);
//		capo.setFont(capo.getFont().deriveFont(W.fontSize36));//36f
//		capo.setPreferredSize(W.labelCapoValue);
//		ikona = new ImageIcon(getClass().getResource("/up.png"));
//		JButton cup = new JButton(ikona);
//		cup.setToolTipText(Const.TIP_CAPOUP);
//		cup.setFocusable(false);
//		cup.setPreferredSize(W.buutonHalf);
//		cup.addActionListener( new ActionListener()
//	    {
//	        public void actionPerformed(ActionEvent e)
//	        {
//	           ac.clickCapoUp();
//	        }
//	    });
//		ikona = new ImageIcon(getClass().getResource("/down.png"));
//		JButton cdo = new JButton(ikona);
//		cdo.setToolTipText(Const.TIP_CAPODOWN);
//		cdo.setFocusable(false);
//		cdo.setPreferredSize(W.buutonHalf);
//		cdo.addActionListener( new ActionListener()
//	    {
//	        public void actionPerformed(ActionEvent e)
//	        {
//	        	ac.clickCapoDown();
//	        }
//	    });
//		panelCapo.add(c);
//		panelCapo.add(capo);
//		panelCapo.add(cup);
//		panelCapo.add(cdo);
		
		
		
//		JPanel panelTranspose = new JPanel();
//		panelTranspose.setPreferredSize(W.panelTranspose);
//		JLabel t = new JLabel("Ton:",SwingConstants.CENTER);
//		t.setFont(t.getFont().deriveFont(W.fontSize12));
//		t.setPreferredSize(W.labelTonNapis);
//		ikona = new ImageIcon(getClass().getResource("/up.png"));
//		JButton tup = new JButton(ikona);
//		tup.setToolTipText(Const.TIP_TONEUP);
//		tup.setFocusable(false);
//		tup.setPreferredSize(W.buutonHalf);
//		tup.addActionListener( new ActionListener()
//	    {
//	        public void actionPerformed(ActionEvent e)
//	        {
//	        	ac.clickToneUp();
//	        }
//	    });
//		ikona = new ImageIcon(getClass().getResource("/down.png"));
//		JButton tdo = new JButton(ikona);
//		tdo.setToolTipText(Const.TIP_TONEDOWN);
//		tdo.setFocusable(false);
//		tdo.setPreferredSize(W.buutonHalf);
//		tdo.addActionListener( new ActionListener()
//	    {
//	        public void actionPerformed(ActionEvent e)
//	        {
//	        	ac.clickToneDown();
//	        }
//	    });
//		panelTranspose.add(t);
//		panelTranspose.add(tup);
//		panelTranspose.add(tdo);

		
		
//		JPanel panelUndo = new JPanel();
//	    panelUndo.setPreferredSize(W.panelUndo);
//	    ikona = new ImageIcon(getClass().getResource("/back.png"));
//		JButton undo = new JButton(ikona);
//		undo.setToolTipText(Const.TIP_UNDO);
//		undo.setFocusable(false);
//		undo.setPreferredSize(W.buutonHalf);
//		undo.addActionListener( new ActionListener()
//	    {
//	        public void actionPerformed(ActionEvent e)
//	        {
//	        	ac.clickUndo();
//	        }
//	    });
//	    panelUndo.add(undo);
	   
	    
	    JPanel panelMenu = new JPanel();
	    panelMenu.setPreferredSize(W.panelMenu);
	    ikona = new ImageIcon(getClass().getResource("/note.png"));
	    menuSong = new JButton(ikona);
		menuSong.setToolTipText(Const.TIP_SONGMENU);
		menuSong.setFocusable(false);
		menuSong.setPreferredSize(W.buttonAll);
		menuSong.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	//Dane.popMenu.menuGroupCheck.show(songGroups, 36, 0);
		  //      	Dane.popMenu.songMenu.show(menuSong, W.menuSongX, W.menuSongY);
		        }
		    });
		panelMenu.add(menuSong);
	    
		
		menuSong.setVisible(false);
		
		JPanel panelShare = new JPanel();
		panelShare.setPreferredSize(W.panelShare);
		
	    ikona = new ImageIcon(getClass().getResource("/help.png"));
		JButton help = new JButton(ikona);
		help.setToolTipText("Jak korzystaæ");
		help.setFocusable(false);
		help.setPreferredSize(W.buttonAll);
		help.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        }
	    });
	    
		
//		p_tools.add(panelCapo);
//		p_tools.add(panelTranspose);
//		p_tools.add(panelUndo);
		
		p_tools.add(TextViewer.getPanelTool());
		p_tools.add(panelMenu);
		p_tools.add(panelShare);
		
//		p_tools.add(help);
		
		add(p_tools);
		
		
		if(W.colors){
			Color c1 = new Color(0xC0C0C0);//D3D3D3
			Color c2 = new Color(0xDCDCDC);
//			panelCapo.setBackground(c2);
//			panelTranspose.setBackground(c2);
//		    panelUndo.setBackground(c2);
		    panelMenu.setBackground(c1);
		    panelShare.setBackground(c2);
		    this.setBackground(Color.YELLOW);
		}
	}

	
}
