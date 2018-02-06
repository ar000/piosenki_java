package piosenki;

import baseFile.Baza;
import baseFile.Group;
import textViewer.TextViewer;
import view.ViewController;

public class LogicEditGroups {
	ViewController vc;
	LogicOLD L;
	
	public LogicEditGroups(LogicOLD L, ViewController vc){
		this.vc = vc;
		this.L = L;
	}
	
	public void start(){
		createModelEditGroups();
		vc.showGroupEdit();
		Dane.editLog.clear();
		Dane.editLog.add(" ");Dane.editLog.add(" ");
		if(Baza.groups.size() == Const.ILE_MAX_GRUP) vc.setAddGroupEnabled(false);
	}
	
	private void createModelEditGroups(){
		Dane.modelEditGroups.setRowCount(0);
		for(Group g : Baza.groups){
			if(!g.getName().equals(Const.ALL) 
					&& !g.getName().equals(Const.HIDE) 
					&& !g.getName().equals(Const.NEWEST))
				Dane.modelEditGroups.addRow(new Object[]{g.getName(),g.getSize()});
		}
		
	}
	private void refreshEditGroup(){
		createModelEditGroups();
		vc.selectionTableEditGroup();
		
		String[]s = new String[Dane.editLog.size()];
		int i = 0;
		for(String h : Dane.editLog){
			s[i++] = h;
		}
	//	TextViewer.setText(s);  //vc.setText(s);
		if(Baza.groups.size() == Const.ILE_MAX_GRUP) 
			vc.setAddGroupEnabled(false);
		else
			vc.setAddGroupEnabled(true);
			
		
	}
	public void editGroupUp(String name){
		//System.out.println(name);
		Baza.moveGroup(name, 1);
		//createGroupTable();
		Dane.editLog.add("Przesuniêto do góry grupê: \""+name+"\"");
		refreshEditGroup();
	}
	public void editGroupDown(String name){
		//System.out.println(name);
		Baza.moveGroup(name, -1);
		//createGroupTable();
		Dane.editLog.add("Przesuniêto na dó³ grupê: \""+name+"\"");
		refreshEditGroup();
	}
	public void editGroupRename(String old, String newn){
		
		if(Baza.isGroupName(newn)){
			vc.setNameGroupAlert(true);
			Dane.editLog.add("Zana nazwy niemo¿liwa: \""+newn+"\" - ju¿ istnieje.");
		}else{
			Baza.groupRename(old, newn);
			Dane.editLog.add("Zmieniono nazwê: \""+old+"\" na: \""+newn+"\"");
			
		}	
		refreshEditGroup();
	}
	public void editGroupNew(String name){
		if(Baza.isGroupName(name)){
			vc.setNameGroupAlert(true);
			Dane.editLog.add("Utworzenie grupy niemo¿liwe: \""+name+"\" - ju¿ istnieje.");
		}else{
			Baza.addGroup(name);
			Dane.editLog.add("Utworzono now¹ grupê: \""+name+"\"");
		}
		refreshEditGroup();
	}
	public void editGroupDelete(String name){
		Baza.removeGroup(name);
		Dane.editLog.add("Usuniêto pust¹ grupê: \""+name+"\"");
		refreshEditGroup();
	}
	public void editGroupExit(){
		L.endEditGroups();
		
	}
	
}
