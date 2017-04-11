package controller;

import gui.FormEvent;
import gui.FormPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;







import model.Database;
import model.InsuranceCategory;
import model.Gender;
import model.Person;

public class Controller {
	
	Database db = new Database();
	FormPanel fP = new FormPanel();
	
	//ta liste chce przekazac do TableModel w klasie TablePanel
	public List<Person> getPeople() {
		return db.getPeople();
	}
	
	public void removePerson(int index) {
		db.removePerson(index);
	}
	
	
	public void addPerson(FormEvent ev) {
		String name = ev.getName();
		String surname = ev.getSurname();
		String pesel = ev.getPesel();
		String insCat = ev.getInsuranceCategory();
		String gender = ev.getGender();
		
		InsuranceCategory insCategory = null;
		
		if(insCat.equals("NFZ")) {
			insCategory = InsuranceCategory.NFZ;
		}
		else if(insCat.equals("Prywatne")) {
			insCategory = InsuranceCategory.Prywatne;
		}
		else if(insCat.equals("brak")) {
			insCategory = InsuranceCategory.brak;
		}
			
		Gender genderCat;
		
		if(gender.equals("kobieta")) {
			genderCat = Gender.K;
		}
		else {
			genderCat = Gender.M;
		}
		
		Person person = new Person(name, genderCat, pesel, insCategory, surname );
		
		db.addPerson(person);
	}

	


	

}
