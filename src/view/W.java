package view;

import java.awt.Dimension;
import java.awt.Rectangle;


public class W {

	public static boolean colors = false;
	
	public static int windowX, windowY;
	public static Dimension panelLeftDim, panelRightDim, panelEditDim;
	
	public static Rectangle searchPanelRect, searchInfoRect, searchFieldRect, searchButtonClearRect;
	public static Rectangle scrollTitlesRect, scrollWordsRect, panelIndexRect;
	public static Rectangle buttonGroupsRect, labelGroupNameRect;
	
	
	public W(){
		windowX = 100;
		windowY = 10;
		
		panelLeftDim = new Dimension(580, 725);
		panelRightDim = new Dimension(520, 725);
		panelEditDim = new Dimension(352+45,725);
		
		searchPanelRect = new Rectangle(0, 0, 600, 40);
		searchInfoRect = new Rectangle(5, 0, 340, 20);
		searchFieldRect = new Rectangle(3, 18, 250, 20);
		searchButtonClearRect = new Rectangle(260, 18, 70, 20);
		scrollTitlesRect = new Rectangle(0, 40, 260, 660);
		scrollWordsRect = new Rectangle(260, 40, 260, 660);
		panelIndexRect = new Rectangle(0, 25, 600, 698);
		buttonGroupsRect = new Rectangle(10, 2, 88, 20);
		labelGroupNameRect = new Rectangle(105,2,290,20);
		
		
	}
}
