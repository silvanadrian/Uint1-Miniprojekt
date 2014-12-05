
 

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.GadgetMasterView;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException
    { 
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		GadgetMasterView window = new GadgetMasterView();
		window.frame.setVisible(true);
    }
}
