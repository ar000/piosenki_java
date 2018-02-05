package textViewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import piosenki.Const;
import view.W;

public class PanelTranspose extends JPanel {

	private static final long serialVersionUID = 1L;
	public JLabel capo = new JLabel();
	
	public PanelTranspose(){
		FlowLayout fl = new FlowLayout();
		fl.setHgap(0);
		fl.setVgap(0);
	//	setPreferredSize(W.panelToolsDim);
		setBounds(W.panelTransposeTool);
		
		
		setLayout(fl);
		ImageIcon ikona;
		
		JPanel panelCapo = new JPanel();
		panelCapo.setPreferredSize(W.panelCapo);
		panelCapo.setLayout(new FlowLayout());
		JLabel c = new JLabel("Capo:",SwingConstants.CENTER);
		c.setFont(c.getFont().deriveFont(W.fontSize12));
		c.setPreferredSize(W.labelCapoNapis);
		capo = new JLabel("0",SwingConstants.CENTER);
		capo.setFont(capo.getFont().deriveFont(W.fontSize36));//36f
		capo.setPreferredSize(W.labelCapoValue);
		ikona = new ImageIcon(getClass().getResource("/up.png"));
		
		JButton cup = new JButton(resizeIcon(ikona,W.halfIcon));
		cup.setToolTipText(Const.TIP_CAPOUP);
		cup.setFocusable(false);
		cup.setPreferredSize(W.buutonHalf);
		cup.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	           TextViewer.capoUp();
	        }
	    });
		ikona = new ImageIcon(getClass().getResource("/down.png"));
		
		JButton cdo = new JButton(resizeIcon(ikona,W.halfIcon));
		cdo.setToolTipText(Const.TIP_CAPODOWN);
		cdo.setFocusable(false);
		cdo.setPreferredSize(W.buutonHalf);
		cdo.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	TextViewer.capoDown();
	        }
	    });
		panelCapo.add(c);
		panelCapo.add(capo);
		panelCapo.add(cup);
		panelCapo.add(cdo);
		
		JPanel panelTranspose = new JPanel();
		panelTranspose.setPreferredSize(W.panelTranspose);
		JLabel t = new JLabel("Ton:",SwingConstants.CENTER);
		t.setFont(t.getFont().deriveFont(W.fontSize12));
		t.setPreferredSize(W.labelTonNapis);
		ikona = new ImageIcon(getClass().getResource("/up.png"));
		JButton tup = new JButton(resizeIcon(ikona,W.halfIcon));
		tup.setToolTipText(Const.TIP_TONEUP);
		tup.setFocusable(false);
		tup.setPreferredSize(W.buutonHalf);
		tup.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	TextViewer.toneUp();
	        }
	    });
		ikona = new ImageIcon(getClass().getResource("/down.png"));
		JButton tdo = new JButton(resizeIcon(ikona,W.halfIcon));
		tdo.setToolTipText(Const.TIP_TONEDOWN);
		tdo.setFocusable(false);
		tdo.setPreferredSize(W.buutonHalf);
		tdo.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	TextViewer.toneDown();
	        }
	    });
		panelTranspose.add(t);
		panelTranspose.add(tup);
		panelTranspose.add(tdo);

		JPanel panelUndo = new JPanel();
	    panelUndo.setPreferredSize(W.panelUndo);
	    ikona = new ImageIcon(getClass().getResource("/back.png"));
		JButton undo = new JButton(resizeIcon(ikona,W.halfIcon));
		undo.setToolTipText(Const.TIP_UNDO);
		undo.setFocusable(false);
		undo.setPreferredSize(W.buutonHalf);
		undo.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	TextViewer.restore();
	        }
	    });
	    panelUndo.add(undo);
	   // undo.setEnabled(false);
	    add(panelCapo);
	    add(panelTranspose);
	    add(panelUndo);
	    
	    if(W.colors){
	    	setBackground(Color.BLUE);
	    	panelCapo.setBackground(Color.YELLOW);
	    	panelTranspose.setBackground(Color.white);
	    	panelUndo.setBackground(Color.YELLOW);
	    }
	}
	
	private ImageIcon resizeIcon(ImageIcon im, Dimension d){
		Image image = im.getImage(); // transform it 
		Image newimg = image.getScaledInstance(d.width, d.height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return new ImageIcon(newimg);  // transform it back
		
	}
}
