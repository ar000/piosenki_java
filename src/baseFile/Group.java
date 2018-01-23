package baseFile;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private String name;
	private int size;
	private List<String> songs;
	
	public Group(String name, int size, List<String> so){
		this.name = name;
		songs = new ArrayList<String>(so);
		this.size = songs.size();
	}
	
	public String getSongLine(String title){
		String ret = "";
		String[] ll;
		for(String p : songs){
			ll = p.split("/");
			if(ll[0].equals(title)){
				ret = p;
			}
		}
		return ret;
	}
	
	public List<String> getSongs(){
		return songs;
	}
	public String getTitleFirstSong(){
		String[] ll = songs.get(0).split("/");
		return ll[0];
	}
	public void addSong(String line){
		songs.add(line);
		size = songs.size();
	}
	public void removeSong(String title){
		String[] ll; 
		int index = -1;
		for(String s : songs){
			index++;
			ll = s.split("/");
			if(ll[0].equals(title)){
				break;
			}
		}
		songs.remove(index);
		size = songs.size();
	}
	
	public boolean isSong(String title){
		boolean iss = false;
		String[] ll;
		for(int i = 0; i < size; i++){
			ll = songs.get(i).split("/");
			if(ll[0].equals(title)) {
				iss = true;
				break;
			}
		}
		return iss;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
