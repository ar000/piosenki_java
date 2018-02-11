package piosenki;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import song.SongInfo;

public class Dane {

	public static DefaultTableModel  tabelaPackage, modelEditGroups;
	public static List<String> titlesNewSong;
	public static List<String> editLog;
	public static List<String> newBaseFile;
	public static int maxGroupSize;
	public static int substringIndexForMenu;
	public static String path;
	public static String pathDelete;
	public static String pathIndex;
	//public static SongBase songBase;
	public static SongInfo currentSong;
	
	
//	public static boolean isEdit, isAdd;
//	public static String editTitle, editOrygTitle, editAuthor, editLine1, editLine2, editCapo;
	//public static DefaultTableModel tabelaT, tabelaW, tabelaS, tabelaG, tabT, tabW;
	//public static DefaultListModel modelListT, modelListW, modelTextList;
//	public static List<LineText> linesText;;
	//public static List<String> titlesNoHtml;
//	pubic static String helpAdd;
//	public static PopMenu popMenu;
	//public static SongText currentText;
//	public static Font textFont, chordFont;
//	public static Font oxygenFont;
	//public static boolean[] currentSongGroups;
//	public static List<JCheckBoxMenuItem> menuCheck;
	
	@SuppressWarnings("serial")
	public Dane(){
		path = System.getProperty("user.dir");
		pathDelete =  path + "\\"+Const.DELETENAME;
		pathIndex = path + "\\"+Const.BASENAME;
//		menuCheck = new ArrayList<JCheckBoxMenuItem>();
		titlesNewSong = new ArrayList<String>();
		editLog = new ArrayList<String>();
		newBaseFile = new ArrayList<String>();
		
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
		
		
//		InputStream is = this.getClass().getResourceAsStream("/RobotoCondensed-Regular.ttf");
//	    Font ttfBase;
//		try {
//			ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);
//			oxygenFont = ttfBase.deriveFont(Font.PLAIN, 13);
//		} catch (FontFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//		is = this.getClass().getResourceAsStream("/Roboto-Bold.ttf");
//	
//		try {
//			ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);
//			chordFont = ttfBase.deriveFont(Font.PLAIN, 13);
//		} catch (FontFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
