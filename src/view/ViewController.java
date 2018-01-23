package view;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.BadLocationException;
import baseFile.Baza;
import piosenki.Current;
import piosenki.Dane;
import song.SongText;



public class ViewController implements ViewControll {

	public enum PANELS{
		NORMAL, EDIT, ADD, SHARE;
	}
	
	private Okno w;

		
	public ViewController(){

	}
	
	@Override
	public void init(Okno w) {
		this.w = w;
	}
	@Override
	public void setWindowTitle(String title) {
		w.setTitle(title);
	}

	@Override
	public void setCapoValue(int capo) {
		w.p_tool.capo.setText((String.valueOf(capo)));
	}

//	@Override
//	public void xxxsetPanelView(int p) {
//
//	}

	@Override
	public void setButtonSaveText(String t) {
		w.p_edit.b_save.setText(t);
	}

	@Override
	public void setSaveInfo(String t) {
		w.p_edit.l_info.setText(t);
	}

//	@Override
//	public void xxxsetSearchInfo(String t) {
//		//w.setSearchInfo(t);
//	}

	@Override
	public void setTextString(String t) {
		w.p_left.text.setText(t);
	}
	
	@Override
	public void setText(String[] t) {
		w.p_left.text.setText("");
		for(int i = 2; i < t.length; i++){
			w.p_left.text.append(t[i]+'\n');
		}
		w.p_left.text.setCaretPosition(0);
	}
	
	@Override
	public void selectionTableEditGroup() {
		w.editGroups.tabela.clearSelection();
		w.editGroups.tabela.changeSelection(w.editGroups.gIndex, 0, false, false);
	}
	
	@Override
	public void showGroupEdit() {
		//w.showEditGroup();
		w.p_right.setVisible(false);
		w.p_tool.setVisible(false);
		w.editGroups.setVisible(true);
		//w.editGroups.createModel();
		w.editGroups.check();
		
		w.clearText();
		w.pack();
	}
	
	@Override
	public void hideGroupEdit() {
		w.p_right.setVisible(true);
		w.p_tool.setVisible(true);
		w.editGroups.setVisible(false);
		w.pack();
	}
	
	@Override
	public void setInfoSong(SongText t) {
		setWindowTitle(t.getTitle() + "   ... " + t.getAuthor());
		
//		setWindowTitle(t.getTitle() + "      s�owa: " + t.getAuthor()
//					+ "      muzyka: " + t.getComposer()
//					+ "      wykonawca: " + t.getArtist());
		
		
		setCapoValue(Integer.parseInt(t.getCapo()));
	}
	

//	@Override
//	public void setIndexes(Indeksy ind, TAB tab) {
////		switch(tab){
////		case TITLE:
//////			w.p_right.setIndexTableSearch(ind.search);
//////			w.p_right.setIndexTableWord(ind.words);
//////		//	w.p_right.setIndexTableGroups(ind.groups);
//////			w.p_right.setIndexTableTitleNotScroll(ind.titles);
////			break;
////		case SEARCH:
//////			w.p_right.setIndexTableTitle(ind.titles);
//////			w.p_right.setIndexTableWord(ind.words);
//////		//	w.p_right.setIndexTableGroups(ind.groups);
////			break;
////		case WORDS:
//////			w.p_right.setIndexTableTitle(ind.titles);
//////			w.p_right.setIndexTableSearch(ind.search);
//////		//	w.p_right.setIndexTableGroups(ind.groups);
////			break;
////		case GROUP:
//////			w.p_right.setIndexTableTitle(ind.titles);
//////			w.p_right.setIndexTableSearch(ind.search);
//////			w.p_right.setIndexTableWord(ind.words);
////			break;
////		}
//	}	
	@Override
	public void setGroupName(String name) {
		w.p_right.groupName.setText(name);
	}
	
	@Override
	public void showShareButton(boolean state) {
		w.p_tool.share.setVisible(state);
	}
	
