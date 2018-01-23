package song;

public class Chord {
	private String[] chords = { "c", "cis", "d", "dis", "e", "f", "fis", "g", "gis", "a", "b", "h" };
	private String rest;
	private int chordIndex;
	private boolean dur;
	private boolean isSlash;
	private int bassNoteIndex;
	
	public Chord(String chord){		//np.    "/D"
		String ch,r;
		bassNoteIndex = -1;
		char p = chord.charAt(0);
		if(p == '/'){
			isSlash = true;
			chord = chord.substring(1);
			p = chord.charAt(0);
		}
		
		if(p > 90){
			dur = false;
		}else{
			chord = chord.substring(0,1).toLowerCase()+chord.substring(1);
			dur = true;
		}
		if(chord.length()>1){
			if(chord.substring(1, 2).equals("i") && chord.substring(2, 3).equals("s")){
				ch = chord.substring(0,3);
				r = chord.substring(3);
			}else{
				ch = chord.substring(0,1);
				r = chord.substring(1);
			}
		}else{
			ch = chord.substring(0,1);
			r = "";
		}
		chordIndex = -1;
		for(int w = 0; w < 12; w++){
			if(ch.equals(chords[w])){
				//isChord = true;
				chordIndex = w;
				rest = r;
				break;
			}
		}
		if(chordIndex == -1){
			rest = ch + r;
		}
		//-------------------------------------------------------------------------NUTA w BASIE
		//boolean isBass = false;
		int bassIndex = rest.indexOf("/");
		if(bassIndex>-1){
			String bassNote = rest.substring(bassIndex+1);
			char f = bassNote.charAt(0);
			if(f < 91){	//jeœli z du¿ej litery
				bassNote = bassNote.substring(0,1).toLowerCase()+bassNote.substring(1);
				bassNoteIndex = -1;
				for(int w = 0; w < 12; w++){
					if(bassNote.equals(chords[w])){
						//isChord = true;
						bassNoteIndex = w;
						//isBass = true;
						break;
					}
				}
			}
			if(bassNoteIndex > -1){
				rest = rest.substring(0, bassIndex+1);
			}
		}
	}
	public void up(){
		if(chordIndex > -1){
			chordIndex ++;
			if(chordIndex > 11) chordIndex = 0;
		}
		if(bassNoteIndex > -1){
			bassNoteIndex ++;
			if(bassNoteIndex > 11) bassNoteIndex = 0;
		}
	}
	public void down(){
		if(chordIndex > -1){
			chordIndex --;
			if(chordIndex < 0) chordIndex = 11;
		}
		if(bassNoteIndex > -1){
			bassNoteIndex --;
			if(bassNoteIndex < 0) bassNoteIndex = 11;
		}
	}
	public String get(){
		String ret = "";
		String bass = "";
		
		if(bassNoteIndex > -1){
			bass = chords[bassNoteIndex];
			bass = bass.substring(0, 1).toUpperCase() + bass.substring(1);
			//rest += bass;
			
	
		}else{
			bass = "";
		}
		
		if(chordIndex > -1){
			if(isSlash) ret = "/";
			ret += chords[chordIndex]+rest+bass+" ";
		}else{
			ret += rest+bass+" ";
		}
		
		
		
		if(isSlash){
			if(dur) ret = ret.substring(0, 1) + ret.substring(1,2).toUpperCase()+ret.substring(2);;
		}else{
			if(dur) ret = ret.substring(0, 1).toUpperCase() + ret.substring(1);
		}
		
		
		
		return ret;
	}
}
