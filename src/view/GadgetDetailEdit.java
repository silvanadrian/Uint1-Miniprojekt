package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ToDoEditGadget;
import bl.Gadget;
import bl.Gadget.Condition;

public class GadgetDetailEdit extends GadgetDetail {
	
	Gadget g;
	ToDoEditGadget tdeg;
	
	public GadgetDetailEdit(Gadget g, ToDoEditGadget tdeg) {
		
		this.g = g;
		this.tdeg = tdeg;
		
		setTitle("Gadget editieren");
		btnAkzeptieren.setText("Speichern");
		
		lblIdText.setText(g.getInventoryNumber());
		textFieldName.setText(g.getName());		
		textFieldHersteller.setText(g.getManufacturer());
		textFieldPreis.setText(String.valueOf(g.getPrice()));
		comboBoxZustand.setSelectedIndex(g.getCondition().ordinal());
		
		btnAkzeptieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				g.setName(textFieldName.getText());
				g.setManufacturer(textFieldHersteller.getText());
				g.setPrice(Double.parseDouble(textFieldPreis.getText()));
				g.setCondition((Condition)comboBoxZustand.getSelectedItem());
				
				tdeg.editGadget(g);
			}
		});
		btnAbbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
