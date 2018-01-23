package piosenki;

import view.ViewController;

public class LogicSong {
	private ViewController vc;
	
	public LogicSong(ViewController vc){
		this.vc = vc;
	}
	public void clickCapoUp(){
		Dane.currentText.capoUp();
		vc.setCapoValue(Integer.parseInt(Dane.currentText.getCapo()));
		vc.setText(Dane.currentText.getText());
		
		
	
		
	}
	public void clickCapoDown(){
		Dane.currentText.capoDown();
		vc.setCapoValue(Integer.parseInt(Dane.currentText.getCapo()));
		vc.setText(Dane.currentText.getText());
	}
	
	public void clickToneUp(){
		Dane.currentText.transposeUp();
		vc.setText(Dane.currentText.getText());
	}
	
	public void clickToneDown(){
		Dane.currentText.transposeDown();
		vc.setText(Dane.currentText.getText());
	}
	
	public  void clickUndo(){
		Dane.currentText.restore();
		vc.setCapoValue(Integer.parseInt(Dane.currentText.getCapo()));
		vc.setText(Dane.currentText.getText());
	}
}
