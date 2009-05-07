package cl.uchile.cc68j.restobar.model;

import java.sql.SQLException;

public class DBException extends SQLException {
	public DBException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
