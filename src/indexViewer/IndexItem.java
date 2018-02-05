package indexViewer;

public class IndexItem {

	private String text;
	private int start, end;
	
	public IndexItem(String text, int start, int end){
		this.text = text;
		this.start = start;
		this.end = end;
	}

	public String getText() {
		return text;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
	
}
