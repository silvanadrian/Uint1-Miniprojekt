package view;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bl.Gadget;

public class GadgetDetailNew extends GadgetDetail {
	
	private Gadget g;
	
	public GadgetDetailNew(Gadget g) {
		
		this.g = g;
		setTitle("Gadget erfassen");
		btnAkzeptieren.setText("Erfassen");
		
		
		btnAbbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		textFieldName.setText(g.getName());
		lblIdText.setText(g.getInventoryNumber());
		
		
		//doppelter code, verschieben in gadgetdetail
		/*
		pack();
		setMinimumSize(getSize());
		Dimension d = getSize();
		d.width += 100;
		setSize(d);
		*/
	}

}
