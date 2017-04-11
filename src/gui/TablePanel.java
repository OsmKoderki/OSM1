package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import model.Person;
import gui.FormPanel;

public class TablePanel extends JPanel implements ActionListener{ 
	private JTable table;
	private PersonTableModel tableModel;
	private JScrollPane scrollpane;
	private PersonTableListener personTableListener;
	private JButton dodajBut, usunBut;
	private JPanel mainPane, listPane, panelButton;
	private FormPanel formPanel;
	private PersonTableListener tablelistener;
	private FormListener formListener;
	private FormPanel nameField;
	private FormPanel surnameField, peselField;

	      
	      
	      public TablePanel(){
	    	  
	    	tableModel = new PersonTableModel();
	    	//table model który jest z PersonTableModel jest przekazany do konstruktora
	    	table = new JTable(tableModel);
	    	//identyfikuje table model
	    	
	    	//panel listy-tabeli
	    	listPane = new JPanel();
	  		Border innerBorder = BorderFactory.createTitledBorder("Lista pacjentów");
	  		setBorder(innerBorder);
	  		
	  		//dodaje przyciski Buttons
	  		dodajBut = new JButton("Dodaj");
	  		usunBut = new JButton("Usuñ");
	  	   
	  		
	  		// jak klikne to zaczynam dodawanie pacjenta
	  		dodajBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//nameField.setEnabled(true);
					//surnameField.setEnabled(true);
				//	peselField.setEnabled(true);
					 
				}
			});
	  		
	  		//wybieram myszka dany wiersz w tabeli
	  		  table.addMouseListener(new MouseAdapter(){
	  			  
	  	        @Override
	  	        public void mouseClicked(MouseEvent e){
	  	            
	  	            // i = indeks wybranego wiersza
	  	            int i = table.getSelectedRow(); 
	  	            
	  	        }
	  	        });
	  		  
	  		// usuwam dany wiersz z tabeli
	  	//	usunBut.addActionListener(new ActionListener() {
			//	public void actionPerformed(ActionEvent arg0) {
				//	int row = table.getSelectedRow();
				//	if(personTableListener != null ) {
					//	try{
					//	//	personTableListener.rowDeleted(row);
						//	tableModel.fireTableRowsDeleted(row, row);
							
							//}catch(IndexOutOfBoundsException e){
						//			}				
					//	}
					//}
	  			//});
	  		
	  		

    	     // Umo¿liwiam scrollowanie tabeli
	    	 scrollpane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    	 
	    	 //wywoluje metode w ktorej ustawiam wszystkie komponenty 
	    	 layoutComponents();  
	      }

		private void layoutComponents() {
			setLayout(new BorderLayout());
			
			//ustawienia grafiki, polozenie
			listPane.setLayout(new BorderLayout());
	        listPane.add(scrollpane);
	        
	        //flowlayout zeby byly obok siebie przyciski
	        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        buttonPane.add(dodajBut);
	        buttonPane.add(usunBut);

	        //dwa panele jeden gora drugi dol    
	        add(listPane, BorderLayout.NORTH);
	        add(buttonPane, BorderLayout.SOUTH);
	   	}
		
		public void setData(List<Person> db) {
			tableModel.setData(db);
		
		}
		
		public void refresh() {
			tableModel.fireTableDataChanged();
			
		}
		
		public void setPersonTableListener(PersonTableListener listener) {
			this.personTableListener = listener;
			usunBut.addActionListener(this);
			dodajBut.addActionListener(this);
		}
		
		//sprobuje usuwac z formularza
		public void setFormListener(FormListener listener) {
			this.formListener = listener;
		}
		//metoda usun 
		
			
		

			@Override
			public void actionPerformed(ActionEvent evt) {
				 if (evt.getSource() == usunBut)
				{
					 nameField = new FormPanel();
					 nameField.cleanForm();
					 int row = table.getSelectedRow();
						if(personTableListener != null ) {
							try{
								personTableListener.rowDeleted(row);
								tableModel.fireTableRowsDeleted(row, row);
								
								}catch(IndexOutOfBoundsException e){
										}				
							}
						} else  if (evt.getSource() == dodajBut){
							System.out.println("Dziala dodaj");
							nameField = new FormPanel();
							nameField.set();
						}
				
				
			}
  			
}
