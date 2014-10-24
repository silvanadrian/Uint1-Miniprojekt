package view;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import control.ToDoSaveGadget;
import bl.Gadget;
import bl.Gadget.Condition;

public class GadgetDetailNew extends GadgetDetail {
	
	private Gadget g;
	private ToDoSaveGadget tdsg;
	
	public GadgetDetailNew(Gadget g, ToDoSaveGadget tdsg) {
		
		this.g = g;
		this.tdsg = tdsg;
		
		setTitle("Gadget erfassen");
		btnAkzeptieren.setText("Erfassen");
		
		textFieldName.setText(g.getName());
		lblIdText.setText(g.getInventoryNumber());
		
		btnAkzeptieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				g.setName(textFieldName.getText());
				g.setManufacturer(textFieldHersteller.getText());
				g.setPrice(Double.parseDouble(textFieldPreis.getText()));
				g.setCondition((Condition)comboBoxZustand.getSelectedItem());
				
				tdsg.saveGadget(g);
			}
		});
		
		btnAbbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
