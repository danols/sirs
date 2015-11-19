package sirs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DataBaseModel {
	private static String db_host = "localhost";
	private static String db_port = "3306";
	private static String db_name = "";
	private static String db_user = "";
	private static String db_password = "";
	private static String base = "jdbc:mysql://";
	private static String driver = "com.mysql.jdbc.Driver";
	
	protected abstract List<Object> select();
	protected abstract String insert(List<Object> input);
	protected abstract String delete();
	protected abstract String update();
	
	static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {

        }
    }
	
	private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(base + db_host + ":" + db_port + "/" + db_name, db_user, db_password);
    }
	
	private void closeConnection(Connection connection) {
        if(connection == null) return;
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexión");
        }
    }
	
	protected ResultSet getResultFromQuery(String query) {
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
            closeConnection(connection);
        }
		return resultSet;
	}
}