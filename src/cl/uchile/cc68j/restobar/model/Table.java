package cl.uchile.cc68j.restobar.model;

import java.sql.*;
import java.util.Vector;

public class Table extends Model {
	static public String tableName = "TABLES";
	static private String insertQuery = "INSERT INTO TABLES(SPACES, LOCATION) VALUES (?, ?)";
	static private String updateQuery = "UPDATE TABLES SET (SPACES = ?, LOCATION = ?) WHERE ID = ?";
	static private String deleteQuery = "DELETE FROM TABLES WHERE ID = ?";
	static private String generatedColumns[] = {"ID"};

	private int spaces;
	private String location;
	
	private Table(ResultSet row) {
		super(row);
		
		try {
			id = row.getInt("id");
			spaces = row.getInt("spaces");
			location = row.getString("location");
		} catch (SQLException ex) {}
	}

	public Table() {}

	public int getSpaces() {
		return spaces;
	}

	public void setSpaces(int spaces) {
		this.spaces = spaces;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public boolean valid() {
		if (spaces <= 0 || location == null) return false;
		
		return true;
	}

	@Override
	protected boolean insert() {
		try {
			
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(insertQuery, generatedColumns);
		
			st.setInt(1, spaces);
			st.setString(2, location);
		
			st.executeUpdate();
		
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			this.id = rs.getInt(1);
		
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}

	@Override
	protected boolean update() {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(updateQuery);
		
			st.setInt(1, spaces);
			st.setString(2, location);
			st.setInt(3, id);
		
			st.executeUpdate();
		
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}
	
	@Override
	public boolean delete() {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(deleteQuery);
		
			st.setInt(1, id);
		
			st.executeUpdate();
		
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}
	
	static public Vector<Table> findAll() {
		Vector<Table> result = new Vector<Table>();
		
		try {
			Statement st = DB.getConnection().createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM TABLES");
			
			while (rs.next()) {
				result.add(new Table(rs));
			}
		} catch (SQLException ex) {}
		
		return result;
	}

	public static Table find(long id) {
		try {
			PreparedStatement st = DB.getConnection().prepareStatement(
					"SELECT * FROM TABLES WHERE ID = ?");
			
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				return new Table(rs);
			}
		} catch (SQLException ex) {}
		
		return null;
	}
}
