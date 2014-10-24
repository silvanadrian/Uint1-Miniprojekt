package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import bl.Customer;
import bl.Gadget;
import bl.Gadget.Condition;
import bl.Library;
import bl.Loan;

public class GadgetTableModel extends AbstractTableModel implements Observer {
	

	
	
	String[] columnNames = {
			"Id", 
			"Name", 
			"Hersteller", 
			"Preis", 
			"Zustand", 
			"Verfügbar ab", 
			"Ausgeliehen an"
	};
	
	Class[] columnClass = {
			Integer.class,
			String.class,
			String.class,
			Integer.class,
			Condition.class,
			Date.class,
			Customer.class
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
	public void update(Observable arg0, Object arg1) {
		Library lib = (Library)arg0;
		values.clear();
		
		
		
		for(Gadget g: lib.getGadgets()) {
			//Alles Mist
			Customer customer = null;
			if(lib.getReservatonFor(g, true).size() > 0) {
				customer = lib.getCustomer(lib.getReservatonFor(g, true).get(0).getCustomerId());
			}
			Date returnDate = null;
			if(lib.getLoansFor(g, true).size() > 0) {
				returnDate = lib.getLoansFor(g, true).get(0).getReturnDate();
			}
			
			values.add(new Object[]{
					g.getInventoryNumber(), 
					g.getName(),
					g.getManufacturer(),
					g.getPrice(),
					g.getCondition(),
					returnDate,
					customer
					//loan.getReturnDate(),
					//loan.getReturnDate()
			});
		}
		fireTableDataChanged();
	}
}
