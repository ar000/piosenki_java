package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;


public class W {

	public static boolean colors = false;
	public static int windowX, windowY, menuGrupX, menuGrupY, menuSongX, menuSongY, indexCellLeftMargin;
	public static float fontSize12, fontSize14, fontSize36, fontSize16, fontSize18, fontSize20;
	
	public static Dimension panelEditDim, panelTranspose,
							panelCapo, labelCapoNapis, labelCapoValue, buutonHalf,
							buttonAll, labelTonNapis, panelUndo, panelMenu,
							panelShare, panelEditGroup, panelPackage, scrollTebleEditGroups,
							labelZaznaczGrupe, panelButtonsEditGroup, labelIndexCell, halfIcon,
							fullIcon, window, scrollView,labelInfoEdit, panelEditField, panelEditFieldCapo,
							panelEditorSeparator, panelEditSave, panelEditHelp, indexCellLastLabel;
	
	public static Rectangle searchPanelRect, searchInfoRect, searchFieldRect, 
							searchButtonClearRect, scrollTitlesRect, scrollWordsRect,
							buttonGroupsRect, labelGroupNameRect,panelIndexRect,
							labelWykonajDlaGrupy, buttonGroupUp, buttonGroupDown,
							buttonGroupRename, buttonGroupDelete, buttonGroupAdd,
							buttonExitEditGroups, labelInfoNewGroup, panelGroupChange,
							panelTools, panelTransposeTool, panelTextViewer, panelEditor,
							panelEditFieldButton, panelEditFieldText,panelEditFieldIcon,
							panelEditFieldCapoPlus, panelEditFieldCapoMinus, panelEditFieldCapoLabel,
							panelEditButtonSave, panelEditButtonSaveAs, panelEditButtonCancel, 
							panelEditLabelInfoSave, panelEditLabelHelp, textEditTitle, textEditInfo, textEditText,
							textEditTitleLabel, textEditInfoLabel;
	
	
	double ww, hh;
	public static Font textFont, chordFont;
	
