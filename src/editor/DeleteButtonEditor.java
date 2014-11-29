package editor;

import javax.swing.JCheckBox;

import control.ToDoDeleteReservation;
import bl.Library;

public class DeleteButtonEditor extends ButtonEditor {
	
	private ToDoDeleteReservation dr;

	public DeleteButtonEditor(JCheckBox checkBox, ToDoDeleteReservation dr) {
		super(checkBox);
		this.dr = dr;
		// TODO Auto-generated constructor stub
	}
	
	public void clicked() {
		dr.deleteReservation();
	}

}
