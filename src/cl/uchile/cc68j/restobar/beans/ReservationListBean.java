package cl.uchile.cc68j.restobar.beans;

import java.util.Vector;

import cl.uchile.cc68j.restobar.model.Reservation;

public class ReservationListBean {

    Vector<Reservation> reservations;
    // ------------------------- Get y Set  --------------------
    
    /**
     * @return collection de reservas
     */
    public Vector<Reservation> getReservations(){
            if (reservations == null) {
            	reservations = Reservation.findAll();
            }
            
            return reservations;
    }
            
    /**
     * @param reservations Las reservas a definir.
     */
    public void setReservations(Vector<Reservation> reservations) {
            this.reservations = reservations;
    }       
}