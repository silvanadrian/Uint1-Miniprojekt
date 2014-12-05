package view;


import java.awt.EventQueue;
















import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;

import renderer.ButtonRenderer;
import control.ToDoDeleteReservation;
import control.ToDoEditGadget;
import control.ToDoLoanReservation;
import control.ToDoReturnGadget;
import control.ToDoSaveGadget;
import dl.CrudListener;
import dl.LibraryData;
import dl.LocalLibrary;
import editor.ButtonEditor;
import editor.DeleteButtonEditor;
import editor.LoanButtonEditor;
import editor.ReturnButtonEditor;
import bl.Customer;
import bl.Gadget;
import bl.Library;
import bl.Loan;
import bl.Reservation;
import model.CustomerTableModel;
import model.GadgetTableModel;
import model.LoanTableModel;
import model.LoanTextModel;
import model.ReservationTableModel;
import model.ReservationTextModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import junit.runner.Sorter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GadgetMasterView {

	public JFrame frame; //evtl auf private setzen
	private JTextField textField;
	private JTable table;
	private JTextField txtSuche;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_2;
	private JTable table_3;
	private JTextField textField_1;
	private Library library = new Library(new LocalLibrary());
	
	private JButton btnNewButton;
	
	private TableRowSorter<GadgetTableModel> gadgetSorter;
	private TableRowSorter<CustomerTableModel> customerSorter;
	private TableRowSorter<ReservationTableModel> reservationSorter;
	private TableRowSorter<LoanTableModel> loanSorter;
	
	private ReservationTableModel rtm = new ReservationTableModel();
	private LoanTableModel ltm = new LoanTableModel();
	
	private ReservationTextModel rtextm;
	private LoanTextModel ltextm;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GadgetMasterView window = new GadgetMasterView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public GadgetMasterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gadget Biblio");
		frame.setBounds(100, 100, 852, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		
		tabbedPane.addTab("Gadgets", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_3 = new JPanel();
		
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				RowFilter<GadgetTableModel, Object> rf = null;
			    rf = RowFilter.regexFilter(textField.getText());
			    gadgetSorter.setRowFilter(rf);
			    table.repaint();
			}
		});
		
		panel_3.add(textField);
		textField.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel_3.add(horizontalStrut);
		
		btnNewButton = new JButton("Gadget erfassen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GadgetDetailNew gdn = new GadgetDetailNew(new bl.Gadget(), new ToDoSaveGadget(library));
							gdn.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panel_3.add(btnNewButton);
		panel_1.getRootPane().setDefaultButton(btnNewButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		panel_3.add(horizontalStrut_1);
		
		JButton btnNewButton_1 = new JButton("Gadget editieren");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GadgetDetailEdit gde = new GadgetDetailEdit(library.getGadget((String)table.getValueAt(table.getSelectedRow(), 0)), new ToDoEditGadget(library) );
							gde.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panel_3.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnNewButton_1.setEnabled(true);
			}
		});
		{
			GadgetTableModel gtm = new GadgetTableModel();
			library.addObserver(gtm);
			table.setModel(gtm);
			gadgetSorter = new TableRowSorter<GadgetTableModel>(gtm);
			table.setRowSorter(gadgetSorter);
			gtm.update(library, null);
			//table.setAutoCreateRowSorter(true);
		}
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ausleihen & R\u00FCckgabe", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {100, 0, 0};
		gbl_panel_2.rowHeights = new int[] {0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_2.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		txtSuche = new JTextField();
		txtSuche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				RowFilter<CustomerTableModel, Object> rf = null;
			    rf = RowFilter.regexFilter(txtSuche.getText());
			    customerSorter.setRowFilter(rf);
			    table.repaint();
			}
		});
		panel_6.add(txtSuche);
		txtSuche.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rtm.setCustomer(library.getCustomer((String)table_1.getValueAt(table_1.getSelectedRow(), 0)));
				ltm.setCustomer(library.getCustomer((String)table_1.getValueAt(table_1.getSelectedRow(), 0)));
				rtm.update(library, null);
				ltm.update(library, null);
				rtextm.update(library, null);
				ltextm.update(library, null);
			}
		});
		
		{
			CustomerTableModel ctm = new CustomerTableModel();
			library.addObserver(ctm);
			table_1.setModel(ctm);
			customerSorter = new TableRowSorter<CustomerTableModel>(ctm);
			table_1.setRowSorter(customerSorter);
			ctm.update(library, null);
		}
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_16 = new JPanel();
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 1;
		gbc_panel_16.gridy = 1;
		panel_2.add(panel_16, gbc_panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_16.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JLabel reservationLabel = new JLabel("Reservation (x von y)");
		panel_5.add(reservationLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panel_4.add(scrollPane_2, gbc_scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rtm.update(library, null);
			}
		});
		
		{
			//table_2.getColumn("Ausleihen").setCellRenderer(); 
			library.addObserver(rtm);
			table_2.setModel(rtm);
			table_2.setEditingColumn(3);
			//table_2.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer());
			//table_2.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
			table_2.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
			table_2.getColumnModel().getColumn(3).setCellEditor(new DeleteButtonEditor(new JCheckBox(), new ToDoDeleteReservation(library), rtm, table_2));
			table_2.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
			table_2.getColumnModel().getColumn(2).setCellEditor(new LoanButtonEditor(new JCheckBox(), new ToDoLoanReservation(library), rtm, table_2));
			reservationSorter = new TableRowSorter<ReservationTableModel>(rtm);
			table_2.setRowSorter(reservationSorter);
			rtm.update(library, null);
		}
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 2;
		panel_4.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JLabel lblNeue = new JLabel("Neue Reservation");
		panel_8.add(lblNeue);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 3;
		panel_4.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		JLabel lblId = new JLabel("Id");
		panel_9.add(lblId);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_9.add(horizontalStrut_2);
		
		textField_2 = new JTextField();
		panel_9.add(textField_2);
		textField_2.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_9.add(horizontalStrut_3);
		
		JButton btnNewButton_2 = new JButton("Reservation");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					library.addReservation(library.getGadget(textField_2.getText()), rtm.getCustomer());
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Ihre Eingabe ist nicht korrekt.");
				}
				
			}
		});
		panel_9.add(btnNewButton_2);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_9.add(horizontalStrut_6);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 4;
		panel_4.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JLabel reservationInfo = new JLabel("Reservation");
		panel_10.add(reservationInfo);
		
		rtextm = new ReservationTextModel(reservationLabel, reservationInfo, rtm);
		library.addObserver(rtextm);
		//rtextm.update(library, null);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 5;
		panel_4.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 6;
		panel_4.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		JLabel loanLabel = new JLabel("Ausleihen (x von y)");
		panel_11.add(loanLabel);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 7;
		panel_4.add(scrollPane_3, gbc_scrollPane_3);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rtm.update(library, null);
			}
		});
		{
			library.addObserver(ltm);
			table_3.setModel(ltm);
			table_3.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
			table_3.getColumnModel().getColumn(5).setCellEditor(new ReturnButtonEditor(new JCheckBox(), new ToDoReturnGadget(library), ltm, table_3, library));
			loanSorter = new TableRowSorter<LoanTableModel>(ltm);
			table_3.setRowSorter(loanSorter);
			ltm.update(library, null);
		}
		scrollPane_3.setViewportView(table_3);
		
		JPanel panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 8;
		panel_4.add(panel_13, gbc_panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		JLabel loanText = new JLabel("Neue Ausleihe");
		panel_13.add(loanText);
		
		
		
		JPanel panel_14 = new JPanel();
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(0, 0, 5, 0);
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.gridx = 0;
		gbc_panel_14.gridy = 9;
		panel_4.add(panel_14, gbc_panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
		
		JLabel lblId_1 = new JLabel("Id");
		panel_14.add(lblId_1);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_14.add(horizontalStrut_4);
		
		textField_1 = new JTextField();
		panel_14.add(textField_1);
		textField_1.setColumns(10);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_14.add(horizontalStrut_5);
		
		JButton btnNewButton_3 = new JButton("Ausleihen");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					library.addLoan(library.getGadget(textField_1.getText()), rtm.getCustomer());
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Ihre Eingabe ist nicht korrekt.");
				}
				
				
			}
		});
		panel_14.add(btnNewButton_3);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_14.add(horizontalStrut_7);
		
		JPanel panel_15 = new JPanel();
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 0;
		gbc_panel_15.gridy = 10;
		panel_4.add(panel_15, gbc_panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
		
		JLabel lblKeineAusleiheMglich = new JLabel("Ausleihe");
		panel_15.add(lblKeineAusleiheMglich);
		
		ltextm = new LoanTextModel(loanLabel, lblKeineAusleiheMglich, ltm);
		library.addObserver(ltextm);
		
		frame.setMinimumSize(new Dimension(800, 400));
		frame.setSize(new Dimension(1200, 500));
	}
}
