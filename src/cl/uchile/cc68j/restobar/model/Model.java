package cl.uchile.cc68j.restobar.model;

import java.sql.*;

public abstract class Model {
	protected int id;
	protected boolean newRecord;
	
	protected Model(ResultSet row) {
		newRecord = false;
	}
	
	public Model() {
		newRecord = true;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}
	
	public boolean save() {
		if (!valid()) return false;
		
		if (newRecord) {
			if (insert()) {
				this.newRecord = false;
				return true;
			} else{
				return false;
			}
		} else
			return update();
	}

	public abstract boolean valid();
	abstract protected boolean insert();
	abstract protected boolean update();
	abstract public boolean delete();
}
