package tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import piosenki.Const;
import view.W;

public class PanelTool extends JPanel {
	private static final long serialVersionUID = 1L;
	public JButton menuSong;
	
	public PanelTool(){
		FlowLayout fl = new FlowLayout();
		fl.setHgap(0);
		fl.setVgap(0);
		setLayout(fl);
		setBounds(W.panelTools);
		ImageIcon ikona;
		
		JPanel panelMenu = new JPanel();
	    panelMenu.setPreferredSize(W.panelMenu);
	    
	    ikona = new ImageIcon(getClass().getResource("/note.png"));
	    menuSong = new JButton(resizeIcon(ikona, W.fullIcon));
		menuSong.setToolTipText(Const.TIP_SONGMENU);
		menuSong.setFocusable(false);
		menuSong.setPreferredSize(W.buttonAll);
		menuSong.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	//Dane.popMenu.menuGroupCheck.show(songGroups, 36, 0);
		        	Tools.clickMenuButton();
		        }
		    });
		panelMenu.add(menuSong);
		
		
		
		
		
		add(panelMenu);
		
		if(W.colors){
			setBackground(Color.RED);
			panelMenu.setBackground(Color.yellow);
		}
		
		
		
		
	}
	
	
	private ImageIcon resizeIcon(ImageIcon im, Dimension d){
		Image image = im.getImage(); // transform it 
		Image newimg = image.getScaledInstance(d.width, d.height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return new ImageIcon(newimg);  // transform it back
		
	}
	
	
}
