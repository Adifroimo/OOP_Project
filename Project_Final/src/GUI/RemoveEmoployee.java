package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import Exceptions.PersonNotExistException;
import model.Car;
import model.DepartmentManager;
import model.Employee;
import model.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveEmoployee extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public RemoveEmoployee() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(218, 86, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.libr.getAllEmployees().containsKey(textField.getText())) { 
					if(Main.libr.getAllEmployees().get(textField.getText()) instanceof DepartmentManager) {
						try {
							Main.libr.removeDepartmentManager((DepartmentManager) Main.libr.getAllEmployees().get(textField.getText()));
						} catch (PersonNotExistException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(btnNewButton, "Department Manager"+textField.getText() +" is Removed");
					}
					else if(Main.libr.getAllEmployees().containsKey(textField.getText())) {
					try {
						Main.libr.removeEmployee(Main.libr.getAllEmployees().get(textField.getText()));
					} catch (PersonNotExistException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(btnNewButton, "Employee "+textField.getText() +" is Removed");
					}
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Employee Not in the system!");
			}
		}
		});
		btnNewButton.setBounds(145, 164, 117, 29);
		getContentPane().add(btnNewButton);
		
		
		
		JLabel lblNewLabel = new JLabel("Employee's ID");
		lblNewLabel.setBounds(52, 91, 130, 16);
		getContentPane().add(lblNewLabel);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		
	}
}
