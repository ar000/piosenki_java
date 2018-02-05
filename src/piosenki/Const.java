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
	
	public static final String TIP_HIDE = "<html>Piosenka nie b�dzie widziana w g��wnej bazie,<br>"
										+ "b�dzie dost�pna wy��cznie<br>"
										+ "w specjalnej grupie \""+Const.HIDE+"\"</html>";
	public static final String TIP_UNHIDE = "<html>Piosenka zostanie przywr�cona,<br>"
											+ "z grupiy \""+Const.HIDE+"\"<br>"
											+ "do g��wnej bazy i do grupy \""+Const.NEWEST+"\"</html>";
	public static final String TIP_CAPOUP = "kapodaster o 1 pr�g wy�ej";
	public static final String TIP_CAPODOWN = "kapodaster o 1 pr�g ni�ej";	
	public static final String TIP_TONEUP = "tonacja o p� tonu wy�ej";
	public static final String TIP_TONEDOWN = "tonacja o p� tonu ni�ej";
	public static final String TIP_UNDO = "przywr�� oryginaln� tonacj�";
	public static final String TIP_SONGMENU = "akcje dla aktualnej piosenki";
	public static final String TIP_EDITSONG = "edytuj aktualn� piosenk�";
	public static final String TIP_DELETESONG = "usu� aktualn� piosenk� z bazy";
	public static final String TIP_EDITGROUP = "zmieniaj uk�ad grup piosenek";
	public static final String TIP_GROUPS = "wybierz inn� grup� piosenek";
	public static final String TIP_GROUPNAME = "<html>nazwa aktualnie wy�wietlanej<br>grupy piosenek</html>";
	public static final String TIP_GROUPEXPORT = "eksportuj piosenki z bie��cej grupy do pliku (np. w celu udost�pnienia)";
	
	public static final String SEARCHINFO = "Wpisz wyszukiwany tekst. Bez polskich liter.";
	
	public static final String STARTINFO = "Program do obs�ugi bazy piosenek \n"
			+ "z udogodnieniami do zmiany tonacji \n\n"
			+ "Wymy�li� o wykona�: Adam Ruci�ski.\n\n\n\n"
			+ "kliknij tytu� na li�cie z prawej strony...";
	
	public static final String EDITINFO = "<html>Zaznacz tekst w lewym oknie i kliknij odpowiedni przycisk.<br>"
			+ "lub wpisz tekst w pole edycji</html>";

	public static final String EDITHELP = "<html>Tekst, kt�ry ma by� wy�wietlany w g��wnym oknie,<br>"
			+ "powinien zaczyna� si� od trzeciej linijki.<br>Dwie pierwsze mog� zawiera� cokolwiek,<br>"
			+"b�d� ignorowane.<br><br>"
			+"F1 - wstawia pionow� kresk�<br> &emsp&emsp - doda� przed akordami w ka�dej linii<br><br>"
			+"np. &emsp linijka tekstu &emsp&emsp&emsp&emsp |A C d7</html>"; 
	
//	public static final int WINDOW_WIDTH = 700;
//	public static final Dimension PANEL_LEFT_DIM = new Dimension(550,725);
//	public static final Dimension PANEL_RIGHT_DIM = new Dimension(700,725);
	
	
	
}
