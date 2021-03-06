package bl;

 
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

import dl.CrudListener;
import dl.LibraryData;
import dl.MessageData;

public class Library extends Observable{
	
	
	private LibraryData data;
	
	public Library(LibraryData data)
	{
		this.data = data;
		
		data.registerCustomerListener(new CrudListener<Customer>() {
			@Override
			public void changed(MessageData message) {
				setChanged();
				notifyObservers(message);
				
			}
		});
		
		data.registerGadgetListener(new CrudListener<Gadget>() {

			@Override
			public void changed(MessageData message) {
				System.out.println("test");
				setChanged();
				notifyObservers(message);
			}
		});
		
		data.registerLoanListener(new CrudListener<Loan>() {

			@Override
			public void changed(MessageData message) {
				setChanged();
				notifyObservers(message);
			}
		});
		
		data.registerReservationListener(new CrudListener<Reservation>() {
			
			@Override
			public void changed(MessageData message) {
				setChanged();
				notifyObservers(message);
			}
		});
	}
	
	
	public boolean canLent(Gadget gadget, Customer customer)
	{		
		List<Reservation> reservations = getReservatonFor(gadget, true);
		return getLoansFor(gadget, true).size() == 0 && (reservations.size() == 0 || reservations.get(0).getCustomerId().equals(customer.getStudentNumber()));
	}
	
	
	public void addLoan(Gadget gadget, Customer customer)
	{
		if(canLent(gadget, customer))
		{
			data.addLoan(new Loan(customer, gadget));
			Reservation reservation = getReservatonFor(gadget, customer, true);
			if(reservation !=null)
			{
				reservation.setFinished(true);
				data.updateReservation(reservation);
			}			
		}
		
		setChanged();
		notifyObservers(this);
	}
	
	public List<Loan> getLoansFor(Gadget gadget, boolean onlyLent)
	{	
		if(!onlyLent)
		{
			return data.getLoans().stream().filter(p -> p.getGadgetId().equals(gadget.getInventoryNumber())).collect(Collectors.toList());
		}
		else
		{
			return data.getLoans().stream().filter(p -> p.isLent() &&  p.getGadgetId().equals(gadget.getInventoryNumber())).collect(Collectors.toList());
		}		
	}
	
	public List<Loan> getLoansFor(Customer customer, boolean onlyLent)
	{	
		if(!onlyLent)
		{
			return data.getLoans().stream().filter(p -> p.getCustomerId().equals(customer.getStudentNumber())).collect(Collectors.toList());
		}
		else
		{
			return data.getLoans().stream().filter(p -> p.isLent() &&  p.getCustomerId().equals(customer.getStudentNumber())).collect(Collectors.toList());
		}
	}	
	
	public boolean hasOverdue(Customer customer){
		return getLoansFor(customer, true).stream().anyMatch(p -> p.isOverdue());
	}
	
	public List<Customer> getCustomers() {
		return data.getCustomers();
	}	

	public List<Gadget> getGadgets() {
		return data.getGadgets();
	}
	
	public Gadget getGadget(String id) {
		return data.getGadgets().stream().filter(p->p.getInventoryNumber().equals(id)).findAny().orElse(null);
	}
	
	public Gadget getGadgetByName(String name) {
		return data.getGadgets().stream().filter(p->p.getName().equals(name)).findAny().orElse(null);
	}

	
	public Customer getCustomer(String id) {
		return data.getCustomers().stream().filter(p->p.getStudentNumber().equals(id)).findAny().orElse(null);
	}	
	
	public void addGadget(Gadget gadget) {		
		data.addGadget(gadget);
		setChanged();
		notifyObservers(this);
	}

	public void updateGadget(Gadget gadget) {
		data.updateGadget(gadget);	
		setChanged();
		notifyObservers(this);
	}
	
	public void updateLoan(Loan loan) {
		data.updateLoan(loan);		
		setChanged();
		notifyObservers(this);
	}	

	public void updateReservation(Reservation reservation) {
		data.updateReservation(reservation);		
	}
	
	
	public Reservation getReservatonFor(Gadget gadget, Customer customer, boolean onlyOpen) {

		if(gadget == null || customer == null)
		{
			return null;
		}
		if(!onlyOpen)
		{
			return data.getReservations().stream()
					.filter(p -> p.getGadgetId().equals(gadget.getInventoryNumber()) &&  p.getCustomerId().equals(customer.getStudentNumber()) )
					.sorted((e1, e2) -> e1.getReservationDate().compareTo(e2.getReservationDate())).findAny().orElse(null);
		}
		else
		{
			return data.getReservations().stream()
					.filter(p -> !p.getFinished() && (p.getGadgetId().equals(gadget.getInventoryNumber()) &&   p.getCustomerId().equals(customer.getStudentNumber())))
					.sorted((e1, e2) -> e1.getReservationDate().compareTo(e2.getReservationDate())).findAny().orElse(null);
		}
		
	}
	
	public List<Reservation> getReservatonFor(Gadget gadget, boolean onlyOpen) {

		if(!onlyOpen)
		{
			return data.getReservations().stream().
					filter(p -> p.getGadgetId().equals(gadget.getInventoryNumber())).
					sorted((e1, e2) -> e1.getReservationDate().compareTo(e2.getReservationDate())).collect(Collectors.toList());
		}
		else
		{
			return data.getReservations().stream()
					.filter(p -> !p.getFinished() &&  p.getGadgetId().equals(gadget.getInventoryNumber()))
					.sorted((e1, e2) -> e1.getReservationDate().compareTo(e2.getReservationDate())).collect(Collectors.toList());
		}
		
	}

	public List<Reservation> getReservatonFor(Customer customer, boolean onlyOpen) {

		if(!onlyOpen)
		{
			return data.getReservations().stream()
					.filter(p -> p.getCustomerId().equals(customer.getStudentNumber())).collect(Collectors.toList());
		}
		else
		{
			return data.getReservations().stream()
					.filter(p -> !p.getFinished() &&  p.getCustomerId().equals(customer.getStudentNumber())).collect(Collectors.toList());
		}
		
	}
	
	public void addReservation(Gadget gadget, Customer customer)
	{
		if(canReservation(gadget, customer))
		{
			data.addReservation(new Reservation(customer, gadget));
		}
		
		setChanged();
		notifyObservers(this);
	}
	
	
	public boolean canReservation(Gadget gadget, Customer customer)
	{		
		return getReservatonFor(gadget, customer, true) == null;
	}	
	
	public void update() {
		setChanged();
		notifyObservers(this);
	}
	
	
}
