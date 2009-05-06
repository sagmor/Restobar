package cl.uchile.cc68j.restobar.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table extends Model {
	static public String tableName = "TABLES";
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
	protected String deleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String insertQuery() {
		String q = "INSERT INTO "+tableName+
		"(SPACES, LOCATION) VALUES ("+spaces+", '"+location+"');";
		System.out.println(q);
		
		return q;
	}

	@Override
	protected String updateQuery() {
		// TODO Auto-generated method stub
		return null;
	}
}
