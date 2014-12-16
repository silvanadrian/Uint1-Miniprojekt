package editor;

import javax.swing.JCheckBox;
import javax.swing.JTable;

import bl.Library;
import model.LoanTableModel;
import model.ReservationTableModel;
import control.ToDoDeleteReservation;
import control.ToDoReturnGadget;

public class ReturnButtonEditor extends ButtonEditor {
	
	private ToDoReturnGadget rg;
	private LoanTableModel ltm;
	private JTable table;
	private Library lib;

	public ReturnButtonEditor(JCheckBox checkBox, ToDoReturnGadget rg, LoanTableModel ltm, JTable table, Library lib) {
		super(checkBox);
		this.rg = rg;
		this.ltm = ltm;
		this.table = table;
		this.lib = lib;
		// TODO Auto-generated constructor stub
	}
	
	public void clicked() {
		rg.returnGadget(ltm.getCustomer(), (String)ltm.getValueAt(table.getSelectedRow(), 0));
	}
}