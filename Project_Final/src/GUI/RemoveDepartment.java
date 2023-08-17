package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Car;
import model.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveDepartment extends JInternalFrame {
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
	public RemoveDepartment() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(218, 86, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.libr.getAllDepartments().containsKey(Integer.parseInt(textField.getText()))) {
					Main.libr.removeDepartment(Main.libr.getAllDepartments().get(Integer.parseInt(textField.getText())));
					JOptionPane.showMessageDialog(btnNewButton, "Department "+textField.getText() +"is Removed");
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Department Not in the system!");
				}
			}
		});
		btnNewButton.setBounds(145, 164, 117, 29);
		getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("Department's ID");
		lblNewLabel.setBounds(52, 91, 130, 16);
		getContentPane().add(lblNewLabel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		
		
		
	}
}
