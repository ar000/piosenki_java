package piosenki;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;

import baseFile.Baza;
import baseFile.Group;
import song.SongBase;
import song.SongInfo;
import song.SongText;
import text.LineText;
import view.ActionsController;
import view.Okno;
import view.ViewController;
import view.W;

public class Logic {
	LogicEditSong editSong;
	LogicEditGroups  editGroups;
	LogicDrop drop;
	LogicSong song;
	Okno w;
	ViewController vc;
	ActionsController ac;
	List<Integer> indexes;
	public Logic(){
		ToolTipManager.sharedInstance().setDismissDelay(30000);
		new W();
		new Dane();
		new Baza(Dane.pathIndex);
		new Current();
		Dane.popMenu.sendTo(this);
		w = new Okno();
		vc = new ViewController();
		song = new LogicSong(vc);
		drop = new LogicDrop(this, vc);
		editSong = new LogicEditSong(this, vc);
		editGroups = new LogicEditGroups(this, vc);
		ac = new ActionsController();
		
		ac.init(this, drop, editGroups, editSong, song);
		w.init(this, vc, ac);
		vc.init(w);
		
		indexes = new ArrayList<>();
		Current.group = Const.ALL;
		viewCurrentGroup();
		
		//vc.setTextString(Const.STARTINFO);
		clickTitleOnList(0);
		
		vc.showTools(true);

	}
	private void viewCurrentGroup(){
		if(!Baza.isGroupName(Current.group)){
			Current.group = Const.ALL;
		}
		if(Baza.getGroupSize(Current.group) == 0){
			Current.group = Const.ALL;
		}
		if(Current.group==Const.ALL && Baza.getGroupSize(Current.group)==0){
			
		}else{
			makeCurrentGroupBaseAndTables();
			clickClearSearch();
		}
		
		
		vc.setGroupName(Current.group);
	}
	private void makeCurrentGroupBaseAndTables(){
		if(Baza.getGroupSize(Current.group)==0)
			Current.group = Const.ALL;
		Dane.songBase = new SongBase(Baza.getSongListFromGroup(Current.group));
		vc.setGroupName(Current.group);
		createTables();
	}
	private void viewTitle(String title){
		if(!Baza.isSongOnGroup(Current.group, title)){		
			Current.title = Dane.songBase.getSongFromTitle(0).getTitle();
			title = Current.title;
		}
		Dane.currentSong = Dane.songBase.getSongFromTitle(title);
		showText();
		createMenus();
	}
	private void showText(){
		Dane.currentText = new SongText(Baza.getSongText(Dane.currentSong.getTitle()), Dane.currentSong.getTitle(),
										Dane.currentSong.getAuthor(), Dane.currentSong.getCapo(),W.panelLeftDim.width);
		vc.setText(Dane.currentText.getText());
		vc.setInfoSong(Dane.currentText);
		
		
		
		Dane.modelTextList.clear();
		List<LineText> lt = Dane.currentText.getArrayLineText();
		for(LineText l : lt){
			Dane.modelTextList.addElement(l);
			int r = 93;
			r++;
			//vbfg
		}
		
	}
	public void clickTitleOnList(int index){
		Current.title = Dane.titlesNoHtml.get(index);
		viewTitle(Current.title);
		vc.showTools(true);
	}
	public void clickHideSong(){
		Baza.hideSong(Dane.currentSong.getTitle());
		Baza.saveBase();
		viewCurrentGroup();
		viewTitle(Current.title);
		createMenus();
	}
	public void clickUnhideSong(){
		Baza.unhideSong(Dane.currentSong.getTitle());
		Baza.saveBase();
		viewCurrentGroup();
		viewTitle(Current.title);
		createMenus();
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
    		viewCurrentGroup();
    		viewTitle(Current.title);
    		createMenus();
    	}else{
    		
    	}
    	
	}
	private void createTables(){
		szukaj("");
	}
	public void clickWordOnList(int index){
		Current.title = Dane.songBase.getSongFromWord(indexes.get(index)).getTitle();
		viewTitle(Current.title);
	}
	
	//==  EDIT GROUPS  ======================
	public void clickEditGroup(){
		editGroups.start();
		//vc.setEditClassToEditGroups(editGroups);
		vc.selectionTableEditGroup();
	}
	public void endEditGroups(){
		vc.hideGroupEdit();
		showText();
		createMenus();
		Baza.saveBase();
	}
	//==  EDIT SONG  ======================
	
	public void clickEditSong(){
		Dane.editCapo = String.valueOf(Dane.currentText.getCapo());
		Dane.isEdit = true;
		Dane.isAdd = false;
		editSong.edit(Dane.currentSong);
		
	}
	public void newSongToEdit(SongInfo si){
		editSong.edit(si);
	}
	public void postEditSong(String actualTitle){
		makeCurrentGroupBaseAndTables();
		vc.showPanels(ViewController.PANELS.NORMAL);
		Dane.isEdit = false;
		Dane.isAdd = false;
		viewTitle(actualTitle);
		Baza.saveBase();
	}
	public void editCancel(){
		vc.showPanels(ViewController.PANELS.NORMAL);
		viewTitle(Current.title);
		Dane.isEdit = false;
		Dane.isAdd = false;
	}
	//=====================================
	public void clickStartSearch(String d){
		szukaj(d);
	}
	public void szukaj(String d){
		//Stoper st = new Stoper();
		//st.Start();
		Dane.modelListT.clear();
        Dane.modelListW.clear();
        Dane.titlesNoHtml.clear();
        indexes.clear();
        int ii;
        String[] f = Dane.songBase.getTitleList();
        String[] w = Dane.songBase.getWordList();
        
		if(d.equals("")){
			for(String title : f){
				Dane.modelListT.addElement(title);
		        Dane.titlesNoHtml.add(title);
			}
			ii = 0;
			for(String word : w){
                Dane.modelListW.addElement(word);
                indexes.add(ii++);
			}
	
		}else{
			String h0 = "<html>";
			String h1 = "<font color=\"red\";'><b>";
	        String h2 = "</b></font>";
	        String h3 = "</html>";
	        
	        String tt;
	        StringBuilder html;
	        String ss = d.toLowerCase().trim();
//	        Dane.tabT.setRowCount(0);
//	        Dane.tabW.setRowCount(0);
	       

			for(String title : f){
				tt = title.toLowerCase();
				String tt2 = bezPol(tt);
				if(jestSlowo(tt2, ss)){
					html = new StringBuilder();
	                int start = tt2.indexOf(ss);
	                String s1 = title.substring(0,start);
	                String s2 = title.substring(start+ss.length());
	                html.append(h0);
	                html.append(s1);
	                html.append(h1);
	                html.append(title.substring(start, start+ss.length()));
	                html.append(h2);
	                html.append(s2);
	                html.append(h3);
	                Dane.modelListT.addElement(html.toString());
	                Dane.titlesNoHtml.add(title);
				}
			} 
			
			
			ii = 0;
			for(String word : w){
	            tt = word.toLowerCase();
	            String tt2 = bezPol(tt);
	            if(jestSlowo(tt2,ss)){
	                html = new StringBuilder();
	                int start = tt2.indexOf(ss);
	                String s1 = word.substring(0,start);
	                String s2 = word.substring(start+ss.length());
	                html.append(h0);
	                html.append(s1);
	                html.append(h1);
	                html.append(word.substring(start, start+ss.length()));
	                html.append(h2);
	                html.append(s2);
	                html.append(h3);
	                Dane.modelListW.addElement(html.toString());
	                indexes.add(ii);
	            }
	            ii++;
	        }
		}
		//st.Stop("szukanie");
        
	}
    private String bezPol(String t){
        StringBuilder sb = new StringBuilder();
        char[] tpol = t.toCharArray();
        for(char c : tpol){
            if(c > 122){
                if(c == '¿') c = 'z';
                else  if(c == 'Ÿ') c = 'z';
                else  if(c == '³') c = 'l';
                else  if(c == 'ñ') c = 'n';
                else  if(c == 'æ') c = 'c';
                else  if(c == '¹') c = 'a';
                else  if(c == 'ê') c = 'e';
                else  if(c == 'œ') c = 's';
                else  if(c == 'ó') c = 'o';
            }
            sb.append(c);
        }
        return sb.toString();
    }
    private boolean jestSlowo(String t, String s){
        int in = t.indexOf(s);
        if(in >- 1){
            if(in == 0){
                return true;
            }else{
                String sub = t.substring(in-1, in);
                if(sub.equals(" ")){
                    return true;
                }else if(sub.equals("-")){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
	public void clickClearSearch(){
		vc.clearSearchField();
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
		makeCurrentGroupBaseAndTables();
		viewTitle(Current.title);
		vc.showPanels(ViewController.PANELS.NORMAL);
		Dane.isEdit = false;
		Dane.isAdd = false;
		Baza.saveBase();
	}
	public void clickSavePackage(){
		drop.savePackage();		
		makeCurrentGroupBaseAndTables();
		viewTitle(Current.title);
		vc.showPanels(ViewController.PANELS.NORMAL);
		Dane.isEdit = false;
		Dane.isAdd = false;
		Baza.saveBase();
	}
	public void clickCancelPackage(){
		viewTitle(Current.title);
		vc.showPanels(ViewController.PANELS.NORMAL);
		Dane.isEdit = false;
		Dane.isAdd = false;
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

	public void clickHelp(){
		
	}
	
	///--CREATE POPUP MENU-------///
	private void createMenus(){
		createMenuSong();
		createMenuCheck();
		createMenuGroup();
	}
	private void createMenuSong(){
		boolean ishide,isLast;
		if(Current.group.equals(Const.HIDE)){
			ishide = true;
		}else{
			ishide = false;
		}
		if(Current.group==Const.ALL && Baza.getGroupSize(Current.group)==1){
			isLast = true;
		}else{
			isLast = false;
		}
		
		Dane.popMenu.createSongMenu(ishide,isLast);
		
	}
	public void createMenuCheck(){
		JCheckBoxMenuItem tt;
		Dane.popMenu.itemCheck.clear();
		boolean b = false;
		for(Group g : Baza.groups){
			b = (Baza.isSongOnGroup(g.getName(), Dane.currentSong.getTitle()));
			if(g.getName().equals(Const.NEWEST) && !b){
				tt = new JCheckBoxMenuItem(g.getName(),b);
				tt.setEnabled(false);
				Dane.popMenu.itemCheck.add(tt);
			}
			else
				Dane.popMenu.itemCheck.add(new JCheckBoxMenuItem(g.getName(),b));
		}

		Dane.popMenu.createMenuGroupCheck();		
	}
	public void createMenuGroup(){
		groupsMaxSize();
		Dane.popMenu.itemMenu.clear();
		JMenuItem item;
		String text = "";
		int size;
		
		for(Group g : Baza.groups){
			size = g.getSize();
			text = sizeToString(size)+g.getName();
			
			item = new JMenuItem(text);
			if(size==0) item.setEnabled(false);
			
			Dane.popMenu.itemMenu.add(item);
			
		}
		
		Dane.popMenu.createMenuGroup();
	}
	private void groupsMaxSize(){
		int maxSize = 0;
		for(Group s : Baza.groups)
			if(s.getSize()>maxSize) maxSize=s.getSize();
		Dane.maxGroupSize = maxSize;
	}
	private String sizeToString(int size){
		final String S = "[";
		final String K = "] ";
		String s1="",s2="",s3="",s4="";
		if(Dane.maxGroupSize<10){
			Dane.substringIndexForMenu = 4;
		}else if(Dane.maxGroupSize<100){
			s1 = " ";
			Dane.substringIndexForMenu = 5;
		}else if(Dane.maxGroupSize<1000){
			s1 = "  ";s2 = " ";
			Dane.substringIndexForMenu = 6;
		}else if(Dane.maxGroupSize<10000){
			s1 = "   ";s2 = "  ";s3 = " ";
			Dane.substringIndexForMenu = 7;
		}else if(Dane.maxGroupSize<100000){
			s1 = "    ";s2 = "   ";s3 = "  ";s4 = " ";
			Dane.substringIndexForMenu = 8;
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
	public void clickCheckMenu(String name, boolean state){
		//System.out.println(name+" - "+String.valueOf(state));
		if(state){
			String line = Dane.currentSong.getTitle()+"/"+Dane.currentSong.getAuthor()
					+"/"+Dane.currentSong.getLine1()+"/"+Dane.currentSong.getLine2()
					+"/"+String.valueOf(Dane.currentSong.getCapo());
			Baza.addSongLine(name, line);
		}else{
			Baza.removeSongLine(name, Current.title);
		}
		makeCurrentGroupBaseAndTables();
		viewTitle(Current.title);
		createMenus();
		Baza.saveBase();
	}
	public void clickGroupMenu(String name){		
		Current.group = name.substring(Dane.substringIndexForMenu);		
		viewCurrentGroup();
		viewTitle(Current.title);
	}
	
	
	
	
	

	
}
