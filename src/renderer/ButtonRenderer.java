package renderer;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer implements TableCellRenderer {
	
	private JButton button = new JButton();

	@Override
	 public Component getTableCellRendererComponent( JTable table,
													 Object value,
													 boolean isSelected,
													 boolean hasFocus,
													 int row, int column) {
		if("Nein".compareTo((String)value) == 0) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
			
		 button.setText(value.toString());
		 button.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
                System.out.println("clicked");
             }
         });
		 return button;
	}
}
