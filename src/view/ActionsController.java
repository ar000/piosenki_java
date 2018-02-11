package view;

import piosenki.LogicDrop;
import piosenki.LogicEditGroups;
import piosenki.LogicOLD;
import zzzzzzz.LogicEditSong;

public class ActionsController{
	
	private LogicOLD l;
	private LogicDrop ld;
	private LogicEditGroups leg; 
	
	
	public ActionsController(){
		
	}

	public void init(LogicOLD l, LogicDrop ld, LogicEditGroups leg, 
			LogicEditSong les) {
		this.l = l;
		this.ld = ld;
		this.leg = leg;
	}

	// DROP =======================================
	public void dropFile(String path) {
		ld.drop(path);
	}

	public void clickSavePackage() {
		ld.clickSavePackage();
	}

	public void clickCancelPackage() {
		l.clickCancelPackage();
	}
	
	public void clickGroupFromPackage() {
		ld.clickGroupFromPackage();
	}
	//==============================================
	public void clickEditGroup() {
		l.clickEditGroup();
	}
	public void clickShare() {
		l.clickShare();
	}
	//============================================

		public void clickEditGroupUp(String name) {
			leg.editGroupUp(name);
		}

		public void clickEditGroupDown(String name) {
			leg.editGroupDown(name);
		}

		public void clickEditGroupRename(String oldName, String newName) {
			leg.editGroupRename(oldName,newName);
		}

		public void clickEditGroupDelete(String name) {
			leg.editGroupDelete(name);
		}

		public void clickEditGroupNew(String name) {
			leg.editGroupNew(name);
		}

		public void clickEditGroupExit() {
			leg.editGroupExit();
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	public void clickTitleOnList(int index) {
//		l.clickTitleOnList(index);
//	}
//	public void clickSearchOnList(int index) {
//		//l.clickSearchOnList(index);
//	}
//	public void clickWordOnList(int index, List<Integer> indexes) {
//		//l.clickWordOnList(index, indexes);
//	}

//	public void clickStartSearch(String text) {
//		//l.clickStartSearch(text);
//	}

//	public void clickClearSearch() {
////		l.clickClearSearch();
//	}

	

//	public void clickTabTitle() {
//		//l.clickTabTitle();
//	}
//
//	public void clickTabWord() {
//		//l.clickTabWord();
//	}
//
//	public void clickTabSearch() {
//		//l.clickTabSearch();
//	}

//	public void xxxxxxxclickCapoUp() {
//	//	song.clickCapoUp();
//	}

//	public void xxxxxxxxclickCapoDown() {
//	//	song.clickCapoDown();
//	}
//
//	public void xxxxxxxxxxxclickToneUp() {
//	//	song.clickToneUp();
//	}
//
//	public void xxxxxxxxxxxxxclickToneDown() {
//	//	song.clickToneDown();
//	}
//
//	public void xxxxxxxxxxxxclickUndo() {
//	//	song.clickUndo();
//	}



//	public void clickEditTitle() {
//	//	les.clickTitle();
//	}
//
//	public void clickEditAuthor() {
//	//	les.clickAuthor();
//	}
//
//	public void clickEditLine1() {
//	//	les.clickLine1();
//	}
//
//	public void clickEditLine2() {
//	//	les.clickLine2();
//	}

//	public void clickEditSavePostEdit() {
//	//	les.clickSavePostEdit();
//	}
//
//	public void clickEditSaveAs() {
//	//	les.clickSaveAs();
//	}
//
//	public void clickEditCancel() {
//	//	les.clickCancel();
//	}




	
	
	
}
