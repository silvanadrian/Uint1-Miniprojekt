package editor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    JButton button;
    String txt;

    public ButtonEditor() {
        super();
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buttontext: " + button.getText());
            }
        });
    }

    public Object getCellEditorValue() {
        return null;
    }

    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    public boolean shouldSelectCell(EventObject anEvent) {
        return false;
    }

    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    public void cancelCellEditing() {
    }

    public void addCellEditorListener(CellEditorListener l) {
    }

    public void removeCellEditorListener(CellEditorListener l) {
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        txt = (value == null) ? "" : value.toString();
        button.setText(txt);
        return button;
    }
} 