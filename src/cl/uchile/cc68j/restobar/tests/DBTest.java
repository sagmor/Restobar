package cl.uchile.cc68j.restobar.tests;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import cl.uchile.cc68j.restobar.model.DB;
import cl.uchile.cc68j.restobar.model.DBException;

public class DBTest {
	DB db = null;
	
	@Before
	public void loadConnection() {
		try {
			db = DB.getInstance();
		} catch (DBException e) {
		} finally {
			assertNotNull(db);
		}
	}
	
	@Test
	public void test() {
	}
}
