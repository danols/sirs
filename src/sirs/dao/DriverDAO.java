package sirs.dao;

import sirs.model.DataBaseModel;
import sirs.model.Driver;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

public class DriverDAO extends DataBaseModel {
	/*
	protected List<Driver> select() {
		List<Driver> drivers = new ArrayList<Driver>();
		return drivers;
	}
	protected String insert(List<Object> input) {
		return "success";
	}
	protected String delete() {
		return "success";
	}
	protected String update() {
		return "success";
	}
	*/
	public List<Driver> getAllDrivers() throws SQLException {
		String query = "select * from chofer inner join telefono_chofer on chofer.id_chofer = telefono_chofer.id_chofer order by chofer.id_chofer";
		List<Driver> drivers = new ArrayList<Driver>();
		CachedRowSetImpl resultSet = getResultFromQuery(query);
		Driver driver = null;
		List<String> phones = null;
		long currentId = 1;
		if(resultSet.next()) {
			driver = new Driver();
			phones = new ArrayList<String>();
			driver.setId(resultSet.getLong("id_chofer"));
			driver.setDrivingLicense(resultSet.getString("licencia_manejo"));
			driver.setCurp(resultSet.getString("curp"));
			driver.setEmail(resultSet.getString("correo_chofer"));
			driver.setName(resultSet.getString("nombre"));
			driver.setLastName(resultSet.getString("apellido_paterno"));
			driver.setSurName(resultSet.getString("apellido_materno"));
			phones.add(resultSet.getString("telefono"));
		}
		while(resultSet.next()) {
			if(resultSet.getLong("id_chofer") == currentId) {
				phones.add(resultSet.getString("telefono"));
			} else {
				driver.setPhoneNumbers(phones);
				drivers.add(driver);	
				currentId = resultSet.getLong("id_chofer");
				driver = new Driver();
				phones = new ArrayList<String>();
				driver.setId(resultSet.getLong("id_chofer"));
				driver.setDrivingLicense(resultSet.getString("licencia_manejo"));
				driver.setCurp(resultSet.getString("curp"));
				driver.setEmail(resultSet.getString("correo_chofer"));
				driver.setName(resultSet.getString("nombre"));
				driver.setLastName(resultSet.getString("apellido_paterno"));
				driver.setSurName(resultSet.getString("apellido_materno"));
				phones.add(resultSet.getString("telefono"));
			}
        }
		driver.setPhoneNumbers(phones);
		drivers.add(driver);
		return drivers;
	}
}
