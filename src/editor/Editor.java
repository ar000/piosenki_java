package editor;

import java.util.ArrayList;
import java.util.List;

import baseFile.Baza;
import groups.Groups;
import indexViewer.Index;
import piosenki.Dane;
import textViewer.TextViewer;
import tools.Tools;

public class Editor {

	private static PanelToolEdit panelToolEdit;
	private static PanelTextEdit panelTextEdit;
	private static String oldTitle, newTitle, info, line1, line2;
	private static boolean  saveas = false;
	private static boolean  titleok = false;
	private static boolean  line1ok = false;
	private static boolean  line2ok = false;
	
	public Editor(){
		panelToolEdit = new PanelToolEdit();
		panelTextEdit = new PanelTextEdit();
		
		
	}
	
	public static void changeInfo(){
		info = panelToolEdit.getInfo();
	}
	public static void changeTitle(){
		newTitle = panelToolEdit.getTitle();
		if(newTitle.length()==0){
			saveas = false;
			titleok = false;
		}else{
			titleok = true;
			if(!newTitle.equals(oldTitle)){
				saveas = true;
			}else{
				saveas = false;
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
			panelToolEdit.b_save.setEnabled(true);
			panelToolEdit.b_saveAs.setEnabled(saveas);
		}else{
			panelToolEdit.b_save.setEnabled(false);
			panelToolEdit.b_saveAs.setEnabled(false);
		}
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
	
	public static void clickSave(){
		System.out.println("SAVE!!!");
		if(newTitle.equals(oldTitle)){
			System.out.println("równe tytu³y");
			String lineSong = makeSongLine();
			for(int i = 0; i<Baza.groups.size(); i++){
				if(Baza.isSongOnGroup(Baza.groups.get(i).getName(),oldTitle)){
					Baza.removeSongLine(Baza.groups.get(i).getName(), oldTitle);
					Baza.addSongLine(Baza.groups.get(i).getName(), lineSong);
				}
			}
			Baza.removeSongText(oldTitle);
			List<String> tekst = new ArrayList<String>();
			tekst.add(newTitle);
			tekst.add(info);
			tekst.add(panelToolEdit.getCapo()+"p");
			tekst.add("");
			tekst.addAll(panelTextEdit.getTextFromEdit());
			
			
			Baza.writeSongText(tekst, newTitle);
			Baza.saveBase();
			Groups.setGroup(Groups.grupa);
//			TextViewer.clickTitle(newTitle);
//			Index.setMarkTitle(newTitle);
			Index.virtualClickTitle(newTitle);
			clickCancel();
		}else{
			//czy jest wbazie taki tytul?
			System.out.println("ró¿ne tytu³y");
		}
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
	public static void clickSaveAs(){
		
	}
	
	public static void clickCancel(){
		TextViewer.showViewer();
		Groups.show();
		Index.show();
		Editor.hide();
		Tools.show();
	}
	
	public static void setTextToEdit(String[] text){
		StringBuilder sb= new StringBuilder();
		for(int i = 4; i < text.length; i++){
			sb.append(text[i]);
			sb.append('\n');
		}
		panelTextEdit.textArea.setText(sb.toString());
		panelTextEdit.textArea.setCaretPosition(0);
		
		oldTitle = text[0].trim();
		newTitle = oldTitle;
		
		panelToolEdit.setTitle(text[0]);
		panelToolEdit.setInfo(text[1]);
		panelToolEdit.setLine1(TextViewer.songInfo.getLine1());
		panelToolEdit.setLine2(TextViewer.songInfo.getLine2());
		panelToolEdit.setCapo(TextViewer.songText.getCapo());
		
		//panelToolEdit.b_save.setEnabled(true);
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
