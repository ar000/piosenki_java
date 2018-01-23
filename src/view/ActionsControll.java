package view;

import piosenki.Logic;
import piosenki.LogicDrop;
import piosenki.LogicEditGroups;
import piosenki.LogicEditSong;
import piosenki.LogicSong;

public interface ActionsControll {

	
	public void init(Logic l, LogicDrop ld, LogicEditGroups leg, 
								LogicEditSong les, LogicSong song);
	
	public void dropFile(String path);
	
	
	public void clickSavePackage();
	public void clickCancelPackage();
	public void clickGroupFromPackage();
	
	public void clickTitleOnList(int index);
	public void clickWordOnList(int index);
//	public void clickSearchOnList(int index);
	public void clickStartSearch(String text);
	public void clickClearSearch();
	
	
	public void clickEditGroup();
	
//	public void clickTabTitle();
//	public void clickTabWord();
//	public void clickTabSearch();
	
	public void clickCapoUp();
	public void clickCapoDown();
	public void clickToneUp();
	public void clickToneDown();
	public void clickUndo();
	public void clickShare();
	
	public void clickEditTitle();
	public void clickEditAuthor();
	public void clickEditLine1();
	public void clickEditLine2();
	public void clickEditSavePostEdit();
	public void clickEditSaveAs();
	public void clickEditCancel();
	
	public void clickEditGroupUp(String name);
	public void clickEditGroupDown(String name);
	public void clickEditGroupRename(String oldName, String newName);
	public void clickEditGroupDelete(String name);
	public void clickEditGroupNew(String name);
	public void clickEditGroupExit();
}
