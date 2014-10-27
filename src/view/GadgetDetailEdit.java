package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GadgetDetailEdit extends GadgetDetail {
	
	public GadgetDetailEdit() {
		setTitle("Gadget editieren");
		btnAkzeptieren.setText("Speichern");
		btnAbbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
