package sirs.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sun.rowset.CachedRowSetImpl;
import sirs.model.DataBaseModel;
import sirs.model.Truck;

public class TruckDAO extends DataBaseModel{
	
	private String query;
	private List<Truck> Trucks= new ArrayList<Truck>();
	private Truck Truck;
	
	public  List<Truck> getAllTrucks() throws SQLException {
	
		query= "select v.*,tv.tipo_vehiculo,tv.capacidad "+
			   "from vehiculo_recolector v ,tipo_vehiculo_recolector tv "+ 
			   "where tv.id_tipo_vehiculo=v.id_tipo_vehiculo order by v.delegacion,v.matricula;";	
		CachedRowSetImpl resultSet = getResultFromQuery(query);
		
		while(resultSet.next()){
			Truck =new Truck();
			Truck.setLicensePlate(resultSet.getString("matricula"));
			Truck.setYear(resultSet.getInt("año"));
			Truck.setTrademark(resultSet.getString("marca"));
			Truck.setDistrict(resultSet.getString("delegacion"));
			Truck.setType(resultSet.getString("tipo_vehiculo"));
			Truck.setCapacity(resultSet.getFloat("capacidad"));
			
			if(resultSet.getString("modelo")!=null)
				Truck.setModel(resultSet.getString("modelo"));
		
			Trucks.add(Truck);
		
		}
		return Trucks;
	}

}
