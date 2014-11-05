package control;

import bl.Gadget;
import bl.Library;

public class ToDoEditGadget {
	
	private Library lib;
	
	public ToDoEditGadget(Library lib) {
		this.lib = lib;
	}

	public void editGadget(Gadget g) {
		lib.updateGadget(new Gadget());
	}
}