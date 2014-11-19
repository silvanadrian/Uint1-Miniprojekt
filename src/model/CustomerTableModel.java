package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

import bl.Customer;
import bl.Gadget.Condition;
import bl.Library;
import bl.Loan;
import bl.Reservation;

@SuppressWarnings("serial")
public class CustomerTableModel extends AbstractTableModel implements Observer {
	
	String[] columnNames = {
			"KundenID", 
			"Name", 
			"Reservationen", 
			"Ausleihen", 
			"Hat Überfällige"
	};
	
	Class[] columnClass = {
			Integer.class,
			String.class,
			String.class,
			String.class,
			Boolean.class
	};
	
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
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Library lib = (Library) arg0;
		values.clear();
		boolean hatUeberfaellige = false;
		
		
		for(Customer customer: lib.getCustomers()) {
			StringBuilder sbr = new StringBuilder();
			for(Reservation res: lib.getReservatonFor(customer, true)) {
				sbr.append(lib.getGadget(res.getGadgetId()).getName());
				sbr.append(", ");
			}
			if(sbr.length() > 0) {
				sbr.deleteCharAt(sbr.length()-2);
				hatUeberfaellige = true;
			}
				
			
			StringBuilder sbl = new StringBuilder();
			for(Loan l: lib.getLoansFor(customer, true)) {
				sbl.append(lib.getGadget(l.getGadgetId()).getName());
				sbl.append(", ");
			}
			if(sbl.length() > 0)
				sbl.deleteCharAt(sbl.length()-2);
			
			
			
			values.add(new Object[]{
					customer.getStudentNumber(),
					customer.getName(),
					sbr.toString(),
					sbl.toString(),
					hatUeberfaellige
			});
		}
		fireTableDataChanged();
		
	}

}
