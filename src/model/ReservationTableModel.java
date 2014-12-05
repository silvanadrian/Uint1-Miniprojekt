package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import bl.Customer;
import bl.Gadget;
import bl.Library;
import bl.Gadget.Condition;
import bl.Reservation;

public class ReservationTableModel extends AbstractTableModel implements Observer {
	
	private Customer customer;
	
	String[] columnNames = {
			"Name",
			"Warteschlange",
			"Ausleihen",
			"Löschen"
	};
	
	Class[] columnClass = {
			String.class,
			Integer.class,
			String.class,
			String.class
	};
	
	
	ArrayList<Object[]> values = new ArrayList<>();
	
	
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

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
		// TODO Auto-generated method stub
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 3)
			return true;
		if(columnIndex == 2)
			if( ((String)values.get(rowIndex)[2]).compareTo("Ja") == 0)
				return true;
		return false;
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		if(customer != null) {
			Library lib = (Library)o;
			values.clear();
			
			
			
			for(Reservation res: lib.getReservatonFor(customer, true)) {
				
				Gadget g = lib.getGadget(res.getGadgetId());
				
				values.add(new Object[]{
					g.getName(),
					lib.getReservatonFor(g, true).indexOf(lib.getReservatonFor(g, customer, true))+1,//lib.getReservatonFor(g, true).size(),
					lib.getLoansFor(g, true).size() > 0 ? "Nein" : "Ja",
					"Löschen"
				});
			}
			
		}
		fireTableDataChanged();
	
	}

}
