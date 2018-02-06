package groups;

import javax.swing.JMenuItem;

import baseFile.Baza;
import baseFile.Group;
import baseFile.SongBase;
import indexViewer.Index;
import piosenki.Const;
import textViewer.TextViewer;
import view.W;

public class Groups {

	private static PanelGroups pg;
	
	public static String grupa;
	
	private static int maxGroupSize, substringIndexForMenu;
	
	public Groups(){
		pg = new PanelGroups();
		new GroupsMenu();
		//createMenu();
	}
	private static void createMenu(){
		groupsMaxSize();
		GroupsMenu.itemMenu.clear();
		JMenuItem item;
		String text = "";
		int size;
		
		for(Group g : Baza.groups){
			size = g.getSize();
			text = sizeToString(size)+g.getName();
			
			item = new JMenuItem(text);
			if(size==0) item.setEnabled(false);
			
			GroupsMenu.itemMenu.add(item);
			
		}
		GroupsMenu.createMenuGroup();
	}
	private static void groupsMaxSize(){
		int maxSize = 0;
		for(Group s : Baza.groups)
			if(s.getSize()>maxSize) maxSize=s.getSize();
		maxGroupSize = maxSize;
	}
	private static String sizeToString(int size){
		final String S = "[";
		final String K = "] ";
		String s1="",s2="",s3="",s4="";
		if(maxGroupSize<10){
			substringIndexForMenu = 4;
		}else if(maxGroupSize<100){
			s1 = " ";
			substringIndexForMenu = 5;
		}else if(maxGroupSize<1000){
			s1 = "  ";s2 = " ";
			substringIndexForMenu = 6;
		}else if(maxGroupSize<10000){
			s1 = "   ";s2 = "  ";s3 = " ";
			substringIndexForMenu = 7;
		}else if(maxGroupSize<100000){
			s1 = "    ";s2 = "   ";s3 = "  ";s4 = " ";
			substringIndexForMenu = 8;
		}				
			
		String t = "";
		if(size<10)
			t = S+s1+String.valueOf(size)+K;
		else if(size<100)
			t = S+s2+String.valueOf(size)+K;
		else if(size<1000)
			t = S+s3+String.valueOf(size)+K;
		else if(size<10000)
			t = S+s4+String.valueOf(size)+K;
		else if(size<100000)
			t = S+String.valueOf(size)+K;
		return t;
	}
	
	
	public static void setGroup(String name){
		grupa = name;
		if(!Baza.isGroupName(grupa)){
			grupa = Const.ALL;
		}
		if(Baza.getGroupSize(grupa) == 0){
			grupa = Const.ALL;
		}
		
		pg.groupName.setText(grupa);
		
		Baza.songBase = new SongBase(Baza.getSongListFromGroup(grupa));
		Index.search("");
//		TextViewer.clickTitle(Index.titlesNoHtm.get(0));
//		Index.setMarkTitle(Index.titlesNoHtm.get(0));
		createMenu();
	}
	
	public static void show(){
		pg.setVisible(true);
	}
	public static void hide(){
		pg.setVisible(false);
	}
	
	public static void clickGroupButton(){
		//Dane.popMenu.menuGroup.show(gru, W.menuGrupX, W.menuGrupY);
		GroupsMenu.menuGroup.show(pg.gru, W.menuGrupX, W.menuGrupY);
	}
	public static void clickGroupMenu(String cmd){
		setGroup(cmd.substring(substringIndexForMenu));	
		Index.setMarkTitle(TextViewer.title); //po wybraniu nowej grupy, zaznacza na niej aktualny tytul
	//	viewCurrentGroup();
	//	viewTitle(Current.title);
	}
	public static void clickEditGroups(){
		
	}
	public static void clicShareGroup(){
		
	}

	public static PanelGroups getPanel(){
		return pg;
	}
}
