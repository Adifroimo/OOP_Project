package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import Exceptions.PersonNotExistException;
import model.Car;
import model.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Remove_Customer extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Remove_Customer() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(218, 86, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.libr.getAllCustomers().containsKey(textField.getText())) {
					try {
						Main.libr.removeCustomer(Main.libr.getAllCustomers().get(textField.getText()));
					} catch (PersonNotExistException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(btnNewButton, "Customer "+textField.getText() +" is Removed");
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Customer Not in the system!");

				}
			}
		});
		btnNewButton.setBounds(145, 164, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Customer's ID");
		lblNewLabel.setBounds(52, 91, 130, 16);
		getContentPane().add(lblNewLabel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
	}
}
