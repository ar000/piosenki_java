package tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.MenuSelectionManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import piosenki.Const;
import view.W;

public class SongMenu {

	public static JPopupMenu songMenu;
	public static JMenu checkSubmenu;
	public  static List<JMenuItem> itemSongMenu;
	public static  List<JCheckBoxMenuItem> itemCheck;
	public static JMenuItem hide, unhide, edit, delete;
	
	public SongMenu(){
		songMenu = new JPopupMenu();
		checkSubmenu = new JMenu("Grupy");
		itemCheck = new ArrayList<JCheckBoxMenuItem>();
		itemSongMenu = new ArrayList<JMenuItem>();
		
		
	}
	
	public static void createSongMenu(boolean ishide, boolean ostatnia){
		songMenu.removeAll();
		
		hide = new JMenuItem("Przenieœ do ukrytych");
		hide.setFont(hide.getFont().deriveFont(W.fontSize12));
		hide.setToolTipText(Const.TIP_HIDE);
		hide.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        //	L.clickHideSong();
	        }
	    });
		 unhide = new JMenuItem("Przenieœ do bazy");
		 unhide.setFont(unhide.getFont().deriveFont(W.fontSize12));
		unhide.setToolTipText(Const.TIP_UNHIDE);
		unhide.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        //	L.clickUnhideSong();
	        }
	    });
		unhide.setEnabled(false);
		 edit = new JMenuItem("Edytuj piosenkê");
		 edit.setFont(edit.getFont().deriveFont(W.fontSize12));
		edit.setToolTipText(Const.TIP_EDITSONG);
		edit.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Tools.clickEdit();
	        }
	    });
		//TextViewer tv = new TextViewer(new Dimension(3,3));
		// edit.addActionListener(TextViewer.ActionViewEdit());
		 delete = new JMenuItem("Usuñ piosenkê");
		 delete.setFont(delete.getFont().deriveFont(W.fontSize12));
		 delete.setToolTipText(Const.TIP_DELETESONG);
		 delete.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        //	L.clickDeleteSong();
		        }
		    });
			
	if(ishide){
		hide.setEnabled(false);
		unhide.setEnabled(true);
		edit.setEnabled(false);
		checkSubmenu.setEnabled(false);
	}else{
		hide.setEnabled(true);
		unhide.setEnabled(false);
		edit.setEnabled(true);
		checkSubmenu.setEnabled(true);
	}
	if(ostatnia){
		hide.setEnabled(false);
		delete.setEnabled(false);
	}else{
		hide.setEnabled(true);
		delete.setEnabled(true);
	}
		
		songMenu.add(checkSubmenu);
		songMenu.addSeparator();
		songMenu.add(edit);
		songMenu.addSeparator();
		songMenu.add(hide);
		songMenu.add(unhide);
		songMenu.add(delete);
		
		checkSubmenu.setFont(checkSubmenu.getFont().deriveFont(W.fontSize12));
	}
	
	public static void createMenuGroupCheck(){
		//menuGroupCheck.removeAll();
		checkSubmenu.removeAll();
		
		for(JCheckBoxMenuItem it : itemCheck){
			it.setFont(it.getFont().deriveFont(W.fontSize12));
			if(it.getText().equals(Const.ALL) || it.getText().equals(Const.HIDE)){
				
			}else{
				//menuGroupCheck.add(it);
				checkSubmenu.add(it);
			}
			it.setUI( new MenuNotClosed());
			it.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	String cmd = e.getActionCommand();
		        	JCheckBoxMenuItem itt = (JCheckBoxMenuItem) e.getSource();
		        	boolean k = itt.getState();
		        	Tools.clickGroupCheckMenu(cmd, k);
		        }
		    });
		}

	}
	
	
	private static class MenuNotClosed extends BasicCheckBoxMenuItemUI{



		   @Override
		   protected void doClick(MenuSelectionManager msm) {
		      menuItem.doClick(0);
		   }

		   public static ComponentUI createUI(JComponent c) {
		      return new MenuNotClosed();
		   }
		
	}
}
