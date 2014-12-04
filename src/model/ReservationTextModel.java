package model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import bl.Library;

public class ReservationTextModel implements Observer{
	
	private JLabel label1;
	private JLabel label2;
	private ReservationTableModel rtm;
	//private Library lib;

	public ReservationTextModel(JLabel reservationLabel, JLabel reservationInfo, ReservationTableModel rtm) {
		this.label1 = reservationLabel;
		this.label2 = reservationInfo;
		this.rtm = rtm;
	}

	@Override
	public void update(Observable o, Object arg) {
		Library lib = (Library) o;
		
		if(rtm.getCustomer() == null)
			return;
		
		int res = lib.getReservatonFor(rtm.getCustomer(), true).size();
		label1.setText("Reservationen ( "+ res + " von 3)");
		
		if(lib.getReservatonFor(rtm.getCustomer(), true).size() >= 3) {
			label2.setText("Keine Reservationen möglich");
		} else {
			label2.setText("Reservationen möglich");
		}
		
		
	}
	
	
}
