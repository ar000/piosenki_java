package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JLabel;

import piosenki.Dane;


public class W {

	public static boolean colors = false;
	public static int windowX, windowY, menuGrupX, menuGrupY, menuSongX, menuSongY;
	public static float fontSize12, fontSize14, fontSize36, fontSize16, fontSize18, fontSize20;
	
	public static Dimension panelLeftDim, panelRightDim, panelEditDim, panelToolsDim,
							panelCapo, labelCapoNapis, labelCapoValue, buutonHalf,
							buttonAll, panelTranspose, labelTonNapis, panelUndo, panelMenu,
							panelShare, panelEditGroup, panelPackage, scrollTebleEditGroups,
							labelZaznaczGrupe, panelButtonsEditGroup, labelIndexCell;
	
	public static Rectangle searchPanelRect, searchInfoRect, searchFieldRect, 
							searchButtonClearRect, scrollTitlesRect, scrollWordsRect,
							buttonGroupsRect, labelGroupNameRect,panelIndexRect,
							labelWykonajDlaGrupy, buttonGroupUp, buttonGroupDown,
							buttonGroupRename, buttonGroupDelete, buttonGroupAdd,
							buttonExitEditGroups, labelInfoNewGroup, panelGroupChange;
	
	
	double ww, hh;
	public static Font textFont, chordFont;
	
	public W(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double W = screenSize.getWidth();					//1366x768
		double H = screenSize.getHeight();

		W = 1500;
		H = 900;
		ww = W*0.01;
		hh = H*0.01;
		
		windowX = 60;
		windowY = 0;

		int panelH = 91;
//== PANEL LEWY =====
	panelLeftDim = new Dimension(w(42.45), h(panelH));		// 580x725	


//== PANEL TOOLS =====			
	panelToolsDim = new Dimension(w(3.29), h(panelH));		//45x725
		panelCapo = new Dimension(panelToolsDim.width, h(18.23));
			labelCapoNapis = new Dimension(panelToolsDim.width, h(2.6));
			labelCapoValue = new Dimension(panelToolsDim.width, h(4.55));	//45x35    font 36f
		panelTranspose = new Dimension(panelToolsDim.width, h(13.67));
			labelTonNapis = new Dimension(panelToolsDim.width, h(2.6));
		panelUndo = new Dimension(panelToolsDim.width, h(12.37));
		panelMenu = new Dimension(panelToolsDim.width, h(25.5));//34.5
		panelShare = new Dimension(panelToolsDim.width, h(16));//(8.46*h)
	
//== PENEL EDYCJI GRUP ==				
	panelEditGroup = new Dimension(w(28.55), h(panelH));	
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
	panelRightDim = new Dimension(w(38.06),h(panelH));
		labelIndexCell = new Dimension(w(3.66), h(7.81));
//== PANEL LISTY GRUP ========
	panelGroupChange = new Rectangle(0, 0, panelRightDim.width, h(3.25));
		buttonGroupsRect = new Rectangle(w(0.73), h(0.26), w(6.44), h(2.6));
		labelGroupNameRect = new Rectangle(w(7.68), h(0.26),w(21.23), h(2.6));	
//== PANEL SPISU I SZUKANIA ==========				
	panelIndexRect = new Rectangle(0, panelGroupChange.height, w(43.92), panelRightDim.height-panelGroupChange.height);//h(90.88)
		searchPanelRect = new Rectangle(0, 0, panelIndexRect.width, h(5.2));
			searchInfoRect = new Rectangle(w(0.36), 0, w(24.89), h(2.6));
			searchFieldRect = new Rectangle(w(0.22), h(2.34), w(18.3), h(2.6));
			searchButtonClearRect = new Rectangle(w(19.03), h(2.34), w(5.12), h(2.6));
		scrollTitlesRect = new Rectangle(0, h(5.2), w(19.05), panelIndexRect.height-searchPanelRect.height);//(0, 40, 260, 635)
		scrollWordsRect = new Rectangle(w(19.05), h(5.2), w(19.05), scrollTitlesRect.height);

//==    ===			
		

	panelEditDim = new Dimension(panelRightDim.width+panelToolsDim.width,h(panelH));//(352+45,725)h88
	panelPackage = new Dimension(w(28.55), h(panelH));			
			
	buutonHalf = new Dimension(w(2.56), h(2.6));					
	buttonAll = new Dimension(w(2.56), h(4.55));
			
	menuGrupX = -buttonGroupsRect.x;
	menuGrupY = buttonGroupsRect.height;
	menuSongX = buttonAll.width+w(0.14);
	menuSongY = 0;
			
	fontSize12=(float) h(1.58);//standard 12f
	fontSize14=(float) h(1.82);//14f
	fontSize16=(float) h(2.08);//16f
	fontSize18=(float) h(2.34);//18f
	fontSize20=(float) h(2.6);//20f
	fontSize36=(float) h(5.72);//36f
	JLabel line = new JLabel();
	line.setFont(Dane.oxygenFont);
	line.setFont(line.getFont().deriveFont(fontSize14));
	textFont = line.getFont();
	JLabel ch = new JLabel();
	ch.setFont(Dane.chordFont);
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
