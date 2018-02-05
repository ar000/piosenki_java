package groups;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import piosenki.Const;
import view.W;

public class GroupsMenu {
	public static JPopupMenu menuGroup;
	private static JMenu groupSubmenu;
	public static List<JMenuItem> itemMenu;
	
	public GroupsMenu(){
		menuGroup = new JPopupMenu();
		groupSubmenu = new JMenu("WIÊCEJ");
		itemMenu = new ArrayList<JMenuItem>();
	}
	
	public static void createMenuGroup(){
		menuGroup.removeAll();
		groupSubmenu.removeAll();
		int i = 0;
		for(JMenuItem it : itemMenu){
			it.setFont(new Font("Monospaced", Font.PLAIN, 12));
			it.setFont(it.getFont().deriveFont(W.fontSize12));
			
			menuGroup.add(it);
			it.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	String cmd = e.getActionCommand();
		        	
		        	Groups.clickGroupMenu(cmd);
		  //      	L.clickGroupMenu(cmd);
		        }
		    });
			
			if(i==2)menuGroup.add(new JSeparator());
			i++;
		}
		menuGroup.add(new JSeparator());
		JMenuItem edit = new JMenuItem("EDYTUJ GRUPY");
		edit.setFont(edit.getFont().deriveFont(W.fontSize12));
		edit.setToolTipText(Const.TIP_EDITGROUP);
		edit.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Groups.clickEditGroups();
	        }
	    });
		groupSubmenu.add(edit);
		groupSubmenu.addSeparator();
		JMenuItem export = new JMenuItem("EKSPORTUJ GRUPÊ");
		export.setFont(export.getFont().deriveFont(W.fontSize12));
		export.setToolTipText(Const.TIP_GROUPEXPORT);
		export.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Groups.clicShareGroup();
	        }
	    });
		groupSubmenu.add(export);
		groupSubmenu.setFont(groupSubmenu.getFont().deriveFont(W.fontSize12));
		menuGroup.add(groupSubmenu);
		//MenuScroller.setScrollerFor(menuGroup,30,100,3,0);
	}
	
}
