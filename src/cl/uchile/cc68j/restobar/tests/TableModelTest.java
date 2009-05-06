package cl.uchile.cc68j.restobar.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cl.uchile.cc68j.restobar.model.Table;


public class TableModelTest {
	
	@Test
	public void validCreation() {
		Table t = new Table();
		t.setSpaces(5);
		t.setLocation("Somewhere");
		
		assertTrue(t.valid());
		assertTrue(t.save());
	}
}
