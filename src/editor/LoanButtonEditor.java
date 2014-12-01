package editor;

import javax.swing.JCheckBox;
import javax.swing.JTable;

import model.LoanTableModel;
import model.ReservationTableModel;
import control.ToDoLoanReservation;

public class LoanButtonEditor extends ButtonEditor {
	
	private JTable table;
	private ToDoLoanReservation lr;
	private ReservationTableModel ltm;

	public LoanButtonEditor(JCheckBox checkBox, ToDoLoanReservation lr, ReservationTableModel ltm, JTable table) {
		super(checkBox);
		this.table = table;
		this.lr = lr;
		this.ltm = ltm;
		// TODO Auto-generated constructor stub
	}
	
	public void clicked() {
		lr.loanReservation((String)ltm.getValueAt(table.getSelectedRow(), 0),ltm.getCustomer());
	}

}
