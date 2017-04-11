package gui;
import java.util.EventObject;

public class FormEvent extends EventObject {

	private String name,surname;
	private String pesel;
	private String insCat;
	private String gender;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String gender, String pesel,
			String insCat, String surname) {
		super(source);
		this.surname = surname;
		this.name = name;
		this.pesel = pesel;
		this.insCat = insCat;
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPesel() {
		return pesel;
	}

	public String getInsuranceCategory() {
		return insCat;
	}

}
