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
			//System.out.println(loan.getGadgetId() + ", " + lib.getGadgetByName(name).getInventoryNumber());
			
			if(loan.getGadgetId().compareTo(lib.getGadgetByName(name).getInventoryNumber()) == 0 ) {
				try {
					//Date date = new Date();
					//date.setTime(date.getTime() + 7 * 24 * 60 * 60 * 1000);
					loan.returnCopy(new Date());
					lib.update();
					
				} catch (IllegalLoanOperationException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

}
