package view;

import piosenki.Logic;
import piosenki.LogicDrop;
import piosenki.LogicEditGroups;
import piosenki.LogicEditSong;
import piosenki.LogicSong;

public class ActionsController implements ActionsControll{
	
	private Logic l;
	private LogicDrop ld;
	private LogicEditGroups leg; 
	private LogicEditSong les;
	private LogicSong song;
	
	
	public ActionsController(){
		
	}

	@Override
	public void init(Logic l, LogicDrop ld, LogicEditGroups leg, 
			LogicEditSong les, LogicSong song) {
		this.l = l;
		this.ld = ld;
		this.leg = leg;
		this.les = les;
		this.song = song;
	}

	// DROP =======================================
	@Override
	public void dropFile(String path) {
		ld.drop(path);
	}

	@Override
	public void clickSavePackage() {
		ld.clickSavePackage();
	}

	@Override
	public void clickCancelPackage() {
		l.clickCancelPackage();
	}
	
	@Override
	public void clickGroupFromPackage() {
		ld.clickGroupFromPackage();
	}
	//==============================================
	@Override
	public void clickTitleOnList(int index) {
		l.clickTitleOnList(index);
	}
//	@Override
//	public void clickSearchOnList(int index) {
//		//l.clickSearchOnList(index);
//	}
	@Override
	public void clickWordOnList(int index) {
		l.clickWordOnList(index);
	}

	@Override
	public void clickStartSearch(String text) {
		l.clickStartSearch(text);
	}

	@Override
	public void clickClearSearch() {
		l.clickClearSearch();
	}

	@Override
	public void clickEditGroup() {
		l.clickEditGroup();
	}

//	@Override
//	public void clickTabTitle() {
//		//l.clickTabTitle();
//	}
//
//	@Override
//	public void clickTabWord() {
//		//l.clickTabWord();
//	}
//
//	@Override
//	public void clickTabSearch() {
//		//l.clickTabSearch();
//	}

	@Override
	public void clickCapoUp() {
		song.clickCapoUp();
	}

	@Override
	public void clickCapoDown() {
		song.clickCapoDown();
	}

	@Override
	public void clickToneUp() {
		song.clickToneUp();
	}

	@Override
	public void clickToneDown() {
		song.clickToneDown();
	}

	@Override
	public void clickUndo() {
		song.clickUndo();
	}

	@Override
	public void clickShare() {
		l.clickShare();
	}

	@Override
	public void clickEditTitle() {
		les.clickTitle();
	}

	@Override
	public void clickEditAuthor() {
		les.clickAuthor();
	}

	@Override
	public void clickEditLine1() {
		les.clickLine1();
	}

	@Override
	public void clickEditLine2() {
		les.clickLine2();
	}

	@Override
	public void clickEditSavePostEdit() {
		les.clickSavePostEdit();
	}

	@Override
	public void clickEditSaveAs() {
		les.clickSaveAs();
	}

	@Override
	public void clickEditCancel() {
		les.clickCancel();
	}
//============================================

	@Override
	public void clickEditGroupUp(String name) {
		leg.editGroupUp(name);
	}

	@Override
	public void clickEditGroupDown(String name) {
		leg.editGroupDown(name);
	}

	@Override
	public void clickEditGroupRename(String oldName, String newName) {
		leg.editGroupRename(oldName,newName);
	}

	@Override
	public void clickEditGroupDelete(String name) {
		leg.editGroupDelete(name);
	}

	@Override
	public void clickEditGroupNew(String name) {
		leg.editGroupNew(name);
	}

	@Override
	public void clickEditGroupExit() {
		leg.editGroupExit();
	}



	
	
	
}
