package control;

import bl.Customer;
import bl.Gadget;
import bl.Library;

public class ToDoLoanReservation {
	
	private Library lib;
	
	public ToDoLoanReservation(Library lib) {
		this.lib = lib;
	}
	
	public void loanReservation(String name, Customer customer) {
		lib.addLoan(lib.getGadgetByName(name), customer);
	}

}
