package zzzzzzz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.MenuSelectionManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import piosenki.Const;
import piosenki.LogicOLD;
import textViewer.TextViewer;
import view.W;

public class PopMenu {

	private  LogicOLD L;
	//public  JPopupMenu menuGroupCheck;
	public  JPopupMenu menuGroup;
	public  JPopupMenu songMenu;
	public  List<JCheckBoxMenuItem> itemCheck;
	public  List<JMenuItem> itemMenu;
	public  List<JMenuItem> itemSongMenu;
	public JMenuItem hide, unhide, edit, delete;
	public JMenu checkSubmenu;
	public JMenu groupSubmenu;
	
	public PopMenu(){
		
		//menuGroupCheck = new JPopupMenu();
		menuGroup = new JPopupMenu();
		songMenu = new JPopupMenu();
		checkSubmenu = new JMenu("Grupy");
		
		groupSubmenu = new JMenu("WI�CEJ");
		
		itemCheck = new ArrayList<JCheckBoxMenuItem>();
		itemMenu = new ArrayList<JMenuItem>();
		itemSongMenu = new ArrayList<JMenuItem>();
		
	}
	
	public void sendTo(LogicOLD L){
		this.L = L;
	}
	public void createSongMenu(boolean ishide, boolean ostatnia){
		songMenu.removeAll();
		
		hide = new JMenuItem("Przenie� do ukrytych");
		hide.setFont(hide.getFont().deriveFont(W.fontSize12));
		hide.setToolTipText(Const.TIP_HIDE);
		hide.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	L.clickHideSong();
	        }
	    });
		 unhide = new JMenuItem("Przenie� do bazy");
		 unhide.setFont(unhide.getFont().deriveFont(W.fontSize12));
		unhide.setToolTipText(Const.TIP_UNHIDE);
		unhide.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	L.clickUnhideSong();
	        }
	    });
		unhide.setEnabled(false);
		 edit = new JMenuItem("Edytuj piosenk�");
		 edit.setFont(edit.getFont().deriveFont(W.fontSize12));
		edit.setToolTipText(Const.TIP_EDITSONG);
		edit.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        //	L.clickEditSong();
	        	TextViewer.hide();
	        }
	    });
		//TextViewer tv = new TextViewer(new Dimension(3,3));
		// edit.addActionListener(TextViewer.ActionViewEdit());
		 delete = new JMenuItem("Usu� piosenk�");
		 delete.setFont(delete.getFont().deriveFont(W.fontSize12));
		 delete.setToolTipText(Const.TIP_DELETESONG);
		 delete.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	L.clickDeleteSong();
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
	
	public  void createMenuGroupCheck(){
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
		       // 	L.clickCheckMenu(cmd, k);
		        }
		    });
		}

		groupSubmenu.setFont(groupSubmenu.getFont().deriveFont(W.fontSize12));
	}
	
//	public  void createMenuGroup(){
//		menuGroup.removeAll();
//		groupSubmenu.removeAll();
//		int i = 0;
//		for(JMenuItem it : itemMenu){
//			it.setFont(new Font("Monospaced", Font.PLAIN, 12));
//			it.setFont(it.getFont().deriveFont(W.fontSize12));
//			
//			menuGroup.add(it);
//			it.addActionListener( new ActionListener()
//		    {
//		        public void actionPerformed(ActionEvent e)
//		        {
//		        	String cmd = e.getActionCommand();
//		        	
//		        	
//		        	L.clickGroupMenu(cmd);
//		        }
//		    });
//			
//			if(i==2)menuGroup.add(new JSeparator());
//			i++;
//		}
//		menuGroup.add(new JSeparator());
//		JMenuItem edit = new JMenuItem("EDYTUJ GRUPY");
//		edit.setFont(edit.getFont().deriveFont(W.fontSize12));
//		edit.setToolTipText(Const.TIP_EDITGROUP);
//		edit.addActionListener( new ActionListener()
//	    {
//	        public void actionPerformed(ActionEvent e)
//	        {
//	        	L.clickEditGroup();
//	        }
//	    });
//		groupSubmenu.add(edit);
//		groupSubmenu.addSeparator();
//		JMenuItem export = new JMenuItem("EKSPORTUJ GRUP�");
//		export.setFont(export.getFont().deriveFont(W.fontSize12));
//		export.setToolTipText(Const.TIP_GROUPEXPORT);
//		export.addActionListener( new ActionListener()
//	    {
//	        public void actionPerformed(ActionEvent e)
//	        {
//	        	L.clickShare();
//	        }
//	    });
//		groupSubmenu.add(export);
//		menuGroup.add(groupSubmenu);
//		//MenuScroller.setScrollerFor(menuGroup,30,100,3,0);
//	}
	
	
	
	
	
	
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
