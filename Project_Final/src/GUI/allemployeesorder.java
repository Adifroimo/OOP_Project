package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Department;
import model.Employee;
import model.Main;
import utils.Color;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class allemployeesorder extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public allemployeesorder() {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(149, 129, 160, 54);
		getContentPane().add(comboBox);
		JButton btnNewButton = new JButton("Click");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(btnNewButton, "Please write a number :)");
				}
				else {
					comboBox.removeAllItems();
					List< Employee> l1= new ArrayList<>();

					
					l1= Main.libr.allEmployees(Integer.valueOf(textField.getText()));
					
						for(Employee ss: l1) {
							comboBox.addItem(ss.getID());
						}
				}
				
			}
		});
		btnNewButton.setBounds(139, 109, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("How many employees?");
		lblNewLabel.setBounds(51, 66, 154, 16);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(233, 61, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		
		

	}

}
