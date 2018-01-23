package view;

import java.util.List;

import piosenki.Dane;
import piosenki.Indeksy;
import song.SongText;

public interface ViewControll {

	public void setTextSize(int size);
	//akcje na oknie
	public void setWindowTitle(String title);
	public void setCapoValue(int capo);
	//public void xxxsetPanelView(int p);
	public void setButtonSaveText(String t);
	public void setSaveInfo(String t);
	//public void xxxsetSearchInfo(String t);
	public void setText(String[] t);
	public void setTextString(String t);
	public void selectionTableEditGroup();
	public void showGroupEdit();
	public void hideGroupEdit();
	public void setInfoSong(SongText t);
	public void showShareButton(boolean state);
	//public void setIndexes(Indeksy ind, Dane.TAB tab);
	public void setGroupName(String g);
	public void clearSearchField();
	public void saveAsEnabled(boolean state);
	public void postAddTextFile();
	public void setScreenEdit();
	public void setScreenNormal();
	public void setScreenShare();
	public void setScreenAdd();
	public void showPanels(ViewController.PANELS p);
	//public void selectTab(Dane.TAB tab);
	public void textToEdit();
	public void showTools(boolean state);
	
	public List<String> getTextFromEdit();
	public void setAddGroupEnabled(boolean s);
	public void setNameGroupAlert(boolean b);
	public void init(Okno w);
	public void enableAddPackage(boolean state);
	
	//akcje z okna
	public void dropTextFile(String path);
	public void dropNewBase(String path);
	public void clickTitle();
	public void clickAuthor();
	public void clickLine1();
	public void clickLine2();
}
