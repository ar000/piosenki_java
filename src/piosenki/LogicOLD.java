package piosenki;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;

import baseFile.Baza;
import editor.Editor;
import groups.Groups;
import indexViewer.Index;
import song.SongInfo;
import textViewer.TextViewer;
import tools.Tools;
import view.ActionsController;
import view.Okno;
import view.ViewController;
import view.W;
import zzzzzzz.LogicEditSong;

public class LogicOLD {
	LogicEditSong editSong;
	LogicEditGroups  editGroups;
	LogicDrop drop;

	Okno w;
	ViewController vc;
	ActionsController ac;
	public LogicOLD(){
		ToolTipManager.sharedInstance().setDismissDelay(30000);
		new Dane();
		new W();
		
		new Baza(Dane.pathIndex);
		new Current();
		
		new TextViewer();
		new Index();
		new Groups();
		new Editor();
		new Tools();
		
		w = new Okno();
	//	TextViewer.setWindow(w);
		
		vc = new ViewController();
		drop = new LogicDrop(this, vc);
	//	editSong = new LogicEditSong(this, vc);
		editGroups = new LogicEditGroups(this, vc);
		ac = new ActionsController();
		
		ac.init(this, drop, editGroups, editSong);
		w.init(this, vc, ac);
		vc.init(w);
		Current.group = Const.ALL;
		
		Groups.setGroup(Const.ALL); // tam robi siê "szukaj("") 
//		TextViewer.clickTitle(Index.titlesNoHtm.get(0));
//		Index.setMarkTitle(Index.titlesNoHtm.get(0));
		Index.virtualClickTitle(Index.titlesNoHtm.get(0));
		
	//	viewCurrentGroup();
		
		//vc.setTextString(Const.STARTINFO);
		//clickTitleOnList(0);
		
		//Index.clickTitle(0);
		
		//vc.showTools(true);

	}
//	private void viewCurrentGroup(){
//		if(!Baza.isGroupName(Current.group)){
//			Current.group = Const.ALL;
//		}
//		if(Baza.getGroupSize(Current.group) == 0){
//			Current.group = Const.ALL;
//		}
//		
//			//makeCurrentGroupBaseAndTables();
//	//	Dane.songBase = new SongBase(Baza.getSongListFromGroup(Current.group));
//	//	vc.setGroupName(Current.group);
//		
//	//	Index.search("");   //createTables();
//		
//	//		clickClearSearch();
//		
//		
//		
//	//	vc.setGroupName(Current.group);
//	}
//	private void xxxmakeCurrentGroupBaseAndTables(){
////		if(Baza.getGroupSize(Current.group)==0)
////			Current.group = Const.ALL;
////		Dane.songBase = new SongBase(Baza.getSongListFromGroup(Current.group));
////		vc.setGroupName(Current.group);
////		createTables();
//	}
//	private void viewTitle(String title){
//		if(!Baza.isSongOnGroup(Current.group, title)){		
//			Current.title = Dane.songBase.getSongFromTitle(0).getTitle();
//			title = Current.title;
//		}
//		Dane.currentSong = Dane.songBase.getSongFromTitle(title);
//		TextViewer.setSong(Dane.songBase.getSongFromTitle(title));
//	//	dddshowText();
//	//	createMenus();
//	}
//	private void fdddshowText(){
////		Dane.currentText = new SongText(Baza.getSongText(Dane.currentSong.getTitle()), Dane.currentSong.getTitle(),
////										Dane.currentSong.getAuthor(), Dane.currentSong.getCapo(),W.panelTextViewer.width);
//		
//		
//		
//	//	vc.setText(Dane.currentText.getText());
//	//	vc.setInfoSong(Dane.currentText);
//		
//		
//		
////		Dane.modelTextList.clear();
////		List<LineText> lt = Dane.currentText.getArrayLineText();
////		for(LineText l : lt){
////			Dane.modelTextList.addElement(l);
////			int r = 93;
////			r++;
////			//vbfg
////		}
		
		
		
