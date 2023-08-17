package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class profitpervehicle extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public profitpervehicle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(154, 146, 61, 16);
		getContentPane().add(lblNewLabel_1);
		JButton btnNewButton = new JButton("getProfit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Main.libr.profitPerVehiclesTransportation(Main.libr.getRealVehicleTransportation(textField.getText())))==null) {
					JOptionPane.showMessageDialog(btnNewButton, "There is no such vehicle!");
				}
				else {
					lblNewLabel_1.setText(Double.toString(Main.libr.profitPerVehiclesTransportation(Main.libr.getRealVehicleTransportation(textField.getText()))));
					lblNewLabel_1.setVisible(true);

				}
			}
		});
		btnNewButton.setBounds(144, 105, 117, 29);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(196, 60, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please enter Vehicle ID");
		lblNewLabel.setBounds(6, 65, 154, 16);
		getContentPane().add(lblNewLabel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);
		
	}

}
