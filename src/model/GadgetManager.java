package model;

import java.util.Observable;

public class GadgetManager extends Observable {
	
	private static GadgetManager gm = null;
	
	private GadgetManager(){};
	public static GadgetManager getInstance() {
		if(gm == null) 
			gm = new GadgetManager();
		return gm;
	}
	
	
}
