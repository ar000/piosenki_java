package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import piosenki.Const;
import piosenki.Dane;

public class PanelRight extends JPanel{
	private static final long serialVersionUID = 1L;
	JList listT, listW;
	JScrollPane scrollTitle, scrollWords;
	JTextArea searchField;
	JLabel searchInfo;
	JLabel groupName;
	JPanel panelIndex;
	int currentRowTT, currentRowTW, currentRowTS, currentRowTL;
	private ActionsController ac;

	public void init(ActionsController ac){
		this.ac = ac;
	}
	
	public PanelRight(){
		FlowLayout fl = new FlowLayout();
		fl.setHgap(0);
		fl.setVgap(0);
		setPreferredSize(W.panelRightDim);		//352,725
		if(W.colors)
			setBackground(Color.GREEN);
		setLayout(new GridLayout());
		setLayout(null);

		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(W.searchPanelRect);
	
		if(W.colors)
			searchPanel.setBackground(Color.orange);
		searchPanel.setLayout(null);
		searchInfo = new JLabel("Wpisz wyszukiwany tekst");
		searchInfo.setBounds(W.searchInfoRect);
		searchPanel.add(searchInfo);
		JButton clear = new JButton("Czyœæ");
		searchField = new JTextArea();
		searchField.setBounds(W.searchFieldRect);
		searchField.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
		    	if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
		    	    e.consume();
		    	    ac.clickClearSearch();
		    	}
		    }

		    @Override
		    public void keyTyped(KeyEvent e) {
		    }
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	String dd = searchField.getText();
		    	ac.clickStartSearch(dd);
		    	clear.setEnabled(true);
		    }
		});
		
		clear.setBounds(W.searchButtonClearRect);
		clear.setFocusable(false);
		clear.setEnabled(false);
		clear.addMouseListener(new MouseAdapter() {
	         @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
	         }
	         public void mouseReleased(MouseEvent e) {       	
	        	 ac.clickClearSearch();
	        	 ac.clickStartSearch("");
	        	 clear.setEnabled(false);
		     }
	      });
		searchPanel.add(searchField);
		searchPanel.add(clear);
		
		listT = new JList();
		listT.setCellRenderer(new TableCell());	
		listT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listT.setModel(Dane.modelListT);
		listT.addMouseListener(new MouseAdapter() {
	         @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
	         }
	         public void mouseReleased(MouseEvent e) {
	        	 int index = listT.locationToIndex(e.getPoint());
	        	 ac.clickTitleOnList(index);
	        	 listW.clearSelection();
		     }
	      });
		
		listW = new JList();
		listW.setCellRenderer(new TableCell());	
		listW.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listW.setModel(Dane.modelListW);
		listW.addMouseListener(new MouseAdapter() {
	         @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
	         }
	         public void mouseReleased(MouseEvent e) {
	        	 int index = listW.locationToIndex(e.getPoint());
	        	 ac.clickWordOnList(index);
	        	 listT.clearSelection();
		     }
	      });
		panelIndex = new JPanel();
		panelIndex.setLayout(null);
		
		scrollTitle = new JScrollPane(listT);
		scrollTitle.setBounds(W.scrollTitlesRect);
		scrollWords = new JScrollPane(listW);
		scrollWords.setBounds(W.scrollWordsRect);
		
		panelIndex.setBounds(W.panelIndexRect);
		if(W.colors) 
			panelIndex.setBackground(Color.YELLOW);
		panelIndex.add(searchPanel);
		panelIndex.add(scrollTitle);
		panelIndex.add(scrollWords);
		
		JButton gru = new JButton("GRUPA  >");
		gru.setToolTipText(Const.TIP_GROUPS);
		gru.setBounds(W.buttonGroupsRect);
		gru.setFocusable(false);
		gru.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	Dane.popMenu.menuGroup.show(gru, -10, 18); //90,0
	        }
	    });
		
		groupName = new JLabel("... ...");
		groupName.setBounds(W.labelGroupNameRect);
		groupName.setToolTipText(Const.TIP_GROUPNAME);
		groupName.setForeground(Color.blue);
		groupName.setFont(groupName.getFont().deriveFont(14f));
		
		add(gru);
		add(groupName);
		add(panelIndex);
		
	}
	
	public void clearSearchField(){
		searchField.setText("");
	}
}
