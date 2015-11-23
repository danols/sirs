package sirs.model;

public class Truck extends GarbageTruck {
	private String licensePlate;
	private String model;
	private int year;
	private String trademark;
	private String district;
	
	
	public void setDistrict(String district) {this.district = district;}
	public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
	public void setModel(String model) { this.model = model; }
	public void setYear(int year) { this.year = year; }
	public void setTrademark(String trademark) { this.trademark = trademark; }
	
	public String getLicensePlate() { return licensePlate; }
	public String getModel() { return model; }
	public int getYear() { return year; }
	public String getTrademark() { return trademark; }
	public String getDistrict() {return district;}
}
