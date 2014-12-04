package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;

import javax.swing.JComboBox;

import bl.Gadget;

//Muss am Ende noch abstract gemacht werden.
public class GadgetDetail extends JDialog {

	private JPanel contentPane;
	
	protected JTextField textFieldName;
	protected JTextField textFieldHersteller;
	protected JTextField textFieldPreis;
	protected JComboBox comboBoxZustand;
	
	protected JLabel lblIdText;
	
	protected JButton btnAbbruch;
	protected JButton btnAkzeptieren;

	public GadgetDetail() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelLabelId = new JPanel();
		GridBagConstraints gbc_panelLabelId = new GridBagConstraints();
		gbc_panelLabelId.insets = new Insets(0, 0, 5, 5);
		gbc_panelLabelId.fill = GridBagConstraints.BOTH;
		gbc_panelLabelId.gridx = 0;
		gbc_panelLabelId.gridy = 0;
		contentPane.add(panelLabelId, gbc_panelLabelId);
		panelLabelId.setLayout(new BoxLayout(panelLabelId, BoxLayout.X_AXIS));
		
		JLabel lblId = new JLabel("Id");
		panelLabelId.add(lblId);
		
		JPanel panelTextId = new JPanel();
		GridBagConstraints gbc_panelTextId = new GridBagConstraints();
		gbc_panelTextId.insets = new Insets(0, 0, 5, 0);
		gbc_panelTextId.fill = GridBagConstraints.BOTH;
		gbc_panelTextId.gridx = 1;
		gbc_panelTextId.gridy = 0;
		contentPane.add(panelTextId, gbc_panelTextId);
		panelTextId.setLayout(new BoxLayout(panelTextId, BoxLayout.X_AXIS));
		
		lblIdText = new JLabel("0");
		panelTextId.add(lblIdText);
		
		JPanel panelLabelName = new JPanel();
		GridBagConstraints gbc_panelLabelName = new GridBagConstraints();
		gbc_panelLabelName.insets = new Insets(0, 0, 5, 5);
		gbc_panelLabelName.fill = GridBagConstraints.BOTH;
		gbc_panelLabelName.gridx = 0;
		gbc_panelLabelName.gridy = 1;
		contentPane.add(panelLabelName, gbc_panelLabelName);
		panelLabelName.setLayout(new BoxLayout(panelLabelName, BoxLayout.X_AXIS));
		
		JLabel lblName = new JLabel("Name");
		panelLabelName.add(lblName);
		
		JPanel panelTextName = new JPanel();
		GridBagConstraints gbc_panelTextName = new GridBagConstraints();
		gbc_panelTextName.insets = new Insets(0, 0, 5, 0);
		gbc_panelTextName.fill = GridBagConstraints.BOTH;
		gbc_panelTextName.gridx = 1;
		gbc_panelTextName.gridy = 1;
		contentPane.add(panelTextName, gbc_panelTextName);
		panelTextName.setLayout(new BoxLayout(panelTextName, BoxLayout.X_AXIS));
		
		textFieldName = new JTextField();
		panelTextName.add(textFieldName);
		textFieldName.setColumns(10);
		
		JPanel panelLabelHersteller = new JPanel();
		GridBagConstraints gbc_panelLabelHersteller = new GridBagConstraints();
		gbc_panelLabelHersteller.insets = new Insets(0, 0, 5, 5);
		gbc_panelLabelHersteller.fill = GridBagConstraints.BOTH;
		gbc_panelLabelHersteller.gridx = 0;
		gbc_panelLabelHersteller.gridy = 2;
		contentPane.add(panelLabelHersteller, gbc_panelLabelHersteller);
		panelLabelHersteller.setLayout(new BoxLayout(panelLabelHersteller, BoxLayout.X_AXIS));
		
		JLabel lblHersteller = new JLabel("Hersteller");
		panelLabelHersteller.add(lblHersteller);
		
