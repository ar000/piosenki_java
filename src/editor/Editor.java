package editor;

import java.util.ArrayList;
import java.util.List;

import baseFile.Baza;
import groups.Groups;
import indexViewer.Index;
import piosenki.Const;
import piosenki.Plik;
import textViewer.TextViewer;
import tools.Tools;

public class Editor {

	private static PanelToolEdit panelToolEdit;
	private static PanelTextEdit panelTextEdit;
	private static String oldTitle, newTitle, info, line1, line2;
	private static boolean  save = true;
	private static boolean  saveas = false;
	private static boolean  titleok = false;
	private static boolean  line1ok = false;
	private static boolean  line2ok = false;
	private static boolean  duplicateTitle = false;
	
	public Editor(){
		panelToolEdit = new PanelToolEdit();
		panelTextEdit = new PanelTextEdit();
		
	}
	
	public static void changeInfo(){
		info = panelToolEdit.getInfo();
	}
	public static void changeTitle(){
		duplicateTitle = false;
		newTitle = panelToolEdit.getTitle();
		if(newTitle.length()==0){
			titleok = false;
		}else{
			titleok = true;
			if(newTitle.equals(oldTitle)){
				saveas = false;
			}else{
				if(isUniqueTitle()){
					saveas = true;
				}else{
					titleok = false;
					duplicateTitle = true;
				}
				
			}
		}
		analizeChange();
	}
	public static void changeLine1(){
		line1 = panelToolEdit.getLine1();
		if(line1.length()==0){
			line1ok = false;			
		}else{
			line1ok = true;
		}
		analizeChange();
	}
	public static void changeLine2(){
		line2 = panelToolEdit.getLine2();
		if(line2.length()==0){
			line2ok = false;
		}else{
			line2ok = true;
		}
		analizeChange();
	}
	
	private static void analizeChange(){
		panelToolEdit.setWarningTitle(!titleok);
		panelToolEdit.setWarningLine1(!line1ok);
		panelToolEdit.setWarningLine2(!line2ok);
		if(titleok && line1ok && line2ok){
			panelToolEdit.b_save.setEnabled(save);
			panelToolEdit.b_saveAs.setEnabled(saveas);
			panelToolEdit.b_saveNew.setEnabled(saveas);
			
		}else{
			panelToolEdit.b_save.setEnabled(false);
			panelToolEdit.b_saveAs.setEnabled(false);
			panelToolEdit.b_saveNew.setEnabled(false);
		}
		panelToolEdit.setWarningSameTitle(duplicateTitle);
	}
	
	
	public static void clickTitle(){
		panelToolEdit.setTitle(panelTextEdit.textArea.getSelectedText().trim());
		
	}
	
	public static void clickInfo(){
		panelToolEdit.setInfo(panelTextEdit.textArea.getSelectedText().trim());
	}

	public static void clickWord1(){
		panelToolEdit.setLine1(panelTextEdit.textArea.getSelectedText().trim());
	}
	
	public static void clickWord2(){
		panelToolEdit.setLine2(panelTextEdit.textArea.getSelectedText().trim());
	}
	
	private static boolean isUniqueTitle(){
			if(Baza.isSongOnGroup(Const.ALL,newTitle) 
					|| Baza.isSongOnGroup(Const.HIDE,newTitle)){
				return false;
			}else{
				return true;
			}
	}
	
	public static void clickSave(){
		System.out.println("SAVE.");
		save();
	}
	
	private static void save(){
		deleteOldSaveNewLineText();
		Baza.removeSongText(oldTitle);
		Baza.writeSongText(makeSongTextToSave(), newTitle);
		postSave();
	}
	public static void clickSaveAs(){
		saveNewLineText();
		Baza.writeSongText(makeSongTextToSave(), newTitle);
		postSave();
	}	
	private static void saveNewLineText(){
		for(int i = 0; i<Baza.groups.size(); i++){
			if(Baza.isSongOnGroup(Baza.groups.get(i).getName(),oldTitle)){
				Baza.addSongLine(Baza.groups.get(i).getName(), makeSongLine());
			}
		}
	}
	private static void deleteOldSaveNewLineText(){
		for(int i = 0; i<Baza.groups.size(); i++){
			if(Baza.isSongOnGroup(Baza.groups.get(i).getName(),oldTitle)){
				Baza.removeSongLine(Baza.groups.get(i).getName(), oldTitle);
				Baza.addSongLine(Baza.groups.get(i).getName(), makeSongLine());
			}
		}
	}
	private static void postSave(){
		Baza.saveBase();
		Groups.setGroup(Groups.grupa);//robi tez menugrup
		Index.virtualClickTitle(newTitle);
		clickCancel();
	}
	private static List<String> makeSongTextToSave(){
		List<String> tekst = new ArrayList<String>();
		tekst.addAll(panelTextEdit.getTextFromEdit());
		return tekst;
	}
	
