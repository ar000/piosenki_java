package song;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import textViewer.LineText;
import view.W;


public class SongText {
	
    private String title, author;
    private int capo, cCount, tCount;
    private String[] oryginalText;
    private String[] outText;
    private String[] outTextToEdit;
    private String[] linesText;
    private Chord[][] myChords;
    private int linesCount;
    private int[] separatorPos;
    private ArrayList<LineText> arrayLineText;
   // private TextView tv;
    private int screenW;

    public int getMaxWidthChord() {
        return maxWidthChord;
    }

    public int getMaxWidthLine() {
        return maxWidthLine;
    }

    private int maxWidthChord, maxWidthLine;


    public SongText(List<String> linie, String tit, String aut, int cap, int screenW){
     
    	
        this.screenW = screenW;
      //  tv = new TextView(context);
       // tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        
        tCount = 0;
        cCount = 0;
        title = tit;
        author = aut;
        capo = cap ;
        oryginalText = new String[linie.size()];
        outText = new String[linie.size()];
        outTextToEdit = new String[linie.size()];
        for(int w = 0; w < linie.size(); w++){
            oryginalText[w] = linie.get(w);
        }

        linesCount = oryginalText.length;
        linesText = new String[linesCount];
        separatorPos = new int[linesCount];
        myChords = new Chord[linesCount][];


        int c = 0;
        for(String linia : oryginalText){
            int ind = linia.indexOf('|');
            if(ind>-1){
                separatorPos[c] = ind;
                linesText[c] = linia.substring(0,ind);
                String la = linia.substring(ind+1);
                la = la.trim();
                String[] ak = la.split(" ");
                if(la.length() > 0){
                    myChords[c] = new Chord[ak.length];
                    int ii = 0;
                    for(String v : ak){
                        if(v.length()>0) myChords[c][ii] = new Chord(v);
                        else myChords[c][ii] = new Chord(" ");// dorabiam pozostawianie spacji miêdzy akordami//dzia³¹!
                        ii++;
                    }
                }
            }else{
                linesText[c] = linia;
                separatorPos[c] = -1;
            }
            c++;
        }
        makeOut();
    }

    private void makeOut(){
        arrayLineText = new ArrayList<LineText>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbtoedit = new StringBuilder();
        StringBuilder ch;
        String lineTrim;
        String chordLine;
        maxWidthChord = 0;
        maxWidthLine = 0;

        for(int d = 0; d < linesCount; d++){
            sb.append(linesText[d]);
            sbtoedit.append(linesText[d]);
            ch = new StringBuilder();
            if(myChords[d] != null){
                for(int r = 0; r < myChords[d].length; r++){
                    if(myChords[d][r] != null){
                       // sb.append(myChords[d][r].get());
                        ch.append(myChords[d][r].get());
                    }
                }
            }
            chordLine = ch.toString();
            sb.append(chordLine);

            if(chordLine.length()>0){
            	int ilesp = separatorPos[d] - linesText[d].length();
	            for(int t = 0; t < ilesp; t++){
	            	sbtoedit.append(" ");
	            }
	            sbtoedit.append("|");
	            sbtoedit.append(chordLine);
            }
            
            
            if(d>3){

                int w = getTextSize(chordLine, W.chordFont);
       
                if (w > maxWidthChord)
                    maxWidthChord = w;
            }


            int ile = 0;
            for(int u = linesText[d].length()-1; u > 0; u--){
                if(linesText[d].charAt(u) != ' '){
                    break;
                }else{
                    ile++;
                }
            }
            lineTrim = linesText[d].substring(0,linesText[d].length()-ile);
            if(d>3){
              
                int gw = getTextSize(lineTrim, W.textFont);
                if (gw > maxWidthLine)
                    maxWidthLine = gw;
            }


            if(d>3)
                arrayLineText.add(new LineText(lineTrim,chordLine,maxWidthLine,maxWidthChord,screenW));
            
            outText[d] = sb.toString();
            outTextToEdit[d] = sbtoedit.toString();
            sbtoedit.setLength(0);
            sb.setLength(0);
        }

        for(LineText lt : arrayLineText){
            lt.setChordWidth(maxWidthChord);
            lt.setLineWidth(maxWidthLine);
        }

    }

    private int  getTextSize(String t, Font f) {
    	
    	BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g2d = img.createGraphics();
    	g2d.setFont(f);
    	FontMetrics fm = g2d.getFontMetrics();
    	g2d.dispose();
    	
    	return fm.stringWidth(t);
    }

    public int[] getSeparatorPosTable(){
        return separatorPos;
    }

    private void transpose(int direction){
        for(int d = 0; d < linesCount; d++){
            if(myChords[d] != null){
                for(int t = 0; t < myChords[d].length; t++){
                    if(direction > 0) myChords[d][t].up();
                    else myChords[d][t].down();
                }
            }
        }
        makeOut();
    }

    public void transposeDown(){
        transpose(-1);
        tCount -= 1;
    }

    public void transposeUp(){
        transpose(1);
        tCount += 1;
    }
    public void capoDown(){
        if(capo > 0){
            transpose(1);
            capo--;
            cCount -= 1;
        }

    }

    public void capoUp(){
        if(capo < 9){
            transpose(-1);
            capo++;
            cCount += 1;
        }

    }
    public void restore(){
        while(tCount != 0){
            if(tCount > 0) transposeDown();
            else transposeUp();
        }
        while(cCount != 0){
            if(cCount > 0) capoDown();
            else capoUp();
        }

    }
    public ArrayList<LineText> getArrayLineText(){
        return arrayLineText;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getCapo(){
        return String.valueOf(capo);
    }

    public String[] getText(){
        return outText;
    }
    public String[] getTextToEdit(){
        return outTextToEdit;
    }
    public String[] getOrygText(){
        return oryginalText;
    }

}

