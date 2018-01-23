package song;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import piosenki.Const;


public class SongBase {

	
	private SongInfo[] titles;
	private String[] titleList;
	private SongInfo[] words;
	private String[] wordList;
	private SongInfo currentSong;
	
	public SongBase(List<String> indexAll) {
		int size = indexAll.size();
		titles = new SongInfo[size];
		titleList = new String[size];
		words = new SongInfo[size*2];
		wordList = new String[size*2];
		int indW = 0;
		for(int t = 0; t < size; t++){
			String[] temp = indexAll.get(t).split("/");
			int capo = Integer.parseInt(temp[Const.CAPO_POS]);
			String title = temp[Const.TITLE_POS];
			String author = temp[Const.AUTHOR_POS];
			String words1 = temp[Const.WORD1_POS];
			String words2 = temp[Const.WORD2_POS];
			
			titles[t] = new SongInfo();
			titles[t].setCapo(capo);
			titles[t].setTitle(title);
			titles[t].setAuthor(author);
			titles[t].setForCompare(title);
			titles[t].setLine1(words1);
			titles[t].setLine2(words2);
			titleList[t] = title;
			
			words[indW] = new SongInfo();
			words[indW].setCapo(capo);
			words[indW].setTitle(title);
			words[indW].setAuthor(author);
			words[indW].setForCompare(words1);
			words[indW].setLine1(words1);
			words[indW].setLine2(words2);
			wordList[indW] = words1;
			
			words[indW+1] = new SongInfo();
			words[indW+1].setCapo(capo);
			words[indW+1].setTitle(title);
			words[indW+1].setAuthor(author);
			words[indW+1].setForCompare(words2);
			words[indW+1].setLine1(words1);
			words[indW+1].setLine2(words2);
			wordList[indW+1] = words2;
			
			indW += 2;
			
		}
		Arrays.sort(titles, SongInfo.Sort);
	    Arrays.sort(words, SongInfo.Sort);
	    sortuj(titleList);
	    sortuj(wordList);
	    currentSong = getSongFromTitle(0);
	}

	private void sortuj(String[] so){
		Arrays.sort(so, new Comparator<String>() {
	    	 
            @Override
            public int compare(String s1, String s2) {
                Collator c = Collator.getInstance(new Locale("pl", "PL"));
                return c.compare(s1, s2);
            }
 
        });
	}
	public String[] getTitleList(){
		return titleList;
	}
	public String[] getWordList(){
		return wordList;
	}

	public SongInfo getSongFromTitle(String title){
		int index = -1;
		for(SongInfo t : titles){
			index++;
			if(t.getTitle().equals(title)){
				break;
			}
		}
		
		currentSong = titles[index];
		return currentSong;
	}
	public SongInfo getSongFromTitle(int index){
		currentSong = titles[index];
		return currentSong;
	}
	public SongInfo getSongFromWord(int index){
		currentSong = words[index];
		return currentSong;
	}


}
