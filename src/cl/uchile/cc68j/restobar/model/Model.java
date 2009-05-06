package cl.uchile.cc68j.restobar.model;

import java.sql.ResultSet;

public abstract class Model {
	protected int id;
	protected boolean newRecord = true;
	
	protected Model(ResultSet row) {
		newRecord = false;
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
		
		try {
			DB db = DB.getInstance();
			
			if (newRecord)
				db.update(insertQuery());
			else
				db.update(updateQuery());

		} catch (DBException ex) {
			return false;
		}
		return true;
	}
	
	public void destroy() {
		try {
			DB db = DB.getInstance();
			db.update(deleteQuery());
		} catch (DBException ex) {}
	}

	public abstract boolean valid();
	protected abstract String insertQuery();
	protected abstract String updateQuery();
	protected abstract String deleteQuery();
}
