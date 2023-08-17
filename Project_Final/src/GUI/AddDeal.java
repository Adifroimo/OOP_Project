package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

import model.Car;
import model.Customer;
import model.Deal;
import model.Main;
import model.VehicleTransportation;
import utils.Color;
import utils.Gender;

import javax.swing.JTable;
import javax.swing.JButton;

public class AddDeal extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTable table;
	public AddDeal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CustomerID");
		lblNewLabel_1.setBounds(22, 36, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("shippingCost");
		lblNewLabel_3.setBounds(22, 61, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1= new JTextField();
		textField_1.setBounds(113, 33, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 61, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	
		
		JLabel lblNewLabel_7 = new JLabel("Add a vehicle");
		lblNewLabel_7.setBounds(229, 11, 96, 14);
		contentPane.add(lblNewLabel_7);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("");
		comboBox.setBounds(239, 33, 181, 22);
		for(VehicleTransportation v: Main.libr.getAllVehicleTransportation().values()) {
			comboBox.addItem(v.getLicensePlate());
		}

		

		contentPane.add(comboBox);
		
		table = new JTable();
		table.setBounds(410, 185, -117, -85);
		contentPane.add(table);
		//s
		JLabel lblNewLabel_5 = new JLabel("your car has been added to the deal!");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setBounds(171, 108, 273, 65);
		contentPane.add(lblNewLabel_5);
		HashSet<VehicleTransportation> c= new HashSet<>();
		JButton btnNewButton = new JButton("Add car to deal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equals("")||textField_3.getText().equals("")||comboBox.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton, "alert", "alert", JOptionPane.ERROR_MESSAGE);
				}
				else {
				String mycar= (String) comboBox.getSelectedItem();
				c.add(Main.libr.getAllVehicleTransportation().get(mycar));
				lblNewLabel_5.setVisible(true);
					}
			}
		});
		btnNewButton.setBounds(249, 71, 127, 29);
		contentPane.add(btnNewButton);


		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equals("")||textField_3.getText().equals("")||comboBox.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton_1, "alert", "alert", JOptionPane.ERROR_MESSAGE);
				}
				else if (Main.libr.getRealCustomer(textField_1.getText())==null) {
				JOptionPane.showMessageDialog(btnNewButton, "Customer not exist", "Customer not exist", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Customer customer = Main.libr.getAllCustomers().get(textField_1.getText());
					Deal d1= new Deal(customer,LocalDateTime.now(),c,Integer.parseInt(textField_3.getText()));
					Main.libr.addDeal(d1);
					JOptionPane.showMessageDialog(btnNewButton_1, "Deal added "+ d1.getDealID()+" is deal id");
				}

			}
		});
		btnNewButton_1.setBounds(156, 168, 106, 20);
		contentPane.add(btnNewButton_1);
		
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		
	}
}
