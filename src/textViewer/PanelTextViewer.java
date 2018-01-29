package textViewer;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import piosenki.Dane;
import view.TableCell;
import view.W;

public class PanelTextViewer extends JPanel {
	
	JTextArea textArea;
	JList textList;
	private JScrollPane scrollView, scrollEdit;
	
	public PanelTextViewer(DefaultListModel model){
		setPreferredSize(W.panelLeftDim);
		setBackground(Color.GREEN);
		setLayout(new GridLayout());
		setLayout(null);
		
		textList = new JList();
		textList.setCellRenderer(new TableCell());
		textList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		textList.setCellRenderer(new TextListCell());
		textList.setModel(model);
	
		
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 100, 100);
		textArea.setFont(textArea.getFont().deriveFont(W.fontSize12));
		
	    Border border = BorderFactory.createLineBorder(Color.WHITE);
	    textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(3, 3, 3, 3)));
	    textArea.addKeyListener(new KeyListener(){
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
	    
	    new DropTarget(textArea, new DropTargetListener(){
	    	
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
			////////////	ac.dropFile(path);

			}

			@Override
			public void dropActionChanged(DropTargetDragEvent arg0) {
				
				
			}
        });
	    
	    scrollEdit = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollView = new JScrollPane (textList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollView.setBounds(0,0,W.panelLeftDim.width, W.panelLeftDim.height);
	    scrollEdit.setBounds(0,0,W.panelLeftDim.width, W.panelLeftDim.height);
	    
	    add(scrollView);
	    add(scrollEdit);
	    scrollView.setVisible(false);
	    scrollEdit.setVisible(false);
	   
	    
	    
	}
	
	public void setEditor(){
		scrollView.setVisible(false);
	    scrollEdit.setVisible(true);
	    setEdit(true);
	}
		
	public void setView(){
		scrollView.setVisible(true);
	    scrollEdit.setVisible(false);
	    setEdit(false);
	}
	private void setEdit(boolean co){
		textArea.setEditable(co);
		textArea.setCaretPosition(0);
		textArea.getCaret().setVisible(co);
	}
	private void pressF1(){
		addSymbol("|");
	}

	private void pressTab(){
		addSymbol("  ");
	}
	private void addSymbol(String s){
		int position = -1;
		position = textArea.getCaretPosition();
		textArea.insert(s, position);
		textArea.setCaretPosition(position);
	}
	
}
