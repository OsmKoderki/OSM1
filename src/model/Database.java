package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
	
	private List<Person> people;
	 
	public Database() {
		people = new LinkedList<Person>();
		
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}
	
	public void removePerson(int index) {
		people.remove(index);
	}
	
	
	public List<Person> getPeople() {
		 return Collections.unmodifiableList(people);
	}
	

	
	
}
