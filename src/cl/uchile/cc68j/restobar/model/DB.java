package cl.uchile.cc68j.restobar.model;

import java.sql.*;

/**
 * @author SagMor
 *
 */
public class DB {
	
	String url;
	String user;
	String pass;
	String driver;
	Connection connection;
	
	/**
	 * @throws DBException 
	 * 
	 */
	private DB() throws DBException {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "restobar";
		pass = "restobar";
		driver = "oracle.jdbc.driver.OracleDriver";
		
		initConnection();
	}
	
	private void initConnection() throws DBException {
		try{
			/* carga el driver usando el metodoClass.forName() */
			Class.forName(driver);
			// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url, user, pass);
		}
		catch(ClassNotFoundException ex) {
			/* Si el driver no esta disponible, el método forName()
			* lanzará una excepciondel tipo ClassNotFoundException. */
			ex.printStackTrace();
			throw new DBException("Driver Not Found");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Connection Error");
		}
	}
	
	public ResultSet query(String q) throws DBException {
		try	{
			Statement statement = connection.createStatement();
			return statement.executeQuery(q);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Query Failed");
		}
	}
	
	public void update(String q) throws DBException {
		try	{
			Statement statement = connection.createStatement();
			statement.executeUpdate(q);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Update query failed");
		}
	}
	
	/**
	 * 
	 */
	static private DB instance = null;
	
	/**
	 * 
	 * @return instance of the database connection;
	 * @throws DBException 
	 */
	static public DB getInstance() throws DBException {
		if (instance == null) {
			instance = new DB();
		}
		
		return instance;
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		return connection.getMetaData();
	}	
}
