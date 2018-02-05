package piosenki;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import baseFile.Baza;
import song.SongInfo;
import textViewer.TextViewer;
import view.ViewController;

public class LogicDrop {

	private  ViewController vc;
	private  String path;
	private  Logic L;
	private String shareName;
	private List<String> songEx;
	private List<String> songOk;
	private List<String> songAll;
	
	public LogicDrop(Logic lo, ViewController vc){
		this.vc = vc;
		L = lo;
	}
	public  void drop(String pathf){
		//String path = Dane.pathNoweFolder;
		path = pathf;
		
		String ext = path.substring(path.length()-4);
		if(ext.equalsIgnoreCase(".txt")){
			dropText();
		}else{
			ext = path.substring(path.length()-3);
			if(ext.equalsIgnoreCase(Const.EXTNEW))
				dropBase();
		}
	}
	public void clickSavePackage(){
		savePackage();
		L.postkSavePackage();
		
	}
	public void clickGroupFromPackage(){
		String newName = shareName;
		
		while(Baza.isGroupName(newName)){
			newName = JOptionPane.showInputDialog("Grupa \""+newName+"\" istnieje, wpisz now¹ nazwê: ");
        	if(newName==null){
        		newName = "";
        		break;
        	}
		}
		if(newName.length() > 0){
			Baza.addGroup(newName);
			
			//tutaj tworzenie grupy i dodanie piosenek
			//do bazy z udostêpnionego pliku
			//kiedyœ mo¿e... 
			//na razie przycisk w panelPackage ukryty
			
			
			createSukcessPanel(newName);
			
			
		}
		
		
	}
	private void createSukcessPanel(String name){
		String[] opcje = { "FAJNIE"};
			JOptionPane.showOptionDialog(
			           null, // okno
			           "Utworzono grupê: \""+name+"\"" , // komunikat
			           "Sukces", // tytu³
			           JOptionPane.DEFAULT_OPTION, // rodzaj przycisków u do³u (tu niewa¿ny)
			           JOptionPane.QUESTION_MESSAGE,// typ komunikatu (standardowa ikona)
			           null, // w³asna ikona (tu: brak)
			           opcje, // w³asne opcje - przyciski
			           opcje[0]); // domyœlny przycisk
	}
	public void savePackage(){
		String lineIndex = "";
		String[] sp;
		String title = "";
		
		List<String> text = new ArrayList<String>();
		for(int row = 0; row < Dane.tabelaPackage.getRowCount(); row++){
			if((boolean) Dane.tabelaPackage.getValueAt(row, 1)){
				title = (String) Dane.tabelaPackage.getValueAt(row, 0);
				for(int i = 0; i < Dane.newBaseFile.size(); i++){
					sp = Dane.newBaseFile.get(i).split("/");
					if(sp[Const.TITLE_POS].equals(title)){
						lineIndex = Dane.newBaseFile.get(i);
						text = getTextFromPackage(title);
						
//						if(!Baza.isSongOnGroup(shareName, title))
//							Baza.addSongLine(shareName, lineIndex);
						Baza.addSongLine(Const.ALL, lineIndex);
						Baza.addSongLine(Const.NEWEST, lineIndex);
						Baza.writeSongText(text, title);
						
						break;
					}
				}
//				if(!Baza.isSongOnGroup(shareName, title))
//					Baza.addSongLine(shareName, lineIndex);
//				Baza.addSongLine(Const.ALL, lineIndex);
//				Baza.addSongLine(Const.NEWEST, lineIndex);
//				Baza.writeSongText(text, title);
				//L.exportToBase("Nowe", title, lineIndex);
				
			}
				
		}	
	}
	
	private List<String> getTextFromPackage(String title){
		List<String> text = new ArrayList<String>();
		String n = "<"+title;
		int a1 = Dane.newBaseFile.indexOf(n);
		n = title+">";
		int a2 = Dane.newBaseFile.indexOf(n);
		for(int d = a1+1; d<a2; d++){
			text.add(Dane.newBaseFile.get(d));
		}
		
		
		return text;
	}
	
	private  void dropBase(){
		vc.enableAddPackage(false);
		int r = path.lastIndexOf("\\");
//		String shareName = path.substring(r+1,(path.length()-Const.EXTNEW.length()));
		shareName = path.substring(r+1,(path.length()-Const.EXTNEW.length()));
		Dane.newBaseFile = Plik.readFile(path);
		songEx = new ArrayList<String>();
		songOk = new ArrayList<String>();
		songAll = new ArrayList<String>();
		List<String> stat = new ArrayList<String>();
		int stop = Dane.newBaseFile.indexOf("<<<>>>");
		Dane.tabelaPackage.setRowCount(0);
		for(int i = 0; i < stop; i++){
			String[] p = Dane.newBaseFile.get(i).split("/");
			songAll.add(Dane.newBaseFile.get(i));
			if(Baza.isSongOnGroup(Const.ALL, p[0])){
				songEx.add(p[0]);
			}else{
				songOk.add(p[0]);
				Dane.tabelaPackage.addRow(new Object[]{p[0],Boolean.TRUE});
			}					
		}
		if(songOk.size() > 0)
			vc.enableAddPackage(true);
		stat.add("Piosenek w paczce: "+String.valueOf(stop));
		stat.add("");
		stat.add("===========================================");
		stat.add("Nowych do dodania: "+ String.valueOf(songOk.size()));
		stat.add("++");
		stat.addAll(songOk);
		stat.add("++");
		stat.add("===========================================");
		stat.add("Pominiêtych bo ju¿ s¹ w œpiewniku: " + String.valueOf(songEx.size()));
		stat.add("--");
		stat.addAll(songEx);
		stat.add("--");
		stat.add("===========================================");
		
		String[] titles;
		titles = new String[stat.size()];
		int a = 0;
		for(String d : stat){
			titles[a++] = d;
		}
		
		TextViewer.setText(titles);  //vc.setText(titles);
		
		
	//	vc.showPanels(ViewController.PANELS.ADD);
	//	vc.setWindowTitle("Dodawanie piosenek z zestawu:  \"" + shareName + "\"");
	}
	
	private  void dropText(){
		List<String>textLines = Plik.readFile(path);
		//StringBuilder sb = new StringBuilder();
		String[] t = new String[textLines.size()];
		for(int tx = 0; tx < textLines.size(); tx++){
			t[tx] = textLines.get(tx);
			//sb.append(textLines.get(tx));
			//sb.append('\n');
		}
		TextViewer.setText(t);   //vc.setTextString(sb.toString());
		
	//	vc.setWindowTitle("Dodawanie z pliku: "+path);
		Dane.editTitle = "";
		Dane.editOrygTitle = "";
		Dane.editAuthor = "";
		Dane.editLine1 = "";
		Dane.editLine2 = "";
		Dane.editCapo = "0";
		vc.postAddTextFile();
		vc.saveAsEnabled(false);
		SongInfo si = new SongInfo();
		si.setTitle("");
		si.setAuthor("");
		si.setLine1("");
		si.setLine2("");
		si.setCapo(0);
		Dane.isAdd = true;
		Dane.isEdit = false;
		L.newSongToEdit(si);
	}
}
