package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {
	
	private List<Person> db;
	
	private String[] colNames = { "Imiê i Nazwisko", "P³eæ", "PESEL", "Ubezpieczenie", "Badanie"};
	
	
	public PersonTableModel(){
		
	}
	//ustawiamy liste danych
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}



	public void setData(List<Person> db) {
		this.db = db;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		try {
			return db.size();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return 0;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// do person wrzucam dane z poszczególnych miejsc
		Person person = db.get(row);
		
		//wrzucam dane do tabeli - do poszczegolnych kolumn
		switch(col) {
		case 0:
			return person.getName()+" "+ person.getSurname();
		case 1:
			return person.getGender();
		case 2:
			return person.getPesel();
		case 3:
			return person.getInsCat();
		case 4:
			//narazie tak ale ma byæ badanie
			
		
		}
		
		return null;
	

	}
	
	
	
	

}
