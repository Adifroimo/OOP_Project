package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import model.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class GetRealVehicle extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GetRealVehicle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 43, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Vehicle License Plate");
		lblNewLabel.setBounds(6, 48, 148, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblNewLabel_1.setBounds(6, 101, 420, 153);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Show info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.libr.getAllVehicleTransportation().containsKey(textField.getText())) {
					
					lblNewLabel_1.setText(Main.libr.getRealVehicleTransportation(textField.getText()).toString());
					
					lblNewLabel_1.setVisible(true);

				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Car Not in the system!");

				}
			}
		});
		btnNewButton.setBounds(143, 81, 117, 29);
		getContentPane().add(btnNewButton);
		lblNewLabel_1.setVisible(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/2,screenSize.height/2);

	}

}
