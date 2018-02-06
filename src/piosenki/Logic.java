package piosenki;

import javax.swing.ToolTipManager;

import baseFile.Baza;
import editor.Editor;
import groups.Groups;
import indexViewer.Index;
import textViewer.TextViewer;
import tools.Tools;
import view.Okno;
import view.W;

public class Logic {

	private static Okno w;
	
	public Logic(){
		ToolTipManager.sharedInstance().setDismissDelay(30000);
		new Dane();
		new W();
		new Baza(Dane.pathIndex);
		new Current();
		new TextViewer();
		new Index();
		new Groups();
		new Editor();
		new Tools();
		w = new Okno();
	//	TextViewer.setWindow(w);
		
		Current.group = Const.ALL;
		Groups.setGroup(Const.ALL); // tam robi siê "szukaj("") 
		Index.virtualClickTitle(Index.titlesNoHtm.get(0));
		
	}//Logic()
	
	
	public static void setWindowTitle(String title){
		w.setTitle(title);
	}
	
	
}
