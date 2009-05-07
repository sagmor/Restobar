package cl.uchile.cc68j.restobar.beans;

import java.util.Vector;

import cl.uchile.cc68j.restobar.model.Table;

public class TableListBean {

    Vector<Table> tables;
    // ------------------------- Get y Set  --------------------
    
    /**
     * @return collection de libros
     */
    public Vector<Table> getTables(){
            if (tables == null) {
            	tables = Table.findAll();
            }
            
            return tables;
    }
            
    /**
     * @param books Los libros a definir.
     */
    public void setTables(Vector<Table> tables) {
            this.tables = tables;
    }       
}