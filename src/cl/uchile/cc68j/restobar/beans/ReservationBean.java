package cl.uchile.cc68j.restobar.beans;

import java.util.Map;
import java.util.Vector;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import cl.uchile.cc68j.restobar.model.Reservation;
import cl.uchile.cc68j.restobar.model.Table;

public class ReservationBean {
	Reservation reservation;
	
	public ReservationBean() {
	}

	public ReservationBean(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public void loadReservation(ActionEvent event) {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		this.reservation = Reservation.find(Long.parseLong(params.get("reservationId")));
	}
	
	public void newReservation(ActionEvent event) {	
		this.reservation = new Reservation();
	}
	
	public void getData(ActionEvent event) {	
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (params.get("reservation:id") != null) {
			this.reservation = Reservation.find(Long.parseLong(params.get("table:id")));
		} else {
			this.reservation = new Reservation();
		}
		
		this.reservation.setName(params.get("reservation:name"));
		this.reservation.setExtras(params.get("reservation:extras"));
		this.reservation.setAt(params.get("reservation:at"));
	}

	public void getTableAndSave(ActionEvent event) {	
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		this.reservation.setTableId(Integer.parseInt(params.get("reservation:tableId")));
		
		this.reservation.save();
	}

	
	public void deleteReservation(ActionEvent event) {	
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		this.reservation = Reservation.find(Long.parseLong(params.get("reservation:id")));
		this.reservation.delete();
		this.reservation = null;
	}
	
	public String validateTable() {
		if (reservation.valid())
			return "valid";
		else
			return "invalid";
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public Vector<Table> getAvailableTables() {
		return this.reservation.availableTables();
	}
	
	public void setAvailableTables(Vector<Table> t) {}

}
