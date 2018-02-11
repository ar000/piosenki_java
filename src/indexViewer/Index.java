package indexViewer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import baseFile.Baza;
import textViewer.TextViewer;

public class Index {

	private static PanelIndex iv;
	private static DefaultListModel<IndexItem> modelWordd, modelTitlee;
	private static List<Integer> indexes = new ArrayList<>();
	public static List<String> titlesNoHtm = new ArrayList<>();
	public static boolean szukam = false;
	public static String firstTitle = "";
	
	public Index(){
		modelWordd = new DefaultListModel<IndexItem>() ;
		modelTitlee = new DefaultListModel<IndexItem>() ;
		iv = new PanelIndex(modelWordd, modelTitlee);	
		
	}
	

	public static void clickTitle(int index){
		
			TextViewer.showTitle(titlesNoHtm.get(index));   //ac.clickTitleOnList(index);
		
	}
	public static void virtualClickTitle(String title){
		
		TextViewer.showTitle(title);  
		setMarkTitle(title);
	}
	public static void clickWord(int index){
		String title = Baza.songBase.getSongFromWord(indexes.get(index)).getTitle();
		iv.setTitleSelection(titlesNoHtm.indexOf(title));
		TextViewer.showTitle(title);
	}
	
	public static void setMarkTitle(String title){
		iv.setTitleSelection(titlesNoHtm.indexOf(title));
	}

	public static PanelIndex getPanel(){
		return iv;
	}
	
	
	public static void show(){
		iv.setVisible(true);
	}
	public static void hide(){
		iv.setVisible(false);
	}
	public static void search(String d){
		modelTitlee.clear();
		modelWordd.clear();
        titlesNoHtm.clear();
        indexes.clear();
        
        int ii;
        String[] f = Baza.songBase.getTitleList();
        String[] w = Baza.songBase.getWordList();
        
		if(d.equals("")){
			for(String title : f){
				modelTitlee.addElement(new IndexItem(title,0,0));
				titlesNoHtm.add(title);
			}
			ii = 0;
			for(String word : w){
                modelWordd.addElement(new IndexItem(word,0,0));
                indexes.add(ii++);
			}
	
		}else{
	        String tt;
	        String ss = d.toLowerCase().trim();
			for(String title : f){
				tt = title.toLowerCase();
				String tt2 = bezPol(tt);
				if(jestSlowo(tt2, ss)){
	                int start = tt2.indexOf(ss);
	                int stop = start+ss.length();
	                modelTitlee.addElement(new IndexItem(title,start,stop));
	                titlesNoHtm.add(title);
				}
			} 
			ii = 0;
			for(String word : w){
	            tt = word.toLowerCase();
	            String tt2 = bezPol(tt);
	            if(jestSlowo(tt2,ss)){
	                int start = tt2.indexOf(ss);
	                int stop = start+ss.length();
	                modelWordd.addElement(new IndexItem(word,start,stop));
	                indexes.add(ii);
	            }
	            ii++;
	        }
		}
		
	}
	
	private static String bezPol(String t){
        StringBuilder sb = new StringBuilder();
        char[] tpol = t.toCharArray();
        for(char c : tpol){
            if(c > 122){
                if(c == '¿') c = 'z';
                else  if(c == 'Ÿ') c = 'z';
                else  if(c == '³') c = 'l';
                else  if(c == 'ñ') c = 'n';
                else  if(c == 'æ') c = 'c';
                else  if(c == '¹') c = 'a';
                else  if(c == 'ê') c = 'e';
                else  if(c == 'œ') c = 's';
                else  if(c == 'ó') c = 'o';
            }
            sb.append(c);
        }
        return sb.toString();
    }
    private static boolean jestSlowo(String t, String s){
        int in = t.indexOf(s);
        if(in >- 1){
            if(in == 0){
                return true;
            }else{
                String sub = t.substring(in-1, in);
                if(sub.equals(" ")){
                    return true;
                }else if(sub.equals("-")){
                    return true;
                }
            }
        }
        return false;
    }
    
   
    
    
    
    
}
