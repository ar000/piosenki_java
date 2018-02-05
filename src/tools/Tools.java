package tools;

import javax.swing.JCheckBoxMenuItem;

import baseFile.Baza;
import baseFile.Group;
import editor.Editor;
import groups.Groups;
import indexViewer.Index;
import piosenki.Const;
import textViewer.TextViewer;
import view.W;

public class Tools {

	private static PanelTool pt;
	
	public Tools(){
		pt = new PanelTool();
		new SongMenu();
		
	}
	
	public static void clickEdit(){
		TextViewer.showEditor();
		Groups.hide();
		Index.hide();
		Editor.show();
		hide();
	}
	
	public static void createSongMenu(){
		
		createMenuCheck();
		
		boolean ishide,isLast;
		if(Groups.grupa.equals(Const.HIDE)){
			ishide = true;
		}else{
			ishide = false;
		}
		if(Groups.grupa==Const.ALL && Baza.getGroupSize(Groups.grupa)==1){
			isLast = true;
		}else{
			isLast = false;
		}
		
		SongMenu.createSongMenu(ishide,isLast);
		
		
		
	}
	
	private static void createMenuCheck(){
		JCheckBoxMenuItem tt;
		SongMenu.itemCheck.clear();
		boolean b = false;
		for(Group g : Baza.groups){
			b = (Baza.isSongOnGroup(g.getName(), TextViewer.currentTitle));
			if(g.getName().equals(Const.NEWEST) && !b){
				tt = new JCheckBoxMenuItem(g.getName(),b);
				tt.setEnabled(false);
				SongMenu.itemCheck.add(tt);
			}
			else
				SongMenu.itemCheck.add(new JCheckBoxMenuItem(g.getName(),b));
		}

		SongMenu.createMenuGroupCheck();		
	}
	
	public static void clickMenuButton(){
		SongMenu.songMenu.show(pt.menuSong, W.menuSongX, W.menuSongY);
	}
	
	public static PanelTool getPanel(){
		return pt;
	}
	
	public static void show(){
		pt.setVisible(true);
	}
	public static void hide(){
		pt.setVisible(false);
	}
}
