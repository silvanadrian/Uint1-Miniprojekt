package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import bl.Gadget;
import bl.Gadget.Condition;
import bl.Library;
import bl.Loan;

public class GadgetTableModel extends AbstractTableModel implements Observer {
	
	
	/*public GadgetTableModel(Library library) {
		update(library, null);
	}*/
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
			Date.class
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
		
		for(Gadget g: lib.getGadgets()) {
			//Loan loan = lib.getLoansFor(g, false);
			values.add(new Object[]{
					g.getInventoryNumber(), 
					g.getName(),
					g.getManufacturer(),
					g.getPrice(),
					g.getCondition()
					//loan.getReturnDate(),
					//loan.getReturnDate()
			});
		}
		
	}

}
