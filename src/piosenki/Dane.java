package piosenki;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.table.DefaultTableModel;

import song.SongBase;
import song.SongInfo;
import song.SongText;
import textViewer.LineText;
import view.PopMenu;

public class Dane {

	public static DefaultTableModel  tabelaPackage, modelEditGroups;
	//public static DefaultTableModel tabelaT, tabelaW, tabelaS, tabelaG, tabT, tabW;
	public static DefaultListModel modelListT, modelListW, modelTextList;
	public static List<LineText> linesText;;
	public static List<String> titlesNoHtml;
	public static List<String> titlesNewSong, editLog, newBaseFile;
	
	public static PopMenu popMenu;
	public static int maxGroupSize;
	public static int substringIndexForMenu;
	
	public static String path;
	public static String pathDelete;
	public static String pathIndex;
	
	public static String editTitle, editOrygTitle, editAuthor, editLine1, editLine2, editCapo;
	public static boolean isEdit, isAdd;
	public static String helpEdit = "<html>Tekst, który ma byæ wyœwietlany w g³ównym oknie,<br>"
			+ "powinien zaczynaæ siê od trzeciej linijki.<br>Dwie pierwsze mog¹ zawieraæ cokolwiek,<br>"
			+"bêd¹ ignorowane.<br><br>"
			+"F1 - wstawia pionow¹ kreskê<br> &emsp&emsp - dodaæ przed akordami w ka¿dej linii<br><br>"
			+"np. &emsp linijka tekstu &emsp&emsp&emsp&emsp |A C d7</html>"; 
	public static String helpAdd;
	
	//public static TAB currentTab;
	public static SongBase songBase;
	public static SongInfo currentSong;
	public static SongText currentText;
	
	public static Font textFont, chordFont;
	public static Font oxygenFont;
	
	//public static String[] groups;
	public static boolean[] currentSongGroups;
	
	public static List<JCheckBoxMenuItem> menuCheck;
	
	@SuppressWarnings("serial")
	public Dane(){
		path = System.getProperty("user.dir");
		pathDelete =  path + "\\"+Const.DELETENAME;
		pathIndex = path + "\\"+Const.BASENAME;
		
		popMenu = new PopMenu();
		
		menuCheck = new ArrayList<JCheckBoxMenuItem>();
		titlesNewSong = new ArrayList<String>();
		editLog = new ArrayList<String>();
		newBaseFile = new ArrayList<String>();
		
		modelListT = new DefaultListModel<String>();
		modelListW = new DefaultListModel<String>();
		modelTextList = new DefaultListModel<LineText>();
		
		titlesNoHtml = new ArrayList<>();
		
		tabelaPackage = new DefaultTableModel(){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return column == 1;
		    }
			public Class<?> getColumnClass(int column){
				switch(column){
				case 0:
					
					return String.class;
				case 1:
					return Boolean.class;
				default: 
					return String.class;
				}
			}
			
		};
		tabelaPackage.addColumn("");
		tabelaPackage.addColumn("");
		
		
		modelEditGroups = new DefaultTableModel(){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       //return false;
		     //Only the third column
		       return column == 1;
		    }
			public Class<?> getColumnClass(int column){
				switch(column){
				case 0:
					
					return String.class;
				case 1:
					return int.class;
				default: 
					return String.class;
				}
			}
			
		};
		modelEditGroups.addColumn("");
		modelEditGroups.addColumn("");
		
		
		InputStream is = this.getClass().getResourceAsStream("/RobotoCondensed-Regular.ttf");
	    Font ttfBase;
		try {
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);
			oxygenFont = ttfBase.deriveFont(Font.PLAIN, 13);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		is = this.getClass().getResourceAsStream("/Roboto-Bold.ttf");
	
		try {
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);
			chordFont = ttfBase.deriveFont(Font.PLAIN, 13);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