	public W(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double W = screenSize.getWidth();					//1366x768
		double H = screenSize.getHeight();

//		W = 1648;		//1648 bo nie moze byc szersze niz monitor
//		H = 925;		//925
		ww = W*0.01;
		hh = H*0.01;
		
		windowX = 100;
		windowY = 0;

		
	int height = h(91);
		
	fontSize12=(float) h(1.58);//standard 12f
	fontSize14=(float) h(1.82);//14f
	fontSize16=(float) h(2.08);//16f
	fontSize18=(float) h(2.34);//18f
	fontSize20=(float) h(2.6);//20f
	fontSize36=(float) h(5.72);//36f
	
//== PANEL LEWY =====
	int leftWidth = w(42.45);
	panelTextViewer = new Rectangle(0, 0, leftWidth, height);
		scrollView = new Dimension(panelTextViewer.width, panelTextViewer.height);
//		JLabel lab = new JLabel();
//		lab.setFont(lab.getFont().deriveFont(fontSize12));
		textEditTitleLabel = new Rectangle(0, h(0.3), w(3.2), h(2.6));
		textEditInfoLabel = new Rectangle(0, h(3.1), w(3.2), h(2.6));
		textEditTitle = new Rectangle(w(3.5), h(0.3), w(33.7), h(2.6));
		textEditInfo = new Rectangle(w(3.5), h(3.1), w(33.7), h(2.6));
		
		
		//textEditText = new Rectangle(0, h(5.8), leftWidth, height - h(5.8));
		textEditText = new Rectangle(0, 0, leftWidth, height);
	
//== PANEL TOOLS =====		
	int toolsWidth = w(3.29);
	panelTransposeTool = new Rectangle(leftWidth,0,toolsWidth, h(36));
		panelCapo = new Dimension(toolsWidth, h(18.23));
			labelCapoNapis = new Dimension(toolsWidth, h(2.6));
			labelCapoValue = new Dimension(toolsWidth, h(4.55));	//45x35    font 36f
		panelTranspose = new Dimension(toolsWidth, h(13.67));
			labelTonNapis = new Dimension(toolsWidth, h(2.6));
		panelUndo = new Dimension(toolsWidth, h(4));
		
	
		panelTools = new Rectangle(leftWidth,panelTransposeTool.height+h(9),toolsWidth, h(6));
		
		panelMenu = new Dimension(toolsWidth, h(25.5));//34.5
		panelShare = new Dimension(toolsWidth, h(16));//(8.46*h)
		
//== PENEL EDYCJI GRUP ==				
	panelEditGroup = new Dimension(w(28.55), height);	
		labelZaznaczGrupe = new Dimension(w(25.62),h(3.25));
		scrollTebleEditGroups = new Dimension(w(25.62), h(64.2));
		panelButtonsEditGroup = new Dimension(w(25.62), h(20.53));
		labelWykonajDlaGrupy = new Rectangle(w(0.36),h(0.65), w(21.66), h(3.25));
		buttonGroupDown = new Rectangle(w(9.15),h(4.55), w(8.05), h(3.25));
		buttonGroupUp = new Rectangle(w(0.36),h(4.55), w(8.05), h(3.25));
		buttonGroupRename = new Rectangle(w(0.36),h(9.11), w(8.05), h(3.25));
		buttonGroupDelete = new Rectangle(w(9.15),h(9.11), w(8.05), h(3.25));
		labelInfoNewGroup = new Rectangle(w(0.36),h(13.02), w(21.96), h(3.25));
		buttonGroupAdd = new Rectangle(w(0.36),h(16.27), w(11.71), h(3.25));
		buttonExitEditGroups = new Rectangle(w(17.30),h(16.27), w(7.32), h(3.25));
//== PANEL PRAWY ========
	int rightWidth = w(38.06);

		labelIndexCell = new Dimension(w(3.66), h(7.81));
		
//== PANEL  GRUP ========
	panelGroupChange = new Rectangle(0, 0, rightWidth, h(3.25));
	panelGroupChange = new Rectangle(leftWidth+toolsWidth, 0, rightWidth, h(3.25));
		buttonGroupsRect = new Rectangle(w(0.73), h(0.26), w(6.44), h(2.6));
		labelGroupNameRect = new Rectangle(w(7.68), buttonGroupsRect.y,w(21.23), buttonGroupsRect.height);	
//== PANEL SPISU I SZUKANIA ==========				
	panelIndexRect = new Rectangle(leftWidth+toolsWidth, panelGroupChange.height, 
									rightWidth, height-panelGroupChange.height);//h(90.88)
		searchPanelRect = new Rectangle(0, 0, panelIndexRect.width, h(5.2));
			searchInfoRect = new Rectangle(w(0.36), 0, w(24.89), h(2.6));
			searchFieldRect = new Rectangle(w(0.22), h(2.34), w(18.3), h(2.6));
			searchButtonClearRect = new Rectangle(w(19.03), h(2.34), w(5.12), h(2.6));
		scrollTitlesRect = new Rectangle(0, searchPanelRect.height, rightWidth/2, panelIndexRect.height-searchPanelRect.height);//(0, 40, 260, 635)
		scrollWordsRect = new Rectangle(scrollTitlesRect.width, searchPanelRect.height, rightWidth/2, scrollTitlesRect.height);
		
		JLabel label = new JLabel();
		Font f = label.getFont();
		label.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		label.setFont(label.getFont().deriveFont(fontSize12));
		int wys = (int)(label.getFont().getSize() * 1.6);
		indexCellLastLabel = new Dimension(scrollTitlesRect.width, wys);
		indexCellLeftMargin = w(0.15);  //0.15 = 2 pix

//== PANEL EDYCJI ===			
	panelEditor = new Rectangle(leftWidth+toolsWidth, 0, rightWidth, height);//h(90.88)
		labelInfoEdit = new Dimension(panelEditor.width, h(7.81));
		panelEditField = new Dimension(w(33.7), h(5));
			panelEditFieldButton = new Rectangle(w(0.59), h(0.91), w(7.32), h(3.26));
			panelEditFieldText = new Rectangle(w(8.5), h(1.3), w(22.32), h(2.6));
			panelEditFieldIcon = new Rectangle(w(31.28), h(0.94), w(1.83), h(3.26));
		panelEditFieldCapo = new Dimension(panelEditField.width, h(8.4));	
		panelEditFieldCapoMinus = new Rectangle(w(11.32), h(2.6), w(3.66), h(3.26));
		panelEditFieldCapoLabel = new Rectangle(w(15.71), h(2.6), w(3.66), h(3.26));
		panelEditFieldCapoPlus = new Rectangle(w(17.91), h(2.6), w(3.66), h(3.26));
		panelEditorSeparator = new Dimension(panelEditField.width, h(1.1));
		panelEditSave = new Dimension(panelEditField.width, h(14.37));
			panelEditButtonSave = new Rectangle(w(0.6), h(0.5), w(14), h(3.26));
			panelEditLabelInfoSave = new Rectangle(w(0.59), h(4.96), w(21.96), h(3.26));
			panelEditButtonSaveAs = new Rectangle(w(19.1), h(0.5), w(14), h(3.26));
			panelEditButtonCancel = new Rectangle(w(9.85), h(10.5), w(14), h(3.26));
		panelEditHelp = new Dimension(panelEditField.width, h(35));
		panelEditLabelHelp = new Rectangle(w(0.59), h(1.04), w(32.5), h(33.1));
		
		

	panelEditDim = new Dimension(rightWidth+toolsWidth,height);//(352+45,725)h88
	panelPackage = new Dimension(w(28.55), height);			
			
	buutonHalf = new Dimension(w(2.56), h(2.6));					
	buttonAll = new Dimension(w(2.56), h(4.55));
	halfIcon = new Dimension(w(2.56), h(2.34));
	fullIcon = new Dimension(w(2.56), h(4.56));
			
	menuGrupX = -buttonGroupsRect.x;
	menuGrupY = buttonGroupsRect.height;
	menuSongX = buttonAll.width+w(0.14);
	menuSongY = 0;
			
	window =  new Dimension(leftWidth+toolsWidth+rightWidth+w(0.37),height+h(3.65));
			
	Font f1 = null, f2 = null;
	InputStream is = this.getClass().getResourceAsStream("/RobotoCondensed-Regular.ttf");
    Font ttfBase;
	try {
		ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);
		f1 = ttfBase.deriveFont(Font.PLAIN, 13);
	} catch (FontFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	is = this.getClass().getResourceAsStream("/Roboto-Bold.ttf");

	try {
		ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);
		f2 = ttfBase.deriveFont(Font.PLAIN, 13);
	} catch (FontFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	JLabel line = new JLabel();
	line.setFont(f1);
	line.setFont(line.getFont().deriveFont(fontSize14));
	textFont = line.getFont();
	JLabel ch = new JLabel();
	ch.setFont(f2);
	ch.setFont(ch.getFont().deriveFont(fontSize14));
	chordFont = ch.getFont();
	}
	
	private int w(double x){
		return (int) (x*ww);
	}
	private int h(double y){
		return (int) (y*hh);
	}
}
