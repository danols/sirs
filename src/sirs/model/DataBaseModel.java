package sirs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

public abstract class DataBaseModel {
	private static String db_host = "localhost";
	private static String db_port = "3306";
	private static String db_name = "sirs";
	private static String db_user = "root";
	private static String db_password = "15040102hh";
	private static String base = "jdbc:mysql://";
	private static String driver = "com.mysql.jdbc.Driver";
	/*
	protected abstract <T> List<T> select();
	protected abstract String insert(List<Object> input);
	protected abstract String delete();
	protected abstract String update();
	*/
	
	static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {

        }
    }
	
	private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(base + db_host + ":" + db_port + "/" + db_name, db_user, db_password);
    }
	
	void closeConnection(Connection connection) {
        if(connection == null) return;
        try {
            connection.close();
        } catch (SQLException ex) {
            
        }
    }
	
	protected CachedRowSetImpl getResultFromQuery(String query) throws SQLException {
		Connection connection = null;
		ResultSet resultSet = null;
		CachedRowSetImpl result = new CachedRowSetImpl();;
		try {
			connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			result.populate(resultSet);
            closeConnection(connection);
        }
		return result;
	}
}