package model;
// W tej klasie przechowuje wszystkie dane o osobie, tu jest konstruktor do ktorego przekazuje dane z textfields
public class Person {
	
	
	private String name, pesel,surname;
	private InsuranceCategory insCat;
	private Gender gender;
	private Examination bloodGlucose, urineGlucose, ghb;
	
	public Person(String name, Gender gender, String pesel,
			InsuranceCategory insCat, String surname) {
		this.name = name;
		this.surname = surname;
		this.insCat = insCat;
		this.gender = gender;
		this.pesel = pesel;
	}
	
	public Person(String name, Gender gender, String pesel,
			InsuranceCategory insCat, String surname,Examination bloodGlucose, Examination urineGlucose, Examination ghb) {
		this.name = name;
		this.surname = surname;
		this.insCat = insCat;
		this.gender = gender;
		this.pesel = pesel;
		this.bloodGlucose = bloodGlucose;
		this.ghb = ghb;
		this.urineGlucose = urineGlucose;
	}
	
	public Examination getBloodGlucose() {
		return bloodGlucose;
	}

	public void setBloodGlucose(Examination bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

	public Examination getUrineGlucose() {
		return urineGlucose;
	}

	public void setUrineGlucose(Examination urineGlucose) {
		this.urineGlucose = urineGlucose;
	}

	public Examination getGhb() {
		return ghb;
	}

	public void setGhb(Examination ghb) {
		this.ghb = ghb;
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
	public void setSrurname(String surname) {
		this.surname = surname;
	}
	
	public InsuranceCategory getInsCat() {
		return insCat;
	}
	public void setInsCat(InsuranceCategory insCat) {
		this.insCat = insCat;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
