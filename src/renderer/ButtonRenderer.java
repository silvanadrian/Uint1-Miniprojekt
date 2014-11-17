package renderer;

import java.awt.Component;

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
		 return button;
	}
}
