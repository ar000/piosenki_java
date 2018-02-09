package textViewer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import view.W;

public class PanelText extends JPanel {
	private static final long serialVersionUID = 1L;
	JTextArea textArea, header;
	JList<LineText> textList;
	private JScrollPane scrollView;///, scrollEdit;
	
	public PanelText(DefaultListModel<LineText> model){
		setBounds(W.panelTextViewer);
		setBackground(Color.GREEN);
		FlowLayout fl = new FlowLayout();
		fl.setHgap(0);
		fl.setVgap(0);
		setLayout(fl);
		setLayout(null);
		
		textList = new JList<LineText>();
		textList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		textList.setCellRenderer(new TextListCell());
		textList.setModel(model);
	
	    
	    new DropTarget(textList, new DropTargetListener(){
	    	
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
				
				TextViewer.dropFile(path);
			////////////	ac.dropFile(path);

			}

			@Override
			public void dropActionChanged(DropTargetDragEvent arg0) {
				
				
			}
        });
	    
		scrollView = new JScrollPane (textList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollView.setBounds(W.panelTextViewer);
	    
	    add(scrollView);
	}
	
	
}
