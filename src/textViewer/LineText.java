package textViewer;

public class LineText {
    String text, chords;

    public int getLineWidth() {
        return lineWidth;
    }

    public int getChordWidth() {
        return chordWidth;
    }

    int lineWidth, chordWidth, screenWidth;

    public LineText(String text, String chords, int lineWidth, int chordWidth, int screenWidth){
        this.chords = chords;
        this.text = text;
        this.lineWidth = lineWidth;
        this.chordWidth = chordWidth;
        this.screenWidth = screenWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void setChordWidth(int chordWidth) {
        this.chordWidth = chordWidth;
    }

    public String getText() {
        return text;
    }

    public String getChords() {
        return chords;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
}