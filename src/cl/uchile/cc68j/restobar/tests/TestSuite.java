package cl.uchile.cc68j.restobar.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { 
		DBTest.class, 
		DBTablesTest.class,
		TableModelTest.class })
public class TestSuite {
}
