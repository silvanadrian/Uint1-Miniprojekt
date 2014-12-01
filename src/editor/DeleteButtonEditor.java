package editor;

import javax.swing.JCheckBox;
import javax.swing.JTable;

import model.ReservationTableModel;
import control.ToDoDeleteReservation;
import bl.Library;

public class DeleteButtonEditor extends ButtonEditor {
	
	private ToDoDeleteReservation dr;
	private ReservationTableModel rtm;
	private JTable table;

	public DeleteButtonEditor(JCheckBox checkBox, ToDoDeleteReservation dr, ReservationTableModel rtm, JTable table) {
		super(checkBox);
		this.dr = dr;
		this.rtm = rtm;
		this.table = table;
		// TODO Auto-generated constructor stub
	}
	
	public void clicked() {
		dr.deleteReservation((String)rtm.getValueAt(table.getSelectedRow(), 0) , rtm.getCustomer());
	}

}