		JPanel panelTextHersteller = new JPanel();
		GridBagConstraints gbc_panelTextHersteller = new GridBagConstraints();
		gbc_panelTextHersteller.insets = new Insets(0, 0, 5, 0);
		gbc_panelTextHersteller.fill = GridBagConstraints.BOTH;
		gbc_panelTextHersteller.gridx = 1;
		gbc_panelTextHersteller.gridy = 2;
		contentPane.add(panelTextHersteller, gbc_panelTextHersteller);
		panelTextHersteller.setLayout(new BoxLayout(panelTextHersteller, BoxLayout.X_AXIS));
		
		textFieldHersteller = new JTextField();
		panelTextHersteller.add(textFieldHersteller);
		textFieldHersteller.setColumns(10);
		
		JPanel panelLabelPreis = new JPanel();
		GridBagConstraints gbc_panelLabelPreis = new GridBagConstraints();
		gbc_panelLabelPreis.insets = new Insets(0, 0, 5, 5);
		gbc_panelLabelPreis.fill = GridBagConstraints.BOTH;
		gbc_panelLabelPreis.gridx = 0;
		gbc_panelLabelPreis.gridy = 3;
		contentPane.add(panelLabelPreis, gbc_panelLabelPreis);
		panelLabelPreis.setLayout(new BoxLayout(panelLabelPreis, BoxLayout.X_AXIS));
		
		JLabel lblPreis = new JLabel("Preis");
		panelLabelPreis.add(lblPreis);
		
		JPanel panelTextPreis = new JPanel();
		GridBagConstraints gbc_panelTextPreis = new GridBagConstraints();
		gbc_panelTextPreis.insets = new Insets(0, 0, 5, 0);
		gbc_panelTextPreis.fill = GridBagConstraints.BOTH;
		gbc_panelTextPreis.gridx = 1;
		gbc_panelTextPreis.gridy = 3;
		contentPane.add(panelTextPreis, gbc_panelTextPreis);
		panelTextPreis.setLayout(new BoxLayout(panelTextPreis, BoxLayout.X_AXIS));
		
		textFieldPreis = new JTextField();
		panelTextPreis.add(textFieldPreis);
		textFieldPreis.setColumns(10);
		
		JPanel panelLabelZustand = new JPanel();
		GridBagConstraints gbc_panelLabelZustand = new GridBagConstraints();
		gbc_panelLabelZustand.insets = new Insets(0, 0, 5, 5);
		gbc_panelLabelZustand.fill = GridBagConstraints.BOTH;
		gbc_panelLabelZustand.gridx = 0;
		gbc_panelLabelZustand.gridy = 4;
		contentPane.add(panelLabelZustand, gbc_panelLabelZustand);
		panelLabelZustand.setLayout(new BoxLayout(panelLabelZustand, BoxLayout.X_AXIS));
		
		JLabel lblZustand = new JLabel("Zustand");
		panelLabelZustand.add(lblZustand);
		
		JPanel panelTextZustand = new JPanel();
		GridBagConstraints gbc_panelTextZustand = new GridBagConstraints();
		gbc_panelTextZustand.insets = new Insets(0, 0, 5, 0);
		gbc_panelTextZustand.fill = GridBagConstraints.BOTH;
		gbc_panelTextZustand.gridx = 1;
		gbc_panelTextZustand.gridy = 4;
		contentPane.add(panelTextZustand, gbc_panelTextZustand);
		panelTextZustand.setLayout(new BoxLayout(panelTextZustand, BoxLayout.X_AXIS));
		
		comboBoxZustand = new JComboBox(Gadget.Condition.values());
		panelTextZustand.add(comboBoxZustand);
		
		JPanel panelButtons = new JPanel();
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panelButtons.gridwidth = 2;
		gbc_panelButtons.insets = new Insets(0, 0, 0, 5);
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 5;
		contentPane.add(panelButtons, gbc_panelButtons);
		
		btnAbbruch = new JButton("Abbruch");
		
		panelButtons.add(btnAbbruch);
		
		btnAkzeptieren = new JButton("New button");
		panelButtons.add(btnAkzeptieren);
		
		contentPane.getRootPane().setDefaultButton(btnAkzeptieren);
		
		
		pack();
		setMinimumSize(getSize());
		Dimension d = getSize();
		d.width += 100;
		setSize(d);
	}

}
