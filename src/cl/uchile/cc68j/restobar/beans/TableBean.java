package cl.uchile.cc68j.restobar.beans;

import java.util.Vector;

import javax.faces.component.UIInput;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import cl.uchile.cc68j.restobar.model.Table;

public class TableBean {
	Table table;
	
	public TableBean() {
	}

	public TableBean(Table table) {
		this.table = table;
	}

	public static Vector<TableBean> getAllTables() {
		Vector<Table> tables = Table.findAll();
		Vector<TableBean> beans = new Vector<TableBean>();
		
		for (Table t : tables) {
			beans.add(new TableBean(t));
		}
		
		return beans;
	}
	
	public void loadTable(ActionEvent event) {
		System.out.println("load Table");
		UIParameter component = (UIParameter) event.getComponent().findComponent("tableId");
		long id = Long.parseLong(component.getValue().toString());
		
		this.table = Table.find(id);
	}
	
	public void saveTable(ActionEvent event) {				
		System.out.println("save event");
		UIInput component = (UIInput) event.getComponent().findComponent("tableId");
		System.out.println(component.getValue());
	}
	
	public String validateTable() {
		if (table.valid())
			return "valid";
		else
			return "invalid";
	}
	
	public Table getTable() {
		return table;
	}
	
	public void setTable(Table table) {
		this.table = table;
	}

}
