package view;

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

public class PanelTool extends JPanel{
	private static final long serialVersionUID = 1L;
	private ActionsController ac;
	JButton share;
	JLabel capo;
	JButton b_gr_remowe, menuSong;
	JPanel p_tools;
	
	public void init(ActionsController ac){
		this.ac = ac;
	}
	
	public PanelTool(){
		FlowLayout fl = new FlowLayout();
		fl.setHgap(0);
		fl.setVgap(0);
		setPreferredSize(new Dimension(45,725));
		setLayout(fl);
		ImageIcon ikona;

		
		p_tools = new JPanel();
		p_tools.setLayout(fl);
		p_tools.setPreferredSize(new Dimension(45,725));
		
		
		JPanel panelCapo = new JPanel();
		panelCapo.setPreferredSize(new Dimension(45,140));
		panelCapo.setLayout(new FlowLayout());
		JLabel c = new JLabel("Capo:",SwingConstants.CENTER);
		c.setPreferredSize(new Dimension(45,20));
		capo = new JLabel("0",SwingConstants.CENTER);
		capo.setFont(capo.getFont().deriveFont(36f));
		capo.setPreferredSize(new Dimension(45,35));
		ikona = new ImageIcon(getClass().getResource("/up.png"));
		JButton cup = new JButton(ikona);
		cup.setToolTipText(Const.TIP_CAPOUP);
		cup.setFocusable(false);
		cup.setPreferredSize(new Dimension(35, 20));
		cup.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	           ac.clickCapoUp();
	        }
	    });
		ikona = new ImageIcon(getClass().getResource("/down.png"));
		JButton cdo = new JButton(ikona);
		cdo.setToolTipText(Const.TIP_CAPODOWN);
		cdo.setFocusable(false);
		cdo.setPreferredSize(new Dimension(35, 20));
		cdo.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickCapoDown();
	        }
	    });
		panelCapo.add(c);
		panelCapo.add(capo);
		panelCapo.add(cup);
		panelCapo.add(cdo);
		
		
		
		JPanel panelTranspose = new JPanel();
		panelTranspose.setPreferredSize(new Dimension(45,105));
		JLabel t = new JLabel("Ton:",SwingConstants.CENTER);
		t.setPreferredSize(new Dimension(45,20));
		ikona = new ImageIcon(getClass().getResource("/up.png"));
		JButton tup = new JButton(ikona);
		tup.setToolTipText(Const.TIP_TONEUP);
		tup.setFocusable(false);
		tup.setPreferredSize(new Dimension(35, 20));
		tup.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickToneUp();
	        }
	    });
		ikona = new ImageIcon(getClass().getResource("/down.png"));
		JButton tdo = new JButton(ikona);
		tdo.setToolTipText(Const.TIP_TONEDOWN);
		tdo.setFocusable(false);
		tdo.setPreferredSize(new Dimension(35, 20));
		tdo.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickToneDown();
	        }
	    });
		panelTranspose.add(t);
		panelTranspose.add(tup);
		panelTranspose.add(tdo);

		JPanel panelUndo = new JPanel();
	    panelUndo.setPreferredSize(new Dimension(45,95));
	    ikona = new ImageIcon(getClass().getResource("/back.png"));
		JButton undo = new JButton(ikona);
		undo.setToolTipText(Const.TIP_UNDO);
		undo.setFocusable(false);
		undo.setPreferredSize(new Dimension(35,20));
		undo.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ac.clickUndo();
	        }
	    });
	    panelUndo.add(undo);
	   
	    
	    JPanel panelGroups = new JPanel();
	    panelGroups.setPreferredSize(new Dimension(45,265));
	    ikona = new ImageIcon(getClass().getResource("/note.png"));
	    menuSong = new JButton(ikona);
		menuSong.setToolTipText(Const.TIP_SONGMENU);
		menuSong.setFocusable(false);
		menuSong.setPreferredSize(new Dimension(35, 35));
		menuSong.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	//Dane.popMenu.menuGroupCheck.show(songGroups, 36, 0);
		        	Dane.popMenu.songMenu.show(menuSong, 36, 0);
		        }
		    });
		panelGroups.add(menuSong);
	    
		JPanel panelShare = new JPanel();
		panelShare.setPreferredSize(new Dimension(45,65));
		
	    ikona = new ImageIcon(getClass().getResource("/help.png"));
		JButton help = new JButton(ikona);
		help.setToolTipText("Jak korzystaæ");
		help.setFocusable(false);
		help.setPreferredSize(new Dimension(35, 35));
		help.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        }
	    });
	    
		
		p_tools.add(panelCapo);
		p_tools.add(panelTranspose);
		p_tools.add(panelUndo);
		p_tools.add(panelGroups);
		p_tools.add(panelShare);
		
		p_tools.add(help);
		
		add(p_tools);
		
		
		if(W.colors){
			Color c1 = new Color(0xC0C0C0);//D3D3D3
			Color c2 = new Color(0xDCDCDC);
			panelCapo.setBackground(c2);
			panelTranspose.setBackground(c2);
		    panelUndo.setBackground(c2);
		    panelGroups.setBackground(c1);
		}
	}

	
}
