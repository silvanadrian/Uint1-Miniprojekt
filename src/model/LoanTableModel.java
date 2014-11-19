package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.table.AbstractTableModel;

import bl.Customer;
import bl.Gadget;
import bl.Library;
import bl.Loan;
import bl.Reservation;

public class LoanTableModel extends AbstractTableModel implements Observer {
	
	private Customer customer;
	
	String[] columnNames = {
			"Name",
			"Ausgeliehen am",
			"Zurück bis",
			"Fällig",
			"Reserviert",
			"Rücknahme"
	};
	
	Class[] columnClass = {
			String.class,
			Date.class,
			Date.class,
			Boolean.class,
			Boolean.class,
			String.class
	};
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	ArrayList<Object[]> values = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return values.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return values.get(rowIndex)[columnIndex];
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		if(customer != null) {
			Library lib = (Library)o;
			values.clear();
		
			for(Loan loan:lib.getLoansFor(customer, true)) {
				values.add(new Object[]{
						lib.getGadget(loan.getGadgetId()).getName(),
						loan.getPickupDate(),
						loan.getReturnDate(),
						null,
						lib.getReservatonFor((lib.getGadget(loan.getGadgetId())), true).size() > 0,
						"Rückgabe"
				});
			}
		}
		
		
		fireTableDataChanged();
	
	}

}
