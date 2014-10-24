package control;

import bl.Gadget;
import bl.Library;

public class ToDoSaveGadget {
	
	private Library lib;
	
	public ToDoSaveGadget(Library lib) {
		this.lib = lib;
	}
	
	public void saveGadget(Gadget g) {
		lib.addGadget(g);
	}

}
