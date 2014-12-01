package control;

import bl.Customer;
import bl.Library;
import bl.Reservation;

public class ToDoDeleteReservation {

	private Library lib;

	public ToDoDeleteReservation(Library lib) {
		this.lib = lib;
	}

	public void deleteReservation(String name, Customer customer) {
		lib.getReservatonFor(lib.getGadgetByName(name), customer, true).setFinished(true);
	}
}
