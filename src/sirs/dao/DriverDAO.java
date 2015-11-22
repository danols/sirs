package sirs.dao;

import sirs.model.DataBaseModel;
import sirs.model.Driver;
import java.util.List;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;

public class DriverDAO extends DataBaseModel {
	
	private String query;
	private List<Driver> drivers = new ArrayList<Driver>();
	private Driver driver;
	private List<String> phones;
	
	public List<Driver> getAllDrivers() throws SQLException {
		long currentId = 1;
		query = "select d.*,dt.telefono  from chofer d left  join telefono_chofer dt on d.id_chofer=dt.id_chofer  order by d.id_chofer";
		CachedRowSetImpl resultSet = getResultFromQuery(query);
		if(resultSet.next()) setDriver(resultSet);
		while(resultSet.next()) {
			if(resultSet.getLong("id_chofer") == currentId) {
				if(resultSet.getString("telefono") != null) phones.add(resultSet.getString("telefono"));
			}
			else {
				addDriverToList();	
				currentId = resultSet.getLong("id_chofer");
				setDriver(resultSet);
			}
        }
		addDriverToList();
		return drivers;
	}
	
	private void addDriverToList() {
		driver.setPhoneNumbers(phones);
		drivers.add(driver);
	}
	
	private void setDriver(CachedRowSetImpl resultSet) throws SQLException {
		driver = new Driver();
		phones = new ArrayList<String>();
		driver.setId(resultSet.getLong("id_chofer"));
		driver.setDrivingLicense(resultSet.getString("licencia_manejo"));
		driver.setCurp(resultSet.getString("curp"));
		if(resultSet.getString("correo_chofer") != null) driver.setEmail(resultSet.getString("correo_chofer"));
		driver.setName(resultSet.getString("nombre"));
		driver.setLastName(resultSet.getString("apellido_paterno"));
		driver.setSurName(resultSet.getString("apellido_materno"));
		if(resultSet.getString("telefono") != null) phones.add(resultSet.getString("telefono"));
	}
}
