package textViewer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import baseFile.Baza;
import piosenki.Dane;
import song.SongText;
import view.W;

public class TextViewer{
	
	private static PanelTextViewer tv;
	private static DefaultListModel model;
//	private static ActionShowEdit actionShowEdit;
//	private static ActionShowView actionShowView;
	private static SongText songText;
	
	public TextViewer(){
		model = new DefaultListModel<LineText>();
		tv = new PanelTextViewer(model);
		tv.setView();
//		actionShowEdit = new ActionShowEdit();
//		actionShowView = new ActionShowView();
	}
	
	public static void setTextRead(SongText st){
		songText = st;
		List<LineText> linie = songText.getArrayLineText();
		model.clear();
		for(LineText lt : linie){
			model.addElement(lt);
		}
	}
	
	public static void setTextEdit(){
		String[] t = songText.getOrygText();
		setText(t);
	}
	
	public static void setText(String[] t){
		StringBuilder sb= new StringBuilder();
		for(String  l : t){
			sb.append(l);
			sb.append('\n');
		}
		tv.textArea.setText(sb.toString());
		tv.textArea.setCaretPosition(0);
	}
	
	public static void showEditor(){
		System.out.println("TextViewer->showEditor();");
		tv.setEditor();
		setTextEdit();
	}
	public static void showViewer(){
		System.out.println("TextViewer->showView();");
		tv.setView();
	}
	public static PanelTextViewer getPanel(){
		return tv;
	}
	
	
	
	
//	public static ActionShowEdit ActionViewEdit(){
//		return actionShowEdit;
//	}
//	public static ActionShowView ActionViewView(){
//		return actionShowView;
//	}
//	private  class ActionShowEdit implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
////			System.out.println("TextViewer->setEditor();");
////			tv.setEditor();
////			setTextEdit();
//		}	
//	}
//	private  class ActionShowView implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
////			System.out.println("TextViewer->setView();");
////			tv.setView();
//		}	
//	}
}