	//	TextViewer.showText();
		
		
//	}
	public void clickHideSong(){
		Baza.hideSong(Dane.currentSong.getTitle());
		Baza.saveBase();
		// SETGROUPS       viewCurrentGroup();
	//	viewTitle(Current.title);
//		createMenus();
	}
	public void clickUnhideSong(){
		Baza.unhideSong(Dane.currentSong.getTitle());
		Baza.saveBase();
		// SETGROUPS       viewCurrentGroup();
	//	viewTitle(Current.title);
//		createMenus();
	}
	public void clickDeleteSong(){
		String[] opcje = { "TAK, USUÑ","NIE, POMY£KA"};
    	int xx = JOptionPane.showOptionDialog(
    	           null, // okno
    	           "Na pewno usun¹æ z bazy piosenkê:  \n\""+Current.title +"\"", // komunikat
    	           "Niebezpieczna operacja", // tytu³
    	           JOptionPane.DEFAULT_OPTION, // rodzaj przycisków u do³u (tu niewa¿ny)
    	           JOptionPane.WARNING_MESSAGE,// typ komunikatu (standardowa ikona)
    	           null, // w³asna ikona (tu: brak)
    	           opcje, // w³asne opcje - przyciski
    	           opcje[1]); // domyœlny przycisk
		
    	System.out.println(xx);
    	
    	if(xx == 0){  //tak
    		List<String> text = Baza.getSongText(Current.title) ;
    		Date da = new Date();
    		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
    		String ee = ft.format(da);
    		String path = Dane.pathDelete + "\\"+Current.title+"_"+ee+".txt";//ee
    		Plik.checkFolder(Dane.pathDelete);
    		Plik.writeFile(text, path);
    		///jeszcze sprawdzic nazwe pliku bo sie nie zapisze do folderu
    
    		Baza.removeSong(Current.title);
    		Baza.saveBase();
    		// SETGROUPS       viewCurrentGroup();
    //		viewTitle(Current.title);
 //   		createMenus();
    	}else{
    		
    	}
    	
	}
//	private void createTables(){
//		//IndexViewer.search("");  //szukaj("");
//		
//	}
//	public void clickWordOnList(int index, List<Integer> indexes){
//		Current.title = Baza.songBase.getSongFromWord(indexes.get(index)).getTitle();
//	//	viewTitle(Current.title);
//	}
	
	//==  EDIT GROUPS  ======================
	public void clickEditGroup(){
		editGroups.start();
		//vc.setEditClassToEditGroups(editGroups);
		vc.selectionTableEditGroup();
	}
	public void endEditGroups(){
		vc.hideGroupEdit();
		//dddshowText();
//		createMenus();
		Baza.saveBase();
	}
	//==  EDIT SONG  ======================
	
	public void newSongToEdit(SongInfo si){
	//	editSong.edit(si);
	}
	public void postEditSong(String actualTitle){
	//	makeCurrentGroupBaseAndTables();
	//	vc.showPanels(ViewController.PANELS.NORMAL);
//		Dane.isEdit = false;
//		Dane.isAdd = false;
		//viewTitle(actualTitle);
		Baza.saveBase();
	}
	public void editCancel(){
	//	vc.showPanels(ViewController.PANELS.NORMAL);
	//	viewTitle(Current.title);
//		Dane.isEdit = false;
//		Dane.isAdd = false;
	}

	//========================================
	public boolean checkFile(String name){
		if(Plik.checkExportBase(name)){
			String[] opcje = { "ROZUMIEM"};
        	JOptionPane.showOptionDialog(
        	           null, // okno
        	           "Plik o takiej nazwie ju¿ istnieje" , // komunikat
        	           "Eksport niemo¿liwy", // tytu³
        	           JOptionPane.DEFAULT_OPTION, // rodzaj przycisków u do³u (tu niewa¿ny)
        	           JOptionPane.QUESTION_MESSAGE,// typ komunikatu (standardowa ikona)
        	           null, // w³asna ikona (tu: brak)
        	           opcje, // w³asne opcje - przyciski
        	           opcje[0]); // domyœlny przycisk
        	return false;
		}else{
			return true;
		}
	}
//	public String xxxxcreateShareFile(String name){
//		String fname = "";
//		fname = name;
//		Plik.createShareFile(fname);
//		return fname;
//	}
	//=========  DROP  ===========================
//	public void drop(String path){	
//		drop.drop(path);
//	}
	public void postkSavePackage(){	
	//	makeCurrentGroupBaseAndTables();
	//	viewTitle(Current.title);
	//	vc.showPanels(ViewController.PANELS.NORMAL);
//		Dane.isEdit = false;
//		Dane.isAdd = false;
		Baza.saveBase();
	}
	public void clickSavePackage(){
		drop.savePackage();		
	//	makeCurrentGroupBaseAndTables();
	//	viewTitle(Current.title);
	//	vc.showPanels(ViewController.PANELS.NORMAL);
//		Dane.isEdit = false;
//		Dane.isAdd = false;
		Baza.saveBase();
	}
	public void clickCancelPackage(){
	//	viewTitle(Current.title);
	//	vc.showPanels(ViewController.PANELS.NORMAL);
//		Dane.isEdit = false;
//		Dane.isAdd = false;
	}
	public void clickGroupFromPackage() {
		
	}
	//==================================================================

	public void clickShare(){
		
		String name = Current.group;
		Plik.createShareFile(name);
		List<String> tyt = Baza.getSongListFromGroup(Current.group);
		List<String> nowe = Plik.readFile(Dane.path+"\\" + name + Const.EXTNEW);
		for(String line : tyt){
			String[] l = line.split("/");
			nowe.add(0, line);
			nowe.add("<"+l[0]);
			nowe.addAll(nowe.size(),Baza.getSongText(l[0]));
			nowe.add(l[0]+">");
		}
		Plik.writeFile(nowe, Dane.path+"\\" + name + Const.EXTNEW);
		
		
		String[] opcje = { "FAJNIE"};
    	JOptionPane.showOptionDialog(
           null, // okno
           "Utworzono plik: \""+name+"\"" , // komunikat
           "Eksport udany", // tytu³
           JOptionPane.DEFAULT_OPTION, // rodzaj przycisków u do³u (tu niewa¿ny)
           JOptionPane.QUESTION_MESSAGE,// typ komunikatu (standardowa ikona)
           null, // w³asna ikona (tu: brak)
           opcje, // w³asne opcje - przyciski
           opcje[0]); // domyœlny przycisk
	}
	
