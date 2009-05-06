package cl.uchile.cc68j.restobar.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table extends Model {
	private int spaces;
	private String location;
	
	private Table(ResultSet row) {
		super(row);
		
		try {
			newRecord = false;
			id = row.getInt("id");
			spaces = row.getInt("spaces");
			location = row.getString("location");
		} catch (SQLException ex) {}
	}

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String deleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String insertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String updateQuery() {
		// TODO Auto-generated method stub
		return null;
	}
}
