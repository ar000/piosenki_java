package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import piosenki.Dane;

public class PanelEditGroups extends JPanel{

	private static final long serialVersionUID = 1L;
	public JTable tabela;
	int gIndex;
	public JButton up, down, delete, dodaj;
	private JLabel label1;
	public JLabel infoNewGroup;
	
	private ActionsController ac;
	
	public void init(ActionsController ac){
		this.ac = ac;
	}
	
	public PanelEditGroups(){
		setPreferredSize(W.panelEditGroup);//(345+45,725)
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.green);
		setVisible(false);
	
		JLabel l1 = new JLabel("Zaznacz grupê do zmiany",SwingConstants.CENTER);
		l1.setFont(l1.getFont().deriveFont(W.fontSize12));
		l1.setPreferredSize(W.labelZaznaczGrupe);//(350,25)
		
		tabela = new JTable();
		tabela.setFocusable(false);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setColumnSelectionAllowed(true);
		tabela.setRowSelectionAllowed(true);
		tabela.setShowGrid(false);
		tabela.addMouseListener(new MouseAdapter() {
	         @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
	         public void mouseReleased(MouseEvent e) {
	        	gIndex = tabela.rowAtPoint(e.getPoint());
	        	check();
	        	infoNewGroup.setVisible(false);
		     }
	      });
		tabela.setModel(Dane.modelEditGroups);
		TableColumn column = null;
        column = tabela.getColumnModel().getColumn(0);
        column.setPreferredWidth(305);
        column.setResizable(false);
        column = tabela.getColumnModel().getColumn(1);
        column.setPreferredWidth(25);
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setPreferredSize(W.scrollTebleEditGroups);//(350,510)
		
		JPanel but = new JPanel();
		but.setPreferredSize(W.panelButtonsEditGroup);//(350, 150)
		but.setLayout(null);
		
			label1 = new JLabel("Wykonaj dla zaznaczonej grupy: ");
			label1.setFont(label1.getFont().deriveFont(W.fontSize12));
			label1.setBounds(W.labelWykonajDlaGrupy);//(5, 5, 300, 25)
			
			up = new JButton("wy¿ej");
			up.setFocusable(false);
			up.setBounds(W.buttonGroupUp);//(5, 35, 110, 25)
			up.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	ac.clickEditGroupUp((String) Dane.modelEditGroups.getValueAt(gIndex--, 0));
		        	check();
		        	infoNewGroup.setVisible(false);
		        }
		    });
			
			down = new JButton("ni¿ej");
			down.setFocusable(false);
			down.setBounds(W.buttonGroupDown);//(125, 35, 110, 25)
			down.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	ac.clickEditGroupDown((String) Dane.modelEditGroups.getValueAt(gIndex++, 0));
		        	check();
		        	infoNewGroup.setVisible(false);
		        }
		    });
			
			JButton rename = new JButton("Zmieñ nazwê");
			rename.setFocusable(false);
			rename.setBounds(W.buttonGroupRename);
			rename.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	infoNewGroup.setVisible(false);
		        	String tekst = "";
		        	String gr = (String) Dane.modelEditGroups.getValueAt(gIndex, 0);
		        	tekst = JOptionPane.showInputDialog("  Wpisz now¹ nazwê dla grupy: \""+gr+"\"  ");
		        	if(tekst==null) tekst = "";
		        	
		        	if(tekst.trim().length()>1 )
		        		
		        		ac.clickEditGroupRename(gr,tekst);
		        }
		    });
			
			delete = new JButton("Usuñ grupê");
			delete.setFocusable(false);
			delete.setBounds(W.buttonGroupDelete);
			delete.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	String gr = (String) Dane.modelEditGroups.getValueAt(gIndex, 0);
		        	int oo =  (int) Dane.modelEditGroups.getValueAt(gIndex, 1);
		        	StringBuilder kom = new StringBuilder();
		        	kom.append("Iloœæ piosenek w tej grupie: ");
		        	kom.append(oo);
		        	
		        	StringBuilder tyt = new StringBuilder();
		        	tyt.append("Usun¹æ grupê \"");
		        	tyt.append(gr);
		        	tyt.append("\" ?");
		        	
		        	
		        	if(oo>-1){
			        	String[] opcje = { "TAK", "NIE"};
			        	int a = JOptionPane.showOptionDialog(
			        	           null, // okno
			        	           kom.toString() , // komunikat
			        	           tyt.toString(), // tytu³
			        	           JOptionPane.DEFAULT_OPTION, // rodzaj przycisków u do³u (tu niewa¿ny)
			        	           JOptionPane.QUESTION_MESSAGE,// typ komunikatu (standardowa ikona)
			        	           null, // w³asna ikona (tu: brak)
			        	           opcje, // w³asne opcje - przyciski
			        	           opcje[1]); // domyœlny przycisk
			        	if(a==0)ac.clickEditGroupDelete(gr);
			        	
		        	}else{
		        		ac.clickEditGroupDelete(gr);
		        	}
		        	
		        }
		    });
			
			infoNewGroup = new JLabel("Grupa o tej nazwie ju¿ istnieje. Wybierz inn¹ nazwê.");
			infoNewGroup.setFont(infoNewGroup.getFont().deriveFont(W.fontSize12));
			infoNewGroup.setBounds(W.labelInfoNewGroup);
			infoNewGroup.setVisible(false);
			
			dodaj = new JButton("Dodaj now¹ grupê");
			dodaj.setFocusable(false);
			dodaj.setBounds(W.buttonGroupAdd);
			dodaj.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	infoNewGroup.setVisible(false);
		        	String tekst = "";       	
		        	tekst = JOptionPane.showInputDialog("  Wpisz nazwê dla nowej grupy: ");
		        	if(tekst==null) tekst = "";
		        	
		        	if(tekst.trim().length()>1 )
		        		
		        			ac.clickEditGroupNew(tekst);
		        		
		        		
		        }
		    });
			
			JButton exit = new JButton("Zakoñcz");
			exit.setFocusable(false);
			exit.setBounds(W.buttonExitEditGroups);
			exit.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	infoNewGroup.setVisible(false);
		        	ac.clickEditGroupExit();
		        }
		    });
			
		but.add(label1);
		but.add(up);
		but.add(down);
		but.add(delete);
		but.add(rename);
		but.add(infoNewGroup);
		but.add(dodaj);
		but.add(exit);
		
		add(l1);
		add(scroll);
		add(but);
	}
	
	public void check(){
		up.setEnabled(true);
		down.setEnabled(true);
		if(gIndex == 0) up.setEnabled(false);
		if(gIndex == tabela.getRowCount()-1) down.setEnabled(false);
	}
	

	
}
