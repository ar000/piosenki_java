package textViewer;

import java.util.List;

import javax.swing.DefaultListModel;

import baseFile.Baza;
import editor.Editor;
import piosenki.Dane;
import song.SongInfo;
import song.SongText;
import tools.Tools;
import view.Okno;
import view.W;

public class TextViewer{
	
	private static PanelText textViewer;
	private static PanelTranspose panelTranspose;
	private static DefaultListModel<LineText> model;
	public static SongText songText;
	public static SongInfo songInfo;
	public static String currentTitle;
	private static Okno okno;
	
	public TextViewer(){
		model = new DefaultListModel<LineText>();
		textViewer = new PanelText(model);
		
		panelTranspose = new PanelTranspose();
		showViewer();
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
		setSong(Dane.songBase.getSongFromTitle(title));
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
		
		okno.setTitle(tyt.toString());
		currentTitle = songText.getTitle();
		Tools.createSongMenu();

		
		setTextEdit();
	}
	
	public static void setTextEdit(){
		String[] t = songText.getTextToEdit();
		setText(t);
	}
	
	public static void setText(String[] t){
		Editor.setTextToEdit(t);
	}
	
	public static void showEditor(){
		panelTranspose.setVisible(false);
		textViewer.setVisible(false);
	}
	public static void showViewer(){
		textViewer.setVisible(true);
		panelTranspose.setVisible(true);
	}
	public static PanelText getPanelText(){
		return textViewer;
	}
	public static PanelTranspose getPanelTool(){
		return panelTranspose;
	}
	public static void setWindow(Okno o){
		okno = o;
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
