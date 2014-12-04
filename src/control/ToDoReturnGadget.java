package control;

import java.util.Date;

import bl.Customer;
import bl.IllegalLoanOperationException;
import bl.Library;
import bl.Loan;

public class ToDoReturnGadget {
	
	Library lib;
	
	public ToDoReturnGadget(Library lib) {
		this.lib = lib;
	}
	
	public void returnGadget(Customer customer, String name) {
		for(Loan loan: lib.getLoansFor(customer, true)) {
			if(loan.getGadgetId() == lib.getGadgetByName(name).getInventoryNumber()) {
				try {
					loan.returnCopy(new Date());
					lib.update();
				} catch (IllegalLoanOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