	//================================
	//================================
	//================================
	//================================
	//================================
	//================================
	//================================


	
	///--CREATE POPUP MENU-------///
//	private void createMenus(){
////		createMenuSong();
////		createMenuCheck();
////		//createMenuGroup();
//	}
//	private void createMenuSong(){
////		boolean ishide,isLast;
////		if(Current.group.equals(Const.HIDE)){
////			ishide = true;
////		}else{
////			ishide = false;
////		}
////		if(Current.group==Const.ALL && Baza.getGroupSize(Current.group)==1){
////			isLast = true;
////		}else{
////			isLast = false;
////		}
////		
////		Dane.popMenu.createSongMenu(ishide,isLast);
//		
//	}
//	public void createMenuCheck(){
////		JCheckBoxMenuItem tt;
////		Dane.popMenu.itemCheck.clear();
////		boolean b = false;
////		for(Group g : Baza.groups){
////			b = (Baza.isSongOnGroup(g.getName(), Dane.currentSong.getTitle()));
////			if(g.getName().equals(Const.NEWEST) && !b){
////				tt = new JCheckBoxMenuItem(g.getName(),b);
////				tt.setEnabled(false);
////				Dane.popMenu.itemCheck.add(tt);
////			}
////			else
////				Dane.popMenu.itemCheck.add(new JCheckBoxMenuItem(g.getName(),b));
////		}
////
////		Dane.popMenu.createMenuGroupCheck();		
//	}
//	public void createMenuGroup(){
//		groupsMaxSize();
//		Dane.popMenu.itemMenu.clear();
//		JMenuItem item;
//		String text = "";
//		int size;
//		
//		for(Group g : Baza.groups){
//			size = g.getSize();
//			text = sizeToString(size)+g.getName();
//			
//			item = new JMenuItem(text);
//			if(size==0) item.setEnabled(false);
//			
//			Dane.popMenu.itemMenu.add(item);
//			
//		}
//		
//	//	Dane.popMenu.createMenuGroup();
//	}
//	private void groupsMaxSize(){
//		int maxSize = 0;
//		for(Group s : Baza.groups)
//			if(s.getSize()>maxSize) maxSize=s.getSize();
//		Dane.maxGroupSize = maxSize;
//	}
//	private String sizeToString(int size){
//		final String S = "[";
//		final String K = "] ";
//		String s1="",s2="",s3="",s4="";
//		if(Dane.maxGroupSize<10){
//			Dane.substringIndexForMenu = 4;
//		}else if(Dane.maxGroupSize<100){
//			s1 = " ";
//			Dane.substringIndexForMenu = 5;
//		}else if(Dane.maxGroupSize<1000){
//			s1 = "  ";s2 = " ";
//			Dane.substringIndexForMenu = 6;
//		}else if(Dane.maxGroupSize<10000){
//			s1 = "   ";s2 = "  ";s3 = " ";
//			Dane.substringIndexForMenu = 7;
//		}else if(Dane.maxGroupSize<100000){
//			s1 = "    ";s2 = "   ";s3 = "  ";s4 = " ";
//			Dane.substringIndexForMenu = 8;
//		}				
//			
//		String t = "";
//		if(size<10)
//			t = S+s1+String.valueOf(size)+K;
//		else if(size<100)
//			t = S+s2+String.valueOf(size)+K;
//		else if(size<1000)
//			t = S+s3+String.valueOf(size)+K;
//		else if(size<10000)
//			t = S+s4+String.valueOf(size)+K;
//		else if(size<100000)
//			t = S+String.valueOf(size)+K;
//		return t;
//	}
//	public void clickCheckMenu(String name, boolean state){
//		//System.out.println(name+" - "+String.valueOf(state));
//		if(state){
//			String line = Dane.currentSong.getTitle()+"/"+Dane.currentSong.getAuthor()
//					+"/"+Dane.currentSong.getLine1()+"/"+Dane.currentSong.getLine2()
//					+"/"+String.valueOf(Dane.currentSong.getCapo());
//			Baza.addSongLine(name, line);
//		}else{
//			Baza.removeSongLine(name, Current.title);
//		}
	//	makeCurrentGroupBaseAndTables();
//		viewTitle(Current.title);
////		createMenus();
//		Baza.saveBase();
//	}
//	public void clickGroupMenu(String name){		
//		Current.group = name.substring(Dane.substringIndexForMenu);		
//		viewCurrentGroup();
//		viewTitle(Current.title);
//	}
	
	
	
	
	

	
}
