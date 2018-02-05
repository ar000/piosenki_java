package piosenki;

public class Const {

	public static final int ILE_MAX_GRUP = 34;
	public static final int TITLE_POS = 0;
	public static final int AUTHOR_POS = 1;
	public static final int WORD1_POS = 2;
	public static final int WORD2_POS = 3;
	public static final int CAPO_POS = 4;
	public static final String ALL = "WSZYSTKIE";
	public static final String NEWEST = "NAJNOWSZE";
	public static final String HIDE = "UKRYTE";
	public static final String BASENAME = "BazaPiosenek.ar";
	public static final String DELETENAME = "Kosz";
	public static final String EXTBASE = ".ar1";
	public static final String EXTNEW = ".ra";
	
	public static final String TIP_HIDE = "<html>Piosenka nie bêdzie widziana w g³ównej bazie,<br>"
										+ "bêdzie dostêpna wy³¹cznie<br>"
										+ "w specjalnej grupie \""+Const.HIDE+"\"</html>";
	public static final String TIP_UNHIDE = "<html>Piosenka zostanie przywrócona,<br>"
											+ "z grupiy \""+Const.HIDE+"\"<br>"
											+ "do g³ównej bazy i do grupy \""+Const.NEWEST+"\"</html>";
	public static final String TIP_CAPOUP = "kapodaster o 1 próg wy¿ej";
	public static final String TIP_CAPODOWN = "kapodaster o 1 próg ni¿ej";	
	public static final String TIP_TONEUP = "tonacja o pó³ tonu wy¿ej";
	public static final String TIP_TONEDOWN = "tonacja o pó³ tonu ni¿ej";
	public static final String TIP_UNDO = "przywróæ oryginaln¹ tonacjê";
	public static final String TIP_SONGMENU = "akcje dla aktualnej piosenki";
	public static final String TIP_EDITSONG = "edytuj aktualn¹ piosenkê";
	public static final String TIP_DELETESONG = "usuñ aktualn¹ piosenkê z bazy";
	public static final String TIP_EDITGROUP = "zmieniaj uk³ad grup piosenek";
	public static final String TIP_GROUPS = "wybierz inn¹ grupê piosenek";
	public static final String TIP_GROUPNAME = "<html>nazwa aktualnie wyœwietlanej<br>grupy piosenek</html>";
	public static final String TIP_GROUPEXPORT = "eksportuj piosenki z bie¿¹cej grupy do pliku (np. w celu udostêpnienia)";
	
	public static final String SEARCHINFO = "Wpisz wyszukiwany tekst. Bez polskich liter.";
	
	public static final String STARTINFO = "Program do obs³ugi bazy piosenek \n"
			+ "z udogodnieniami do zmiany tonacji \n\n"
			+ "Wymyœli³ o wykona³: Adam Ruciñski.\n\n\n\n"
			+ "kliknij tytu³ na liœcie z prawej strony...";
	
	public static final String EDITINFO = "<html>Zaznacz tekst w lewym oknie i kliknij odpowiedni przycisk.<br>"
			+ "lub wpisz tekst w pole edycji</html>";

	public static final String EDITHELP = "<html>Tekst, który ma byæ wyœwietlany w g³ównym oknie,<br>"
			+ "powinien zaczynaæ siê od trzeciej linijki.<br>Dwie pierwsze mog¹ zawieraæ cokolwiek,<br>"
			+"bêd¹ ignorowane.<br><br>"
			+"F1 - wstawia pionow¹ kreskê<br> &emsp&emsp - dodaæ przed akordami w ka¿dej linii<br><br>"
			+"np. &emsp linijka tekstu &emsp&emsp&emsp&emsp |A C d7</html>"; 
	
//	public static final int WINDOW_WIDTH = 700;
//	public static final Dimension PANEL_LEFT_DIM = new Dimension(550,725);
//	public static final Dimension PANEL_RIGHT_DIM = new Dimension(700,725);
	
	
	
}
