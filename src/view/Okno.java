package view;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;

import editor.Editor;
import groups.Groups;
import groups.PanelEditGroups;
import indexViewer.Index;
import piosenki.LogicOLD;
import textViewer.TextViewer;
import tools.Tools;


public class Okno  extends JFrame{

	private static final long serialVersionUID = 1L;
//	PanelLeft p_left;
//	PanelTool p_tool;
//	 PanelRight p_right;
//	 PanelEdit p_edit;
	 PanelPackage p_package;
	 PanelEditGroups editGroups;
	//private ViewController vc;
	//private Logic L;
	
	
	public Okno(){
		
//		p_left = new PanelLeft();
//		p_tool = new PanelTool();
	//	p_right = new PanelRight();
//		p_edit = new PanelEdit();
		p_package = new PanelPackage();
		/////////////addShare = new PanelShare(L,vc);
		editGroups = new PanelEditGroups();
		
		
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
		
//		FlowLayout flow = new FlowLayout();
//		flow.setAlignment(FlowLayout.LEFT);
//		flow.setHgap(0);
//		flow.setVgap(0);
		setTitle("***");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(W.windowX,W.windowY);
		setPreferredSize(W.window);
		setLayout(null);
		setBackground(Color.YELLOW);
		
		add(TextViewer.getPanelText());
		add(Editor.getPanelTextEdit());
		add(Groups.getPanelEditGroups());
		add(TextViewer.getPanelTool());
		add(Tools.getPanel());
		add(Groups.getPanel());
		add(Index.getPanel());
		add(Editor.getPanelToolEdit());
		
		
		///////////////////////add(addShare);
		
		
		pack();
		setVisible(true);
	}
	
	public void init(LogicOLD L, ViewController vc, ActionsController ac){
		//this.ac = ac;
		//this.L =  L;
		//this.vc = vc;
		
	//	p_left.init(ac);
	//	p_right.init(ac);
		p_package.init(ac);
	//	p_tool.init(ac);
	//	p_edit.init(ac);
		editGroups.init(ac);
	}
	public void setButtonSaveText(String text){
//		p_edit.b_save.setText(text);
	}
//	public void setIndexTableTitleNotScroll(int ind){
//		//p_right.setIndexTableTitleNotScroll(ind);
//	}
//	public void selectTitleTab(){
//	//	p_right.selectTitleTab();
//	}
//	public void setSearchInfo(String t){
//		//p_right.setSearchInfo(t);
//	}
	
//	public void selectGroupTab(){
//	//	p_right.selectGroupTab();
//	}

	public void clearText(){
		///p_left.text.setText("");
		
	}
	public String getText(){
		//return p_left.text.getText();
		return "nulllll";
	}
	public void setSaveInfo(String info){
	//	p_edit.l_info.setText(info);
	}
}
