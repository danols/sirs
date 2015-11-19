package sirs.model;

import java.util.List;

public class Driver {
	private Long id;
	private String name;
	private String lastName;
	private String surName;
	private String email;
	private String curp;
	private String drivingLicense;
	private List<Long> phoneNumbers;
	
	public void setId(Long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setSurName(String surName) { this.surName = surName; }
	public void setEmail(String email) { this.email = email; }
	public void setCurp(String curp) { this.curp = curp; }
	public void setDrivingLicense(String drivingLicense) { this.drivingLicense = drivingLicense; }
	public void setPhoneNumbers(List<Long> phoneNumbers) { this.phoneNumbers = phoneNumbers; }
	
	public Long getId() { return id; }
	public String getName() { return name; }
	public String getLastName() { return lastName; }
	public String getSurName() { return surName; }
	public String getEmail() { return email; }
	public String getCurp() { return curp; }
	public String getDrivingLicense() { return drivingLicense; }
	public List<Long> getPhoneNumbers() { return phoneNumbers; }
}