package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import piosenki.Dane;

public class PanelPackage extends JPanel{

	private static final long serialVersionUID = 1L;
	private ActionsController ac;
	//private ViewController vc;
	public JTable tabela;
	JButton dodaj, makeGroup;
	
	public void init(ActionsController ac){
		//this.L =  L;
		//this.vc = vc;
		this.ac = ac;
	}
	
	public PanelPackage(){
		//FlowLayout fl = new FlowLayout(FlowLayout.CENTER,30,0);
		//FlowLayout fl = new FlowLayout();
		//fl.setAlignment(FlowLayout.CENTER);
		setPreferredSize(W.panelPackage);//352 bylo (345+45,725)
		setLayout(new FlowLayout(FlowLayout.CENTER));
		//setBackground(Color.yellow);
		setVisible(false);
		
		
		JLabel l1 = new JLabel("Zaznacz piosenki do dodania",SwingConstants.CENTER);
		l1.setPreferredSize(new Dimension(350,25));
		
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
	        	// L.clickTitleOnList(tableT.rowAtPoint(e.getPoint()));
		     }
	      });
		tabela.setModel(Dane.tabelaPackage);
		TableColumn column = null;
        column = tabela.getColumnModel().getColumn(0);
        column.setPreferredWidth(305);
        column.setResizable(false);
        column = tabela.getColumnModel().getColumn(1);
        column.setPreferredWidth(25);
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setPreferredSize(new Dimension(340,500));
		
		JPanel dd = new JPanel();
		//dd.setBackground(Color.YELLOW);
		dd.setPreferredSize(new Dimension(360,270));
		dd.setLayout(new FlowLayout(FlowLayout.CENTER,0,25));
		dodaj = new JButton("Dodaj zaznaczone do swojej bazy");
		dodaj.setPreferredSize(new Dimension(180+180,25));
		dodaj.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//L.clickSavePackage();
	        	ac.clickSavePackage();
	        }
	    });
		makeGroup = new JButton("Utwórz grupê z tymi piosenkami dodaj¹c nowe do bazy");
		makeGroup.setPreferredSize(new Dimension(180+180,25));
		makeGroup.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//L.clickSavePackage();
	        	ac.clickGroupFromPackage();
	        }
	    });
		JButton anuluj = new JButton("Anuluj");
		anuluj.setPreferredSize(new Dimension(100+260,25));
		anuluj.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
//	        	L.clickCancelPackage();
	        	ac.clickCancelPackage();
	        }
	    });
		JPanel sep = new JPanel();
		sep.setPreferredSize(new Dimension(360,5));
		
		dd.add(dodaj);
		//dd.add(makeGroup);
		dd.add(sep);
		dd.add(anuluj);
		
		
		add(l1);
		add(scroll);
		add(dd);
	}
	
}
