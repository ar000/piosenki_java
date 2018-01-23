package song;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;


public class SongInfo implements Comparable<SongInfo> {

	private int  capo;
	private String title, author, forCompare,line1,line2;

	public String getForCompare() {
		return forCompare;
	}
	public void setForCompare(String forCompare) {
		this.forCompare = forCompare;
	}
	public void setTitle(String t){
		title = t;
	}
	public String getTitle(){
		return title;
	}
	public void setAuthor(String t){
		author = t;
	}
	public String getAuthor(){
		return author;
	}
//	
	public void setLine1(String l1){
		line1 = l1;
	}
	public String getLine1(){
		return line1;
	}
	public void setLine2(String l1){
		line2 = l1;
	}
	public String getLine2(){
		return line2;
	}
	
	public void setCapo(int s){
		capo = s;
	}
	public int getCapo(){
		return capo;
	}
	@Override
	public int compareTo(SongInfo o) {
		return 0; 
	}
	
	public static Comparator<SongInfo> Sort 
					= new Comparator<SongInfo>(){
		public int compare(SongInfo p1, SongInfo p2){
			String pn1 = p1.getForCompare().toUpperCase(); 
			String pn2 = p2.getForCompare().toUpperCase();
			
			 Collator c = Collator.getInstance(new Locale("pl", "PL"));
			 return c.compare(pn1, pn2);
			 
			//rosn¹co
		//	//return pn1.compareTo(pn2);
			//malej¹co
			//return pn2.compareTo(pn1);
		}
	};
	/*sortowanie po tytule
	 * 
	 *  	Arrays.sort(songs,Piosenki.SongName);
	 * 
	 * sortowanie po jakims int
	 *
	 * 		Arrays.sort(songs);
	 */ 
	
	
}