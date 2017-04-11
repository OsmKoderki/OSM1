package model;




public class Examination {
	private double bloodGlucose, urineGlucose;
	boolean ghb =false;
	
	public Examination(double bloodGlucose, double urineGlucose, boolean ghb){
		this.bloodGlucose = bloodGlucose;
		this.urineGlucose =urineGlucose;
		this.ghb =ghb;
	}
	
	public double getBloodGlucose() {
		return bloodGlucose;
	}

	public void setBloodGlucose(double bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

	public double getUrineGlucose() {
		return urineGlucose;
	}

	public void setUrineGlucose(double urineGlucose) {
		this.urineGlucose = urineGlucose;
	}

	
	
	
	
	
}