	@Override
	public void clearSearchField() {
		w.p_right.clearSearchField();
	}
	
	@Override
	public void saveAsEnabled(boolean state) {
		w.p_edit.b_saveAs.setEnabled(state);
	}
	

	@Override
	public void postAddTextFile() {
		w.p_edit.l_title.setText(Dane.editTitle);
		w.p_edit.l_author.setText(Dane.editAuthor);
		w.p_edit.l_words1.setText(Dane.editLine1);
		w.p_edit.l_words2.setText(Dane.editLine2);
		w.p_edit.l_capo.setText(Dane.editCapo);
		w.p_edit.u_title.setVisible(true);
		w.p_edit.u_word1.setVisible(true);
		w.p_edit.u_word2.setVisible(true);
		
		setScreenEdit();
		w.p_edit.b_saveAs.setEnabled(false);
	}
	
	@Override
	public void setScreenEdit() {
		w.p_right.setVisible(false);
		w.p_tool.setVisible(false);
		w.p_edit.setVisible(true);
		w.p_left.setEdit(true);
		w.p_package.setVisible(false);
		//w.addShare.setVisible(false);
		w.pack();
	}

	@Override
	public void setScreenNormal() {
		w.p_right.setVisible(true);
		w.p_tool.setVisible(true);
		w.p_edit.setVisible(false);
		w.p_left.setEdit(false);
		w.p_package.setVisible(false);
		//w.addShare.setVisible(false);
		w.pack();
	}

	@Override
	public void setScreenShare() {
		w.p_right.setVisible(false);
		w.p_tool.setVisible(false);
		w.p_edit.setVisible(false);
		w.p_left.setEdit(true);
		w.p_package.setVisible(false);
		//w.addShare.setVisible(true);
		w.pack();
		
	}

	@Override
	public void setScreenAdd() {
		w.p_right.setVisible(false);
		w.p_tool.setVisible(false);
		w.p_edit.setVisible(false);
		w.p_left.setEdit(true);
		w.p_package.setVisible(true);
		//w.addShare.setVisible(false);
		w.pack();
	}

	@Override
	public void showPanels(PANELS p) {
		switch(p){
		case NORMAL:
			setScreenNormal();
			break;
		case EDIT:
			setScreenEdit();
			break;
		case ADD:
			setScreenAdd();
			break;
		case SHARE:
			setScreenShare();
			break;
		}
	}	

//	@Override
//	public void selectTab(TAB tab) {
//		switch (tab){
//		case TITLE:
//		//	w.p_right.tab.setSelectedIndex(0);
//			break;
//		case SEARCH:
//		//	w.p_right.tab.setSelectedIndex(2);
//			break;
//		case WORDS:
//		//	w.p_right.tab.setSelectedIndex(1);
//			break;
//		case GROUP:
//		//	w.p_right.tab.setSelectedIndex(3);
//			break;
//		}
//	}


	@Override
	public void textToEdit() {
		w.p_edit.l_title.setText(Dane.editTitle);
		w.p_edit.l_author.setText(Dane.editAuthor);
		w.p_edit.l_words1.setText(Dane.editLine1);
		w.p_edit.l_words2.setText(Dane.editLine2);
		w.p_edit.l_capo.setText(Dane.editCapo);
		
		w.p_edit.u_title.setVisible(false);
		w.p_edit.u_word1.setVisible(false);
		w.p_edit.u_word2.setVisible(false);
		
		
		List<String> ten = new ArrayList<String>();
		ten = Baza.getSongText(Dane.currentSong.getTitle());
		
		String ta = ten.get(0)+'\n'+ten.get(1)+'\n'+w.p_left.text.getText();
		w.p_left.text.setText(ta);
		w.p_left.text.setCaretPosition(0);
		
		int linie = Dane.currentText.getSeparatorPosTable().length;
		int startLine = 0;
		for(int t = 0; t < linie; t++){
			if(Dane.currentText.getSeparatorPosTable()[t] > -1){
				try {
					startLine = w.p_left.text.getLineStartOffset(t);
					w.p_left.text.insert("|", startLine + Dane.currentText.getSeparatorPosTable()[t]);
				} catch (BadLocationException e) {}
			}
		}
		w.p_edit.b_save.setEnabled(true);
	}
	
