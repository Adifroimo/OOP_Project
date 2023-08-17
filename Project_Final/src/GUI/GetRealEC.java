package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Main;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class GetRealEC extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GetRealEC() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter ID");
		lblNewLabel.setBounds(39, 67, 177, 16);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(182, 62, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblNewLabel_1.setBounds(6, 99, 414, 107);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		JButton btnNewButton = new JButton("Info");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("VIPCustomer");
		rdbtnNewRadioButton.setBounds(6, 116, 141, 23);
		getContentPane().add(rdbtnNewRadioButton);
		btnNewButton.setBounds(133, 160, 117, 29);
		getContentPane().add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Customer");
		rdbtnNewRadioButton_1.setBounds(6, 94, 141, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Employee");
		rdbtnNewRadioButton_2.setBounds(238, 95, 141, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Department Manager");
		rdbtnNewRadioButton_3.setBounds(243, 116, 177, 23);
		getContentPane().add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Select only 1 dot!");
		lblNewLabel_2.setBounds(39, 6, 319, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("minimum 1!");
		lblNewLabel_3.setBounds(39, 22, 108, 16);
		getContentPane().add(lblNewLabel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(rdbtnNewRadioButton, "text is empty!");
				}
				else {
					if(rdbtnNewRadioButton_1.isSelected()&&!rdbtnNewRadioButton.isSelected()) {
						if(Main.libr.getRealCustomer(textField.getText())!=null){
							lblNewLabel_1.setText(Main.libr.getRealCustomer(textField.getText()).toString());
							lblNewLabel_1.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(rdbtnNewRadioButton, "Customer not exist!");
						}
					}
						else if (rdbtnNewRadioButton_1.isSelected()&&rdbtnNewRadioButton.isSelected()) {
							if(Main.libr.getRealVIPCustomer(textField.getText())!=null){
							lblNewLabel_1.setText(Main.libr.getRealVIPCustomer(textField.getText()).toString());
							lblNewLabel_1.setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(rdbtnNewRadioButton, "Vip Customer not exist!");
							}
						}
						else if (rdbtnNewRadioButton_2.isSelected()&&!rdbtnNewRadioButton_3.isSelected()) {
							if(Main.libr.getRealEmployee(textField.getText())!=null){
							lblNewLabel_1.setText(Main.libr.getRealEmployee(textField.getText()).toString());
							
							lblNewLabel_1.setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(rdbtnNewRadioButton, "Employee not exist!");
							}
						}
						else if(rdbtnNewRadioButton_2.isSelected()&&rdbtnNewRadioButton_3.isSelected()) {
							if(Main.libr.getRealDepartmentManager(textField.getText())!=null) {
							lblNewLabel_1.setText(Main.libr.getRealDepartmentManager(textField.getText()).toString());
							lblNewLabel_1.setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(rdbtnNewRadioButton, "DepartmentManager not exist!");
							}
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton, "not in the system!");
						}
					}
					
				}
				
				
			
		});
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		
		
		

	}
}
