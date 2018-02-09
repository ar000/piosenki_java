package textViewer;

import java.util.List;

import javax.swing.DefaultListModel;

import baseFile.Baza;
import editor.Editor;
import piosenki.Const;
//import editor.Editor;
//import piosenki.Dane;
import piosenki.Logic;
import song.SongInfo;
import song.SongText;
import tools.Tools;
import view.W;

public class TextViewer{
	
	private static PanelText textViewer;
	private static PanelTranspose panelTranspose;
	private static DefaultListModel<LineText> model;
	public static SongText songText;
	public static SongInfo songInfo;
	public static String title;
//	private static Okno okno;
	
	public TextViewer(){
		model = new DefaultListModel<LineText>();
		textViewer = new PanelText(model);
		
		panelTranspose = new PanelTranspose();
		show();
	}
	
	public static void setSong(SongInfo si){
		songInfo = si;
		songText = new SongText(Baza.getSongText(si.getTitle()), si.getTitle(),
				si.getAuthor(), si.getCapo(),W.panelTextViewer.width);
	}
	public static void capoUp(){
		songText.capoUp();
		showText();
	}
	public static void capoDown(){
		songText.capoDown();
		showText();
	}
	public static void toneUp(){
		songText.transposeUp();
		showText();
	}
	public static void toneDown(){
		songText.transposeDown();
		showText();
	}
	public static void restore(){
		songText.restore();
		showText();
	}
	public static void showTitle(String title){
		setSong(Baza.songBase.getSongFromTitle(title));
		showText();
	}
	
	private static void showText(){
		//songText = st;
		List<LineText> linie = songText.getArrayLineText();
		model.clear();
		for(LineText lt : linie){
			model.addElement(lt);
		}
		panelTranspose.capo.setText(songText.getCapo());
		StringBuilder tyt = new StringBuilder();
		tyt.append(songText.getTitle());
		tyt.append("       < ");
		if(!songText.getAuthor().equals(""))
			tyt.append(songText.getAuthor());
		else
			tyt.append("...");
		tyt.append(" >");
		
		//okno.setTitle(tyt.toString());
		Logic.setWindowTitle(tyt.toString());
		
		title = songText.getTitle();
		Tools.createSongMenu();

		
//		Editor.setTextToEdit(songText.getTextToEdit());
	}
	
	public static void dropFile(String path){
		System.out.println("drop: "+path);
		String ext = path.substring(path.length()-4);
		if(ext.equalsIgnoreCase(".txt")){
			Editor.newTextFile(path);
		}else{
			ext = path.substring(path.length()-3);
			if(ext.equalsIgnoreCase(Const.EXTNEW)){
				//dropBase();
			}
		}
	}
	
	
//	private static void setTextEdit(){
//		
//	}
	
//	public static void setText(String[] t){
//		Editor.setTextToEdit(t);
//	}
	
	public static void hide(){
		panelTranspose.setVisible(false);
		textViewer.setVisible(false);
	}
	public static void show(){
		textViewer.setVisible(true);
		panelTranspose.setVisible(true);
	}
	public static PanelText getPanelText(){
		return textViewer;
	}
	public static PanelTranspose getPanelTool(){
		return panelTranspose;
	}
//	public static void setWindow(Okno o){
//	//	okno = o;
//	}
	
	
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
