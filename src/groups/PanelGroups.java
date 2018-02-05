package groups;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import piosenki.Const;
import view.W;

public class PanelGroups extends JPanel{
	private static final long serialVersionUID = 1L;

	public JLabel groupName;
	public JButton gru;
	public PanelGroups(){
		
		setBounds(W.panelGroupChange);
		if(W.colors)
			setBackground(Color.GREEN);
		setLayout(null);
		
		gru = new JButton("GRUPA  >");
		gru.setToolTipText(Const.TIP_GROUPS);
		gru.setBounds(W.buttonGroupsRect);
		gru.setFont(gru.getFont().deriveFont(W.fontSize12));
		gru.setFocusable(false);
		gru.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Groups.clickGroupButton();
	        }
	    });
		
		groupName = new JLabel("... ...");
		groupName.setBounds(W.labelGroupNameRect);
		groupName.setToolTipText(Const.TIP_GROUPNAME);
		groupName.setForeground(Color.blue);
		groupName.setFont(groupName.getFont().deriveFont(W.fontSize14));
		
		
		
		add(gru);
		add(groupName);	
	}
	
}
