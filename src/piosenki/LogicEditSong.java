package piosenki;

import baseFile.Baza;
import song.SongInfo;
import view.ViewController;

public class LogicEditSong {
	private Logic L;
	private ViewController vc;
	public LogicEditSong( Logic L, ViewController vc){
		
		this.L = L;
		this.vc = vc;
		
	}
	public void edit(SongInfo song){
		Dane.editOrygTitle = song.getTitle();
		Dane.editTitle = song.getTitle();
		Dane.editAuthor = song.getAuthor();
		Dane.editLine1 = song.getLine1();
		Dane.editLine2 = song.getLine2();
		Dane.editCapo = String.valueOf(Dane.editCapo);
		
		vc.setCapoValue(Integer.valueOf(Dane.editCapo));
		vc.showPanels(ViewController.PANELS.EDIT);
		vc.setButtonSaveText("Zamieñ na t¹ wersjê");
		if(Dane.isAdd) vc.setButtonSaveText("Dodaj piosenkê do bazy");
		vc.saveAsEnabled(false);
		if(Dane.isEdit){
			vc.textToEdit();
		}
		//vc.setEditClassToEditPanel(this);
	}
	public void clickSaveAs(){
		if((Baza.isSongOnGroup(Const.ALL, Dane.editTitle)||Baza.isSongOnGroup(Const.HIDE, Dane.editTitle))){
			vc.setSaveInfo("ZMIEÑ TYTU£!!!  taki ju¿ istnieje !");
		}else{
			String songLine = Dane.editTitle+"/"+Dane.editAuthor+"/"
							+Dane.editLine1+"/"+Dane.editLine2+"/"+Dane.editCapo;
			Baza.addSong(vc.getTextFromEdit(), Dane.editTitle, songLine);
			Baza.addSongLine(Const.NEWEST, songLine);
			if(Dane.isEdit){
				Dane.isEdit = false;
			}else if(Dane.isAdd){
				//L.exportToBase("Nowe",Dane.editTitle, songLine );
				Dane.isAdd = false;
			}
			L.postEditSong(Dane.editTitle);
		}
	}
	
	public void clickSavePostEdit(){
		if(Dane.isEdit){
			if((!Dane.editTitle.equals(Dane.editOrygTitle)) && Baza.isSongOnGroup(Const.ALL, Dane.editTitle)||
					Baza.isSongOnGroup(Const.HIDE, Dane.editTitle)){
				vc.setSaveInfo("ZMIEÑ TYTU£!!!  taki ju¿ istnieje !");
			}else{
				String songLine = Dane.editTitle+"/"+Dane.editAuthor+"/"+Dane.editLine1+"/"+Dane.editLine2+"/"+Dane.editCapo;
				for(int i = 0; i<Baza.groups.size(); i++){
					if(Baza.isSongOnGroup(Baza.groups.get(i).getName(),Dane.editOrygTitle)){
						Baza.removeSongLine(Baza.groups.get(i).getName(), Dane.editOrygTitle);
						Baza.addSongLine(Baza.groups.get(i).getName(), songLine);
					}
				}
				Baza.removeSongText(Dane.editOrygTitle);
				Baza.writeSongText(vc.getTextFromEdit(), Dane.editTitle);
				L.postEditSong(Dane.editTitle);
			}
		}else{
			clickSaveAs();
		}
	}
	public void clickCancel(){
		L.editCancel();
	}
	public void clickTitle(){
		vc.clickTitle();
	}
	public void clickAuthor(){
		vc.clickAuthor();
	}
	public void clickLine1(){
		vc.clickLine1();
	}
	public void clickLine2(){
		vc.clickLine2();
	}
	public void vvvvsetTitle(String title) {
		Dane.editTitle = title;
	}
	public void vvvvsetLine1(String line1) {
		Dane.editLine1 = line1;
	}
	public void vvvvsetLine2(String line2) {
		Dane.editLine2 = line2;
	}
	public void vvvvsetAuthor(String author) {
		Dane.editAuthor = author;
	}
	public void vvvvsetCapo(String capo) {
		Dane.editCapo = capo;
	}
}