	@Override
	public List<String> getTextFromEdit() {
		List<String> e = new ArrayList<String>();
		String[] ww = w.p_left.text.getText().split("\n");
		for(String g : ww){
			e.add(g);
		}
		return e;
	}
	@Override
	public void setAddGroupEnabled(boolean s) {
		 w.editGroups.dodaj.setEnabled(s);
	}
	@Override
	public void setNameGroupAlert(boolean b) {
		w.editGroups.infoNewGroup.setVisible(b);
	}

		
	
	//////////////////////////////////////////////////
	
	
	@Override
	public void dropTextFile(String path) {
		//L.dropText(path);		
	}

	@Override
	public void dropNewBase(String path) {
		//L.dropNewBase();
		
	}

	@Override
	public void clickTitle() {
		String t = "";
		int r = w.p_left.text.getSelectionEnd() - w.p_left.text.getSelectionStart();
		if(r>0) t = w.p_left.text.getSelectedText().trim();
		w.p_edit.l_title.setText(t);
		w.p_edit.b_save.setEnabled(check());
		
		Dane.editTitle = t;
		setSaveInfo("");
		if(Dane.isEdit){
			if(!Dane.editTitle.equals(Dane.editOrygTitle)){
				saveAsEnabled(true);
			}else{
				saveAsEnabled(false);
			}
		}		
	}
	private boolean check(){
		if(w.p_edit.l_title.getText().length()>0)
			w.p_edit.u_title.setVisible(false);
		else
			w.p_edit.u_title.setVisible(true);
		if(w.p_edit.l_words1.getText().length()>0)
			w.p_edit.u_word1.setVisible(false);
		else
			w.p_edit.u_word1.setVisible(true);
		if(w.p_edit.l_words2.getText().length()>0)
			w.p_edit.u_word2.setVisible(false);
		else
			w.p_edit.u_word2.setVisible(true);
		
		if(w.p_edit.l_title.getText().length()>0 && w.p_edit.l_words1.getText().length()>0
				&& w.p_edit.l_words2.getText().length()>0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void clickAuthor() {
		String t = "";
		int r = w.p_left.text.getSelectionEnd() - w.p_left.text.getSelectionStart();
		if(r>0) t = w.p_left.text.getSelectedText().trim();
		w.p_edit.l_author.setText(t);
		Dane.editAuthor = t;
	}

	@Override
	public void clickLine1() {
		String t = "";
		int r = w.p_left.text.getSelectionEnd() - w.p_left.text.getSelectionStart();
		if(r>0) t = w.p_left.text.getSelectedText().trim();
		w.p_edit.l_words1.setText(t);
		w.p_edit.b_save.setEnabled(check());
		Dane.editLine1 = t;
	}

	@Override
	public void clickLine2() {
		String t = "";
		int r = w.p_left.text.getSelectionEnd() - w.p_left.text.getSelectionStart();
		if(r>0) t = w.p_left.text.getSelectedText().trim();
		w.p_edit.l_words2.setText(t);
		w.p_edit.b_save.setEnabled(check());
		Dane.editLine2 = t;
	}

	@Override
	public void enableAddPackage(boolean state) {
		w.p_package.dodaj.setEnabled(state);
	}

	@Override
	public void showTools(boolean state) {
		w.p_tool.p_tools.setVisible(state);
	}

	@Override
	public void setTextSize(int size) {
		Font ff = w.p_left.text.getFont();
		Font ff2 = new Font(ff.getFontName(), ff.getStyle(), ff.getSize()+size);
		w.p_left.text.setFont(ff2);
	}

	

	


















}