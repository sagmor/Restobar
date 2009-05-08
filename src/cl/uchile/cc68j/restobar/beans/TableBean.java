package cl.uchile.cc68j.restobar.beans;

import java.util.Map;
import java.util.Vector;

import javax.faces.context.FacesContext;
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
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		this.table = Table.find(Long.parseLong(params.get("tableId")));
	}
	
	public void newTable(ActionEvent event) {	
		this.table = new Table();
	}
	
	public void saveTable(ActionEvent event) {	
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (params.get("table:id") != null) {
			this.table = Table.find(Long.parseLong(params.get("table:id")));
		} else {
			this.table = new Table();
		}
		
		this.table.setLocation(params.get("table:location"));
	
		this.table.setSpaces(Integer.parseInt(params.get("table:spaces")));
		
		this.table.save();
	}
	
	public void deleteTable(ActionEvent event) {	
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		this.table = Table.find(Long.parseLong(params.get("table:id")));
		this.table.delete();
		this.table = null;
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
