package sirs.model;

import java.util.List;
import java.util.ArrayList;

public class Driver {
	private long id;
	private String name;
	private String lastName;
	private String surName;
	private String email;
	private String curp;
	private String drivingLicense;
	private List<String> phoneNumbers;
	
	public Driver() {
		phoneNumbers = new ArrayList<String>();
	}
	
	public void setId(long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setSurName(String surName) { this.surName = surName; }
	public void setEmail(String email) { this.email = email; }
	public void setCurp(String curp) { this.curp = curp; }
	public void setDrivingLicense(String drivingLicense) { this.drivingLicense = drivingLicense; }
	public void setPhoneNumbers(List<String> phoneNumbers) { this.phoneNumbers = phoneNumbers; }
	
	public long getId() { return id; }
	public String getName() { return name; }
	public String getLastName() { return lastName; }
	public String getSurName() { return surName; }
	public String getEmail() { return email; }
	public String getCurp() { return curp; }
	public String getDrivingLicense() { return drivingLicense; }
	public List<String> getPhoneNumbers() { return phoneNumbers; }
	
	public String printPhoneNumbers() {
		String numbers = " ";
		int size = phoneNumbers.size();
		for(int i=0;i<size;i++) {
			numbers += phoneNumbers.get(i);
			if(i != size-1) numbers += ", ";
		}
		return numbers;
	}
	
	public String toString() {
		return "CURP: " + curp +
				"   Nombre: " + name + 
				"   Licencia de Manejo: " + drivingLicense +
				"   Apellido Paterno: " + lastName + 
				"   Apellido Materno: " + surName + 
				"   Correo Electrónico: " + email+
				"   Teléfono(s): " + printPhoneNumbers() + ".";
	}
}