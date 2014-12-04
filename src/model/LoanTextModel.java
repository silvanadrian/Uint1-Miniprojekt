package model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import bl.Library;

public class LoanTextModel implements Observer {
	
	private JLabel loanLabel;
	private JLabel loanText;
	private LoanTableModel ltm;
	
	public LoanTextModel(JLabel loanLabel, JLabel loanText, LoanTableModel ltm) {
		this.loanLabel = loanLabel;
		this.loanText = loanText;
		this.ltm = ltm;
	}

	@Override
	public void update(Observable o, Object arg) {
		Library lib = (Library) o;
		
		if(ltm.getCustomer() == null)
			return;
		
		int loan = lib.getLoansFor(ltm.getCustomer(), true).size();
		loanLabel.setText("Ausleihen ( " + loan + " von 3)");
		
		if(lib.getLoansFor(ltm.getCustomer(), true).size() >= 3) {
			loanText.setText("Keine Ausleihen möglich");
		} else {
			loanText.setText("Ausleihen möglich");
		}
	}
}
