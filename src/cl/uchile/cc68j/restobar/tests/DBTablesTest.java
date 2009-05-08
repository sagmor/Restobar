package cl.uchile.cc68j.restobar.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import cl.uchile.cc68j.restobar.model.*;

public class DBTablesTest {
	static DatabaseMetaData dbMetaData;
	
	@BeforeClass
	static public void loadConnection() {
		try {
			DB db = DB.getInstance();
			dbMetaData = db.getMetaData();
			
		} catch (DBException e) {
		} catch (SQLException e) {
		} finally {
			assertNotNull("Connection Error", dbMetaData);
		}
	}
	@Test
	public void tablesTableExist() {
		assertTrue(checkTable(Table.tableName));
	}
	
	@Test
	public void usersTableExist() {
		assertTrue(checkTable(User.tableName));
	}
	
	public boolean checkTable(String tableName) {
		try {
			ResultSet tables = dbMetaData.getTables(null, null, tableName, null);
			return tables.next();
		} catch (SQLException e) {
			return false;
		}
	}
}
