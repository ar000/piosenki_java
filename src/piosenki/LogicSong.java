package piosenki;

import textViewer.TextViewer;
import view.ViewController;

public class LogicSong {
	private ViewController vc;
	
	public LogicSong(ViewController vc){
		this.vc = vc;
	}
	public void clickCapoUp(){
		Dane.currentText.capoUp();
		vc.setCapoValue(Integer.parseInt(Dane.currentText.getCapo()));
	//	vc.setText(Dane.currentText.getText());
		TextViewer.setTextRead(Dane.currentText);
		
	
		
	}
	public void clickCapoDown(){
		Dane.currentText.capoDown();
		vc.setCapoValue(Integer.parseInt(Dane.currentText.getCapo()));
	//	vc.setText(Dane.currentText.getText());
		TextViewer.setTextRead(Dane.currentText);
	}
	
	public void clickToneUp(){
		Dane.currentText.transposeUp();
	//	vc.setText(Dane.currentText.getText());
		TextViewer.setTextRead(Dane.currentText);
	}
	
	public void clickToneDown(){
		Dane.currentText.transposeDown();
	//	vc.setText(Dane.currentText.getText());
		TextViewer.setTextRead(Dane.currentText);
	}
	
	public  void clickUndo(){
		Dane.currentText.restore();
		vc.setCapoValue(Integer.parseInt(Dane.currentText.getCapo()));
	//	vc.setText(Dane.currentText.getText());
		TextViewer.setTextRead(Dane.currentText);
	}
}
