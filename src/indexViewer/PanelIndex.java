package indexViewer;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import piosenki.Const;
import view.W;

public class PanelIndex extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel searchInfo;
	JTextArea searchField;
	JList<IndexItem> listW, listT;
	private JScrollPane scrollTitle, scrollWords;
	
	public PanelIndex(DefaultListModel<IndexItem> modelWord, DefaultListModel<IndexItem> modelTitle){
		setBounds(W.panelIndexRect);
		setLayout(null);
		
			JPanel searchPanel = new JPanel();
			searchPanel.setBounds(W.searchPanelRect);
			searchPanel.setLayout(null);
			
			JPanel progressPanel = new JPanel();
			progressPanel.setBounds(W.searchPanelRect);
			progressPanel.setLayout(null);
			
			
		searchInfo = new JLabel(Const.SEARCHINFO);
		searchInfo.setFont(searchInfo.getFont().deriveFont(W.fontSize12));
		searchInfo.setBounds(W.searchInfoRect);
		searchPanel.add(searchInfo);
		JButton clear = new JButton("Czyœæ");
		searchField = new JTextArea();
		searchField.setBounds(W.searchFieldRect);
		searchField.setFont(searchInfo.getFont().deriveFont(W.fontSize12));
		searchField.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
		    	if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
		    	    e.consume();
		    	    searchField.setText("");//   ac.clickClearSearch();
		    	    
		    	}
		    }

		    @Override
		    public void keyTyped(KeyEvent e) {
		    }
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	String dd = searchField.getText();
		    	Index.search(dd);  //ac.clickStartSearch(dd);
		    	clear.setEnabled(true);
		    }
		});
		
		clear.setBounds(W.searchButtonClearRect);
		clear.setFont(searchInfo.getFont().deriveFont(W.fontSize12));
		clear.setFocusable(false);
		clear.setEnabled(false);
		clear.addMouseListener(new MouseAdapter() {
	         @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
	         }
	         public void mouseReleased(MouseEvent e) {       	
	        	 searchField.setText("");// 	 ac.clickClearSearch();
	        	 Index.search("");//	 ac.clickStartSearch("");
	        	 clear.setEnabled(false);
		     }
	      });
		searchPanel.add(searchField);
		searchPanel.add(clear);
		
		listT = new JList<IndexItem>();
		//listT.setCellRenderer(new TableCell());	
		listT.setCellRenderer(new IndexCell());	
		listT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listT.setModel(modelTitle);
		listT.addMouseListener(new MouseAdapter() {
	         @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
	         }
	         public void mouseReleased(MouseEvent e) {
	        	 int index = listT.locationToIndex(e.getPoint());
	        	 Index.clickTitle(index);// ac.clickTitleOnList(index);
	        	listW.clearSelection();
	        	// listT.clearSelection();
		     }
	      });
		
		//listW = new JList<String>();
		listW = new JList<IndexItem>();
		//listW.setCellRenderer(new TableCell());	
		listW.setCellRenderer(new IndexCell());	
		listW.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listW.setModel(modelWord);
		listW.addMouseListener(new MouseAdapter() {
	         @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
	         }
	         public void mouseReleased(MouseEvent e) {
	        	 int index = listW.locationToIndex(e.getPoint());
	        	 Index.clickWord(index);//ac.clickWordOnList(index);
	        	 
	        	 listW.clearSelection();
	        	// listT.clearSelection();
		     }
	      });
		
		scrollTitle = new JScrollPane(listT);
		scrollTitle.setBounds(W.scrollTitlesRect);
		scrollWords = new JScrollPane(listW);
		scrollWords.setBounds(W.scrollWordsRect);
		
		
	
		add(searchPanel);
		add(scrollTitle);
		add(scrollWords);
		
		if(W.colors){
			setBackground(Color.BLUE);
			searchPanel.setBackground(Color.red);
			progressPanel.setBackground(Color.yellow);
		}
		
		
	}
	
	public void appendLists(final DefaultListModel<IndexItem> t,final DefaultListModel<IndexItem> w ) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            listT.setModel(t);
	            listW.setModel(w);
	            listT.setSelectedIndex(0);
	            Index.setCursorWait(false);
	        }
	    });
	}

	
	public void setTitleSelection(int index){
		listT.setSelectedIndex(index);
		JScrollBar sb = scrollTitle.getVerticalScrollBar();
		sb.setValue((index-10)*15);
		scrollTitle.setVerticalScrollBar(sb);
	}
	
}
