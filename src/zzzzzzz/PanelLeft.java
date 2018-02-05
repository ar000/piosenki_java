package zzzzzzz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

//import indexViewer.TableCell;
import piosenki.Const;
import piosenki.Current;
import piosenki.Dane;
import textViewer.TextListCell;
import view.ActionsController;
import view.W;

public class PanelLeft extends JPanel{
	private static final long serialVersionUID = 1L;
	
	/*
	private ActionsController ac;
	public JTextArea text;
	public JList textList;
	private JScrollPane scroll;
	public PanelLeft(){
		setPreferredSize(W.panelLeftDim);
		setBackground(Color.GREEN);
		setLayout(new GridLayout());
		
		
		text = new JTextArea();
		text.setEditable(false);
		text.setBounds(0, 0, 100, 100);
		//text.setFont(new Font("monospaced", Font.PLAIN, 20));//12
		text.setFont(text.getFont().deriveFont(20f));
	    Border border = BorderFactory.createLineBorder(Color.WHITE);
	    text.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(3, 3, 3, 3)));
	    text.addKeyListener(new KeyListener(){
	        @Override
	        public void keyPressed(KeyEvent e){
	        	if(e.getKeyCode() == KeyEvent.VK_F1){
	        		e.consume();
	        		pressF1();
	        	}
	        	if(e.getKeyCode() == KeyEvent.VK_TAB){
	        		e.consume();
	        		pressTab();
	        	}
	        }

	        @Override
	        public void keyTyped(KeyEvent e) {
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
	        }
	    });
	    
	    new DropTarget(text, new DropTargetListener(){
	    	
			@Override
			public void dragEnter(DropTargetDragEvent arg0) {
			}
			@Override
			public void dragExit(DropTargetEvent arg0) {
			}
			@Override
			public void dragOver(DropTargetDragEvent arg0) {
			}
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void drop(DropTargetDropEvent e) {
				List<File> list = null;
				try{
                    // Accept the drop first, important!
                    e.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    // lista upuszczonych plików
                    list = (List) e.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);

            		
                }catch(Exception ex){}
				String path = list.get(0).getPath();
				ac.dropFile(path);

			}

			@Override
			public void dropActionChanged(DropTargetDragEvent arg0) {
				
				
			}
        });
	    
	    textList = new JList();
		textList.setCellRenderer(new TableCell());
		textList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		textList.setCellRenderer(new TextListCell());
		textList.setModel(Dane.modelTextList);
	
	    scroll = new JScrollPane (textList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	  
	    add(scroll);
	}
	
	public void init(ActionsController ac){
		this.ac = ac;
	}
	
	private void pressF1(){
		addSymbol("|");
	}

	private void pressTab(){
		addSymbol("  ");
	}
	private void addSymbol(String s){
		int position = -1;
		position = text.getCaretPosition();
		text.insert(s, position);
		text.setCaretPosition(position);
	}
	public void setEdit(boolean co){
		text.setEditable(co);
		text.setCaretPosition(0);
		text.getCaret().setVisible(co);
	}
	
	
	///////////////////////////////////////////////
	
//	public void xxxsetText(String[] t){
//		text.setText("");
//		for(int i = 2; i < t.length; i++){
//			text.append(t[i]+'\n');
//		}
//		text.setCaretPosition(0);
//	}
//	public void xxxsetTextString(String t){
//		text.setText(t);
//	}
	
*/
}