	private static String makeSongLine(){
		StringBuilder lineSong = new StringBuilder();
		lineSong.append(newTitle);
		lineSong.append("/");
		lineSong.append(info);
		lineSong.append("/");
		lineSong.append(line1);
		lineSong.append("/");
		lineSong.append(line2);
		lineSong.append("/");
		lineSong.append(panelToolEdit.getCapo());
		return lineSong.toString();
	}
	
	public static void clickCancel(){
		TextViewer.show();
		Groups.show();
		Index.show();
		Editor.hide();
		Tools.show();
	}
	
	public static void newTextFile(String path){
		List<String> lines = Plik.readFile(path);
		String[] text = new String[lines.size()];
		int x = 0;
		for(String l : lines){
			text[x++] = l;
		}
		
		setNewTextToEdit(text);
		
		TextViewer.hide();
		Groups.hide();
		Index.hide();
		Tools.hide();
		Editor.show();
		panelToolEdit.setButtonsToNew();
		
	}

	private static void setNewTextToEdit(String[] text){
		panelTextEdit.textArea.setText("");
		StringBuilder sb= new StringBuilder();
		for(int i = 0; i < text.length; i++){
			sb.append(text[i]);
			sb.append('\n');
		}
		panelTextEdit.textArea.setText(sb.toString());
		
			newTitle = text[0].trim();
			oldTitle = "mIo*&^bh#..Ho))";
			panelToolEdit.setTitle(text[0]);
			panelToolEdit.setInfo(text[1]);
			panelToolEdit.setLine1("");
			panelToolEdit.setLine2("");
			int c = 0;
			try{
				c = Integer.parseInt(text[2].substring(0, 1));
			}catch(NumberFormatException n){
				c = 0;
			}
			panelToolEdit.setCapo(String.valueOf(c));
			panelTextEdit.textArea.setCaretPosition(0);
		
		panelToolEdit.b_saveAs.setEnabled(false);
	}
	
	public static void clickSaveNewSong(){
		Baza.addSongLine(Const.ALL, makeSongLine());
		Baza.addSongLine(Const.NEWEST, makeSongLine());
		Baza.writeSongText(makeSongTextToSave(), newTitle);
		postSave();
	}
	
	public static void editCurrentSong(){
		setTextToEdit(TextViewer.songText.getTextToEdit());
		panelToolEdit.setButtonsToEdit();
	}
	
	public static void setTextToEdit(String[] text){
		StringBuilder sb= new StringBuilder();
		for(int i = 0; i < text.length; i++){
			sb.append(text[i]);
			sb.append('\n');
		}
		
		panelTextEdit.textArea.setText(sb.toString());
		panelTextEdit.textArea.setCaretPosition(0);
		
		oldTitle = TextViewer.songInfo.getTitle();
		newTitle = oldTitle;
		
		panelToolEdit.setTitle(oldTitle);
		panelToolEdit.setInfo(TextViewer.songInfo.getAuthor());
		panelToolEdit.setLine1(TextViewer.songInfo.getLine1());
		panelToolEdit.setLine2(TextViewer.songInfo.getLine2());
		panelToolEdit.setCapo(String.valueOf(TextViewer.songInfo.getCapo()));
		
		panelToolEdit.b_saveAs.setEnabled(false);
		panelToolEdit.setWarningLine1(false);
		panelToolEdit.setWarningLine2(false);
		panelToolEdit.setWarningTitle(false);
	}
	public static PanelToolEdit getPanelToolEdit(){
		return panelToolEdit;
	}
	public static PanelTextEdit getPanelTextEdit(){
		return panelTextEdit;
	}
	public static void show(){
		panelToolEdit.setVisible(true);
		panelTextEdit.setVisible(true);
	}
	public static void hide(){
		panelToolEdit.setVisible(false);
		panelTextEdit.setVisible(false);
	}
}
