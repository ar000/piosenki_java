package baseFile;

import java.util.ArrayList;
import java.util.List;

import piosenki.Const;
import piosenki.Plik;
import piosenki.Stoper;

public class Baza {
	private static String myPath;
	private static final String ENDGROUPS = "<<<TEKSTY>>>";
	public static boolean viewHide;
	public static boolean viewNewest;
	public static List<String> teksty;
	public static List<Group> groups;
	
	public Baza(String path){
		
		myPath = path;
		openBase();
		
	}
	private static void openBase(){
		Stoper s1 = new Stoper();
		s1.Start();
		teksty = new ArrayList<String>();
		groups = new ArrayList<Group>();
		List<String> zPliku = new ArrayList<String>();
		zPliku = Plik.readFile(myPath);
		List<String> grupy = new ArrayList<String>();
		List<String> tempNameGroup = new ArrayList<String>();
		List<String> tempG = new ArrayList<String>();
		
		int u = zPliku.indexOf(ENDGROUPS);
		for(int i = 0; i < u; i++){
			grupy.add(zPliku.get(i));
		}
		for(int i = u+1; i < zPliku.size(); i++){
			teksty.add(zPliku.get(i));
		}
		for(int i = 0; i < grupy.size(); i++){
			if(grupy.get(i).length()>1){
				if(grupy.get(i).substring(0,1).equals("<")){
					tempNameGroup.add(grupy.get(i).substring(1));
				}
			}
				
		}
		for(String r : tempNameGroup){
			String start = "<" + r;
			String stop = r + ">";
			int a1 = grupy.indexOf(start);
			int a2 = grupy.indexOf(stop);
			int ile = a2 - a1 - 1;
			tempG.clear();
			for(int d = a1 + 1; d < a2; d++){
				tempG.add(grupy.get(d));
			}
			groups.add(new Group(r,ile,tempG));
		}
		s1.Stop("Open BAZA");
	}
	public static boolean isSongOnGroup(String name, String title){
		return groupObject(name).isSong(title);
	}
	public static void removeSongLine(String name, String title){
		groupObject(name).removeSong(title);
	}
	public static void hideSong(String title){
		String line = groupObject(Const.ALL).getSongLine(title);
		for(Group g : groups){
			if(g.isSong(title)) g.removeSong(title);
		}
		groupObject(Const.HIDE).addSong(line);
	}
	public static void unhideSong(String title){
		
		Group h = groupObject(Const.HIDE);
		String line = h.getSongLine(title);
		h.removeSong(title);
		
		groupObject(Const.ALL).addSong(line);
		groupObject(Const.NEWEST).addSong(line);
	}
	public static void removeSong(String title){
		int a1 = startSong(title);
		int a2 = endSong(title);
		for(int f = 0; f < a2-a1+1; f++){
			teksty.remove(a1);
		}
		for(Group g : groups){
			if(g.isSong(title)) g.removeSong(title);
		}
	}
	public static void removeSongText(String title){
		int a1 = startSong(title);
		int a2 = endSong(title);
		for(int f = 0; f < a2-a1+1; f++){
			teksty.remove(a1);
		}
	}
	public static void addSong(List<String> tt, String title, String line){
		addSongLine(Const.ALL, line);
		writeSongText(tt, title);
	}

	public static void writeSongText(List<String> text, String title){
		teksty.add("<"+title);
		teksty.addAll(text);
		teksty.add(title+">");
	}
	public static void groupRename(String name, String newName){
		Group g = groupObject(name);
		g.setName(newName);		
	}
	public static void moveGroup(String name, int dir){
		int i = 0;
		Group gr = null;
		for(Group g : groups){
			if(g.getName().equals(name)){
				gr = g;
				break;
			}
			i++;
		}
		groups.remove(i);
		groups.add(i-dir, gr);
	}
	public static void addGroup(String name){
		groups.add(new Group(name, 0, new ArrayList<String>()));
	}
	public static void removeGroup(String name){
		for(int i = 0; i < groups.size(); i++){
			if(groups.get(i).getName().equals(name)){
				groups.remove(i);
				break;
			}
		}
	}
	public static void addSongLine(String name, String line){
		Group t = groupObject(name);
		t.addSong(line);
	}
	
	public static List<String> getSongText(String name){
		List<String> temp = new ArrayList<String>();		
		int a1 = startSong(name);
		int a2 = endSong(name);
		for(int d = a1+1; d<a2; d++){
			temp.add(teksty.get(d));
		}
		return temp;
	}
	public static List<String> getSongListFromGroup(String name){
		Group gr = groupObject(name);
		return gr.getSongs();
	}
	public static boolean isGroupName(String name){
		for(Group ss : groups){
			if(ss.getName().equals(name)) return true;
		}
		return false;
	}
	public static String getFirstSongTitle(String name){
		Group t = groupObject(name);
		return t.getTitleFirstSong();
	}
	public static int getGroupSize(String name){
		int ii = -1;
		for(Group g : groups){
			if(g.getName().equals(name)) 
				ii = g.getSize();
		}
		return ii;
	}
	
	
	public static Group groupObject(String name){
		Group rr = null;
		for(Group gg : groups){
			if(gg.getName().equals(name)){
				rr = gg;
			}
		}
		return rr;
	}
	private static int startSong(String title){
		String n = "<"+title;
		int r = teksty.indexOf(n);
		return r;
	}
	private static int endSong(String title){
		String n = title+">";
		int r = teksty.lastIndexOf(n);
		return r;
	}
	public static void saveBase(){
		List<String> toFile = new ArrayList<String>();
		for(Group gr : groups){
			toFile.add("<" + gr.getName());
			toFile.addAll(gr.getSongs());
			toFile.add(gr.getName() + ">");
		}
		toFile.add(ENDGROUPS);
		toFile.addAll(teksty);
		
		
		Plik.writeFile(toFile, myPath);
		
		
//		pl.addAll(sysGroups);		
//		pl.add(ENDSYSTEMGROUPS);
//		pl.addAll(userGroups);
//		pl.add(ENDUSERGROUPS);
//		pl.addAll(teksty);
//		Plik.writeFile(pl, myPath);
	}
}
